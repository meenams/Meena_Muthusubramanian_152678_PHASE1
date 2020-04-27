package com.cg.paymentwalletjpa.dao;

import com.cg.paymentwalletjpa.dto.Customer;
import com.cg.paymentwalletjpa.exception.WalletException;

public interface IWalletDao {
	public void createAccount(Customer customer);

	public double showBalance(String userId);

	public void depositAmount(String userId, double amount);

	public void withdrawAmount(String userId, double amount);

	public void fundTransfer(String userIdSender, String userIdReceiver, double amount) throws WalletException;

	public String printTransaction(String userId);

	public Customer login(String id, String password) throws WalletException;
	
	
	void beginTransaction();
		
	void commitTrasaction();
}


