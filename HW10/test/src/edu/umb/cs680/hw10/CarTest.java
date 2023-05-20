package edu.umb.cs680.hw10;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void testMatrixWithEuclideanDistance() {
        List<Car> cars = Arrays.asList(
                new Car("Tesla", "ModelY", 5000, 2020, 100000),
                new Car("Mercedes", "AMG", 10000, 2015, 80000),
                new Car("Toyota", "Camry", 15000, 2010, 60000),
                new Car("Honda", "Accord", 20000, 2005, 40000),
                new Car("Ford", "Mustang", 25000, 2000, 20000)
        );

        MinMaxNormalization normalization = new MinMaxNormalization(cars);
        List<List<Double>> normalizedCars = normalization.getNormalizedCars();

        List<List<Double>> distanceMatrix = Distance.matrix(normalizedCars, new Euclidean());

        double[][] expectedEuclidean = {
                {0.0, 0.4330127018922193, 0.8660254037844386, 1.299038105676658, 1.7320508075688772},
                {0.4330127018922193, 0.0, 0.4330127018922193, 0.8660254037844386, 1.299038105676658},
                {0.8660254037844386, 0.4330127018922193, 0.0, 0.4330127018922193, 0.8660254037844386},
                {1.299038105676658, 0.8660254037844386, 0.4330127018922193, 0.0, 0.4330127018922193},
                {1.7320508075688772, 1.299038105676658, 0.8660254037844386, 0.4330127018922193, 0.0},
        };

        int numRows = expectedEuclidean.length;
        int numCols = expectedEuclidean[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                assertEquals(expectedEuclidean[i][j], distanceMatrix.get(i).get(j));
            }
        }
    }

    @Test
    public void testMatrixWithManhattanDistance() {
        List<Car> cars = Arrays.asList(
                new Car("Tesla", "ModelY", 5000, 2020, 100000),
                new Car("Mercedes", "AMG", 10000, 2015, 80000),
                new Car("Toyota", "Camry", 15000, 2010, 60000),
                new Car("Honda", "Accord", 20000, 2005, 40000),
                new Car("Ford", "Mustang", 25000, 2000, 20000)
        );

        MinMaxNormalization normalization = new MinMaxNormalization(cars);
        List<List<Double>> normalizedCars = normalization.getNormalizedCars();

        List<List<Double>> distanceMatrix = Distance.matrix(normalizedCars, new Manhattan());


        double[][] expectedEuclidean = {
                {0.0, 0.75, 1.5, 2.25, 3.0},
                {0.75, 0.0, 0.75, 1.5, 2.25},
                {1.5, 0.75, 0.0, 0.75, 1.5},
                {2.25, 1.5, 0.75, 0.0, 0.75},
                {3.0, 2.25, 1.5, 0.75, 0.0},
        };

        int numRows = expectedEuclidean.length;
        int numCols = expectedEuclidean[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                assertEquals(expectedEuclidean[i][j], distanceMatrix.get(i).get(j));
            }
        }
    }


    @Test
    public void testMatrixWithChebyshevDistance() {
        List<Car> cars = Arrays.asList(
                new Car("Tesla", "ModelY", 5000, 2020, 100000),
                new Car("Mercedes", "AMG", 10000, 2015, 80000),
                new Car("Toyota", "Camry", 15000, 2010, 60000),
                new Car("Honda", "Accord", 20000, 2005, 40000),
                new Car("Ford", "Mustang", 25000, 2000, 20000)
        );

        MinMaxNormalization normalization = new MinMaxNormalization(cars);
        List<List<Double>> normalizedCars = normalization.getNormalizedCars();

        List<List<Double>> distanceMatrix = Distance.matrix(normalizedCars, new Chebyshev());

        double[][] expectedEuclidean = {
                {0.0, 0.25, 0.5, 0.75, 1.0},
                {0.25, 0.0, 0.25, 0.5, 0.75},
                {0.5, 0.25, 0.0, 0.25, 0.5},
                {0.75, 0.5, 0.25, 0.0, 0.25},
                {1.0, 0.75, 0.5, 0.25, 0.0},
        };

        int numRows = expectedEuclidean.length;
        int numCols = expectedEuclidean[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                assertEquals(expectedEuclidean[i][j], distanceMatrix.get(i).get(j));
            }
        }
    }
}