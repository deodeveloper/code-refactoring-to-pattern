package com.bijay.replace_condition_with_stratergy.after;

/**
 * Created by bijaydeo on 12/21/15.
 */
public class ConditionalDemo {
    private InsuranceStrategy strategy;

    public double calculateInsurance() {

        double income = 15000;

        if (income <= 10000) {
            strategy = new InsuranceStrategyLow();
            return strategy.calculate(income);
        } else if (income <= 30000) {
            strategy = new InsuranceStrategyMedium();
            return strategy.calculate(income);
        } else if (income <= 60000) {
            strategy = new InsuranceStrategyHigh();
            return strategy.calculate(income);
        } else {
            strategy = new InsuranceStrategyVeryHigh();
            return strategy.calculate(income);
        }

    }

}
