package com.github.projectflink.common;

import org.apache.commons.math3.stat.descriptive.moment.Mean;

import java.util.ArrayList;

public class WeightedMean {
	double max = Double.MIN_VALUE;
	ArrayList<Double> values = new ArrayList<>();
	ArrayList<Double> weights = new ArrayList<>();
	long count;

	public void addValue(double value, double weight) {
		max = Math.max(max, value);
		values.add(value);
		weights.add(weight);
		count++;
	}

	public double getMean() {
		Mean mean = new Mean();

		return mean.evaluate(
				values.stream().mapToDouble(v -> v).toArray(),
				weights.stream().mapToDouble(v -> v).toArray());
	}

	public double getMax() {
		return max;
	}

	public long getN() {
		return count;
	}
}
