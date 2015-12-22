package com.bijay.replace_condition_with_stratergy.after;

/**
 * Created by bijaydeo on 12/21/15.
 */
public class InsuranceStrategyHigh extends InsuranceStrategy {
    @Override
    int getConstant() {
        return 76500;
    }

    @Override
    double getWeight() {
        return 0.1;
    }

    @Override
    int getAdjustment() {
        return 30000;
    }
}
