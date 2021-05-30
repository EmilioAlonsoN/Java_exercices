package com.pluralsight.userregistrationprogram;


import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeySpecException, InvalidKeyException, InvalidAlgorithmParameterException, SQLException {
        mainMenu();
    }

    public static void mainMenu() throws IOException, NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeySpecException, InvalidKeyException, InvalidAlgorithmParameterException, SQLException {
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
                DataClass.deleteFile();
                System.out.println("See you again PigSkin...............");
                System.exit(0);
            }
            default ->
                    mainMenu();
        }
    }

    public static void encryptFile(SecretKey key) throws InvalidAlgorithmParameterException {
        // Function use to encrypt the file-database with the users data.

        try {
            CryptoTools.encryptMode(key);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IOException |
                                                                                        InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    public static void decryptFile() {
        // Function use to decrypt the file-database with the users data.

        try {
            CryptoTools.decryptMode();
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IOException |
                                                    InvalidAlgorithmParameterException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }


}