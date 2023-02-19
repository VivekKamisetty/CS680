package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeGeneratorSingletonTest 
{
	@Test
	void checkInstanceNotNull()
	{
		PrimeGenerator gen = PrimeGenerator.getInstance(1, 10);
		assertNotNull(gen);
	}
	
	@Test
	void checkObjectSame()
	{
		PrimeGenerator gen1 = PrimeGenerator.getInstance(10, 20);
		PrimeGenerator gen2 = PrimeGenerator.getInstance(30, 40);
		
		assertEquals(gen1.hashCode(), gen2.hashCode());
		assertSame(gen1, gen2);
	}
	
	@Test
	void InvalidRangeCheck()
	{
		try {
			PrimeGenerator out = PrimeGenerator.getInstance(50,1);
			out.generatePrimes();
			}
			catch(Exception e) {
				assertEquals("Wrong input values: from=50 to=1",e.getMessage());
			}
	}
}

