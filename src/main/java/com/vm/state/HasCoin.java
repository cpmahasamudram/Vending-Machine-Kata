package com.vm.state;

import com.vm.Util.CoinProcessor;
import com.vm.Util.SelectionHandler;
import com.vm.Util.ProductFinder;
import com.vm.constants.VMConstants;
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
		
		if (buttonPressed.equals(VMConstants.CANCEL)) {
			vm.setReturnTotal(vm.getCurrentAmount());
			vm.setDisplay(VMConstants.INSERT_COIN);
			vm.setCurrentAmount(0.00);
			vm.setVMState(vm.getNoCoinState());
		} else {
			vm.setButtonSelected(buttonPressed);
			new ProductFinder(vm);
			if (vm.getSelectedProduct().getQuantityAvailable() > 0) {
				new SelectionHandler(vm);
			} else {
				vm.setDisplay(VMConstants.SOLD_OUT);
			}
		}

	}

}
