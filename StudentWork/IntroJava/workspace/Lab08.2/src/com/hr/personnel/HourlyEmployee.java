package com.hr.personnel;

import java.time.LocalDate;

public class HourlyEmployee extends Employee{

    private double rate;
    private double hours;

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

    public void pay() {
        System.out.println(getName() + " is pay per hour with salary of : " + (getRate() * getHours()) );
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "rate=" + rate +
                ", hours=" + hours +
                ", toString()=" + super.toString() +
                '}';
    }
}
