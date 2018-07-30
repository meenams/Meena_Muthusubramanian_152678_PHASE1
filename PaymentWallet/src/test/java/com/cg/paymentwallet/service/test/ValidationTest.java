package com.cg.paymentwallet.service.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.paymentwallet.dao.IWalletDao;
import com.cg.paymentwallet.dao.WalletDaoImpl;
import com.cg.paymentwallet.dto.Wallet;
import com.cg.paymentwallet.exception.WalletException;
import com.cg.paymentwallet.service.IWalletService;
import com.cg.paymentwallet.service.WalletServiceImpl;

public class ValidationTest {
	IWalletService service = new WalletServiceImpl();
	IWalletDao dao = new WalletDaoImpl();

	@Test
	public void CheckForZeroDeposittest() {
		boolean condition = false;
		Wallet wallet = new Wallet();
		wallet.setUserId("9940667263");
		dao.createAccount(wallet);
		condition = service.deposit("9940667263", 0.0);
		assertFalse(condition);
	}

	@Test
	public void CheckForValidDepositAmount() {
		boolean condition = false;
		Wallet wallet = new Wallet();
		wallet.setUserId("9940667263");
		dao.createAccount(wallet);
		condition = service.deposit("9940667263", 500);
		assertTrue(condition);
	}

	@Test(expected = WalletException.class)
	public void CheckForInvalidNameTest() throws WalletException {
		Wallet wallet = new Wallet();
		wallet.setName("m123d");
		wallet.setPhNumber("9940667263");
		wallet.setEmailId("meena@gmail.com");
		service.validateDetails(wallet);
	}

	@Test
	public void CheckForValidNameTest() throws WalletException {
		Wallet wallet = new Wallet();
		wallet.setName("Meena");
		wallet.setPhNumber("9940667263");
		wallet.setEmailId("meenah@gmail.com");
		boolean condition = service.validateDetails(wallet);
		assertTrue(condition);
	}

	@Test(expected = WalletException.class)
	public void CheckForInvalidPhoneNumberTest() throws WalletException {
		Wallet wallet = new Wallet();
		wallet.setName("Ranjith");
		wallet.setPhNumber("12345");
		wallet.setEmailId("abcd@gmail.com");
		boolean condition = service.validateDetails(wallet);
		assertFalse(condition);
	}

	@Test
	public void CheckForValidPhoneNumberTest() throws WalletException {
		Wallet wallet = new Wallet();
		wallet.setName("Meena");
		wallet.setPhNumber("9940667263");
		wallet.setEmailId("meena@gmail.com");
		boolean condition = service.validateDetails(wallet);
		assertTrue(condition);
	}

	@Test(expected = WalletException.class)
	public void CheckForInvalidEmailTest() throws WalletException {
		Wallet wallet = new Wallet();
		wallet.setName("Meena");
		wallet.setPhNumber("9940667263");
		wallet.setEmailId("12der45");
		boolean condition = service.validateDetails(wallet);
		assertFalse(condition);
	}

	@Test
	public void CheckForValidEmailTest() throws WalletException {
		Wallet wallet = new Wallet();
		wallet.setName("Meena");
		wallet.setPhNumber("9940667263");
		wallet.setEmailId("meena@gmail.com");
		boolean condition = service.validateDetails(wallet);
		assertTrue(condition);
	}

}
