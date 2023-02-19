package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PrimeGeneratorSingletonTest 
{
	@Test
	void checkInstanceNotNull()
	{
		SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(1, 10);
		assertNotNull(gen);
	}
	
	@Test
	void checkObjectSame()
	{
		SingletonPrimeGenerator gen1 = SingletonPrimeGenerator.getInstance(10, 20);
		SingletonPrimeGenerator gen2 = SingletonPrimeGenerator.getInstance(30, 40);
		
		assertEquals(gen1.hashCode(), gen2.hashCode());
		assertSame(gen1, gen2);
	}
	
	@Test
	void InvalidRangeCheck()
	{
		try {
			SingletonPrimeGenerator out =  SingletonPrimeGenerator.getInstance(50,1);
			out.generatePrimes();
			}
			catch(Exception e) {
				assertEquals("Wrong input values: from=50 to=1",e.getMessage());
			}
	}
}

