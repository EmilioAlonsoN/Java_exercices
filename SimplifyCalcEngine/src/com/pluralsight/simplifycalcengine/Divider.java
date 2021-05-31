package com.pluralsight.simplifycalcengine;

public class Divider extends CalculateBase {

    public Divider() { }

    public Divider(double lefVal, double rightVal) {
        super(lefVal, rightVal);
    }

    @Override
    public void calculate(){
        double value = getLeftVal() / getRightVal();
        setResult(value);
    }
}
