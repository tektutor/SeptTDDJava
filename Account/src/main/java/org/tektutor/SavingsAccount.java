package org.tektutor;

public class SavingsAccount {


	public double getBalance() throws DBServerIsDownException {
		System.out.println ("Original getBalance code ...");
		System.out.println ("Interacts with db server.");
		return 5000.00;
	}

	public double deposit( double amount ) throws DBServerIsDownException {
		System.out.println ("Original deposit code ...");
		double balance = getBalance();
		balance = balance + amount;
		return balance;
	}

	public double withdraw( double amount ) throws DBServerIsDownException {
		System.out.println ("Original withdraw code ...");
		double balance = getBalance();
		balance = balance - amount;
		return balance;
	}

}

