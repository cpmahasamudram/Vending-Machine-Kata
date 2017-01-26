package com.pillar;

import java.text.DecimalFormat;

import com.pillar.data.Foods;
import com.pillar.data.VendingMachine;

public class SelectProduct {

	DecimalFormat df = new DecimalFormat("####0.00");

	public void dispenseProduct(VendingMachine vendingMachine) {
		if (vendingMachine.getButtonPressed() == "X") {
			// not sure which one of the next two lines to keep
			vendingMachine.setReturnTotal(vendingMachine.getTransactionTotal());
			vendingMachine.getReturnCoins().add(vendingMachine.getTransactionTotal());
		} else {

			for (Foods menu : vendingMachine.getMenu()) {
				if (menu.getButtonReference().equalsIgnoreCase(vendingMachine.getButtonPressed())) {
					if (menu.getQuantityAvailable() < 1) {
						vendingMachine.setDisplayText("SOLD OUT");
					} else {
						if (vendingMachine.getTransactionTotal() >= menu.getCost()) {
							vendingMachine.setDispenseProduct(menu);
							vendingMachine.setMachineBalance(
									vendingMachine.getMachineBalance() + vendingMachine.getTransactionTotal());
							vendingMachine.setDisplayText("THANK YOU");
							menu.setQuantityAvailable(menu.getQuantityAvailable()-1);
							if (vendingMachine.getTransactionTotal() > vendingMachine.getDispenseProduct().getCost()) {
								vendingMachine.getReturnCoins().add(vendingMachine.getTransactionTotal()
										- vendingMachine.getDispenseProduct().getCost());
							}
							vendingMachine.setTransactionTotal(0.00);
						} else {
							// if (menu.getCost() >
							// vendingMachine.getTransactionTotal()) {

							vendingMachine.setDisplayText("PRICE " + df.format(menu.getCost()));
							vendingMachine.setReturnTotal(vendingMachine.getTransactionTotal());
							vendingMachine.setTransactionTotal(0.00);
						}

					}
				}
			}
		}
	}
}
