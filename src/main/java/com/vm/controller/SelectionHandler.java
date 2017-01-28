package com.vm.controller;

import java.text.DecimalFormat;

import com.vm.model.Product;
import com.vm.model.VendingMachine;

public class SelectionHandler {

	VendingMachine vm;

	public SelectionHandler(VendingMachine vm) {
		this.vm = vm;
		handleSelection();
	}

	void handleSelection() {
		DecimalFormat df = new DecimalFormat("####0.00");
		if (vm.buttonSelected.equals("X")) {
			vm.returnTotal = vm.currentAmount;
			vm.setCurrentAmount(0.00);
			vm.setDisplay("INSERT COIN");
			vm.setVMState(vm.getNoCoinState());
		} else {
			for (Product product : vm.products) {
				if (product.getButtonReference() == vm.buttonSelected && product.getQuantityAvailable() > 0) {
					vm.setSelectedProduct(product);
					if (vm.currentAmount == vm.selectedProduct.getCost()) {
						vm.setDispensedProduct(product);
						vm.setDisplay("THANK YOU");
						vm.setCurrentAmount(0.00);
						vm.setVMState(vm.getNoCoinState());
					} else if (vm.selectedProduct.getCost() > vm.currentAmount) {
						vm.setDisplay("PRICE " + df.format(vm.selectedProduct.getCost()));
					} else {
						vm.setReturnTotal(vm.currentAmount - vm.selectedProduct.getCost());
						vm.setCurrentAmount(0.00);
						vm.setVMState(vm.getNoCoinState());
					}
				} else {
					if (!(vm.currentAmount > 0)){
						vm.setVMState(vm.getNoCoinState());
					} else {
						vm.setDisplay("SOLD OUT");
					}
				}
			}
		}
	}
}