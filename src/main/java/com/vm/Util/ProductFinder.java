package com.vm.Util;

import com.vm.model.Product;
import com.vm.model.VendingMachine;

public class ProductFinder {

	VendingMachine vm;
	
	public ProductFinder(VendingMachine vm) {
		this.vm = vm;
		for (Product product : vm.getProducts()) {
			if (product.getButtonReference().equals(vm.getButtonSelected())) {
				vm.setSelectedProduct(product);
			}
		}
	
	}
	
	
}
