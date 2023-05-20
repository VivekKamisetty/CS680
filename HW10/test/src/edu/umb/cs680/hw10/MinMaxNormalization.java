package edu.umb.cs680.hw10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class MinMaxNormalization {
    private List<List<Double>> normalizedCars;

    public MinMaxNormalization(List<Car> cars) {
        normalizedCars = normalizeCars(cars);
    }

    private List<List<Double>> normalizeCars(List<Car> cars) {
        List<List<Double>> normalizedCars = new ArrayList<>();

        double minPrice = Double.MAX_VALUE;
        double maxPrice = Double.MIN_VALUE;
        int minYear = Integer.MAX_VALUE;
        int maxYear = Integer.MIN_VALUE;
        int minMileage = Integer.MAX_VALUE;
        int maxMileage = Integer.MIN_VALUE;


        for (Car car : cars) {
            minPrice = Math.min(minPrice, car.getPrice());
            maxPrice = Math.max(maxPrice, car.getPrice());
            minYear = Math.min(minYear, car.getYear());
            maxYear = Math.max(maxYear, car.getYear());
            minMileage = Math.min(minMileage, car.getMileage());
            maxMileage = Math.max(maxMileage, car.getMileage());
        }

        for (Car car : cars) {
            List<Double> normalizedValues = new ArrayList<>();


            double normalizedPrice = (car.getPrice() - minPrice) / (maxPrice - minPrice);
            normalizedValues.add(normalizedPrice);


            double normalizedYear = (car.getYear() - minYear) / (double) (maxYear - minYear);
            normalizedValues.add(normalizedYear);

            double normalizedMileage = (car.getMileage() - minMileage) / (double) (maxMileage - minMileage);
            normalizedValues.add(normalizedMileage);

            normalizedCars.add(normalizedValues);
        }

        return normalizedCars;
    }

    public List<List<Double>> getNormalizedCars() {
        return normalizedCars;
    }
}