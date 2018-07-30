package com.cg.paymentwallet.dao;

import com.cg.paymentwallet.dto.Wallet;
import com.cg.paymentwallet.exception.WalletException;

public interface IWalletDao {
	public void createAccount(Wallet wallet);

	public double showBalance(String userId);

	public void depositAmount(String userId, double amount);

	public void withdrawAmount(String userId, double amount);

	public boolean fundTransfer(String userIdSender, String userIdReceiver, double amount) throws WalletException;

	public String printTransaction(String userId);

	public Wallet login(String id, String password) throws WalletException;
}
