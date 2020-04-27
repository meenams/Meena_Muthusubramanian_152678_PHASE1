package com.cg.paymentwalletjdbc.dto;

import java.util.ArrayList;

public class Wallet extends Customer {
	
	private double balance;
	private String userId;
	private String password;
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Wallet() {

	}
}
	
	
	
	


	
