package com.cg.paymentwalletjdbc.service;
import java.lang.reflect.Array;
import java.util.ArrayList;

import com.cg.paymentwalletjdbc.dao.IWalletDao;
import com.cg.paymentwalletjdbc.dao.WalletDaoImpl;
import com.cg.paymentwalletjdbc.dto.Wallet;
import com.cg.paymentwalletjdbc.exception.IWalletException;
import com.cg.paymentwalletjdbc.exception.WalletException;

public class WalletServiceImpl implements IWalletService {
	

	IWalletDao dao = new WalletDaoImpl();

	public int createAccount(Wallet wallet) throws WalletException {
		int row;
		row = dao.createAccount(wallet);
		return row;
	}

	public double showBalance(String userId) {

		return dao.showBalance(userId);
	}

	public boolean deposit(String userId, double amount) {
		boolean result = false;
		if (amount > 0) {
			dao.depositAmount(userId, amount);
			result = true;
		}

		return result;
	}

	public boolean withdraw(String userId, double amount) {
		boolean result = false;
		if (dao.showBalance(userId) >= amount) {
			dao.withdrawAmount(userId, amount);
			result = true;
		}

		return result;
	}

	public boolean fundTransfer(String userIdSender, String userIdReceiver, double amount) throws WalletException {
		boolean result = false;
		if (dao.showBalance(userIdSender) >= amount) {
			if (dao.fundTransfer(userIdSender, userIdReceiver, amount)) {
				result = true;	
			}
			
		}

		return result;
	}



	public boolean validateDetails(Wallet wallet) throws WalletException {
		boolean result = true;
		String regex = "[A-Z]{1}[a-z]+";
		String regex2 = "[0-9]{10}";
		String regex3 = "[a-z0-9_.]{1,}@[a-z]{1,10}.com";
		String regex4 = "[A-Za-z0-9]{4,}";
		if (wallet.getName().matches(regex)) {
			if (wallet.getPhNumber().matches(regex2)) {
				if (wallet.getEmailId().matches(regex3)) {
					if (!(wallet.getUserId().equals(wallet.getPassword()))) {

						if (wallet.getUserId().matches(regex4)) {


								result = true;


						} else
							throw new WalletException(IWalletException.ERROR8);

					} else
						throw new WalletException(IWalletException.ERROR7);

				} else
					throw new WalletException(IWalletException.ERROR3);

			} else
				throw new WalletException(IWalletException.ERROR2);

		} else
			throw new WalletException(IWalletException.ERROR1);
		return result;

	}
	public String login(String id, String password) throws WalletException {
		if(dao.login(id, password)!=null) {
			return dao.login(id, password);
		} else
			throw new WalletException(IWalletException.ERROR5);

	}

	public ArrayList<String> printTransactions(String userId) {
		ArrayList<String> list = dao.printTransactions(userId);
		return list;
	}

}
