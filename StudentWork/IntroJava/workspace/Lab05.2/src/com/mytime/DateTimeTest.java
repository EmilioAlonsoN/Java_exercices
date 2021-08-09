/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.mytime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class DateTimeTest {

	public static void main(String[] args) {
	    // TODO: Uncomment the test method that you want to run, and comment out the others
	    
		testNow();
		testCreateAndGetValues();
		testParse();
		testFormat();
	}
  
	/**
	 * TASK: create current date, time, and date-time via now() and print them.
	 */
    public static void testNow() {
    // TODO
		LocalTime localTime = LocalTime.now();
		System.out.println("Now is: " + localTime);

		LocalDate localDate = LocalDate.now();
		System.out.println("Today is: " + localDate);

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Date and time now: " + localDateTime);
  }
  
	public static void testCreateAndGetValues() {
	  // TODO: create your birthday via of() and verify some of the fields are correct by outputting them using sysout
	  LocalDate bDay = LocalDate.of(1981, 02, 14);
		System.out.println("The year of my birth was: " + bDay.getYear());
		System.out.println("The month of my birth was: " + bDay.getMonth());
		System.out.println("The day of my birth was: " + bDay.getDayOfMonth());
	}
	
	/**
	 * NOTE: verify these via visual inspection (sysout)
	 */
	public static void testParse() {
		// TODO: create your birthday by parsing a text representation in standard format
	   LocalDate bDay = LocalDate.parse("1981-02-14");
		System.out.println(bDay);
	  // OPTIONAL: create the training class start date-time by parsing text in the form "2/15/2016 @ 8:30am"
	  // Note: the 'am' is deliberately lowercase.
		DateTimeFormatterBuilder builder = new  DateTimeFormatterBuilder();
		builder.parseCaseInsensitive().appendPattern("M/d/yyyy '@' h:mma");
		DateTimeFormatter formatter = builder.toFormatter();

		// optional 1: use a formatter builder to remove case sensitivity from the parse (example in coursebook).
		LocalDateTime classDataTime = LocalDateTime.parse("2/15/2016 @ 8:30am", formatter);
		if (!LocalDateTime.of(2016, 2, 15, 8, 30).equals(classDataTime)) {
			System.out.println("Wrong value.");
		}
	  // optional 2: pre-process the input text for easier parsing.
		String inputText = "2/15/2016 @ 8:30am";
		LocalDateTime classDateTime1 = LocalDateTime.parse(inputText.toUpperCase(), DateTimeFormatter.ofPattern("M/d/yyyy '@' h:mma"));
		if (!LocalDateTime.of(2016, 2, 15, 8, 30).equals(classDateTime1)) {
			System.out.println("Wrong value.");
		}
	  
	}
	
	/**
	 * TASK: create format strings from the date below in these formats:
	 *  10/14/1066
	 *  14-10-1066
	 */
	public static void testFormat() {
	  LocalDate hastings = LocalDate.of(1066, 10, 14);
	  // TODO: 10/14/1066
		String display = hastings.format(DateTimeFormatter.ofPattern("M/dd/yyyy"));
		if (!display.equals("10/14/1066")) {
			System.out.println("Wrong value.");
		}
		System.out.println(display);
	  // TODO: 14-10-1066
	  	String display2 = hastings.format(DateTimeFormatter.ofPattern("dd-M-yyyy"));
		if (!display2.equals("14-10-1066")) {
			System.out.println("Wrong value.");
		}
		System.out.println(display2);
	}
}