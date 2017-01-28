package com.vm.model;

import java.util.ArrayList;

import com.vm.state.HasCoin;
import com.vm.state.NoCoin;
import com.vm.state.VMState;

public class VendingMachine {

	VMState hasCoin;
	VMState noCoin;

	VMState vmState;

	public double cashInMachine;
	public double currentAmount;
	public double returnTotal;
	public String display;
	public ArrayList<Product> products;
	public Product dispensedProduct;
	public Product selectedProduct;
	public Coins enteredCoin;
	public String buttonSelected;

	public boolean validCoinEntered = false;

	public VendingMachine(double cashInMachine) {
		hasCoin = new HasCoin(this);
		noCoin = new NoCoin(this);
		this.setCashInMachine(cashInMachine);
		
		vmState = noCoin;

		if (cashInMachine < 1) {
			this.display = "EXACT CHANGE ONLY";
		}

	}

	public void setVMState(VMState newVMState) {
		vmState = newVMState;
	}

	public void setCashInMachine(double cashInMachine) {
		this.cashInMachine = cashInMachine;
	}

	public void setCurrentAmount(double currentAmount) {
		this.currentAmount = currentAmount;
	}

	public void setReturnTotal(double returnTotal) {
		this.returnTotal = returnTotal;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void setDispensedProduct(Product product) {
		this.dispensedProduct = product;
	}

	public void setSelectedProduct(Product product) {
		this.selectedProduct = product;
	}

	public void setButtonSelected(String buttonSelected) {
		this.buttonSelected = buttonSelected;
	}

	public void setEnteredCoin(Coins coin) {
		this.enteredCoin = coin;
	}

	public void insertCoin(Coins coin) {
		vmState.insertCoin(coin);
	}

	public void selectAnOption(String buttonPressed) {
		vmState.selectAnOption(buttonPressed);
	}

	public VMState getHasCoinState() {
		return hasCoin;
	}

	public VMState getNoCoinState() {
		return noCoin;
	}

}
