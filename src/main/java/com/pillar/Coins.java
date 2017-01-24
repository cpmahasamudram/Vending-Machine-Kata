package com.pillar;

public enum Coins {
	dime(2.27 , 17.91),
	nickel(5.00 , 21.21),
	quarter(5.67 , 24.26);
	
	private final double weight;
	private final double size;
	
	Coins(Double wght, Double sze){
		weight  = wght;
		size = sze;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public double getSize(){
		return size;
	}
}
