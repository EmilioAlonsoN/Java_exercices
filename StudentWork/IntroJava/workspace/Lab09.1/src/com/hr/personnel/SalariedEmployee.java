/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

/*
 * The SalariedEmployee class is a fairly simple class.  It mainly serves as a simple 
 * derived class to illustrate inheritance.
 * 
 * SalariedEmployee includes the following properties:
 *   double salary - pay for a given pay period
 *  
 *  SalariedEmployee includes the following methods (besides get/set methods)
 *  String toString(): Generates string from SalariedEmployee object.
 */

package com.hr.personnel;

import java.time.LocalDate;

// TODO: Implement the TaxPayer method in this class.  Note that we don't have to say "implements TaxPayer"
// again, because it inherits this from Employee.  Another example of IS-A
// SalariedEmployee IS-A Employee, and Employee IS-A TaxPayer, then SalariedEmployee IS-A TaxPayer.
public class SalariedEmployee extends Employee {
  // CLASS CONSTANTS
  public static final double TAX_RATE = 0.30;
	  
  // INSTANCE VARIABLES
  private double salary;
  
  // CONSTRUCTORS
  public SalariedEmployee() {
  }

  public SalariedEmployee(String name, LocalDate hireDate) {
    setName(name);
    setHireDate(hireDate);
  }
  
  public SalariedEmployee(String name, LocalDate hireDate, double salary) {
    setName(name);
    setHireDate(hireDate);
    setSalary(salary);
  }
  
  // BEHAVIORAL METHODS
  // Implement pay() method by printing message: <name> is paid salary <value>
  public void pay() {
    System.out.println(getName() + " is paid salary " + getSalary());
  }

  public void payTaxes() {
    System.out.println(getName() + " tax amount to pay: " + (getSalary() * TAX_RATE));
  }
  
  // ACCESSOR METHODS
  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  // Have toString() include Employee.toString() value
  @Override
  public double getStandardDeductions () {

    return 100000;
  }

  @Override
  public String toString() {
	  return "SalariedEmployee [salary=" + salary + ", toString()=" + super.toString() + "]";
  }

}