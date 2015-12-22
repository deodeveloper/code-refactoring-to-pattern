package com.bijay.replace_condition_with_stratergy.after;

/**
 * Created by bijaydeo on 12/21/15.
 */
public class InsuranceStrategyLow extends InsuranceStrategy {
    @Override
    int getConstant() {
        return 0;
    }

    @Override
    double getWeight() {
        return 0.365;
    }

    @Override
    int getAdjustment() {
        return 0;
    }
}
