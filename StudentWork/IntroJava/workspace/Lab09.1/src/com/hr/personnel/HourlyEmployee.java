/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

/*
 * The HourlyEmployee class is a fairly simple class.  It mainly serves as a simple 
 * derived class to illustrate inheritance.
 * 
 * HourlyEmployee includes the following properties:
 *   double rate - hourly pay
 *   double hours - time worked in a pay period.
 *  
 *  HourlyEmployee includes the following methods (besides get/set methods)
 *  String toString(): Generates string from HourlyEmployee object.
 *
 */
 
package com.hr.personnel;

import java.time.LocalDate;

// TODO: Implement the TaxPayer method in this class.  Note that we don't have to say "implements TaxPayer"
// again, because it inherits this from Employee.  Another example of IS-A
// HourlyEmployee IS-A Employee, and Employee IS-A TaxPayer, then HourlyEmployee IS-A TaxPayer.
public class HourlyEmployee extends Employee {
  // CLASS CONSTANTS
  public static final double TAX_RATE = 0.25;
  public static final double FEDERAL_MINIMUM = 7.25;

  // INSTANCE VARIABLES
  private double rate;
  private double hours;

  // CONSTRUCTORS
  public HourlyEmployee() {
  }
  
  public HourlyEmployee(String name, LocalDate hireDate) {
    setName(name);
    setHireDate(hireDate);
  }
  
  public HourlyEmployee(String name, LocalDate hireDate, double rate, double hours) {
    setName(name);
    setHireDate(hireDate);
    setRate(rate);
    setHours(hours);
  }
  
  // BEHAVIORAL METHODS
  // Implement pay() method by printing message: <name> is paid hourly <value>
  public void pay() {
    System.out.println(getName() + " is paid hourly " + (getRate() * getHours()));
  }

  @Override
  public void payTaxes() {
    System.out.println(getName() + " tax amount to pay: " + (getRate() * getHours()) * TAX_RATE);
  }
  
  // ACCESSOR METHODS
  public double getRate() {
    return rate;
  }

  /*
  public void setRate(double rate) {
    if (rate<FEDERAL_MINIMUM) {
      this.rate = FEDERAL_MINIMUM;
      System.out.println(rate + "is lower than federal minimum - using federal minimum instead");
    } else {
      this.rate = rate;
    }
  }
   */

  public void setRate(double rate) {
    if (rate < FEDERAL_MINIMUM) {
      throw new IllegalArgumentException("Tax rate per hour " + rate + " is lower than Federal minimum rate " + FEDERAL_MINIMUM + ".");
    } else {
      this.rate = rate;
    }
  }
  
  public double getHours() {
    return hours;
  }
  public void setHours(double hours) {
    this.hours = hours;
  }

  // Have toString() include Employee.toString() value
  @Override
  public String toString() {
	  return "HourlyEmployee [rate=" + rate + ", hours=" + hours + ", toString()=" + super.toString() + "]";
  }
    
}