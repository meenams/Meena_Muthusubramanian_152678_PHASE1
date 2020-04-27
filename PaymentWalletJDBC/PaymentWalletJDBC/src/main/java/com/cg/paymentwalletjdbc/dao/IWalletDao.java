package com.cg.paymentwalletjdbc.dao;

import java.util.ArrayList;

import com.cg.paymentwalletjdbc.dto.Wallet;
import com.cg.paymentwalletjdbc.exception.WalletException;

public interface IWalletDao {

	public int createAccount(Wallet wallet) throws WalletException;

	public double showBalance(String userId);

	public void depositAmount(String userId, double amount);

	public void withdrawAmount(String userId, double amount);

	public boolean fundTransfer(String userIdSender, String userIdReceiver, double amount) throws WalletException;


	public String login(String id, String password) throws WalletException;

	public ArrayList<String> printTransactions(String userId);
}

