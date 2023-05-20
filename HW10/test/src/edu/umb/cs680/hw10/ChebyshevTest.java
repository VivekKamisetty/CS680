package edu.umb.cs680.hw10;

//import org.junit.jupiter.api.Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChebyshevTest {


        @Test
        public void testChebyshevDistance() {
            List<Double> p1 = Arrays.asList(1.0, 2.0, 3.0);
            List<Double> p2 = Arrays.asList(4.0, 5.0, 6.0);
            DistanceMetric chebyshev = new Chebyshev();
            double distance = chebyshev.distance(p1, p2);
            assertEquals(3.0, distance, 0.0001);
        }

        @Test
        public void testChebyshevDistanceMatrix() {
            List<List<Double>> points = new ArrayList<>();
            points.add(Arrays.asList(1.0, 2.0, 3.0));
            points.add(Arrays.asList(4.0, 5.0, 6.0));
            points.add(Arrays.asList(7.0, 8.0, 9.0));
            DistanceMetric chebyshev = new Chebyshev();
            double[][] expected = {{0.0, 3.0, 6.0}, {3.0, 0.0, 3.0}, {6.0, 3.0, 0.0}};
            double[][] actual = new double[3][3];
            for (int i = 0; i < points.size(); i++) {
                for (int j = 0; j < points.size(); j++) {
                    actual[i][j] = chebyshev.distance(points.get(i), points.get(j));
                }
            }
            assertArrayEquals(expected, actual);
        }
    }

