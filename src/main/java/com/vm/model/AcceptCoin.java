package com.vm.model;

import com.vm.state.VMState;

public class AcceptCoin implements VMState {

	VendingMachine vm;

	public AcceptCoin(VendingMachine vm) {
		this.vm = vm;
	}
	
	@Override
	public void insertCoin(Coins Coin) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectAnOption(String buttonPressed) {
		// TODO Auto-generated method stub

	}

}
