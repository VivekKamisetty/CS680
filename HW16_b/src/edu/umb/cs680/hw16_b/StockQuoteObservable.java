package edu.umb.cs680.hw16_b;

import java.util.HashMap;
import java.util.Map;

public class StockQuoteObservable extends Observable<StockEvent> {
    private Map<String, Double> quotes = new HashMap<>();

    public StockQuoteObservable() {
        Map<String, Double> quotes = new HashMap<>();
    }

    public void changeQuote(String ticker, double quote) {
        quotes.put(ticker, quote);
        notifyObservers(new StockEvent(ticker, quote));
    }

    public double getQuote(String ticker) {
        return quotes.getOrDefault(ticker, 0.0);
    }
}