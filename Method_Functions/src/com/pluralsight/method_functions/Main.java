package com.pluralsight.method_functions;

public class Main {
    static void showSum(float x, float y, int count){
        float sum = x + y;
        for (int i = 0; i <count; i++)
            System.out.println(sum);
    }
    public static void main(String[] args) {
        showSum(7.5f, 1.4f, 3);

    }
}
