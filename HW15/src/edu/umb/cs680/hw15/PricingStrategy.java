package edu.umb.cs680.hw15;

import java.util.List;

public interface PricingStrategy {
    double priceCalculator(List<Item> items);
}
