package com.pluralsight.simplifycalcengine;

public class Subtracter extends CalculateBase {

    public Subtracter() { }

    public Subtracter(double lefVal, double rightVal) {
        super(lefVal, rightVal);
    }

    @Override
    public void calculate(){
        double value = getLeftVal() - getRightVal();
        setResult(value);
    }
}
