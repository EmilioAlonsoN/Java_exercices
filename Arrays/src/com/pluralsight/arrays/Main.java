package com.pluralsight.arrays;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	float[] theVals = {10.0f, 20.0f, 15.0f, 5.0f};
	float sum = 0.0f;
		System.out.println(Arrays.toString(theVals));

	for (float currentValue : theVals)
		sum += currentValue;

	System.out.println(sum);
		}
    }
