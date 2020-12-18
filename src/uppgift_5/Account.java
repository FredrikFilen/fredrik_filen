package uppgift_5;

import java.io.Serializable;

//implement serializable, abstract class
public class Account implements Serializable {

	/**
	 * 
	 */

	private int accountNumber;
	private double balance;
	private String dateCreated;
	private String latestTransaction;

	public Account() {

	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int number) {
		this.accountNumber = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String date) {
		this.dateCreated = date;
	}

	public String getLatestTransaction() {
		return latestTransaction;
	}

	public void setLatestTransaction(String date) {
		this.latestTransaction = date;
	}

	public void setLatestTransaction(String action, double amount, String date) {
		String transaction = action + amount + " " + date;
		this.latestTransaction = transaction;
	}

}
