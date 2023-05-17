package edu.umb.cs680.hw16_b;

public interface Observer<StockEvent> {
    //public void update(Observable<StockEvent> sender, StockEvent event);

    void update(Observable<StockEvent> sender, StockEvent event);

}
