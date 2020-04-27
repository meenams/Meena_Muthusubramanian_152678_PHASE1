# Payment Wallet for Banking Systems 
This model of payment wallet was developed using Java Scanner and Utilities, which was a prototype of internet banking applications. This can also be implemented using JDBC and Spring boot. 

# Introduction
This is similar to a netbanking application where an user account is created with valid credentails and after which, banking operations are performed. This payment wallet is developed with Java as the programming language and once after logging in, the user will be able to perfom the following operations 
1. Show Balance
2. WIthdraw Money
3. Deposit Money
4. Transfer Funds
5. Print Transaction history
4. Exit app


# Tools and Technologies
Java Packages are created in Eclipse mainly utilising the features of Core java like Scanner class, Implementing interfaces and exception handling


# Functionalities
Performs various operations like - Creating an account with necessary basic details, and after logging in, the user will be able to complete the multiple processes through mobile banking. The multiple process includes - Cheking the account balance, transferring money to other person, checking account transaction history


# Files Overview
PaymentWallet/src/main/java/com/cg/paymentwallet/dao/IWalletDao.java
  Functions are written to perfom the following operations
  - Wallet login
  - Show balance
  - Deposit amount
  - Withdraw amount
  - Funds Transfer
  - Print the transaction
  
PaymentWallet/src/main/java/com/cg/paymentwallet/dto/Customer.java
Inputs are attained in runtime from the user - name, phone number and email for creating the account

PaymentWallet/src/main/java/com/cg/paymentwallet/dto/Wallet.java
After creation of account - userid and password is set and the transaction is returned as an array element

PaymentWallet/src/main/java/com/cg/paymentwallet/exception/IWalletException.java
Exception handling is done based on invalid login details and funds transfer where the parameters for inputs are set of values harcoded in the java file

PaymentWallet/src/main/java/com/cg/paymentwallet/service/WalletServiceImpl.java
Validations are set in this java file for user name, mobile number and email

PaymentWallet/src/main/java/com/cg/paymentwallet/ui/App.java
The inputs from the user are attained by using Scanner utilities and the overall functional java files are called in this main file. 



# Dependencies
