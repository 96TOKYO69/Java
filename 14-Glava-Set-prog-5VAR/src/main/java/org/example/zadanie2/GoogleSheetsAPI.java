package org.example.zadanie2;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class GoogleSheetsAPI {

    private static Sheets sheetsService;


    private static final String CREDENTIALS_FILE_PATH = "credentials.json";

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        if (sheetsService == null) {

            HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();


            InputStream credentialsStream = GoogleSheetsAPI.class.getClassLoader().getResourceAsStream(CREDENTIALS_FILE_PATH);
            if (credentialsStream == null) {
                throw new IOException("Не удалось найти файл с учетными данными: " + CREDENTIALS_FILE_PATH);
            }


            GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream)
                    .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));


            sheetsService = new Sheets.Builder(httpTransport, jsonFactory, new HttpCredentialsAdapter(credentials))
                    .setApplicationName("Google Sheets API Java")
                    .build();
        }
        return sheetsService;
    }
}
