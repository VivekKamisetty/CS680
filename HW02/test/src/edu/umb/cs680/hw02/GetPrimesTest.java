package edu.umb.cs680.hw02;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GetPrimesTest {

	@Test
	public void testGetPrimes() {
		SingletonPrimeGenerator out = SingletonPrimeGenerator.getInstance(1, 20);
		out.generatePrimes();
		List<Long> expectedPrimes = List.of(  2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L);
		List<Long> actualPrimes = out.getPrimes();
		System.out.println(out.getPrimes());
		assertIterableEquals(expectedPrimes, actualPrimes);
	}
}

