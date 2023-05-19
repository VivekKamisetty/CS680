#Shopping Trolley Application

##This application simulates a shopping trolley where customers can add items and calculate the total cost based on different pricing strategies. The application uses the Strategy design pattern to allow customers to switch between different pricing strategies.

##The main classes in the application are:

##- ShoppingTrolley: Represents the shopping trolley and contains a list of items. It also has a reference to the currently selected pricing strategy.

##- Item: Represents an item with a name and price.

##- PricingStrategy: Defines the interface for different pricing strategies. It has a single method `priceCalculator` that takes a list of items and returns the total cost.

##- DefaultPricingStrategy: Implements the `PricingStrategy` interface and calculates the total cost without any discounts or promotions.

##- DiscountPricingStrategy: Implements the `PricingStrategy` interface and applies a 10% discount to the total cost of all items.

