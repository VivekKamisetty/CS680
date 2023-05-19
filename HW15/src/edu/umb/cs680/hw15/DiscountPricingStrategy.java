package edu.umb.cs680.hw15;

import java.util.List;

public class DiscountPricingStrategy implements PricingStrategy {
    public double priceCalculator(List<Item> items) {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice() * 0.9; // Applying 10% discount
        }
        return total;
    }
}
