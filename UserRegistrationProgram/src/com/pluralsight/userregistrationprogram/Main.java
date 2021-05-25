package com.pluralsight.userregistrationprogram;


import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.*;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException,
                                                  NoSuchPaddingException,
                                                  NoSuchAlgorithmException,
                                                  InvalidKeySpecException,
                                                  InvalidKeyException,
                                                  InvalidAlgorithmParameterException {
        mainMenu();
    }

    public static void mainMenu()throws  IOException,
                                         NoSuchPaddingException,
                                         NoSuchAlgorithmException,
                                         InvalidKeySpecException,
                                         InvalidKeyException, InvalidAlgorithmParameterException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my App.");
        System.out.println("From now on you will be part of the PinkSkin community.");
        System.out.println("What would you like to do?");
        System.out.println("1 Make new Account\n2 Login\n3 Exit");
        String option = scanner.next();
        SecretKey key = FileEncryption.generateKey();
        decryptFile(key);

        switch (option) {
            case "1" -> newUser();
            case "2" -> loginMenu();
            case "3" -> {
                System.out.println("See you again PigSkin...............");
                encryptFile(key);
                deleteFile();
                System.exit(0);
            }
            default ->
                    mainMenu();
        }
    }

    private static void newUser()throws IOException,
                                        NoSuchPaddingException,
                                        NoSuchAlgorithmException,
                                        InvalidKeySpecException,
                                        InvalidKeyException, InvalidAlgorithmParameterException {
        // Function to make a new user.
        System.out.println("Registration App");
        System.out.println("App test ");

        String name = String.valueOf(nameRegs());
        String surname = String.valueOf(surnameRegs());
        String email = String.valueOf(eMail());

        System.out.println("NOTE: Your user name is unique so it cannot be changed");
        System.out.println("Choose your Username.");

        String username = userName();
        passwordOptions(name, surname, email, username);

        mainMenu();
    }

    private static String nameRegs() {
        // Function to input a name.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.println("Is this you name: " + name + " " + "Press y to confirm else try again.");
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

        System.out.println("Is this you name: " + surname + " " + "Press y to confirm else try again.");
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

        if (!isValid(email)) {
            System.out.println("Invalid Email.");
            eMail();
        }
        else if (isValid(email)) {
            boolean hasDuplicate = checkForDuplicates("Email:", email);
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
            boolean hasDuplicate = checkForDuplicates("User:", username);
            if (hasDuplicate) {
                System.out.println("Already exists.");
                System.out.println("Please choose another one.");
                return userName();
            }
            else {
                System.out.println("Is this your Username:" + " " + username +
                        " " + "Press y to confirm else try again.");
                String confirmation = scanner1.nextLine();
                if (!confirmation.equals("y")) {
                    return userName();
                }
            }
        }
        return username;
    }

    public static void passwordOptions(String name,
                                       String surname,
                                       String email,
                                       String username) {
        // Function to choose a method to create a password "self chosen or autogenerated".
        Scanner scanner = new Scanner(System.in);

        System.out.print("Password Option:\n1 Autogenerate password \n2 Choose yourself \n3 Exit \n ");
        String option = scanner.nextLine();

        switch (option) {
            case "1" -> {
                String pass = passwordGenerator();
                saveData(name, surname, email, username, pass);
            }
            case "2" -> {
                String pass = selfChoosePassword();
                saveData (name, surname, email, username, pass);
            }
            case "3" -> {
                System.out.println("See you again PigSkin...............");
                System.exit(0);
            }
            default ->
                    passwordOptions(name, surname, email, username);
        }
    }

    private static void saveData(String name,
                                 String surname,
                                 String email,
                                 String username,
                                 String pass) {
        // Function to write new user data to the file and terminate the program.
        try {
            FileWriter myWriter = new FileWriter("decrypted_file_accounts.txt", true);


            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(String.format("Name:%s Surname:%s Email:%s User:%s Password:%s",
                    name, surname, email, username, pass));
            bw.append("\n");
            System.out.println("Your user name is:" + username);
            System.out.println("Your password is:" + pass);
            System.out.println("Successfully registered.");
            bw.close();
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            System.out.println("Please try again PickSkin");
            e.printStackTrace();
        }

    }

    private static void deleteFile() throws IOException {
        // Function use to deleted the decrypt file after new version is save and encrypted.
        File file = new File("C:\\Users\\valde\\IdeaProjects" +
                "\\UserRegistrationProgram\\decrypted_file_accounts.txt");
        while (file.exists()) {
            try {
                Files.deleteIfExists(Path.of("C:\\Users\\valde\\IdeaProjects" +
                        "\\UserRegistrationProgram\\decrypted_file_accounts.txt"));
            } catch (FileSystemException e) {
                System.out.println();
            }
        }

    }

    private static void encryptFile(SecretKey key) throws InvalidAlgorithmParameterException {
        // Function use to encrypt the file-database with the users data.
        File nonEncryptedFile = new File("C:\\Users\\valde\\IdeaProjects" +
                                                    "\\UserRegistrationProgram\\decrypted_file_accounts.txt");
        File encryptFile = new File("C:\\Users\\valde\\IdeaProjects" +
                                               "\\UserRegistrationProgram\\encrypted_file_accounts.txt");
        try {
            FileEncryption.encryptDecryptFile(key, Cipher.ENCRYPT_MODE, nonEncryptedFile, encryptFile);
        } catch (InvalidKeyException |
                NoSuchAlgorithmException |
                InvalidKeySpecException  | NoSuchPaddingException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void decryptFile(SecretKey key) {
        // Function use to decrypt the file-database with the users data.
        File encryptFile = new File("C:\\Users\\valde\\IdeaProjects" +
                                               "\\UserRegistrationProgram\\encrypted_file_accounts.txt");
        File nonEncryptedFile = new File("C:\\Users\\valde\\IdeaProjects" +
                                                    "\\UserRegistrationProgram\\decrypted_file_accounts.txt");
        try {
            FileEncryption.encryptDecryptFile(key, Cipher.DECRYPT_MODE,  encryptFile, nonEncryptedFile);
            //
        } catch (InvalidKeyException |
                NoSuchAlgorithmException |
                InvalidKeySpecException |
                NoSuchPaddingException |
                IOException |
                InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }

    private static String selfChoosePassword() {
        // Function used to obtain a self chosen password from the user.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a password with at least 8 characters");

        System.out.println("Password: ");
        String password = scanner.nextLine();
        System.out.println(password);

        if (password.contains(" ")){
            System.out.println("Password can not contain spaces.");
            return selfChoosePassword();
        }
        else if (password.isEmpty()){
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

    private static boolean checkForDuplicates(String column,
                                              String value) throws IOException {
        // Function to check for duplicates of the "Username and Email" column in the file-database.
        File file = new File("C:\\Users\\valde\\IdeaProjects" +
                                        "\\UserRegistrationProgram\\decrypted_file_accounts.txt");
        String[] words;
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String input = column + value;

        while ((line = bufferedReader.readLine()) != null) {
            words = line.split(" ");
            for (String word : words) {
                if (word.equals(input)) {
                    return true;
                }
            }
        }
        fileReader.close();
        bufferedReader.close();
        return false;
    }

    private static boolean isValid(String email) {
        // Function to check email syntax to avoid non valid emails.
        if (email == null)
            return false;
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
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

    public static String loginMenu() throws IOException,
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
            return loginMenu();
        }
        else {
            System.out.println("Congratulations PinkSkin");
            System.out.println("Successfully logged in.");
            System.out.print("What would you like to do? ");
            String nothing = scanner.nextLine();
            System.out.println(nothing + "HA HA HA was a joke :D ");
            String nothing1 = scanner.nextLine();
            mainMenu();
        }
        return null;
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

    public static String loginCheckUser() throws IOException {
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
            boolean hasDuplicate = checkForDuplicates("User:", username);

            if (!hasDuplicate) {
                loginCheckUser();
            }
            else {
                return username;
            }
        }
        return null;
    }

    public static String loginCheckEmail() throws IOException {
        // Function use to check in the file for user email looking for the parameter introduced exist.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your email:");
        System.out.println("Email: ");
        String email = scanner.nextLine();

        if (!isValid(email)) {
            System.out.println("Invalid Email.");
            return loginCheckEmail();
        }
        else {
            boolean hasDuplicate = checkForDuplicates("Email:", email);
            if (!hasDuplicate) {
                loginCheckEmail();
            }
            else {
                return email;
            }
        }
        return null;
    }

    public static String loginCheckPassword() throws IOException {
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
            boolean hasDuplicate = checkForDuplicates("Password:", pass);
            if (!hasDuplicate) {
                loginCheckPassword();
            }
            else {
                return pass;
            }
        }
        return null;
    }

    public static void emailAddressesArray() {
        // Function created to text the function isValid "check syntax of email to get only valid ones".
        String[] testEmailAddresses = {"email@example.com", "firstname.lastname@example.com",
                "email@subdomain.example.com", "firstname+lastname@example.com", "email@123.123.123.123",
                "email@[123.123.123.123]", "email@example.com", "1234567890@example.com", "email@example-one.com",
                "_______@example.com", "email@example.name", "email@example.museum", "email@example.co.jp",
                "firstname-lastname@example.com", "#@%^%#$@#$@#.com", "@example.com", "Joe Smith <email@example.com>",
                "email.example.com", "email@example@example.com", ".email@example.com", "email.@example.com",
                "email..email@example.com", "あいうえお@example.com", "email@example.com (Joe Smith)",
                "email@example,email@-example.com", "email@example.web", "email@111.222.333.44444",
                "email@example..com", "Abc..123@example.com", "just”not”right@example.com"};

        for (int i = 0; i <= testEmailAddresses.length - 1; i++) {
            boolean send = isValid(testEmailAddresses[i]);
            System.out.println(send+ " " + testEmailAddresses[i] );
        }
    }
}