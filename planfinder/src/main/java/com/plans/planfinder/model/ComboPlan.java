package com.plans.planfinder.model;

import java.util.ArrayList;
import java.util.List;

public class ComboPlan {
	private double price;
	private List<String> plans = new ArrayList<>();
	private List<String> features = new ArrayList<>();

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<String> getPlans() {
		return plans;
	}

	public void setPlans(List<String> plans) {
		this.plans = plans;
	}

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}

	@Override
	public String toString() {
		return "ComboPlan [price=" + price + ", plans=" + plans + ", features=" + features + "]";
	}

	
}
