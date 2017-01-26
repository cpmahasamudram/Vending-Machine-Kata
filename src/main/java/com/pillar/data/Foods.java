package com.pillar.data;

public class Foods {
	String name;
	String buttonReference;
	double cost;
	int quantityAvailable;

	public Foods(String name, double cost, String buttonRef, int quantity) {
		this.name = name;
		this.cost = cost;
		this.buttonReference = buttonRef;
		this.quantityAvailable = quantity;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getButtonReference() {
		return buttonReference;
	}

	public void setButtonReference(String buttonReference) {
		this.buttonReference = buttonReference;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
