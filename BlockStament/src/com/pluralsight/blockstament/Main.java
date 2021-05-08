package com.pluralsight.blockstament;

public class Main {

    public static void main(String[] args) {
	int v1 = 10;
	int v2 = 4;
    final int diff;
	if (v1 > v2) {
	    diff = v1 - v2;
	    System.out.println("v1 is bigger that v2, diff = " + diff);
    }
	else {
	    diff = v2 - v1;
	    System.out.println("v1 in not bigger than v2, diff = " + diff);
    }
    }
}
