package edu.umb.cs680.hw16_b;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObserverTest {

    private StockQuoteObservable observable;
    private Observer<StockEvent> tableObserver;

    private Observer<StockEvent> lineChartObserver;
    private Observer<StockEvent> observer3D;

    private Map<String, Double> tableQuotes = new HashMap<>();
    private Map<String, Double> observer3DQuotes = new HashMap<>();
    private Map<String, Double> lineChartQuotes = new HashMap<>();



    @Test
    public void testObservers() {
        Observable<StockEvent> stockEventObservable = new Observable<>();


        Observer<StockEvent> tableObserver = (sender, event) -> {
            tableQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Table updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        stockEventObservable.addObserver(tableObserver);


        Map<String, Double> observer3DQuotes = new HashMap<>();
        Observer<StockEvent> observer3D = (sender, event) -> {
            observer3DQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("3D visualization updated with quote %.2f for %s", event.getQuote(), event.getTicker()));
        };
        stockEventObservable.addObserver(observer3D);


        Map<String, Double> lineChartQuotes = new HashMap<>();
        Observer<StockEvent> lineChartObserver = (sender, event) -> {
            lineChartQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Line chart updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        stockEventObservable.addObserver(lineChartObserver);


        StockEvent stockEvent = new StockEvent("AAPL", 142.55);
        stockEventObservable.notifyObservers(stockEvent);


        assertEquals(tableQuotes.get("AAPL"), 142.55);
        assertEquals(observer3DQuotes.get("AAPL"), 142.55);
        assertEquals(lineChartQuotes.get("AAPL"), 142.55);

    }




    @Test
    void testObservers1() {
        StockQuoteObservable observable = new StockQuoteObservable();
        Map<String, Double> tableQuotes = new HashMap<>();
        Map<String, Double> observer3DQuotes = new HashMap<>();
        Map<String, Double> lineChartQuotes = new HashMap<>();

        Observer<StockEvent> tableObserver = (sender, event) -> {
            tableQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Table updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        observable.addObserver(tableObserver);

        Observer<StockEvent> observer3D = (sender, event) -> {
            observer3DQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("3D visualization updated with quote %.2f for %s", event.getQuote(), event.getTicker()));
        };
        observable.addObserver(observer3D);

        Observer<StockEvent> lineChartObserver = (sender, event) -> {
            lineChartQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Line chart updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        observable.addObserver(lineChartObserver);

        observable.removeObserver(tableObserver);
        observable.changeQuote("APL", 69.0);
        assertEquals(2, observable.countObservers());

        observable.addObserver(tableObserver);
        observable.changeQuote("TES", 43.0);
        assertEquals(3, observable.countObservers());
    }

    @Test
    void testGetObserver() {
        StockQuoteObservable observable = new StockQuoteObservable();
        Map<String, Double> tableQuotes = new HashMap<>();
        Map<String, Double> observer3DQuotes = new HashMap<>();
        Map<String, Double> lineChartQuotes = new HashMap<>();

        Observer<StockEvent> tableObserver = (sender, event) -> {
            tableQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Table updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        observable.addObserver(tableObserver);

        Observer<StockEvent> observer3D = (sender, event) -> {
            observer3DQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("3D visualization updated with quote %.2f for %s", event.getQuote(), event.getTicker()));
        };
        observable.addObserver(observer3D);

        Observer<StockEvent> lineChartObserver = (sender, event) -> {
            lineChartQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Line chart updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        observable.addObserver(lineChartObserver);
        int lenOfObservers = observable.getObservers().size();
        assertEquals(3, lenOfObservers);
    }

    @Test
    void testClearObservers() {
        StockQuoteObservable observable = new StockQuoteObservable();
        Map<String, Double> tableQuotes = new HashMap<>();
        Map<String, Double> observer3DQuotes = new HashMap<>();
        Map<String, Double> lineChartQuotes = new HashMap<>();

        Observer<StockEvent> tableObserver = (sender, event) -> {
            tableQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Table updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        observable.addObserver(tableObserver);

        Observer<StockEvent> observer3D = (sender, event) -> {
            observer3DQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("3D visualization updated with quote %.2f for %s", event.getQuote(), event.getTicker()));
        };
        observable.addObserver(observer3D);

        Observer<StockEvent> lineChartObserver = (sender, event) -> {
            lineChartQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Line chart updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        observable.addObserver(lineChartObserver);

        observable.clearObservers();
        assertEquals(0, observable.countObservers());
    }

    @Test
    void testPeriodically() throws InterruptedException {

        StockQuoteObservable observable = new StockQuoteObservable();
        Map<String, Double> tableQuotes = new HashMap<>();
        Map<String, Double> observer3DQuotes = new HashMap<>();
        Map<String, Double> lineChartQuotes = new HashMap<>();

        Observer<StockEvent> tableObserver = (sender, event) -> {
            tableQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Table updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        observable.addObserver(tableObserver);

        Observer<StockEvent> observer3D = (sender, event) -> {
            observer3DQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("3D visualization updated with quote %.2f for %s", event.getQuote(), event.getTicker()));
        };
        observable.addObserver(observer3D);

        Observer<StockEvent> lineChartObserver = (sender, event) -> {
            lineChartQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Line chart updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        observable.addObserver(lineChartObserver);

        observable.changeQuote("QWE", 88);
        assertEquals(3, observable.countObservers());
        Thread.sleep(1000);

        observable.changeQuote("QWE", 44);
        assertEquals(3, observable.countObservers());

    }


    @Test
    void testLineChartObserver() {

        StockQuoteObservable observable = new StockQuoteObservable();
        Map<String, Double> tableQuotes = new HashMap<>();
        Map<String, Double> observer3DQuotes = new HashMap<>();
        Map<String, Double> lineChartQuotes = new HashMap<>();

        Observer<StockEvent> tableObserver = (sender, event) -> {
            tableQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Table updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        observable.addObserver(tableObserver);

        Observer<StockEvent> observer3D = (sender, event) -> {
            observer3DQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("3D visualization updated with quote %.2f for %s", event.getQuote(), event.getTicker()));
        };
        observable.addObserver(observer3D);

        Observer<StockEvent> lineChartObserver = (sender, event) -> {
            lineChartQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Line chart updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        observable.addObserver(lineChartObserver);

        double quote = 50.0;
        String ticker = "AAPL";
        observable.changeQuote(ticker, quote);

        Map<String, Double> expected = Map.of(ticker, quote);
        assertEquals(expected, lineChartQuotes);
    }

    @Test
    void testObserver3D() {

        StockQuoteObservable observable = new StockQuoteObservable();
        Map<String, Double> tableQuotes = new HashMap<>();
        Map<String, Double> observer3DQuotes = new HashMap<>();
        Map<String, Double> lineChartQuotes = new HashMap<>();

        Observer<StockEvent> tableObserver = (sender, event) -> {
            tableQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Table updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        observable.addObserver(tableObserver);

        Observer<StockEvent> observer3D = (sender, event) -> {
            observer3DQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("3D visualization updated with quote %.2f for %s", event.getQuote(), event.getTicker()));
        };
        observable.addObserver(observer3D);

        Observer<StockEvent> lineChartObserver = (sender, event) -> {
            lineChartQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Line chart updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        observable.addObserver(lineChartObserver);

        double quote1 = 50.0;
        String ticker1 = "AAPL";
        observable.changeQuote(ticker1, quote1);
        Map<String, Double> expected = Map.of(ticker1, quote1);
        assertEquals(expected, observer3DQuotes);
    }

    @Test
    void testTableObserver() {

        StockQuoteObservable observable = new StockQuoteObservable();
        Map<String, Double> tableQuotes = new HashMap<>();
        Map<String, Double> observer3DQuotes = new HashMap<>();
        Map<String, Double> lineChartQuotes = new HashMap<>();

        Observer<StockEvent> tableObserver = (sender, event) -> {
            tableQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Table updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        observable.addObserver(tableObserver);

        Observer<StockEvent> observer3D = (sender, event) -> {
            observer3DQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("3D visualization updated with quote %.2f for %s", event.getQuote(), event.getTicker()));
        };
        observable.addObserver(observer3D);

        Observer<StockEvent> lineChartObserver = (sender, event) -> {
            lineChartQuotes.put(event.getTicker(), event.getQuote());
            System.out.println(String.format("Line chart updated for %s with quote %.2f", event.getTicker(), event.getQuote()));
        };
        observable.addObserver(lineChartObserver);

        double quote = 50.0;
        String ticker = "AAPL";
        observable.changeQuote(ticker, quote);
        Map<String, Double> expected = Map.of(ticker, quote);
        assertEquals(expected, tableQuotes);
    }
}
