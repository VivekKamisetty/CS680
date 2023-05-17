package edu.umb.cs680.hw13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CarTest extends TestFixatureInitializer{
    static LinkedList<Car> carList = new LinkedList<Car>();


    @BeforeAll
    public static void carList() {
        //LinkedList<Car> carList = new LinkedList<Car>();
        carList.add(toyo);
        carList.add(bmw);
        carList.add(audi);
        carList.add(maruthi);
        carList.add(merc);
    }

    @Test
    public void testAscendingOrderLEMileage() {
        LinkedList<Car> expected = new LinkedList<Car>();
        expected.add(bmw);
        expected.add(audi);
        expected.add(maruthi);
        expected.add(toyo);
        expected.add(merc);
        Collections.sort(carList, Comparator.comparing((Car car)-> car.getMileage()));
        assertArrayEquals(expected.toArray(), carList.toArray());

    }

    @Test
    public void testAscendingOrderLEPrice() {
        LinkedList<Car> expected = new LinkedList<Car>();
        expected.add(maruthi);
        expected.add(toyo);
        expected.add(bmw);
        expected.add(audi);
        expected.add(merc);
        Collections.sort(carList, Comparator.comparing((Car car)-> car.getPrice()));
        assertArrayEquals(expected.toArray(), carList.toArray());
    }

    @Test
    public void testAscendingOrderLEYear() {
        LinkedList<Car> expected = new LinkedList<Car>();
        expected.add(maruthi);
        expected.add(bmw);
        expected.add(toyo);
        expected.add(audi);
        expected.add(merc);
        Collections.sort(carList, Comparator.comparing((Car car)-> car.getYear()));
        assertArrayEquals(expected.toArray(), carList.toArray());
    }


    @Test
    public void testDescendingOrderLEPrice() {
        LinkedList<Car> expected = new LinkedList<Car>();
        expected.add(merc);
        expected.add(audi);
        expected.add(bmw);
        expected.add(toyo);
        expected.add(maruthi);
        Collections.sort(carList, Comparator.comparing((Car car)-> car.getPrice(), Comparator.reverseOrder()));
        assertArrayEquals(expected.toArray(), carList.toArray());
    }

    @Test
    public void testDescendingOrderLEMileage() {
        LinkedList<Car> expected = new LinkedList<Car>();
        expected.add(merc);
        expected.add(toyo);
        expected.add(maruthi);
        expected.add(audi);
        expected.add(bmw);
        Collections.sort(carList, Comparator.comparing((Car car)-> car.getMileage(), Comparator.reverseOrder()));
        assertArrayEquals(expected.toArray(), carList.toArray());
    }


}
