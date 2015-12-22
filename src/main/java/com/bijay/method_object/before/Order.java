package com.bijay.method_object.before;

import java.util.*;

/**
 * Created by bijaydeo on 12/20/15.
 */
public class Order {

    String customerId;
    String orderedItemId;
    int orderedQuantity;
    double totalCost;
    float discount;
    String itemName;


    public Order(String customerId, String orderedItemId, String itemName, int orderedQuantity, double totalCost) {
        this.customerId = customerId;
        this.orderedItemId = orderedItemId;
        this.orderedQuantity = orderedQuantity;
        this.itemName = itemName;
        this.totalCost = totalCost;
    }

    public String getOrderedItemId() {
        return orderedItemId;
    }

    public int getOrderedQuantity() {
        return orderedQuantity;
    }

    public String getItemName() {
        return itemName;
    }


    public double getDiscountedCost() {
        return getaDouble();
    }

    private double getaDouble() {
        return totalCost - calculateDiscount() * totalCost;
    }

    //before refactor
    //discount calculation logic
    public float calculateDiscount() {

        Properties discountProperties = new Properties();
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

        if(orderedQuantity>discountQuantity && totalCost>minimumPrice)
            return discount;
        else
            return 0.0f;

    }


}
