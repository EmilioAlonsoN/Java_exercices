package com.pluralsight.userregistrationprogram;

import java.io.*;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class DataClass {
// Class use to manage all data related.
    public DataClass() { }

    public static void saveData(String name, String surname, String email, String username, String pass) {
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

    public static boolean checkForDuplicates(String column, String value) throws IOException {
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

    public static void deleteFile() throws IOException {
        // Function use to delete the unencrypted file after is encrypted.
        File file = new File("decrypted_file_accounts.txt");
        while(file.exists()) {
            try {
                Files.delete(Path.of("C:\\Users\\valde\\IdeaProjects" +
                                            "\\UserRegistrationProgram\\decrypted_file_accounts.txt"));
            } catch (FileSystemException var2) {
                System.out.println(); // TODO: print exception, or log it
            }
        }
    }

    public static boolean isValid(String email) {
        // Function to check email syntax to avoid non valid emails using Regex.
        if (email == null) {
            return false;
        }
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
