package com.cg.paymentwalletjdbc.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.paymentwalletjdbc.dto.Wallet;
import com.cg.paymentwalletjdbc.exception.WalletException;
import com.cg.paymentwalletjdbc.service.IWalletService;
import com.cg.paymentwalletjdbc.service.WalletServiceImpl;

public class App {
	
	static Scanner scanner=new Scanner(System.in);
	
    public static void main( String[] args ) {
    	
    	int choice1 = 0;

		do {
			System.out.println("PAYMENT WALLET");
			System.out.println("----------------------");
			System.out.println("1.Create Account");
			System.out.println("2.Login");
			System.out.println("3.Exit App");
			
			choice1 = scanner.nextInt();
			IWalletService service= new WalletServiceImpl();
				
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

					Wallet wallet = new Wallet();
					wallet.setPhNumber(phNum);
					wallet.setName(name);
					wallet.setEmailId(emailId);
					wallet.setUserId(userId);
					wallet.setPassword(pass);
					wallet.setBalance(balance);
					
					boolean result=false;
					int row=0;

					try {
						result = service.validateDetails(wallet);
						row = service.createAccount(wallet);
							System.out.println("Account created successfully..");
					
					} catch (WalletException e) {

						e.getMessage();
					}
					if (!result) {
						System.out.println("Cannot create account. Try Again");
					} else if (row != 0) {
						System.out.println(row + " account created");

					} else
						System.out.println("Cannot create account! Try Again");

					break;

				case 2:
					System.out.println("Enter your user id");
					String id = scanner.next();
					System.out.println("Enter your password");
					String password = scanner.next();
					String loginId;
					try {
						loginId = service.login(id, password);
						login(loginId);
					} catch (WalletException e) {
						e.getMessage();
					}

					break;

				case 3:
					System.out.println("Thank you for banking with us :)");
					break;

				default:
					System.out.println("Invalid choice.Try again!!");
					break;
				}
			} while (choice1 != 3);

		}

		private static void login(String userId) {
			int choice2 = 0;
			System.out.println("Welcome ");
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

				switch (choice2) {
				case 1:
					double balance = service.showBalance(userId);
					System.out.println("Your account balance is " + balance);
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
									+ receiverUserId);
							System.out.println("Your updated account balance is rupees " + service.showBalance(userId));
						}
					} catch (WalletException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:

					ArrayList<String> transactions = new ArrayList<String>();
					System.out.println("TRANSACTION DETAILS");
					transactions=service.printTransactions(userId);
					for (String trans : transactions) {
						System.out.println(trans);
					}
					break;
				case 6:
					System.out.println("Logged out successfully");
					break;

				default:
					System.out.println("Invalid choice! Try Again!");
					break;
				}
			} while (choice2 != 6);

		}
	
}
