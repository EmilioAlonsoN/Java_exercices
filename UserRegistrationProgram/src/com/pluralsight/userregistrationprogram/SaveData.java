package com.pluralsight.userregistrationprogram;

import java.io.*;

public class SaveData {

    public SaveData(){}

    public static void saveData(String name,
                                 String surname,
                                 String email,
                                 String username,
                                 String pass) {
        // Function to write new user data to the file and terminate the program.
        try {
            FileWriter myWriter = new FileWriter("accounts.txt", true);


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

    public static boolean checkForDuplicates(String column,
                                              String value) throws IOException {
        // Function to check for duplicates of the "Username and Email" column in the file-database.
        File file = new File("C:\\Users\\valde\\IdeaProjects" +
                "\\UserRegistrationProgram\\accounts.txt");
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
}
