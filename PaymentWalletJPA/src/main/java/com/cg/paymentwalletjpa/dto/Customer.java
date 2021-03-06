package com.cg.paymentwalletjpa.dto;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "paymentwallet")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String userId;
	private String name;
	private String phNumber;
	private String emailId;
	public Customer(String userId, String name, String phNumber, String emailId, Wallet wallet) {
		super();
		this.userId = userId;
		this.name = name;
		this.phNumber = phNumber;
		this.emailId = emailId;
		this.wallet = wallet;
	}

	@Embedded
	private Wallet wallet;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public Customer() {
	}

	public Customer(String name, String phNumber, String emailId) {
		super();
		this.name = name;
		this.phNumber = phNumber;
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}