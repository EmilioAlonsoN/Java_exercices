package com.pluralsight.organized;

public class Main {

    public static void main(String[] args) {
        float floatVal = 1.0f;
        double doubleVal = 4.0d;
        byte byteVal = 7;
        short shortVal = 7;
        long longVal = 5;

        short result1 = (short) longVal;
        short result2 = (short) (byteVal - longVal);
        float result3 = longVal - floatVal;

        System.out.println(byteVal);
        System.out.println("Success");


        int value1 = 3;
        int value2 = 100;
        //int maxValue = (value1 > value2) ? value1 : value2;
        //System.out.println(maxValue);

        if (value1 >= value2)
            System.out.println("value1 not bigger");
        else
            System.out.println("value its bigger");


    }
}
