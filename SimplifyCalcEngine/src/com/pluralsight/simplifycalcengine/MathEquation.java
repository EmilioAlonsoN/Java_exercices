package com.pluralsight.simplifycalcengine;


public class MathEquation {
    double leftVal;
    double rightVal;
    char opCode;
    double result;

    private static int numberOfCal;
    private static double sumOfResults;

    public MathEquation(){}

    public MathEquation(char opCode) {
        this.opCode = opCode;
    }
    public MathEquation(char opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    void execute() {
        switch (opCode) {
            case 'a' -> result = leftVal + rightVal;
            case 's' -> result = leftVal - rightVal;
            case 'm' -> result = leftVal * rightVal;
            case 'd' -> result = rightVal != 0 ? leftVal / rightVal : 0.0d;
            default -> {
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
            }
        }
        numberOfCal++;
        sumOfResults += result;
    }
    public static double getSumOfResults() {return sumOfResults / numberOfCal;}

    public double getLeftVal() {return leftVal;}

    private void setLeftVal(double leftVal) {this.leftVal = leftVal;}

    public void setRightVal(double rightVal) {this.rightVal = rightVal;}

    private double getRightVal(){return rightVal;}

    public char getOpCode() {
        return opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public double getResult() {
        return result;
    }

    }