package com.pluralsight.gui;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static String userName() throws IOException {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Choose your Username.");
        System.out.println("NOTE: Your user name is unique so it cannot be change");
        System.out.print("Username: ");
        String userName = scanner.nextLine();

        if (userName.contains(" ")) {
            System.out.println("Username can not contain spaces.");
            userName();
        } else if (!userName.contains(" ")) {
            boolean hasDuplicate = checkForDuplicates("User:", userName);
            (hasDuplicate)
                    userName();
        }
        else
            return userName;
    }
    public static String userName() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Choose your Username.");
        System.out.println("NOTE: Your user name is unique so it cannot be change");
        System.out.print("Username: ");
        String userName = scanner.nextLine();

        if (userName.contains(" ")) {
            System.out.println("Username can not contain spaces.");
            userName();
        }
        else if (!userName.contains(" ")) {
            boolean hasDuplicate = checkForDuplicates("User:", userName);
            if (hasDuplicate)
                userName();
            else {
                //File file = new File("C:\\Users\\valde\\IdeaProjects\\TestProgram\\accounts.txt");
                //FileReader fileReader = new FileReader(file);
                //fileReader.close();
                System.out.println("Is this your Username:" + " " + userName + " " + "Press y to confirm else try again.");
                String confirmation = scanner1.nextLine();
                if (!confirmation.equals("y")) {
                    userName();
                } else
                    return userName;
            }
        }
        return userName;
    }
    }