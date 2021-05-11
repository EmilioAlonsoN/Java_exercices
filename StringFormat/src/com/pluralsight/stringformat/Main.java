package com.pluralsight.stringformat;

public class Main {

    public static void main(String[] args) {
	int w = 5;
	int x = 235;
	int y = 481;
	int z = 12;
    String s1 = String.format("W:%d X:%d", w, x);
    String s2 = String.format("Y:%d Z:%d", y, z);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("no Width");
        System.out.println();
        //no Width
    String s3 = String.format("W:%5d X:%5d", w, x);
    String s4 = String.format("Y:%5d Z:%5d", y, z);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println("with Width");
        System.out.println();
        // with Width
    String s5 = String.format("W:%05d X:%05d", w, x);
    String s6 = String.format("Y:%05d Z:%05d", y, z);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println("with Width and Zero flag \"0\"");
        System.out.println();
        // with Width and Zero flag "0"
    String s7 = String.format("W:%-5d X:%-5d", w, x);
    String s8 = String.format("Y:%-5d Z:%-5d", y, z);
        System.out.println(s7);
        System.out.println(s8);
        System.out.println("with Width and Minus flag \"-\" just justify");
        System.out.println();
        // with Width and Minus flag "-" just justify
    int iVal = 1234567890;
    double dVal = 1234567890.0d;
    String v1 = String.format("%d", iVal);
        System.out.println(v1);
        System.out.println("Number with no format");
        System.out.println();
        // Number with no format
    String v2 = String.format("%,d", iVal);
        System.out.println(v2);
        System.out.println("Number with format \",\" coma flag");
        System.out.println();
        //Number with format "," coma flag
    String v3 = String.format("%,.2f", dVal);
        System.out.println(v3);
        System.out.println("Number with format \",\" coma flag and 2x decimal ");
        System.out.println();
        //Number with format "," coma flag and 2x decimal
    int posVal = 123;
    int negVal = -456;
    String p1 = String.format("%d", posVal);
    String p2 = String.format("%d", negVal);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println();
        System.out.println("Non aline numbers");
    String p3 = String.format("% d", posVal);
    String p4 = String.format("% d", negVal);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println();
        System.out.println("Aline numbers using \" \" space flag");
    String p5 = String.format("%+d", posVal);
    String p6 = String.format("%+d", negVal);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println();
        System.out.println("Numbers with symbol positive or negative using \"+\" flag");
    String p7 = String.format("% (d", posVal);
    String p8 = String.format("%(d", negVal);
        System.out.println(p7);
        System.out.println(p8);
        System.out.println();
        System.out.println("Parenthesis flag \"(\" place negative numbers on parenthesis");
    int valA = 100, valB = 200, valC = 300;
    String a = String.format("%d %d %d", valA,valB, valC);
        System.out.println(a);
        //Non specify order format "every value is assign by order of position"
    String b = String.format("%3$d %1$d %2$d", valA, valB, valC);
        System.out.println(b);
        // Argument index Specific order assign using "position number + "$" symbol" example: %1$d" to assign same value
        // to more than one format use "<"
    String c = String.format("%2$d %<d %2$d", valA, valB, valC);
        System.out.println(c);
    }
}
