package org.example.zadanie2;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class GoogleSheetsService {

    private static Sheets sheetsService;
    private static String SPREADSHEET_ID = "1E8PVecwBhE9oNCTwcJAHGuqG7gohfjJvNlV5t-sKGg8"; 

    public GoogleSheetsService() throws GeneralSecurityException, IOException {
        sheetsService = GoogleSheetsAPI.getSheetsService();
    }

    public void saveResultToGoogleSheets(double result) throws IOException {
        ValueRange appendBody = new ValueRange().setValues(
                Arrays.asList(
                        Arrays.asList("Результат", result)
                )
        );

        UpdateValuesResponse response = sheetsService.spreadsheets().values()
                .update(SPREADSHEET_ID, "Лист1!A1", appendBody)
                .setValueInputOption("RAW")
                .execute();
    }
}
