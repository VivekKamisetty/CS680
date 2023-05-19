package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingTrolleyTest {
    @Test
    public void testDefaultPricingStrategy() {
        ShoppingTrolley cart = new ShoppingTrolley();

        Item item1 = new Item("Product 1", 10.0);
        Item item2 = new Item("Product 2", 20.0);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.setPricingStrategy(new DefaultPricingStrategy());
        double total = cart.calculateTotal();
        System.out.println(total);

        assertEquals(30.0, total);
    }

    @Test
    public void testDiscountPricingStrategy() {
        ShoppingTrolley cart = new ShoppingTrolley();

        Item item1 = new Item("Product 1", 10.0);
        Item item2 = new Item("Product 2", 20.0);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.setPricingStrategy(new DiscountPricingStrategy());
        double total = cart.calculateTotal();

        assertEquals(27.0, total);
    }
}
