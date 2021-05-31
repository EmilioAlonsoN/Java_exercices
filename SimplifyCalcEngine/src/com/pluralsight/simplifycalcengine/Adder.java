package com.pluralsight.simplifycalcengine;

public class Adder extends CalculateBase {

    public Adder() { }

    public Adder(double lefVal, double rightVal) {
        super(lefVal, rightVal);
    }

    @Override
    public void calculate(){
        double value = getLeftVal() + getRightVal();
        setResult(value);
    }
}
