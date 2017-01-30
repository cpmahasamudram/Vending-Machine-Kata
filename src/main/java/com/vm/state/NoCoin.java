package com.vm.state;

import com.vm.Util.CoinProcessor;
import com.vm.Util.SelectionHandler;
import com.vm.Util.ProductFinder;
import com.vm.constants.VMConstants;
import com.vm.model.Coins;
import com.vm.model.VendingMachine;

public class NoCoin implements VMState {

	VendingMachine vm;

	public NoCoin(VendingMachine vm) {
		this.vm = vm;
	}

	@Override
	public void insertCoin(Coins coin) {
		vm.setEnteredCoin(coin);
		vm.setVMState(vm.getHasCoinState());
		new CoinProcessor(vm);
	}

	@Override
	public void selectAnOption(String buttonPressed) {

		if (!(buttonPressed.equals(VMConstants.CANCEL))) {
			vm.setButtonSelected(buttonPressed);
			new ProductFinder(vm);
			if (vm.getSelectedProduct().getQuantityAvailable() > 0) {
				new SelectionHandler(vm);
			}
		}
	}

}
