package com.bijay.replace_condition_with_stratergy.after;

/**
 * Created by bijaydeo on 12/21/15.
 */
public class InsuranceStrategyMedium extends InsuranceStrategy {
    @Override
    int getConstant() {
        return 35600;
    }

    @Override
    double getWeight() {
        return 0.2;
    }

    @Override
    int getAdjustment() {
        return 10000;
    }
}
