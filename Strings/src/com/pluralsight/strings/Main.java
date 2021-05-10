package com.pluralsight.strings;

public class Main {

    public static void main(String[] args) {
	String s1 = "I love";
	s1 += " Java";
	String s2 = "I";
	s2 += " love Java";
	String s3 = s1.intern();
	String s4 = s2.intern();
	if(s3 == s4)
        System.out.println("true");
	else
		System.out.println("false");
	System.out.println(s1);
	System.out.println(s2);
	// method to compare Strings with double equal "=="
	String s5 = "I love";
	s5 += " JavaScript as well";
	String s6 = "I";
	s6 += " love JavaScript as well";
	if(s5.equals(s6))
		System.out.println("true");
		System.out.println(s5);
		System.out.println(s6);
	//	method to simply compare Strings with ".equal" method

	int iVal = 100;
	String sVal = String.valueOf(iVal);
		System.out.println(sVal.length());
	int i = 2;
	int j = 3;
	int result = i * j;
		//System.out.println(result);
	String output = i + " * " + j + " = " + result;
		System.out.println(output);
	// method to convert non String types to String
	}
}
