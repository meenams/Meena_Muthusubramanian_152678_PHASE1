package com.cg.paymentwalletjpa.test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.cg.paymentwalletjpa.dao.IWalletDao;
import com.cg.paymentwalletjpa.dao.WalletDaoImpl;
import com.cg.paymentwalletjpa.dto.Customer;
import com.cg.paymentwalletjpa.dto.Wallet;
import com.cg.paymentwalletjpa.exception.WalletException;
import com.cg.paymentwalletjpa.service.IWalletService;
import com.cg.paymentwalletjpa.service.WalletServiceImpl;

public class ValidationTest {
	
	IWalletService service = new WalletServiceImpl();
	IWalletDao dao = new WalletDaoImpl();

	@Test 
	public void CheckForZeroDeposittest() throws WalletException {
		boolean condition = false;
		Customer customer = new Customer();
		customer.setName("Meena");
		customer.setPhNumber("9940667263");
		customer.setEmailId("meenams@gmail.com");
		customer.setUserId("meena");
		Wallet wallet = new Wallet();
		wallet.setPassword("123");
		wallet.setTransaction("aaa");
		customer.setWallet(wallet);
		dao.createAccount(customer);
		condition = service.deposit("meena", 0.0);
		assertFalse(condition);
	}

	@Test(expected = WalletException.class)
	public void CheckForInvalidNameTest() throws WalletException {
		Customer customer = new Customer();
		customer.setName("p09opklj");
		customer.setPhNumber("9940667263");
		customer.setEmailId("meena@gmail.com");
		customer.setUserId("meena");
		Wallet wallet = new Wallet();
		wallet.setPassword("123");
		wallet.setTransaction("aaa");
		customer.setWallet(wallet);
		service.validateDetails(customer);
	}

	@Test
	public void CheckForValidNameTest() throws WalletException {
		Customer customer = new Customer();
		customer.setName("Meena");
		customer.setPhNumber("9940667263");
		customer.setEmailId("meena@gmail.com");
		customer.setUserId("mopo");
		Wallet wallet = new Wallet();
		wallet.setPassword("123");
		wallet.setTransaction("aaa");
		customer.setWallet(wallet);
		boolean condition = service.validateDetails(customer);
		assertTrue(condition);
	}

	@Test(expected = WalletException.class)
	public void CheckForInvalidPhoneNumberTest() throws WalletException {
		Customer customer = new Customer();
		customer.setName("Meena");
		customer.setPhNumber("09000");
		customer.setEmailId("meena@gmail.com");
		customer.setUserId("meena");
		Wallet wallet = new Wallet();
		wallet.setPassword("123");
		wallet.setTransaction("aaa");
		customer.setWallet(wallet);
		boolean condition = service.validateDetails(customer);
		assertFalse(condition);
	}

	@Test
	public void CheckForValidPhoneNumberTest() throws WalletException {
		Customer customer = new Customer();
		customer.setName("Meena");
		customer.setPhNumber("9988776655");
		customer.setEmailId("meena@gmail.com");
		customer.setUserId("utui");
		Wallet wallet = new Wallet();
		wallet.setPassword("qwertyui");
		wallet.setTransaction("aaa");
		customer.setWallet(wallet);
		boolean condition = service.validateDetails(customer);
		assertTrue(condition);
	}

	@Test(expected = WalletException.class)
	public void CheckForInvalidEmailTest() throws WalletException {
		Customer customer = new Customer();
		customer.setName("meena");
		customer.setPhNumber("9940667263");
		customer.setEmailId("akjsdj.com");
		customer.setUserId("meena");
		Wallet wallet = new Wallet();
		wallet.setPassword("123");
		wallet.setTransaction("aaa");
		customer.setWallet(wallet);
		boolean condition = service.validateDetails(customer);
		assertFalse(condition);
	}

	@Test
	public void CheckForValidEmailTest() throws WalletException {
		Customer customer = new Customer();
		customer.setName("Meenaa");
		customer.setPhNumber("9940667263");
		customer.setEmailId("pomo@gmail.com");
		customer.setUserId("meena");
		Wallet wallet = new Wallet();
		wallet.setPassword("123");
		wallet.setTransaction("aaa");
		customer.setWallet(wallet);
		boolean condition = service.validateDetails(customer);
		assertTrue(condition);
	}

	@Test(expected = WalletException.class)
	public void CheckForInvalidUserId() throws WalletException {
		Customer customer = new Customer();
		customer.setName("Meena");
		customer.setPhNumber("9940667263");
		customer.setEmailId("meena@gmail.com");
		customer.setUserId("11.1");
		Wallet wallet = new Wallet();
		wallet.setPassword("123");
		wallet.setTransaction("aaa");
		customer.setWallet(wallet);
		boolean condition = service.validateDetails(customer);
		assertFalse(condition);

	}

	@Test
	public void CheckForValidUserId() throws WalletException {
		Customer customer = new Customer();
		customer.setName("Meena");
		customer.setPhNumber("9940667263");
		customer.setEmailId("meena@gmail.com");
		customer.setUserId("lalli");
		Wallet wallet = new Wallet();
		wallet.setPassword("123");
		wallet.setTransaction("aaa");
		customer.setWallet(wallet);
		boolean condition = service.validateDetails(customer);
		assertTrue(condition);

	}

	@Test(expected = WalletException.class)
	public void CheckForInvalidpassword() throws WalletException {
		Customer customer = new Customer();
		customer.setName("Rohini");
		customer.setPhNumber("9940667234");
		customer.setEmailId("meenaas@gmail.com");
		customer.setUserId("qwert");
		Wallet wallet = new Wallet();
		wallet.setPassword("qwert");
		wallet.setTransaction("aaa");
		customer.setWallet(wallet);
		boolean condition = service.validateDetails(customer);
		assertFalse(condition);

	}

	@Test
	public void CheckForValidPassword() throws WalletException {
		Customer customer = new Customer();
		customer.setName("Meena");
		customer.setPhNumber("9940667263");
		customer.setEmailId("meena@gmail.com");
		customer.setUserId("meena");
		Wallet wallet = new Wallet();
		wallet.setPassword("mmmmmmmmmm");
		wallet.setTransaction("aaa");
		customer.setWallet(wallet);
		boolean condition = service.validateDetails(customer);
		assertTrue(condition);

	}
}
	
	

