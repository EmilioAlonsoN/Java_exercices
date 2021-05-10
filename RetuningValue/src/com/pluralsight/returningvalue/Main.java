package com.pluralsight.returningvalue;

public class Main {
    static double calInterest(double atm, double rate, int years){
        return atm * rate * years;
        }
    public static void main(String[] args) {
        double result = calInterest(100d, 0.05d, 10);
        System.out.println(result);
    }

}
