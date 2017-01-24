package com.pillar;

import java.util.ArrayList;

public class SelectProduct {
	
	ArrayList<Foods> menu = new ArrayList<Foods>(10);
	
	public SelectProduct(){
		menu.add(new Drinks("Cola", 1.00));
		menu.add(new Snacks("Candy", 0.65));
		menu.add(new Snacks("Chips", 0.50));
	}
}
