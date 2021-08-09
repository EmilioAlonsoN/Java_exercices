package com.hr.personnel;

import java.time.LocalDate;

public class SalariedEmployee extends Employee {

    private double salary;

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

    public void pay() {
        System.out.println(getName() + " is pay per month with a salary of: " + getSalary());
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "salary=" + salary +
                ", toString()=" + super.toString() +
                '}';
    }
}
