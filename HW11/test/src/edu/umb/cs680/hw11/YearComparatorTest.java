package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class YearComparatorTest extends TestFixatureInitializer{

    @Test
    public void YearComparatorTest() {
        ArrayList<Car> actual = new ArrayList<>();
        actual.add(toyo);
        actual.add(bmw);
        actual.add(audi);
        actual.add(maruthi);
        actual.add(merc);
        Collections.sort(actual, new YearComparator());
        ArrayList<Car> expected = new ArrayList<>();
        expected.add(merc);
        expected.add(toyo);
        expected.add(audi);
        expected.add(bmw);
        expected.add(maruthi);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

}