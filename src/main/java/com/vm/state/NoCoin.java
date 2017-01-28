package com.vm.state;

import com.vm.controller.CoinProcessor;
import com.vm.controller.LoadInventory;
import com.vm.controller.SelectionHandler;
import com.vm.model.Coins;
import com.vm.model.VendingMachine;

public class NoCoin implements VMState {

	VendingMachine vm;

	public NoCoin(VendingMachine vm) {
		this.vm = vm;
		vm.setDisplay("INSERT COIN");
		//vm.setCashInMachine(2.00);
		new LoadInventory(vm);
	}

	@Override
	public void insertCoin(Coins coin) {
		vm.setEnteredCoin(coin);
		vm.setVMState(vm.getHasCoinState());
		new CoinProcessor(vm);
	}

	@Override
	public void selectAnOption(String buttonPressed) {
		vm.setButtonSelected(buttonPressed);
		new SelectionHandler(vm);
	}

}
