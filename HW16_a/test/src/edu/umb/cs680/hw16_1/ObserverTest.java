package edu.umb.cs680.hw16_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObserverTest {

    private StackQuoteObservable observable;
    private LineChartObserver lineChartObserver;
    private Observer3D observer3D;
    private TableObserver tableObserver;

    @BeforeEach
    void setUp() {
        observable = new StackQuoteObservable();
        lineChartObserver = new LineChartObserver();
        observer3D = new Observer3D();
        tableObserver = new TableObserver();
        observable.addObserver(lineChartObserver);
        observable.addObserver(observer3D);
        observable.addObserver(tableObserver);
    }

    @Test
    void testObservers() {
        observable.removeObserver(tableObserver);
        observable.changeQuote("APL", 69.0);
        assertEquals(2, observable.countObservers());

        observable.addObserver(tableObserver);
        observable.changeQuote("TES", 43.0);
        assertEquals(3, observable.countObservers());
    }

    @Test
    void testGetObserver() {
        int lenOfObservers = observable.getObservers().size();
        assertEquals(3, lenOfObservers);
    }

    @Test
    void testClearObservers() {
        observable.clearObservers();
        assertEquals(0, observable.countObservers());
    }

    @Test
    void testPeriodically() throws InterruptedException {
        observable.changeQuote("QWE", 88);
        assertEquals(3, observable.countObservers());
        Thread.sleep(1000);

        observable.changeQuote("QWE", 44);
        assertEquals(3, observable.countObservers());

    }


    @Test
    void testLineChartObserver() {
        double quote = 50.0;
        String ticker = "AAPL";
        observable.changeQuote(ticker, quote);
        Map<String, Double> expected = Map.of(ticker, quote);
        //System.out.println(lineChartObserver.getQuote());
        assertEquals(expected, lineChartObserver.getQuotes());
    }

    @Test
    void testObserver3D() {
        double quote1 = 50.0;
        double quote2 = 60.0;
        String ticker1 = "AAPL";
        String ticker2 = "GOOG";
        observable.changeQuote(ticker1, quote1);
        observable.changeQuote(ticker2, quote2);
        Map<String, Double> expected = Map.of(ticker1, quote1, ticker2, quote2);
        assertEquals(expected, observer3D.getQuotes());
    }

    @Test
    void testTableObserver() {
        double quote = 50.0;
        String ticker = "AAPL";
        observable.changeQuote(ticker, quote);
        Map<String, Double> expected = Map.of(ticker, quote);
        assertEquals(expected, tableObserver.getQuotes());
    }

}