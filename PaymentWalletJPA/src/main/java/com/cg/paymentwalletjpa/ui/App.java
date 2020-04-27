package com.cg.paymentwalletjpa.ui;

import java.util.Scanner;

import com.cg.paymentwalletjpa.dto.Customer;
import com.cg.paymentwalletjpa.dto.Wallet;
import com.cg.paymentwalletjpa.exception.WalletException;
import com.cg.paymentwalletjpa.service.IWalletService;
import com.cg.paymentwalletjpa.service.WalletServiceImpl;


public class App {
	static Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {

	int choice1 = 0;

	do {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("PAYMENT WALLET");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("1.Create Account");
		System.out.println("2.Login");
		System.out.println("3.Exit App");

		choice1 = scanner.nextInt();
		IWalletService service = new WalletServiceImpl();
		switch (choice1) {
		case 1:
			System.out.println("Enter your phone number");
			String phNum = scanner.next();
			System.out.println("Enter your name");
			String name = scanner.next();
			System.out.println("Enter your email Id");
			String emailId = scanner.next();
			System.out.println("Enter the desired user id");
			String userId = scanner.next();
			System.out.println("Set your new password");
			String pass = scanner.next();
			System.out.println("Enter the initial amount to be deposited");
			double balance = scanner.nextDouble();

			Customer customer= new Customer();
			customer.setUserId(userId);
			customer.setPhNumber(phNum);
			customer.setName(name);
			customer.setEmailId(emailId);
			
			Wallet wallet=new Wallet();
			wallet.setPassword(pass);
			wallet.setBalance(balance);
			wallet.setTransaction("aaa");
			customer.setWallet(wallet);

			boolean result = false;
			try {
				result = service.validateDetails(customer);
				service.createAccount(customer);
				System.out.println("Hello " + customer.getName());
				System.out.println("Your Account is Created Succesfully");
			} catch (WalletException e) {

				e.getMessage();
			}
			if (!result) {
				System.out.println("Cannot create account. Try Again");
			}
			break;

		case 2:
			System.out.println("Enter your user id");
			String id = scanner.next();
			System.out.println("Enter your password");
			String password = scanner.next();
			Customer loginWallet = new Customer();
			try {
				loginWallet = service.login(id, password);
				login(loginWallet);
			} catch (WalletException e) {
				e.getMessage();
			}

			break;

		case 3:
			System.out.println("Thank you for banking with us :)");
			System.out.println("----------------------------------------------------------------------");
			break;

		default:
			System.out.println("Invalid choice.Try again!!");
			break;
		}
	} while (choice1 != 3);

}

private static void login(Customer customer) {
	int choice2 = 0;
	System.out.println("Welcome " + customer.getName());
	System.out.println("----------------------------------------------------------------------");
	do {
		System.out.println("PAYMENT WALLET");
		System.out.println("1. Show balance");
		System.out.println("2. Withdraw money");
		System.out.println("3. Deposit money");
		System.out.println("4. Transfer funds");
		System.out.println("5. Print Transaction history");
		System.out.println("6. Exit");
		choice2 = scanner.nextInt();
		IWalletService service = new WalletServiceImpl();
		String userId = customer.getUserId();

		switch (choice2) {
		case 1:
			System.out.println("Your account balance is " + service.showBalance(userId));
			break;
		case 2:
			System.out.println("Enter the withdraw amount ");
			double withdrawAmount = scanner.nextDouble();
			if (service.withdraw(userId, withdrawAmount)) {
				System.out.println("Rupees " + withdrawAmount + " withdrawn from your wallet successfully");
				System.out.println("Your updated account balance is rupees " + service.showBalance(userId));
			} else
				System.out.println("Insufficient balance. Withdraw failed!!");

			break;
		case 3:
			System.out.println("Enter the deposit amount");
			double depositAmount = scanner.nextDouble();
			if (service.deposit(userId, depositAmount)) {
				System.out.println("Rupees " + depositAmount + " deposited to your wallet successfully");
				System.out.println("Your updated account balance is rupees " + service.showBalance(userId));
			} else
				System.out.println("Cannot deposit amount!!");
			break;
		case 4:
			System.out.println("Enter the userId of beneficiery account");
			String receiverUserId = scanner.next();
			System.out.println("Enter the transfer amount");
			double transferAmount = scanner.nextDouble();
			try {
				if (service.fundTransfer(userId, receiverUserId, transferAmount)) {
					System.out.println("Rupees " + transferAmount + " succesfully transfered to beneficiery account" 
							+" "+ receiverUserId);
					System.out.println("Your updated account balance is rupees " + service.showBalance(userId));
				}
			} catch (WalletException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:

			System.out.println("TRANSACTION DETAILS");
			String trans = service.printTransaction(userId);
			Scanner scanner=new Scanner(trans).useDelimiter("aaa");
			while (scanner.hasNext()) {
				String string=scanner.next();
				System.out.println(string);
			}
			break;
		case 6:
			System.out.println("Logged out successfully");
			System.out.println("----------------------------------------------------------------------");
			break;

		default:
			System.out.println("Invalid choice! Try Again!");
			break;
		}
	} while (choice2 != 6);

}
}

