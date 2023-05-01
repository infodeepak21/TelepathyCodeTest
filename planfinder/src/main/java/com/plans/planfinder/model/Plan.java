package com.plans.planfinder.model;

import java.util.List;

public class Plan {
	private String name;
	private double price;
	private List<String> features;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<String> getFeatures() {
		return features;
	}
	public void setFeatures(List<String> features) {
		this.features = features;
	}
	@Override
	public String toString() {
		return "Plan [name=" + name + ", price=" + price + ", features=" + features + "]";
	}
	
	

}
