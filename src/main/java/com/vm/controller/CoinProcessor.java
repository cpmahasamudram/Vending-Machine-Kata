package com.vm.controller;

import java.util.EnumSet;

import com.vm.model.Coins;
import com.vm.model.VendingMachine;

public class CoinProcessor {

	VendingMachine vm;

	public CoinProcessor(VendingMachine vm) {
		this.vm = vm;
		processCoin();
	}
	
	private boolean ValidateCoin(){
		for (Coins eCoin : EnumSet.range(Coins.nickel, Coins.quarter)) {
			if (vm.enteredCoin.getWeight() == eCoin.getWeight() && vm.enteredCoin.getSize() == eCoin.getSize()) {
				return true;
			}
		}
		return false;
	} 
	
	public void processCoin() {

		vm.validCoinEntered = ValidateCoin();
		if (vm.validCoinEntered) {
			vm.setCurrentAmount(vm.currentAmount + vm.enteredCoin.getValue());
			vm.cashInMachine += vm.currentAmount;
			vm.display = String.valueOf(vm.currentAmount);
		} else {
			vm.returnTotal = vm.enteredCoin.getValue();
		}
	}

}
