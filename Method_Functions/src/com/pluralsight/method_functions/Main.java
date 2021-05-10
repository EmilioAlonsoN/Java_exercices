package com.pluralsight.method_functions;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class Main {
    static void showSum(float x, float y, int count){
        float sum = x + y;
        for (int i = 0; i <count; i++)
            System.out.println(sum);
    }

    public static void main(String[] args) {
        showSum(7.5f, 1.4f, 3);
        System.out.println("Back from showSum");
    }

}
