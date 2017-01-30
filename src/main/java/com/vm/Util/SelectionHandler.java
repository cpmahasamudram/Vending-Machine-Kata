package com.vm.Util;

import java.text.DecimalFormat;

import com.vm.constants.VMConstants;
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
		if (vm.getCurrentAmount() == vm.getSelectedProduct().getCost()) {
			vm.setDispensedProduct(vm.getSelectedProduct());
			vm.setDisplay(VMConstants.THANK_YOU);
			reset();
		} else if (vm.getSelectedProduct().getCost() > vm.getCurrentAmount()) {
			vm.setDisplay(VMConstants.PRICE + " " + df.format(vm.getSelectedProduct().getCost()));
		} else {
			vm.setReturnTotal(vm.getCurrentAmount() - vm.getSelectedProduct().getCost());
			reset();
		}
	}
}