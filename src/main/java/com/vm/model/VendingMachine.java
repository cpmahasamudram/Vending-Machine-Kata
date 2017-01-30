package com.vm.model;

import java.util.ArrayList;

import com.vm.Util.InventoryLoader;
import com.vm.state.HasCoin;
import com.vm.state.NoCoin;
import com.vm.state.VMState;

public class VendingMachine {

	VMState hasCoin;
	VMState noCoin;

	VMState vmState;

	private double cashInMachine;
	private double currentAmount;
	private double returnTotal;
	private String display;
	private ArrayList<Product> products;

	private Product dispensedProduct;
	private Product selectedProduct;
	private Coins enteredCoin;
	private String buttonSelected;

	private boolean validCoinEntered = false;

	public VendingMachine(double cashInMachine) {
		hasCoin = new HasCoin(this);
		noCoin = new NoCoin(this);
		this.setCashInMachine(cashInMachine);
		this.setDisplay("INSERT COIN");
		new InventoryLoader(this);

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

	public double getCashInMachine() {
		return cashInMachine;
	}

	public double getCurrentAmount() {
		return currentAmount;
	}

	public Product getDispensedProduct() {
		return dispensedProduct;
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public Coins getEnteredCoin() {
		return enteredCoin;
	}

	public String getButtonSelected() {
		return buttonSelected;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public double getReturnTotal() {
		return returnTotal;
	}

	public String getDisplay() {
		return display;
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

	public boolean isValidCoinEntered() {
		return validCoinEntered;
	}

	public void setValidCoinEntered(boolean validCoinEntered) {
		this.validCoinEntered = validCoinEntered;
	}

}
