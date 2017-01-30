package com.vm.Util;

import java.util.EnumSet;

import com.vm.model.Coins;
import com.vm.model.VendingMachine;

public class CoinProcessor {

	VendingMachine vm;

	public CoinProcessor(VendingMachine vm) {
		this.vm = vm;
		processCoin();
	}

	public void processCoin() {

		for (Coins eCoin : EnumSet.range(Coins.nickel, Coins.quarter)) {
			if (vm.getEnteredCoin().getWeight() == eCoin.getWeight()
					&& vm.getEnteredCoin().getSize() == eCoin.getSize()) {
				vm.setValidCoinEntered(true);
			}
		}

		if (vm.isValidCoinEntered()) {
			vm.setCurrentAmount(vm.getCurrentAmount() + vm.getEnteredCoin().getValue());
			vm.setCashInMachine(vm.getCashInMachine() + vm.getCurrentAmount());
			vm.setDisplay(String.valueOf(vm.getCurrentAmount()));
		} else {
			vm.setReturnTotal(vm.getEnteredCoin().getValue());
		}
	}

}
