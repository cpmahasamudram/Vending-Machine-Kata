package com.vm.Util;

import java.text.DecimalFormat;

import com.vm.constants.VMConstants;
import com.vm.model.Product;
import com.vm.model.VendingMachine;

public class SelectionHandler {

	VendingMachine vm;

	public SelectionHandler(VendingMachine vm) {
		this.vm = vm;
		handleSelection();
		reset();
	}

	private void reset() {
		vm.setCurrentAmount(0.00);
		vm.setVMState(vm.getNoCoinState());

	}

	void handleSelection() {
		DecimalFormat df = new DecimalFormat(VMConstants.DECIMAL_FORMAT);
		if (vm.getButtonSelected().equals(VMConstants.CANCEL)) {
			vm.setReturnTotal(vm.getCurrentAmount());
			vm.setDisplay(VMConstants.INSERT_COIN);
			reset();
		} else {
			for (Product product : vm.getProducts()) {
				if (product.getButtonReference().equals(vm.getButtonSelected()) && product.getQuantityAvailable() > 0) {
					vm.setSelectedProduct(product);
					if (vm.getCurrentAmount() == vm.getSelectedProduct().getCost()) {
						vm.setDispensedProduct(product);
						vm.setDisplay(VMConstants.THANK_YOU);
						reset();
					} else if (vm.getSelectedProduct().getCost() > vm.getCurrentAmount()) {
						vm.setDisplay(VMConstants.PRICE + " " + df.format(vm.getSelectedProduct().getCost()));
					} else {
						vm.setReturnTotal(vm.getCurrentAmount() - vm.getSelectedProduct().getCost());
						reset();
					}
				} else {
					if (!(vm.getCurrentAmount() > 0)) {
						vm.setVMState(vm.getNoCoinState());
					} else {
						vm.setDisplay(VMConstants.SOLD_OUT);
					}
				}
			}
		}
	}
}