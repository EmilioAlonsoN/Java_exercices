package com.pluralsight.CalcEngine;

public class MathEquation {
    double leftVal;
    double rightVal;
    char opCode;
    double result;
    void execute(){
        switch (opCode) {
            case 'a' -> result = leftVal + rightVal;
            case 's' -> result = leftVal - rightVal;
            case 'm' -> result = leftVal * rightVal;
            case 'd' -> {
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                if (rightVal == 0)
                    System.out.println("No result");
            }
            default -> {
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
            }
        }
    }
}
