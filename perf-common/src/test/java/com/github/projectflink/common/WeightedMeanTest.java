package com.github.projectflink.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeightedMeanTest {
	public static final double EPSILON = 0.001;

	@Test
	public void testMean() {
		WeightedMean mean = new WeightedMean();
		// reports being generated every 10 records
		// two reporters, one with throughput 30 records/second ...
		mean.addValue(30, 10.0/30);
		mean.addValue(30, 10.0/30);
		mean.addValue(30, 10.0/30);
		// ... another 10 records/second
		mean.addValue(10, 10.0/10);

		assertEquals(20, mean.getMean(), EPSILON);
		assertEquals(4, mean.getN());
		assertEquals(30, mean.getMax(), EPSILON);
	}
}