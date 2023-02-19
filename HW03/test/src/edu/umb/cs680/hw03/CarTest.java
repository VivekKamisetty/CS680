package edu.umb.cs680.hw03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest 
{
	private String[] carToStringArray(Car c)
	{
		String[] carInfo = {c.getMake(), c.getModel(), String.valueOf(c.getYear())};
		return carInfo;
	}
	
	@Test
	public void verifyCarEqualityWithMakeModelYear()
	{
		String[] expected = {"Toyota", "RAV4", "2018"};
		Car actual = new Car("Toyota", "RAV4", 25, 2018, 1000);
		assertArrayEquals(expected, carToStringArray(actual));
	}
}

