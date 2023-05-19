package edu.umb.cs680.hw15;

import java.util.ArrayList;
import java.util.List;

public class ShoppingTrolley {
    private List<Item> items;
    private PricingStrategy pricingStrategy;

    public ShoppingTrolley() {
        this.items = new ArrayList<>();
        this.pricingStrategy = new DefaultPricingStrategy();
    }

    public void addItem(Item i) {
        items.add(i);
    }

    public void setPricingStrategy(PricingStrategy s) {
        this.pricingStrategy = s;
    }

    public double calculateTotal() {
        return pricingStrategy.priceCalculator(items);
    }
}
