package com.pluralsight.simplifycalcengine;

public class Multiplier extends CalculateBase {

    public Multiplier() { }

    public Multiplier(double lefVal, double rightVal) {
        super(lefVal, rightVal);
    }

    @Override
    public void calculate(){
        double value = getLeftVal() * getRightVal();
        setResult(value);
    }
}
