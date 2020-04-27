package com.cg.spring.PaymentWalletSpring.service;

import java.util.List;

import com.cg.spring.PaymentWalletSpring.dto.Customer;

public interface PaymentWalletService {
	
	public void createAccount(Customer customer);

	public double showBalance(String number);

	public void deposit(String number, Double amount);

	public void withdraw(String number, Double amount);

	public void fundTransfer(String number1, String number2, Double amount);

	public String printTransaction(String number);

	public List<Customer> getAllCustomers();
}
