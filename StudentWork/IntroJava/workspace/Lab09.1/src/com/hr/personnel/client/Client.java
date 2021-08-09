/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

/*
 * Lab - Interfaces
 * 
 * This is the main class where the application starts.
 * 
 * It creates an IRS instance, registers employees with it, then collects taxes from them
 * 
 */
package com.hr.personnel.client;

import java.time.LocalDate;

import com.hr.personnel.HourlyEmployee;
import com.hr.personnel.SalariedEmployee;

import gov.irs.IRS;

public class Client {

  public static void main(String[] args) {

	IRS irs = new IRS();  // Create an IRS instance.

// TODO: Uncomment this block once you make employees taxpayers also. 

    // create Employees (Hourly or Salaried), and register them with the IRS
    irs.register(new HourlyEmployee("Jason", LocalDate.of(1990,8,24), 22.50, 40));
    irs.register(new SalariedEmployee("Tina", LocalDate.of(2000,2,2), 1250));
    irs.register(new HourlyEmployee("John", LocalDate.of(2010, 10, 11), 7.25, 40));
    irs.register(new SalariedEmployee("Jane", LocalDate.of(2005,7,1), 1500));


    // IRS collects taxes
    System.out.println("IRS collects taxes");
    irs.collectTaxes();
    System.out.println("IRS display standard deductions");
    irs.getStandardDeductions();
  }
}