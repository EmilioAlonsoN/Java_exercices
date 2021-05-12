package com.pluralsight.CalcEngine;


import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //double[] leftVal = {100.0d, 25.0d, 225.0d, 11.0d};
        //double[] rightVal = {50.0d, 92.0d, 17.0d, 3.0d};
        //char[] opCode = {'d', 'a', 's', 'm'};
        //double[] result = new double[opCode.length];
        //parallel array
        MathEquation[] equations = new MathEquation[4];
        equations[0] = create(100.0d, 50.0d, 'd');
        equations[1] = create(25.0d, 92.0d, 'a');
        equations[2] = create(225.0d, 17.0d, 's');
        equations[3] = create(11.0d, 3.0d, 'm');
        if (args.length == 0) {
            for(MathEquation equation : equations){
                equation.execute();
                System.out.println("Result = " + equation.result);
           //for (int i = 0; i < opCode.length; i++) {
            //    result[i] = execute(opCode[i], leftVal[i], rightVal[i]);
            }
            //for (double currentResult : result)
            //    System.out.println("Result is: " + currentResult);
        } else if(args.length == 1 && args[0].equals("interactive"))
            executeInteractively();
        else if (args.length == 3)
            handleCommandLine(args);
        else
            System.out.println("Please provide an operation code and 2 numeric values");
    }
    private static MathEquation create(double leftVal, double rightVal, char opCode) {
        MathEquation equation = new MathEquation();
        equation.leftVal = leftVal;
        equation.rightVal = rightVal;
        equation.opCode = opCode;
        return equation;
    }
    static void executeInteractively(){
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
       char opCode = opCodeFromString(parts[0]);
       if(opCode == 'w') {
           handleWhen(parts);
       } else {
           double leftVal = valueFromWord(parts[1]);
           double rightVal = valueFromWord(parts[2]);
           double result = execute(opCode, leftVal, rightVal);
           displayResult(opCode, leftVal, rightVal, result);
       }
    }

    private static void handleWhen(String[] parts) {
        LocalDate startDate = LocalDate.parse(parts[1]);
        long daysToAdd = (long) valueFromWord(parts[2]);
        LocalDate newDate = startDate.plusDays(daysToAdd);
        String output = String.format("%s plus %d days is %s", startDate, daysToAdd, newDate);
        System.out.println(output);
    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);
        //      StringBuilder builder = new StringBuilder(20);
        //      builder.append(leftVal);
        //      builder.append(" ");
        //      builder.append(symbol);
        //      builder.append(" ");
        //      builder.append(rightVal);
        //      builder.append(" = ");
        //      builder.append(result);
        //       String output = builder.toString();
        // Example String builder
        String output = String.format("%.3f %c %.3f = %.3f", leftVal, symbol, rightVal, result);
        //Same result than Builder but using format
        System.out.println(output);
    }

    private  static char symbolFromOpCode(char opCode){
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol = ' ';
        for(int index = 0; index < opCodes.length; index++){
            if (opCode == opCodes[index]){
                symbol = symbols[index];
                break;
            }
        }
        return symbol;
    }

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double lefVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(opCode, lefVal, rightVal);
        System.out.println("Result is: " + result);
    }
    static double execute(char opCode, double leftVal, double rightVal) {
        double result;
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
        } // Enhance Switch statement
        //switch (opCode) {
        //    case 'a':
        //       result = leftVal + rightVal;
        //       break;
        //   case 's':
        //       result = leftVal - rightVal;
        //       break;
        //   case 'm':
        //      result = leftVal * rightVal;
        //      break;
        //  case 'd':
        //      result= rightVal != 0 ? leftVal / rightVal : 0.0d;
        //       if (rightVal == 0)
        //          System.out.println("No result");
        //       break;
        //   default:
        //      System.out.println("Invalid opCode: " + opCode);
        //       result = 0.0d;
        //       break;
        //} Normal Switch statement
        return result;
    }
    static char opCodeFromString(String operationName) {
        return operationName.charAt(0);
    }
    static double valueFromWord(String word){
        String[] numberWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        double value = -1d;
        for(int index = 0; index < numberWords.length; index++){
            if(word.equals(numberWords[index])){
                value = index;
                break;
            }
        }
        if (value == -1d)
            value = Double.parseDouble(word);
        return value;
    }
}
