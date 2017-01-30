package com.vm.state;

import com.vm.Util.CoinProcessor;
import com.vm.Util.SelectionHandler;
import com.vm.model.Coins;
import com.vm.model.VendingMachine;

public class HasCoin implements VMState {
	VendingMachine vm;

	public HasCoin(VendingMachine vm) {
		this.vm = vm;
	}

	@Override
	public void insertCoin(Coins coin) {
		vm.setEnteredCoin(coin);
		new CoinProcessor(vm);
	}

	@Override
	public void selectAnOption(String buttonPressed) {
		vm.setButtonSelected(buttonPressed);
		new SelectionHandler(vm);
	}

}
