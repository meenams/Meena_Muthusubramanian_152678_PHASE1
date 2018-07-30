package com.cg.paymentwallet.exception;

@SuppressWarnings("serial")
public class WalletException extends Exception{
	public WalletException() {
		super();
	}

	public WalletException(String message) {
		System.out.println(message);
	}
}
