package edu.umb.cs680.hw11;

import java.util.Comparator;

public class ParetoCompartor implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return car1.getDominationCount() - car2.getDominationCount();
    }
}
