package com.company;

public class Main {
    public static void main(String[] args) {
        UserDataThread userDataThread = new UserDataThread();
        SecretDataThread secretDataThread = new SecretDataThread();

        userDataThread.start();

        try {
            userDataThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        secretDataThread.start();
    }
}