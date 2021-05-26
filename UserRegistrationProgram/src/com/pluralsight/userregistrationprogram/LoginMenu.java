package com.pluralsight.userregistrationprogram;

import javax.crypto.NoSuchPaddingException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

public class LoginMenu {

    public LoginMenu(){}

    public static void loginMenu() throws IOException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException,
            NoSuchPaddingException,
            InvalidKeySpecException,
            InvalidKeyException {
        // Function use for the login menu.
        Scanner scanner = new Scanner(System.in);
        String checkUsername = loginCheckUser();
        String checkEmail = String.valueOf(loginCheckEmail());
        String checkPassword = loginCheckPassword();
        //loginChecker(checkUsername, checkEmail,checkPassword);
        boolean loginChecker = loginChecker("Email:", checkEmail,
                "User:", checkUsername,
                "Password:", checkPassword);

        if (!loginChecker) {
            System.out.println("No match found for this combination of credentials.");
            System.out.println("Please try again.");
            loginMenu();
        }
        else {
            System.out.println("Congratulations PinkSkin");
            System.out.println("Successfully logged in.");
            System.out.print("What would you like to do? ");
            String nothing = scanner.nextLine();
            System.out.println(nothing + "HA HA HA was a joke :D ");
            Main.mainMenu();
        }
    }

    private static boolean loginChecker(String column, String value,
                                        String column1, String value1,
                                        String column2, String value2) throws IOException {
        // Function use to check in the file for user login parameters.
        File file = new File("C:\\Users\\valde\\IdeaProjects" +
                "\\UserRegistrationProgram\\decrypted_file_accounts.txt");
        String[] words;
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string;
        String input = column + value + column1 + value1 + column2 + value2;

        while ((string = bufferedReader.readLine()) != null) {
            words = string.split(" ");
            for (String word : words) {
                if (!word.equals(input)) {
                    return true;
                }
            }
        }
        bufferedReader.close();
        fileReader.close();
        return false;
    }

    private static String loginCheckUser() throws IOException {
        // Function use to check in the file for username credentials looking for the parameter introduced exist.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your Username:");
        System.out.print("Username: ");
        String username = scanner.nextLine();

        if (username.contains(" ")) {
            System.out.println("Username can not contain spaces.");
            return loginCheckUser();
        }
        else {
            boolean hasDuplicate = SaveData.checkForDuplicates("User:", username);

            if (!hasDuplicate) {
                loginCheckUser();
            }
            else {
                return username;
            }
        }
        return null;
    }

    private static String loginCheckEmail() throws IOException {
        // Function use to check in the file for user email looking for the parameter introduced exist.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your email:");
        System.out.println("Email: ");
        String email = scanner.nextLine();

        if (!Main.isValid(email)) {
            System.out.println("Invalid Email.");
            return loginCheckEmail();
        }
        else {
            boolean hasDuplicate = SaveData.checkForDuplicates("Email:", email);
            if (!hasDuplicate) {
                loginCheckEmail();
            }
            else {
                return email;
            }
        }
        return null;
    }

    private static String loginCheckPassword() throws IOException {
        // Function use to check in the file for user password looking for the parameter introduced exist.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please introduced your password:");
        System.out.println("Password: ");
        String pass = scanner.nextLine();

        if (pass.contains(" ")) {
            System.out.println("Password can not contain spaces.");
            return loginCheckPassword();
        }
        else {
            boolean hasDuplicate = SaveData.checkForDuplicates("Password:", pass);
            if (!hasDuplicate) {
                loginCheckPassword();
            }
            else {
                return pass;
            }
        }
        return null;
    }
}
