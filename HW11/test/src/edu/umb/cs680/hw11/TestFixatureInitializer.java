package edu.umb.cs680.hw11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestFixatureInitializer {

    protected LinkedList<Car> usedCars = new LinkedList<>();

    protected Car toyo;
    protected Car bmw;
    protected Car audi;
    protected Car maruthi;
    protected Car merc;

    @BeforeAll
    public void setUp() {
        toyo = new Car("Toyota", "RAV4", 35000, 2018, 10000);
        bmw = new Car("BMW", "X5", 18000, 2017, 34000);
        audi = new Car("Audi", "Q5", 22000, 2018, 40000);
        maruthi = new Car("Maruthi", "Zen", 25000, 2000, 2000);
        merc = new Car("Mercedes", "Gwagon", 80000, 2020, 90000);

        usedCars.add(toyo);
        usedCars.add(bmw);
        usedCars.add(audi);
        usedCars.add(maruthi);
        usedCars.add(merc);

    }
}
