package edu.umb.cs680.hw16_1;

import java.util.HashMap;
import java.util.Map;

public class LineChartObserver implements Observer<StockEvent> {

    private Map<String, Double> quotes = new HashMap<>();
    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        quotes.put(event.getTicker(), event.getQuote());
        System.out.println(String.format("Line chart updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
    }

    public Map<String, Double> getQuotes() {
      return quotes;
    }
}
