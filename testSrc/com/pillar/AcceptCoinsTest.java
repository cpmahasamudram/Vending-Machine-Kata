package com.pillar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pillar.data.Coins;
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
		//acceptCoins = new AcceptCoins(vendingMachine);
	}

	@Test
	public void whenAValidCoinIsInsertedTotalGetsUpdated() 
	{
		
		vendingMachine.setCoin(Coins.nickel);
		acceptCoins = new AcceptCoins(vendingMachine);
		double expected = vendingMachine.getTransactionTotal() + acceptCoins.getCoinDenomination(Coins.nickel);
		acceptCoins.acceptVendingCoin();
		assertEquals(expected, vendingMachine.getTransactionTotal(), 0.001);
	}
	
	@Test
	public void whenAValidCoinIsInsertedDisplayTextshowsTotalAmount()
	{
		
		vendingMachine.setCoin(Coins.quarter);
		acceptCoins = new AcceptCoins(vendingMachine);
		double expected = vendingMachine.getTransactionTotal() + acceptCoins.getCoinDenomination(Coins.quarter);
		acceptCoins.acceptVendingCoin();
		assertEquals(String.valueOf(expected),vendingMachine.getDisplayText());
	}
	
	@Test
	public void whenNoCoinsInsertedMachineDisplaysINSERTCOIN()
	{
		assertEquals("INSERT COIN", vendingMachine.getDisplayText());
	}
	
	
	@Test
	public void rejectCoinsArePlacedInCoinReturn(){
		vendingMachine.setCoin(Coins.penny);
		new AcceptCoins(vendingMachine).acceptVendingCoin();
		assertEquals(0.01,vendingMachine.getReturnTotal(), 0.001);
	}
	
}
