package com.bijay.compose_method.after;
import com.bijay.method_object.after.Order;

public class DiscountCalculator {
        public static float invoke(Order order) {

            java.util.Properties discountProperties = getDiscountProperties();
            int defaultQuantity = 5;
            double minimumPrice = 100.00;
            float discount = 0.2f;

            int discountQuantity = Integer.parseInt(discountProperties.getProperty("quantity")) == 0 ?defaultQuantity:Integer.parseInt(discountProperties.getProperty("quantity"));
            double minimumDiscountPrice = Integer.parseInt(discountProperties.getProperty("minimum.price")) == 0 ?minimumPrice:Integer.parseInt(discountProperties.getProperty("minimum.price"));

            if(orderQuantityAndCostMoreThanDiscountedValues(order, minimumDiscountPrice, discountQuantity))
                return discount;
            else
                return 0.0f;
        }

    private static boolean orderQuantityAndCostMoreThanDiscountedValues(Order order, double minimumPrice, int discountQuantity) {
        return order.orderedQuantity>discountQuantity && order.totalCost>minimumPrice;
    }

    private static java.util.Properties getDiscountProperties() {
        java.util.Properties discountProperties = new java.util.Properties();
        try {
            discountProperties.load(new java.io.FileInputStream("discount.properties"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return discountProperties;
    }
}