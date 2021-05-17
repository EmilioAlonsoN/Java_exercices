package com.pluralsight.userregistrationprogram;


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
            case "4" -> {
                System.out.println("See you again PigSkin...............");
                System.exit(0);
            }
            default ->
                mainMenu();
        }
    }

    public static void newUser() throws IOException {
        System.out.println("Registration App");
        System.out.println("App test ");

        String name = String.valueOf(nameRegs());
        String surname = String.valueOf(surnameRegs());
        String email = String.valueOf(eMail());

        System.out.println("NOTE: Your user name is unique so it cannot be changed");
        System.out.println("Choose your Username.");

        String username = userName();
        Scanner scanner2 = new Scanner(System.in);

        System.out.print("Password Option:\n1 Autogenerate password \n2 Choose yourself \n3 Or else Exit \n ");
        String option = scanner2.nextLine();

        switch (option) {
            case "1" -> {
                char[] autoGenPass = passwordGenerator();
                try {
                    FileWriter myWriter = new FileWriter("accounts.txt", true);

                    BufferedWriter bw = new BufferedWriter(myWriter);
                    bw.write(String.format("Name:%-30s Surname:%-30s Email:%-60s User:%-20s Password:%-24s",
                            name, surname, email, username,
                            String.copyValueOf(autoGenPass)));
                    System.out.println("Your user name is:" + username);
                    System.out.println("Your password is:" + String.valueOf(autoGenPass));
                    bw.append("\n");
                    bw.close();
                    System.out.println("Successfully registered.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    System.out.println("Please try again PickSkin");
                    e.printStackTrace();
                }
            }
            case "2" -> {
                String pass = selfChoosePass();
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
            case "3" -> {
                System.out.println("See you again PigSkin...............");
                System.exit(0);
            }
        }
    }

    public static String nameRegs(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.println("Is this you name: " + name + " " + "Press y to confirm else try again.");
        String confirmation = scanner.nextLine();

        if (!confirmation.equals("y")) {
            return nameRegs();//probably need name = nameRegs()
        }
        return name;
    }

    public static String surnameRegs() {
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

    public static String eMail() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your email:");
        String email = scanner.nextLine();

        if (!isValid(email)) {
            System.out.println("Invalid Email.");
            return eMail();
        }
        else if (isValid(email)) {
            boolean hasDuplicate = checkForDuplicates("Email:", email);

            if (hasDuplicate)
                return eMail();
        }
        return email;
    }

    public static String userName() throws IOException {
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
            if (hasDuplicate){
                System.out.println("Already exists.");
                System.out.println("Please choose another one.");
                return userName();
            }
            else {
                System.out.println("Is this your Username:" + " " + username + " " + "Press y to confirm else try again.");
                String confirmation = scanner1.nextLine();
                if (!confirmation.equals("y")) {
                    return userName();
                }
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
            return selfChoosePass();
        }
        else if (pass.isEmpty()){
            System.out.println("Password is empty.");
            return selfChoosePass();
        }
        else {
            System.out.print("Confirm Password: ");
            String conf = scanner1.nextLine();
            boolean checkPassword = (pass.equals(conf));

            if (!checkPassword){
                System.out.println("Your password do not match.");
                System.out.println("Try again PinkSkin");
                return selfChoosePass();
            }
            else{
                int length1 = pass.length();
                if (length1 < 8) {
                    System.out.println("Password is to short, please introduced a password with at least 8 characters");
                    System.out.println("Try again PinkSkin");
                    return selfChoosePass();
                }
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
                    return true;
                }
            }
        }
        return false;
    }

    public static String loginMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Please introduced your Username:");
        System.out.print("Username: ");
        String username = scanner.nextLine();

        if (username.contains(" ")) {

            System.out.println("Username can not contain spaces.");
            return loginMenu();

        } else if (!username.contains(" ")) {

            boolean hasDuplicate = checkForDuplicates("User:", username);

            if (hasDuplicate)
                System.out.println("User accepted");
        }
        System.out.print("Please enter your email:");
        System.out.println("Email: ");
        String email = scanner.nextLine();

        if (!isValid(email)) {

            System.out.println("Invalid Email.");
            return eMail();
        }

        else if (isValid(email)) {
            boolean asDuplicate = checkForDuplicates("Email:", email);

            if (asDuplicate)
                System.out.println("Email accepted");
        }

        System.out.println("Please introduced your password:");
        System.out.println("Password: ");
        String pass = scanner1.nextLine();

        if (username.contains(" ")) {
            System.out.println("Username can not contain spaces.");
            return loginMenu();
        } else if (!username.contains(" ")) {
            boolean sDuplicate = checkForDuplicates("Password:", pass);
            if (sDuplicate)
                System.out.println("Successfully login");
            }

        return null;
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
        return password;
    }
    public static void emailAddresses (){
        String[] testEmailAddresses = {"email@example.com","firstname.lastname@example.com","email@subdomain.example.com","firstname+lastname@example.com","email@123.123.123.123","email@[123.123.123.123]"
                ,"email@example.com","1234567890@example.com","email@example-one.com","_______@example.com","email@example.name","email@example.museum","email@example.co.jp","firstname-lastname@example.com","#@%^%#$@#$@#.com","@example.com","Joe Smith <email@example.com>","email.example.com","email@example@example.com",".email@example.com","email.@example.com","email..email@example.com","あいうえお@example.com","email@example.com (Joe Smith)","email@example,email@-example.com","email@example.web","email@111.222.333.44444","email@example..com","Abc..123@example.com","just”not”right@example.com","this\\n isreallynot\\nallowed@example.com"};
        for(int i = 0; i <= testEmailAddresses.length - 1; i++ ){
            boolean send = isValid(testEmailAddresses[i]);
            System.out.println(send+ " " + testEmailAddresses[i] );
        }
    }
    /*
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

     */
}