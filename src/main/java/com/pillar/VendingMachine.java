package com.pillar;

import java.util.List;

public class VendingMachine {	
	public double coins;
	public List<String> products;
	public double total;
	public String displayText;
	public boolean returnCoin;
	
	
	
	public boolean isReturnCoin() {
		return returnCoin;
	}
	public void setReturnCoin(boolean returnCoin) {
		this.returnCoin = returnCoin;
	}
	public double getCoins() {
		return coins;
	}
	public void setCoins(double coins) {
		this.coins = coins;
	}
	
	public List<String> getProducts() {
		return products;
	}
	public void setProducts(List<String> products) {
		this.products = products;
	}
	public double getTotal() {
		return this.total;
	}
	public Object getDisplayText() {
		return this.displayText;
	}
	
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
