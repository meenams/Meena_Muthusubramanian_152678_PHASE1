package com.cg.paymentwalletjpa.service;

import com.cg.paymentwalletjpa.dto.Customer;
import com.cg.paymentwalletjpa.exception.WalletException;

public interface IWalletService {
	
	public void createAccount(Customer customer);

	public double showBalance(String phNumber);

	public boolean deposit(String phNumber, double amount);

	public boolean withdraw(String phNumber, double amount);

	public boolean fundTransfer(String phSender, String phReceiver, double amount) throws WalletException;

	public String printTransaction(String phNumber);

	public boolean validateDetails(Customer customer) throws WalletException;

	public Customer login(String id, String password) throws WalletException;

}
