package com.pluralsight.CalcEngine;


public class Main {

    public static void main(String[] args) {
	    double[] leftValues = {100.0d, 25.0d, 225.0d, 11.0d};
	    double[] rightValues ={50.0d, 92.0d, 17.0d, 3.0d};
	    char[] opCode = {'d', 'a', 's', 'm'};
	    double[] result = new double[opCode.length];

	    for (int i = 0; i < opCode.length; i++) {
            switch (opCode[i]) {
                case 'a':
                    result[i] = leftValues[i] + rightValues[i];
                    break;
                case 's':
                    result[i] = leftValues[i] - rightValues[i];
                    break;
                case 'm':
                    result[i] = leftValues[i] * rightValues[i];
                    break;
                case 'd':
                    result[i] = rightValues[i] != 0 ? leftValues[i] / rightValues[i] : 0.0d;
                    break;
                default:
                    System.out.println("Invalid opCode: " + opCode[i]);
                    result[i] = 0.0d;
                    break;
            }
        }
        for (double currentResult : result)
            System.out.println("Result is: " + currentResult);
    }
}
