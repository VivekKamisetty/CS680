package edu.umb.cs680.hw16_1;

import java.util.HashMap;
import java.util.Map;

public class Observer3D implements Observer<StockEvent> {
    private Map<String, Double> quotes = new HashMap<>();

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        quotes.put(event.getTicker(), event.getQuote());
        System.out.println(String.format("3D visualization updated with quote %.2f for %s", event.getQuote(), event.getTicker()));
    }

    public Map<String, Double> getQuotes() {
        return quotes;
    }
}