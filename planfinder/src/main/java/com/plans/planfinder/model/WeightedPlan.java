package com.plans.planfinder.model;

import java.util.List;

public class WeightedPlan {
	private String name;
	private double price;
	private int weight;
	private List<String> matchedFeatures;
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
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public List<String> getMatchedFeatures() {
		return matchedFeatures;
	}
	public void setMatchedFeatures(List<String> matchedFeatures) {
		this.matchedFeatures = matchedFeatures;
	}
	@Override
	public String toString() {
		return "WeightedPlan [name=" + name + ", price=" + price + ", weight=" + weight + ", matchedFeatures="
				+ matchedFeatures + "]";
	}
	
	
	
	

}
