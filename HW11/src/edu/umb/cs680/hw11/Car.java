package edu.umb.cs680.hw11;


import java.util.LinkedList;

public class Car
{
    private String make, model;
    private int mileage, year;
    private float price;
    private int dominationCount;


    public Car(String make, String model, int mileage, int year, float price)
    {
        this.make = make;
        this.model = model;
        this.mileage =  mileage;
        this.year = year;
        this.price = price;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public void setMileage(int mileage)
    {
        this.mileage = mileage;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public String getMake()
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }

    public int getMileage()
    {
        return mileage;
    }

    public int getYear()
    {
        return year;
    }

    public float getPrice()
    {
        return price;
    }

    public int getDominationCount() {
        return dominationCount;
    }

    public void setDominantionCount(LinkedList<Car> cars) {
            int count = 0;
            for (Car car : cars) {
                boolean dominates = true;
                if (car.getYear() < this.getYear() ||
                        car.getMileage() < this.getMileage() ||
                        car.getPrice() > this.getPrice() &&
                                this.getPrice() <= car.getPrice() &&
                                this.getMileage() <= car.getMileage() &&
                                this.getYear() >= car.getYear()
                ) {
                    dominationCount++;
                }
            }
    }
}