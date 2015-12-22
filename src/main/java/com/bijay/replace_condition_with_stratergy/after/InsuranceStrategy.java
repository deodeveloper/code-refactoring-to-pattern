package com.bijay.replace_condition_with_stratergy.after;

/**
 * Created by bijaydeo on 12/21/15.
 */
public abstract class InsuranceStrategy {
    double calculate(double income) {
        return (income - getAdjustment()) * getWeight() + getConstant();
    }

    abstract int getConstant();

    abstract double getWeight();

    abstract int getAdjustment();
}
