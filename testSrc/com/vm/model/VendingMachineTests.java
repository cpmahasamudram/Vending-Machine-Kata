package com.vm.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vm.model.Coins;
import com.vm.model.VendingMachine;

public class VendingMachineTests {

	VendingMachine vm;
	
	@Before
	public void setUp() throws Exception {
		vm = new VendingMachine(4);
	}

	private void setUpToDispense() {
		vm.insertCoin(Coins.quarter);
		vm.insertCoin(Coins.quarter);
		vm.selectAnOption("P");
	}
	
	private void setUpToFailDispense(){
		vm.insertCoin(Coins.quarter);
		vm.selectAnOption("P");
	}
	
	private void setUpToMakeChange() {
		vm.insertCoin(Coins.quarter);
		vm.insertCoin(Coins.quarter);
		vm.insertCoin(Coins.quarter);
		vm.selectAnOption("P");
	}
	
	private void setUpReturn(){
		vm.insertCoin(Coins.nickel);
		vm.selectAnOption("X");
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void acceptsValidCoin() {
		vm.insertCoin(Coins.dime);
		assertEquals(true, vm.isValidCoinEntered());
	}

	@Test
	public void rejectsInvalidCoin() {
		vm.insertCoin(Coins.penny);
		assertEquals(false, vm.isValidCoinEntered());
	}
	
	@Test
	public void whenAValidCoinIsEnteredCurrentAmountIsUpdated(){
		vm.insertCoin(Coins.quarter);
		assertEquals(Coins.quarter.getValue(), vm.getCurrentAmount(), 0.001);
	}
	
	@Test
	public void whenAValidCoinIsEnteredDisplayIsUpdated(){
		vm.insertCoin(Coins.nickel);
		assertEquals(String.valueOf(Coins.nickel.getValue()), vm.getDisplay());
	}
	
	@Test
	public void whenNoCoinInsertedDisplaysINSERTCOIN(){
		assertEquals("INSERT COIN", vm.getDisplay());
	}
	
	
	@Test
	public void rejectedCoinsPlacedInCoinReturn(){
		vm.insertCoin(Coins.penny);
		assertEquals(Coins.penny.getValue(), vm.getReturnTotal(), 0.001);
	}
	
	@Test
	public void whenRespectiveButtonIsPressedAndEnouhgMoneyIsInsertProductIsDispensed(){
		setUpToDispense();
		assertEquals("Chips", vm.getDispensedProduct().getName());
	}

	@Test
	public void whenRespectiveButtonIsPressedAndEnouhgMoneyIsInsertProductIsDispensedAndDisplaysTHANKYOU(){
		setUpToDispense();
		assertEquals("THANK YOU",vm.getDisplay());
	}
	
	@Test
	public void whenNotEnoughMoneyIsInsertedDisplaysPRICE(){
		setUpToFailDispense();
		assertEquals("PRICE 0.50", vm.getDisplay());
	}
	
	@Test
	public void afterHandlingSelectionDisplaysINSERTCOIN(){
		assertEquals("INSERT COIN", vm.getDisplay());
	}
	
	@Test
	public void whenAProductCostsLessThanMoneyInsertedReturnIsMade(){
		setUpToMakeChange();
		assertEquals(Coins.quarter.getValue(), vm.getReturnTotal(), 0.001);
	}
	
	
	@Test
	public void whenReturnCoinsButtonPressedMoneyIsReturned(){
		setUpReturn();
		assertEquals(Coins.nickel.getValue(), vm.getReturnTotal(), 0.001);
	}
	
	
	@Test
	public void afterReturnCoinsDisplayShowsINSERTCOIN(){
		setUpReturn();
		assertEquals("INSERT COIN", vm.getDisplay());
	}
	
	@Test
	public void whenItemSelectedIsOutOfStockDisplaysINSERTCOINIfNoMoneyInMachine(){
		vm.selectAnOption("N");
		assertEquals("INSERT COIN", vm.getDisplay());
	}
	
	@Test
	public void whenItemSelectedIsOutOfStockDisplaysSOLDOUT(){
		vm.insertCoin(Coins.quarter);
		vm.selectAnOption("N");
		assertEquals("SOLD OUT", vm.getDisplay());
	}
	
	@Test 
	public void whenNotAbleToMakeChangeDisplayEXACTCHANGEONLY(){
		vm = new VendingMachine(0);
		assertEquals("EXACT CHANGE ONLY", vm.getDisplay());
	}
}
