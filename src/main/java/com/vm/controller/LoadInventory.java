package com.vm.controller;

import java.util.ArrayList;

import com.vm.model.Drinks;
import com.vm.model.Product;
import com.vm.model.Snacks;
import com.vm.model.VendingMachine;

public class LoadInventory {
	
	VendingMachine vm;
	
	public LoadInventory(VendingMachine vm) {
		this.vm = vm;
		loadProducts();
	}
	
	void loadProducts(){
		vm.products = new ArrayList<Product>(10);
		vm.products.add(new Drinks("Cola", 1.00, "C", 10));
		vm.products.add(new Snacks("Candy", 0.65, "N", 0));
		vm.products.add(new Snacks("Chips", 0.50, "P", 2));
	}

}
