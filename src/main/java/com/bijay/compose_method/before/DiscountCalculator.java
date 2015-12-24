package com.bijay.compose_method.before;
import com.bijay.method_object.after.Order;
/**
 * Created by bijaydeo on 12/24/15.
 */
public  class DiscountCalculator {
    public static float invoke(Order order) {
        java.util.Properties discountProperties = new java.util.Properties();
        try {
            discountProperties.load(new java.io.FileInputStream("discount.properties"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        int defaultQuantity = 5;
        double minimumPrice = 100.00;
        float discount = 0.2f;
        int discountQuantity = Integer.parseInt(discountProperties.getProperty("quantity")) == 0 ?defaultQuantity:Integer.parseInt(discountProperties.getProperty("quantity"));
        double minimumDiscountPrice = Integer.parseInt(discountProperties.getProperty("minimum.price")) == 0 ?minimumPrice:Integer.parseInt(discountProperties.getProperty("minimum.price"));

        if(order.orderedQuantity>discountQuantity && order.totalCost>minimumDiscountPrice)
            return discount;
        else
            return 0.0f;
    }
}