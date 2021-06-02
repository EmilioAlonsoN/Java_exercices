package com.pluralsight.simplifycalcengine;

public class Multiplier extends CalculateBase implements MathProcessing{

    public Multiplier() { }

    public Multiplier(double lefVal, double rightVal) {
        super(lefVal, rightVal);
    }

    @Override
    public void calculate(){
        double value = getLeftVal() * getRightVal();
        setResult(value);
    }

    @Override
    public String getKeyWord() {
        return "multiply";
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();
        return getResult();
    }
}
