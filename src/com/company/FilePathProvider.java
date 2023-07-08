package com.company;

public class FilePathProvider {
    private static final String BASE_DIRECTORY_PATH = "src/com/company/resources/";

    private static final String PERSON_FILE_NAME = "person.txt";
    private static final String SECRET_FILE_NAME = "secret.txt";

    public static String getPersonFilePath() {
        return BASE_DIRECTORY_PATH + PERSON_FILE_NAME;
    }

    public static String getSecretFilePath() {
        return BASE_DIRECTORY_PATH + SECRET_FILE_NAME;
    }
}
