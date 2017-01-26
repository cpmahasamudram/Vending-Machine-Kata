package com.pillar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pillar.data.VendingMachine;

public class AcceptCoinsTest {

	VendingMachine vendingMachine;
	AcceptCoins acceptCoins;
	double weight;
	double size;
	
	@Before
	public void setUp() throws Exception 
	{
		vendingMachine = new VendingMachine();
		acceptCoins = new AcceptCoins();
	}

	@Test
	public void whenAValidCoinIsInsertedTotalGetsUpdated() 
	{
		weight = 5;
		size= 21.21;
		double expected = vendingMachine.getTransactionTotal() + acceptCoins.getCoinDenomination(weight, size);
		acceptCoins.acceptVendingCoin(vendingMachine, weight, size);
		assertEquals(expected, vendingMachine.getTransactionTotal(), 0.001);
	}
	
	@Test
	public void whenAValidCoinIsInsertedDisplayTextshowsTotalAmount()
	{
		weight = 5.67;
		size= 24.26;
		double expected = vendingMachine.getTransactionTotal() + acceptCoins.getCoinDenomination(weight, size);
		acceptCoins.acceptVendingCoin(vendingMachine, weight, size);
		assertEquals(String.valueOf(expected),vendingMachine.getDisplayText());
	}
	
	@Test
	public void whenNoCoinsInsertedMachineDisplaysINSERTCOIN()
	{
		assertEquals("INSERT COIN", vendingMachine.getDisplayText());
	}
	
	
	@Test
	public void rejectCoinsArePlacedInCoinReturn(){
		weight= 2.5;
		size= 19.05;
		acceptCoins.acceptVendingCoin(vendingMachine, weight, size);
		assertEquals(1,vendingMachine.getReturnCoins().size());
	}
	
}
