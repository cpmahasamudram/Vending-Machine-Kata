package com.pillar.data;

public enum Coins {
	penny(2.5 , 19.05, 0.01),
	nickel(5.00 , 21.21, 0.05),
	dime(2.27 , 17.91, 0.10),
	quarter(5.67 , 24.26, 0.25);
	
	
	private final double weight;
	private final double size;
	private final double value;
	
	Coins(Double wght, Double sze, Double v){
		weight  = wght;
		size = sze;
		value = v;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public double getSize(){
		return size;
	}

	public double getValue() {
		return value;
	}
}
