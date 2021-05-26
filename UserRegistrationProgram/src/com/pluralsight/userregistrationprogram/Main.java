package com.pluralsight.userregistrationprogram;


import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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
        switch (option) {
            case "1" -> NewUser.newUser();
            case "2" -> LoginMenu.loginMenu();
            case "3" -> {
                System.out.println("See you again PigSkin...............");
                System.exit(0);
            }
            default ->
                    mainMenu();
        }
    }

    public static void encryptFile(SecretKey key) throws InvalidAlgorithmParameterException {
        // Function use to encrypt the file-database with the users data.
        File nonEncryptedFile = new File("C:\\Users\\valde\\IdeaProjects" +
                                                    "\\UserRegistrationProgram\\decrypted_file_accounts.txt");
        File encryptFile = new File("C:\\Users\\valde\\IdeaProjects" +
                                                "\\UserRegistrationProgram\\encrypted_file_accounts.txt");
        try {
            EncryptionTools.encryptMode(key, Cipher.ENCRYPT_MODE,nonEncryptedFile, encryptFile);
        } catch (InvalidKeyException |
                NoSuchAlgorithmException |
                NoSuchPaddingException |
                IOException |
                InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    public static void decryptFile(SecretKey key) {
        // Function use to decrypt the file-database with the users data.
        File encryptFile = new File("C:\\Users\\valde\\IdeaProjects" +
                                                "\\UserRegistrationProgram\\encrypted_file_accounts.txt");
        File nonEncryptedFile = new File("C:\\Users\\valde\\IdeaProjects" +
                                                    "\\UserRegistrationProgram\\decrypted_file_accounts.txt");
        try {
            EncryptionTools.decryptMode(key, Cipher.DECRYPT_MODE,  encryptFile, nonEncryptedFile);
        } catch (InvalidKeyException |
                NoSuchAlgorithmException |
                NoSuchPaddingException |
                IOException |
                InvalidAlgorithmParameterException |
                InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile() throws IOException {
        // Function use to delete the unencrypted file after is encrypted.
        File file = new File("decrypted_file_accounts.txt");
        while(file.exists()) {
            try {
                Files.delete(Path.of("C:\\Users\\valde\\IdeaProjects" +
                                            "\\UserRegistrationProgram\\decrypted_file_accounts.txt"));
            } catch (FileSystemException var2) {

            }
        }

    }

    public static boolean isValid(String email) {
        // Function to check email syntax to avoid non valid emails using Regex.
        if (email == null)
            return false;
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
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