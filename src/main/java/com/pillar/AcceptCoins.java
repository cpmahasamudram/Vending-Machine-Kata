package com.pillar;

import java.util.EnumSet;

import com.pillar.data.Coins;
import com.pillar.data.VendingMachine;

public class AcceptCoins {
	
	VendingMachine vm;
	
	public AcceptCoins(VendingMachine vm){
		this.vm = vm;
	}
	
	public void acceptVendingCoin() {

		double denomination = getCoinDenomination(vm.getCoin());

		if (denomination > 0.01) {
			vm.setTransactionTotal(vm.getTransactionTotal() + denomination);
			vm.setDisplayText(String.valueOf(vm.getTransactionTotal()));

		} else {
			vm.setReturnTotal(denomination);
		}

	}

	public double getCoinDenomination(Coins newCoin) {
		for (Coins coin : EnumSet.range(Coins.penny, Coins.quarter)) {
			if (newCoin.getWeight() == coin.getWeight() && newCoin.getSize() == coin.getSize()) {
				return coin.getValue();
			}
		}
		return 0;
	}

}
