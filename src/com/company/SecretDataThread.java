package com.company;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class SecretDataThread extends Thread {
    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter secret information: ");
            String secretInformation = scanner.nextLine();

            try (PrintWriter writer = new PrintWriter(new FileWriter(FilePathProvider.getSecretFilePath(), true))) {
                writer.println("Secret Information of user: " + UserDataThread.latestUsername);
                writer.println(secretInformation);
                writer.println("-----------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
