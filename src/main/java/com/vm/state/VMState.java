package com.vm.state;

import com.vm.model.Coins;

public interface VMState {

	public void insertCoin(Coins coin);

	public void selectAnOption(String buttonPressed);

}
