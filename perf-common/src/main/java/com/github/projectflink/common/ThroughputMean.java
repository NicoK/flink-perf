package com.github.projectflink.common;

public class ThroughputMean {
	double max = Double.MIN_VALUE;
	double elementsSum;
	double timeSum;
	long count;

	public void addMeassurement(double elements, double time) {
		max = Math.max(max, elements / time);
		elementsSum += elements;
		timeSum += time;
		count++;
	}

	public double getMean() {
		return elementsSum / timeSum;
	}

	public double getMax() {
		return max;
	}

	public long getN() {
		return count;
	}
}
