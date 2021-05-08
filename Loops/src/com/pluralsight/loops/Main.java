package com.pluralsight.loops;

public class Main {

    public static void main(String[] args) {
	double someValue = 4;
	int factorial = 1;
	while(someValue > 1){
	    factorial *= someValue;
	    someValue--;
    }
	System.out.println("Factorial result is: " + factorial); // while loop example

	int number = 1;
	do {
		System.out.print(number);
		System.out.print(" * 2 = ");
		number *= 2;
		System.out.println(number);
	}
	while(number < 25); // do-while loop example

	for(int i = 1; i < 100; i *= 2)
		System.out.println("Print : " + i); //For Loop example
    }
}
