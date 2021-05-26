package com.pluralsight.simplifycalcengine;

public class Multiplier extends CalculateBase {
    @Override
    public void calculate(){
        double value = getLeftVal() * getRightVal();
        setResult(value);
    }
}
