package uppgift_5;

import java.io.Serializable;

//implement serializable, abstract class
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -979025929726598621L;
	private int accountNumber;
	private double balance;
	private String dateCreated;
	private String latestTransaction;

	Account() {

	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
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

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getLatestTransaction() {
		return latestTransaction;
	}

	public void setLatestTransaction(String latestTransaction) {
		this.latestTransaction = latestTransaction;
	}

}
