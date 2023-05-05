package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MilageComparatorTest extends TestFixatureInitializer{

    @Test
    public void milageComparatorTest() {
        ArrayList<Car> actual = new ArrayList<>();
        actual.add(toyo);
        actual.add(bmw);
        actual.add(audi);
        actual.add(maruthi);
        actual.add(merc);
        Collections.sort(actual, new MilageComparator());
        ArrayList<Car> expected = new ArrayList<>();
        expected.add(bmw);
        expected.add(audi);
        expected.add(maruthi);
        expected.add(toyo);
        expected.add(merc);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

}