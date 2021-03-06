package com.bijay.method_object.after;

/**
 * Created by bijaydeo on 12/20/15.
 */
public class Order {

    String customerId;
    String orderedItemId;
    public int orderedQuantity;
    public double totalCost;
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
        return totalCost - calculateDiscount() * totalCost;
    }

    //after refactor
    //discount calculation logic
    public float calculateDiscount() {

        return DiscountCalculator.invoke(this);

    }


    public static class DiscountCalculator {
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
}
