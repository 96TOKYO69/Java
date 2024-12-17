package org.example.zadanie2;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class GoogleSheetsService {

    private static final String SPREADSHEET_ID = "1E8PVecwBhE9oNCTwcJAHGuqG7gohfjJvNlV5t-sKGg8";
    private static final String SHEET_NAME = "Лист1";
    private final Sheets sheetsService;

    public GoogleSheetsService() throws GeneralSecurityException, IOException {
        sheetsService = GoogleSheetsAPI.getSheetsService();
    }

    public double calculateUsingGoogleSheets(double num1, double num2, String operator) throws IOException {
        if (operator.equals("/") && num2 == 0) {
            throw new ArithmeticException("Ошибка: деление на ноль.");
        }

        String formula;
        switch (operator) {
            case "+":
                formula = "=A" + getNextAvailableRow() + "+B" + getNextAvailableRow();
                break;
            case "-":
                formula = "=A" + getNextAvailableRow() + "-B" + getNextAvailableRow();
                break;
            case "*":
                formula = "=A" + getNextAvailableRow() + "*B" + getNextAvailableRow();
                break;
            case "/":
                formula = "=A" + getNextAvailableRow() + "/B" + getNextAvailableRow();
                break;
            default:
                throw new IllegalArgumentException("Ошибка: неизвестная операция " + operator);
        }

        int nextRow = getNextAvailableRow();

        ValueRange body = new ValueRange().setValues(Arrays.asList(
                Arrays.asList(num1, num2, formula)
        ));
        sheetsService.spreadsheets().values()
                .update(SPREADSHEET_ID, SHEET_NAME + "!A" + nextRow + ":C" + nextRow, body)
                .setValueInputOption("USER_ENTERED")
                .execute();

        ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID, SHEET_NAME + "!C" + nextRow)
                .execute();

        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty() || values.get(0).isEmpty()) {
            throw new IOException("Результат не найден в таблице.");
        }

        String resultString = values.get(0).get(0).toString();
        if (resultString.startsWith("#")) {
            throw new IOException("Ошибка в формуле Google Sheets: " + resultString);
        }

        return Double.parseDouble(resultString);
    }

    private int getNextAvailableRow() throws IOException {
        ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID, SHEET_NAME + "!A:A")
                .execute();

        List<List<Object>> values = response.getValues();
        return (values == null) ? 1 : values.size() + 1;
    }
}
