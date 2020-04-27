package com.cg.paymentwalletjpa.service;
import com.cg.paymentwalletjpa.dao.IWalletDao;
import com.cg.paymentwalletjpa.dao.WalletDaoImpl;
import com.cg.paymentwalletjpa.dto.Customer;
import com.cg.paymentwalletjpa.exception.IWalletException;
import com.cg.paymentwalletjpa.exception.WalletException;

public class WalletServiceImpl implements IWalletService {
	
	IWalletDao dao = new WalletDaoImpl();
	public void createAccount(Customer wallet) {
		dao.beginTransaction();
		dao.createAccount(wallet);
		dao.commitTrasaction();
	}

	public double showBalance(String userId) {

		double balance = 0;
		dao.beginTransaction();
		balance = dao.showBalance(userId);
		dao.commitTrasaction();
		return balance;
	}

	public boolean deposit(String userId, double amount) {
		boolean result = false;
		if (amount > 0) {
			dao.beginTransaction();
			dao.depositAmount(userId, amount);
			dao.commitTrasaction();
			result = true;
		}
		return result;
	}

	public boolean withdraw(String userId, double amount) {
		boolean result = false;
		if (dao.showBalance(userId) >= amount) {
			dao.beginTransaction();
			dao.withdrawAmount(userId, amount);
			dao.commitTrasaction();
			result = true;
		}
		return result;
	}

	public boolean fundTransfer(String userIdSender, String userIdReceiver, double amount) throws WalletException {
		boolean result = false;
		if (dao.showBalance(userIdSender) >= amount) {
			dao.beginTransaction();
			dao.fundTransfer(userIdSender, userIdReceiver, amount);
			dao.commitTrasaction();
			result = true;
		}
		return result;
	}

	public boolean validateDetails(Customer customer) throws WalletException {
		boolean result = true;
		String regex = "[A-Z]{1}[a-z]+";
		String regex2 = "[0-9]{10}";
		String regex3 = "[a-z0-9_.]{1,}@[a-z]{1,10}.com";
		String regex4 = "[A-Za-z0-9]{4,}";
		if (customer.getName().matches(regex)) {

			if (customer.getPhNumber().matches(regex2)) {

				if (customer.getEmailId().matches(regex3)) {

					if (!(customer.getUserId().equals(customer.getWallet().getPassword()))) {

						if (customer.getUserId().matches(regex4)) {

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

	public Customer login(String id, String password) throws WalletException {

		Customer wallet = new Customer();
		if (dao.login(id, password)!= null) {

			wallet = dao.login(id, password);
		} else
			throw new WalletException(IWalletException.ERROR5);

		return wallet;
	}

	public String printTransaction(String userId) {

		dao.beginTransaction();
		String trans = dao.printTransaction(userId);
		dao.commitTrasaction();
		return trans;
	}

}

	