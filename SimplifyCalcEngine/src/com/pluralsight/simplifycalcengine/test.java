package com.pluralsight.simplifycalcengine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class test {
    public  static  void userRO2(String name, String surname, String userN) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Please introduced a password with at least 8 characters");
        System.out.println("Password: ");
        String pass = scanner1.nextLine();
        if (pass.contains(" ")){
            System.out.println("Password can not contain spaces.");
            userRO2(name, surname, userN);
        }
        else{
        System.out.println(pass);
        System.out.print("Confirm Password: ");
        String conf = scanner1.nextLine();
        boolean checkPassword = (pass == conf);
        if (checkPassword != true){
            System.out.println("Your password do not match.");
            System.out.println("Try again PinkSkin");
            userRO2(name, surname, userN);
        }
        else{
            int length1 = pass.length();
            if (length1 < 8) {
                System.out.println("Password is to short, please introduced a password with at least 8 characters");
                System.out.println("Try again PinkSkin");
                return;
            }
            try {
                FileWriter myWriter = new FileWriter("accounts.txt", true);
                BufferedWriter bw = new BufferedWriter(myWriter);
                bw.write(String.format("Name:%30s Surname:%30s User:%20s Password:%24s", name, surname, userN, pass));
                bw.append("\n");
                bw.close();
                System.out.println("Your user name is:" + userN);
                System.out.println("Your password is:" + String.valueOf(pass));
                System.out.println("Successfully registered.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
    }
}
