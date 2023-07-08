package com.company;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class UserDataThread extends Thread {
    private static final Pattern EMAIL_REGEX_PATTERN =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static String latestUsername = null;

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            latestUsername = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            String email;
            do {
                System.out.print("Enter email: ");
                email = scanner.nextLine();

                if (!EMAIL_REGEX_PATTERN.matcher(email).matches()) {
                    System.out.println("Invalid email! Please enter again.");
                }
            } while(!EMAIL_REGEX_PATTERN.matcher(email).matches());

            String userData = "Username: " + latestUsername + "\nPassword: " + password + "\nEmail: " + email;

            try (PrintWriter writer = new PrintWriter(new FileWriter(FilePathProvider.getPersonFilePath(), true))) {
                writer.println(userData);
                writer.println("-----------------");  // add a separator for better readability
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}