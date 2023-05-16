package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ParetoCompartorTest extends TestFixatureInitializer{

    @Test
    public void paretoComparatorTest() {
        for(Car car:usedCars){
            car.setDominantionCount(usedCars);
        }
        Collections.sort(usedCars, new ParetoCompartor());
        ArrayList<Car> expected = new ArrayList<>();
        expected.add(bmw);
        expected.add(audi);
        expected.add(maruthi);
        expected.add(toyo);
        expected.add(merc);
        assertArrayEquals(expected.toArray(), usedCars.toArray());
    }

}