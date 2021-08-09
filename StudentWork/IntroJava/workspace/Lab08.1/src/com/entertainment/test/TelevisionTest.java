/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
 
/*
 * Lab - Composition
 *
 * This class is the main class, i.e., where the application starts.
 *
 * It instantiates a Television and uses the new channel functionality.
 */

package com.entertainment.test;
import com.entertainment.DisplayType;
import com.entertainment.Television;


class TelevisionTest {
  
  public static void main(String[] args) {
	  Television tvTest = new Television("Samsung", 65, DisplayType.LED);
	  System.out.println(tvTest);
	  
	  // TODO: Change the channel
	  
	  System.out.println(tvTest);

	  String brand = "Sony";
	  String volString = "10";
	  String displayString = "LCD";
	  if (args.length != 3) {
		  System.out.println("Usage: com.entertainment.test.TelevisionTest <brand> <volume> <display>");
		  System.out.println("Using Default Values - Sony 10 LCD");
	  } else {
		  brand = args[0];
		  volString = args[1];
		  displayString = args[2];
	  }

	  int vol = Integer.parseInt(volString);
	  DisplayType display = DisplayType.valueOf(displayString);

	  Television tv = new Television(brand, vol, display);
	  System.out.println(tv);


	  System.out.println("Minimum value of Volume is : " + Television.MIN_VOLUME);
	  System.out.println("Maximum value of Volume is : " + Television.MAX_VOLUME);

	  Television tv1 = new Television("Phillips");
	  tv1.setVolume(Television.MAX_VOLUME);
	  System.out.println(tv1);

	  tv1.turnOn();
	  tv1.turnOff();
	  System.out.println("Television brand is: " + tv1.getBrand() + " with a volume: " + tv1.getVolume() + "%");
	  System.out.println("...................");

	  Television tv2 = new Television(200);
	  tv2.setBrand("AOC");
	  tv2.setVolume(Television.MIN_VOLUME);

	  tv2.turnOn();
	  tv2.turnOff();
	  System.out.println("Television brand is: " + tv2.getBrand() + " with a volume: " + tv2.getVolume() + "%");
	  System.out.println("...................");

	  Television tv3 = new Television();

	  System.out.println(tv3.toString());
	  System.out.println(tv3);
	  System.out.println("...................");

	  Television tv4 = new Television("Asuses", -4);
	  System.out.println(tv4);
	  System.out.println("...................");

	  Television tv5 = new Television("AOC", 75, DisplayType.OLED);
	  System.out.println(tv5);
	  System.out.println("...................");

	  Integer v = tv5.getVolume();
	  System.out.println("Integer: " + v);
	  int vo = v;
	  System.out.println("Int: " + vo);
	  String volu = v.toString();
	  System.out.println("V.toString: " + volu);
	  Integer in = Integer.valueOf(v);
	  System.out.println("Integer.valueOf: " + in);
	  System.out.println("...................");

	  String s1 = "LG";
	  String s2 = "LG";
	  String s3 = "Samsung";

	  if (s1.equals(s2)) {
		  System.out.println("They are equals.");
	  }
	  else {
		  System.out.println("They are not equals.");
	  }
	  System.out.println("...................");

	  if (s1.equals(s3)) {
		  System.out.println("They are equals.");
	  }
	  else {
		  System.out.println("They are not equals.");
	  }
	  System.out.println("...................");

	  String s4 = s3.toUpperCase();
	  System.out.println("To upperCase: " + s4);
	  System.out.println("...................");

	  Television tv6 = new Television("LG");
	  String brand1 = tv6.getBrand();
	  System.out.println(brand1);
	  if (brand1.equals(s2)) {
		  System.out.println("They are equals.");
	  }
	  else {
		  System.out.println("They are not equals.");
	  }
	  System.out.println("...................");

	  String s5 = new String("LG");
	  if (s5.equals(s1)) {
		  System.out.println("They are equals.");
	  }
	  else {
		  System.out.println("They are not equals.");
	  }
	  System.out.println("...................");


	  Television tv7 = new Television("Sony", 10, DisplayType.OLED);
	  System.out.println(tv7);
	  System.out.println("...................");
	  tv7.changeChannel("FOX");
	  System.out.println(tv7);
	  System.out.println("...................");

  }
}