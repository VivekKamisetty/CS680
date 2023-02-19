package edu.umb.cs680.hw01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeGeneratorTest 
{
	@Test
	void primesNumbersFrom1to20Test()
	{
		PrimeGenerator out = new PrimeGenerator(1,20);
		out.generatePrimes();
		
		Long[] expectedPrimes = {2l, 3l, 5l, 7l, 11l, 13l, 17l, 19l};
		assertArrayEquals(expectedPrimes, out.getPrimes().toArray());
	}
	
	@Test
	void primesNegativeIntTest()
	{
		try {
		PrimeGenerator out = new PrimeGenerator(-9, 9);
		out.generatePrimes();
		//Long [] expectedPrimes = {2l, 3l, 5l, 7l};
		//assertArrayEquals(expectedPrimes, out.getPrimes().toArray());
		}
		catch(Exception e) {
			assertEquals("Wrong input values: from=-9 to=9" ,e.getMessage());
		}
	}
	
	@Test
	void primesWrongRange50to1Test()
	{
		try {
		PrimeGenerator out = new PrimeGenerator(50,1);
		out.generatePrimes();
		//Long [] expectedPrimes = {};
		//assertArrayEquals(expectedPrimes, out.getPrimes().toArray());
		}
		catch(Exception e) {
			assertEquals("Wrong input values: from=50 to=1",e.getMessage());
		}
		}
	}
	
	


