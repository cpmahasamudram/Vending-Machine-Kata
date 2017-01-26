package com.pillar;

import java.text.DecimalFormat;

import com.pillar.data.Foods;
import com.pillar.data.VendingMachine;

public class SelectProduct {

	VendingMachine vm;

	public SelectProduct(VendingMachine vm) {
		this.vm = vm;
	}

	DecimalFormat df = new DecimalFormat("####0.00");

	public void dispenseProduct() {
		if (vm.getButtonPressed() == "X") {
			vm.setReturnTotal(vm.getTransactionTotal());

		} else {

			for (Foods menu : vm.getMenu()) {
				if (menu.getButtonReference().equalsIgnoreCase(vm.getButtonPressed())) {
					if (menu.getQuantityAvailable() < 1) {
						vm.setDisplayText("SOLD OUT");
					} else {
						if (vm.getTransactionTotal() >= menu.getCost()) {
							vm.setDispenseProduct(menu);
							vm.setMachineBalance(vm.getMachineBalance() + vm.getTransactionTotal());
							vm.setDisplayText("THANK YOU");
							menu.setQuantityAvailable(menu.getQuantityAvailable() - 1);
							if (vm.getTransactionTotal() > vm.getDispenseProduct().getCost()) {
								vm.setReturnTotal((vm.getTransactionTotal() - vm.getDispenseProduct().getCost()));
							}
							vm.setTransactionTotal(0.00);
						} else {
							vm.setDisplayText("PRICE " + df.format(menu.getCost()));
							vm.setReturnTotal(vm.getTransactionTotal());
							vm.setTransactionTotal(0.00);
						}

					}
				}
			}
		}
	}
}
