package com.vm.Util;

import java.util.ArrayList;

import com.vm.model.Drinks;
import com.vm.model.Product;
import com.vm.model.Snacks;
import com.vm.model.VendingMachine;

public class InventoryLoader {

	VendingMachine vm;

	public InventoryLoader(VendingMachine vm) {
		this.vm = vm;
		loadProducts();
	}

	void loadProducts() {
		ArrayList<Product> Products = new ArrayList<Product>(10);
		Products.add(new Drinks("Cola", 1.00, "C", 10));
		Products.add(new Snacks("Candy", 0.65, "N", 0));
		Products.add(new Snacks("Chips", 0.50, "P", 2));
		vm.setProducts(Products);
	}

}
