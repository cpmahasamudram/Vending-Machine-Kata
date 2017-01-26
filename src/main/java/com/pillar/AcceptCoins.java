package com.pillar;

import java.util.EnumSet;

import com.pillar.data.Coins;
import com.pillar.data.VendingMachine;

public class AcceptCoins {

	public void acceptVendingCoin(VendingMachine vendingMachine, double weight, double size) {

		double denomination = getCoinDenomination(weight, size);

		if (denomination > 0.01) {
			vendingMachine.setTransactionTotal(vendingMachine.getTransactionTotal() + denomination);
			vendingMachine.setDisplayText(String.valueOf(vendingMachine.getTransactionTotal()));

		} else {
			vendingMachine.getReturnCoins().add(denomination);
		}

	}

	public double getCoinDenomination(double weight, double size) {
		for (Coins coin : EnumSet.range(Coins.dime, Coins.quarter)) {
			if (weight == coin.getWeight() && size == coin.getSize()) {
				return coin.getValue();
			}
		}
		return 0;
	}

}
