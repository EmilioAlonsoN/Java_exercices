/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

/*
 * 
 * The Department class manages employees
 * 
 * The class includes the following properties:
 *   String name, location.
 *   Employee[] employees: The employees in the department (in an array).
 *   int currentIndex: Internal counter for number of employees in the department
 *    *  
 *  The class includes the following methods (besides get/set methods)
 *  void listEmployees(): Output info on all employees in the dept.
 *  void workEmployees(): Tell all the employees in the dept. to work.
 *  String toString(): Generates string from an instance.
 *    
 */

package com.hr.personnel;

import java.util.ArrayList;
import java.util.Collection;

public class Department {
  // INSTANCE VARIABLES
  private String name;
  private String location;
  //private Employee[] employees = new Employee[100];
  private Collection<Employee> employees = new ArrayList<>(100);
  private int currentIndex = 0;  // for dealing with array

  // CONSTRUCTORS
  public Department() {
  }
  
  public Department(String name, String location) {
    setName(name);
    setLocation(location);
  }
  
  // BEHAVIORAL METHODS
  public void listEmployees() {
	  // Note that we don't use for-each here because we only want to access the array where employees were added
	  // Question: What is in the array for indices where no Employee was added?
	  for (Employee current : employees) {
		  System.out.println(current);
	  }
  }

  public void workEmployees() {
    for (Employee current : employees) {
      current.work();
    }
  }
  
  // Implement payEmployees() method by calling pay() on each Employee
  // it will look similar to the workEmployees() method above
  public void payEmployees() {
    for (Employee current : employees) {
      current.pay();
    }
  }
  
  // helper method to add an Employee to the array
  public void addEmployee(Employee emp) {
    employees.add(emp);
  }
  
  // ACCESSOR METHODS
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }

  public String toString() {
    return "Department: name=" + getName() + ", location=" + getLocation();
  }
}