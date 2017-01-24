package com.pillar;
import java.util.EnumSet;

public class AcceptCoins {

	public AcceptCoins(VendingMachine vendingMachine) {
		vendingMachine.setDisplayText("INSERT COIN");
	}

	public void acceptVendingCoin(VendingMachine vendingMachine, double weight, double size) {

		double denomination = getCoinDenomination(weight, size);
		
		if(denomination > 0) 
		{
			vendingMachine.setTotal(vendingMachine.getTotal() + denomination);
			vendingMachine.setDisplayText(String.valueOf(vendingMachine.getTotal()));
		
		} else
		{ 
			vendingMachine.setReturnCoin(true);			
		} 
		
}

	public double getCoinDenomination(double weight, double size) {
		for(Coins coin: EnumSet.range(Coins.dime, Coins.quarter)){
			if(weight == coin.getWeight() && size == coin.getSize()) {
				switch(coin) {
					case nickel: 	return 0.01; 
					case dime:		return 0.10; 
					case quarter: 	return 0.25;
					default : 		return 0;
				}
			}
		}
		return 0;
	}

}
