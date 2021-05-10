package com.pluralsight.returningarray;

public class Main {
    public static double[] produceInterestHistory( double amt, double rate, int years){
        double[] accumulatedInterest = new double[years];
        for(int yearIndex = 0; yearIndex < years; yearIndex++){
            int year = yearIndex + 1;
            accumulatedInterest[yearIndex] = calculateInterest(amt, rate, year);
        }
        return accumulatedInterest;
    }

    private static double calculateInterest(double amt, double rate, int year) {
        return 0;
    }

    public static void main(String[] args) {
	// write your code here
    }
}
