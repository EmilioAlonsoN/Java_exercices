package com.pluralsight.testprogram;


import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        mainMenu();
    }

    public static void mainMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my App.");
        System.out.println("From now on you will be part of the PinkSkin community.");
        System.out.println("What would you like to do?");
        System.out.println("1 Make new Account\n2 Login\n3 Delete Account\n4 Exit");
        String option = scanner.next();
        switch (option) {
            case "1" -> newUser();
            case "2" -> loginMenu();
            case "3" -> deleteAccount();
            default -> {
                System.out.println("See you again PigSkin...............");
                System.exit(0);
            }
        }
    }

    public static void newUser() throws IOException {
        System.out.println("Registration App");
        System.out.println("App test ");
        String name = String.valueOf(nameRegs());
        String surname = String.valueOf(surnameRegs());
        String email = String.valueOf(eMail());
        String username = userName();
        String pass = typeOfPasswordChosen();
        if (typeOfPasswordChosen().equals("1")){
            char[] autoGenPass = passwordGenerator();
            System.out.println(autoGenPass);
        }
        try {
            FileWriter myWriter = new FileWriter("accounts.txt", true);

            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(String.format("Name:%-30s Surname:%-30s Email:%-60s User:%-20s Password:%-24s",
                    name, surname, email, username, pass));
            System.out.println("Your user name is:" + username);
            System.out.println("Your password is:" + pass);
            bw.append("\n");
            bw.close();
            System.out.println("Successfully registered.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            System.out.println("Please try again PickSkin");
            e.printStackTrace();
        }
    }

    private static String typeOfPasswordChosen (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Password Option:\n1 Autogenerate password \n2 Choose yourself \n3 Exit \n ");
        String passOpt = scanner.nextLine();
        if (passOpt == "1")
            return "1";
        if (passOpt == "2")
            return "2";
        if (passOpt == "3") {
            System.out.println("See you again PigSkin...............");
            System.exit(0);
        }
        else return typeOfPasswordChosen();
        return passOpt;
    }

    public static String nameRegs(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.println("Is this you name: " + name + " " + "Press y to confirm else try again.");
        String confirmation = scanner.nextLine();

        if (!confirmation.equals("y")) {
            nameRegs();
        }
        else
            return name;
        return name;
    }

    public static String surnameRegs() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Surname: ");
        String surname = scanner.nextLine();

        System.out.println("Is this you name: " + surname + " " + "Press y to confirm else try again.");
        String confirmation = scanner.nextLine();

        if (!confirmation.equals("y")) {
            surnameRegs();
        }
        else
            return surname;
        return surname;
    }

    public static String eMail() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your email:");
        String email = scanner.nextLine();

        if (!isValid(email)) {
            System.out.println("Invalid Email.");
            eMail();
        }
        else if (isValid(email)) {
            boolean hasDuplicate = checkForDuplicates("Email:", email);

            if (hasDuplicate)
                eMail();
            else
                return email;
        }
        return email;
    }

    public static String userName() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("NOTE: Your user name is unique so it cannot be change");
        System.out.println("Choose your Username.");
        System.out.print("Username: ");
        String username = scanner.nextLine();

        if (username.contains(" ")) {
            System.out.println("Username can not contain spaces.");
            userName();
        }
        else if (!username.contains(" ")) {
            boolean hasDuplicate = checkForDuplicates("User:", username);
            if (hasDuplicate)
                userName();
            else {
                System.out.println("Is this your Username:" + " " + username + " " + "Press y to confirm else try again.");
                String confirmation = scanner1.nextLine();
                if (!confirmation.equals("y")) {
                    userName();
                } else
                    return username;
            }
        }
        return username;
    }

    public static String selfChoosePass() {
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Please introduced a password with at least 8 characters");

        System.out.println("Password: ");
        String pass = scanner1.nextLine();
        System.out.println(pass);

        if (pass.contains(" ")){
            System.out.println("Password can not contain spaces.");
            selfChoosePass();
        }
        else if (pass.isEmpty()){
            System.out.println("Password is empty.");
            selfChoosePass();
        }
        else {
            System.out.print("Confirm Password: ");
            String conf = scanner1.nextLine();
            boolean checkPassword = (pass.equals(conf));

            if (!checkPassword){
                System.out.println("Your password do not match.");
                System.out.println("Try again PinkSkin");
                selfChoosePass();
            }
            else{
                int length1 = pass.length();
                if (length1 < 8) {
                    System.out.println("Password is to short, please introduced a password with at least 8 characters");
                    System.out.println("Try again PinkSkin");
                    selfChoosePass();
                }
                return pass;
            }
        }
        return pass;
    }

    public static boolean checkForDuplicates(String type, String value) throws IOException {
        File file = new File("C:\\Users\\valde\\IdeaProjects\\TestProgram\\accounts.txt");
        String[] words;
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string;
        String input = type + value;
        while ((string = bufferedReader.readLine()) != null) {
            words = string.split(" ");
            for (String word : words) {
                if (word.equals(input)) {
                    System.out.println("Already exists.");
                    System.out.println("Please choose another one.");
                    return true;
                }
            }
        }
        return false;
    }

    public static void loginMenu(){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Please introduced your Username:");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Please enter your email:");
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Please introduced your password:");
        System.out.println("Password: ");
        String pass = scanner1.nextLine();
    }

    public static void deleteAccount() {
    }

    private static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    private static char[] passwordGenerator() {
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
