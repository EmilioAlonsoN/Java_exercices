package com.pluralsight.userregistrationprogram;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;
import java.util.Scanner;

public class NewUser {
    // Class use to created a new user.
    public NewUser() {}

    public static void newUser() throws IOException,
                                        NoSuchPaddingException,
                                        NoSuchAlgorithmException,
                                        InvalidKeySpecException,
                                        InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKey key = cryptoTools.generateKey();
        Main.decryptFile(key);

        System.out.println("Registration App");
        System.out.println("App test ");

        String name = String.valueOf(nameRegs());
        String surname = String.valueOf(surnameRegs());
        String email = String.valueOf(eMail());

        System.out.println("NOTE: Your user name is unique so it cannot be changed");
        System.out.println("Choose your Username.");

        String username = userName();
        passwordOptions(name, surname, email, username);

        Main.encryptFile(key);
        Main.deleteFile();

        Main.mainMenu();
    }

    private static String nameRegs() {
        // Function to input a name.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.println("Is this you name: " + "\"" + name + "\"" + " " + "Press \" y \" to confirm else try again.");
        String confirmation = scanner.nextLine();

        if (!confirmation.equals("y")) {
            return nameRegs();
        }
        return name;
    }

    private static String surnameRegs() {
        // Function to input surname.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Surname: ");
        String surname = scanner.nextLine();

        System.out.println("Is this you name: " + "\"" + surname + "\"" + " " + "Press \" y \" to confirm else try again.");
        String confirmation = scanner.nextLine();

        if (!confirmation.equals("y")) {
            return surnameRegs();
        }
        return surname;
    }

    private static String eMail() throws IOException {
        // Function for manual email input. Will check that it is a valid email, and compare it to the file to avoid
        // duplicate emails.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your email:");
        String email = scanner.nextLine();

        if (!Main.isValid(email)) {
            System.out.println("Invalid Email.");
            eMail();
        }
        else if (Main.isValid(email)) {
            boolean hasDuplicate = SaveData.checkForDuplicates("Email:", email);
            if (hasDuplicate) {
                System.out.println("Email already exists.");
                eMail();
            }
            else
                return email;
        }
        return null;
    }

    private static String userName() throws IOException {
        // Function to input a username. Will compare it to the file to avoid duplicate usernames.
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();

        if (username.contains(" ")) {
            System.out.println("Username can not contain spaces.");
            return userName();
        }
        else if (!username.contains(" ")) {
            boolean hasDuplicate = SaveData.checkForDuplicates("User:", username);
            if (hasDuplicate) {
                System.out.println("Already exists.");
                System.out.println("Please choose another one.");
                return userName();
            }
            else {
                System.out.println("Is this your Username:" + " " + "\"" + username + "\"" +
                        " " + "Press \" y \" to confirm else try again.");
                String confirmation = scanner1.nextLine();
                if (!confirmation.equals("y")) {
                    return userName();
                }
            }
        }
        return username;
    }

    private static void passwordOptions(String name,
                                        String surname,
                                        String email,
                                        String username) throws InvalidAlgorithmParameterException,
                                                                                            NoSuchPaddingException,
                                                                                            IOException,
                                                                                            NoSuchAlgorithmException,
                                                                                            InvalidKeySpecException,
                                                                                            InvalidKeyException {
        // Function to choose a method to create a password "self chosen or autogenerated".
        Scanner scanner = new Scanner(System.in);

        System.out.print("Password Option:\n1 Autogenerate password \n2 Choose yourself \n3 Main menu \n ");
        String option = scanner.nextLine();

        switch (option) {
            case "1" -> {
                String pass = passwordGenerator();
                SaveData.saveData (name, surname, email, username, pass);
            }
            case "2" -> {
                String pass = selfChoosePassword();
                SaveData.saveData (name, surname, email, username, pass);
            }
            case "3" -> Main.mainMenu();
            default ->
                    passwordOptions(name, surname, email, username);
        }
    }

    private static String selfChoosePassword() {
        // Function used to obtain a self chosen password from the user.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a password with at least 8 characters");

        System.out.println("Password: ");
        String password = scanner.nextLine();
        System.out.println(password);

        if (password.contains(" ")) {
            System.out.println("Password can not contain spaces.");
            return selfChoosePassword();
        }
        else if (password.isEmpty()) {
            System.out.println("Password is empty.");
            return selfChoosePassword();
        }
        else if (password.length() < 8) {
            System.out.println("Password is too short, please enter a password with at least 8 characters");
            System.out.println("Try again PinkSkin");
            return selfChoosePassword();
        }
        else {
            System.out.print("Confirm Password: ");
            String confirmationPassword = scanner.nextLine();
            boolean checkPassword = password.equals(confirmationPassword);

            if (!checkPassword) {
                System.out.println("Your password do not match.");
                System.out.println("Try again PinkSkin");
                return selfChoosePassword();
            }
        }
        return password;
    }

    private static String passwordGenerator() {
        // Function to autogenerated a new password.
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
        return String.valueOf(password);
    }
}
