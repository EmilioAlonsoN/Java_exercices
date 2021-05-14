package com.pluralsight.testprogram;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Registration App");
        System.out.println("NOTE: Your user name is unique so it cannot be change");
        System.out.println("App test ");
        System.out.print("Name: ");
        String name = input.next();
        System.out.print("Surname \"only the first\": ");
        String surname = input.next();
        System.out.print("Username: ");
        String user = input.next();
        System.out.print("Password Option: Autogenerate password press 1. Chose yourself press 2.");
        int passOpt = Integer.parseInt(input.next());
        if (passOpt == 1) {
            AutoGeneratePassword();
            try {
                FileWriter myWriter = new FileWriter("accounts.txt", true);
                BufferedWriter bw = new BufferedWriter(myWriter);
                bw.write("Name: " + name + " " + "Surname: " +surname + " " + "User: " +user + " "
                        + "Password:" + String.copyValueOf(AutoGeneratePassword()));
                bw.append("\n");
                bw.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();

            }
        } else if (passOpt == 2) {
            System.out.println("Please introduced a password with at least 8 characters");
            System.out.println("Password: ");
            String pass = input.next();
            System.out.print("Confirm Password: ");
            String conf = input.next();
            int length1 = pass.length();
            int passInt = Integer.parseInt(pass);
            int confInt = Integer.parseInt(conf);
            if (length1 < 8) {
                System.out.println("Password is to short, please introduced a password with at least 8 characters");
                return;
            }
            try {
                FileWriter myWriter = new FileWriter("accounts.txt", true);
                BufferedWriter bw = new BufferedWriter(myWriter);
                bw.write("Name: " + name + " " + "Surname: " +surname + " " + "User: " +user + " "
                        + "Password: " + pass);
                bw.append("\n");
                bw.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();

            }
        }

    }


    private static char[] AutoGeneratePassword() {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[20];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i< 20; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        //System.out.println(password);
        return password;
    }


}

            



