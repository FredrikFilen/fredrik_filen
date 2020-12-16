package uppgift_5;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
	/**
	 * 
	 */

	ArrayList<Account> accounts = new ArrayList<Account>();
	private String userName;
	private String password;

	public User() {

	}

	public void createAccount() {
		Account account = new Account();
		account.setAccountNumber(MainController.randomNumber());
		account.setBalance(1337);
		account.setDateCreated(MainController.getDateAndTime());

		this.accounts.add(account);

	}

	public void printAccounts() {
		for (int i = 0; i < accounts.size(); i++) {
			System.out.println(accounts.get(i).getAccountNumber());
			System.out.println(accounts.get(i).getBalance());
			System.out.println(accounts.get(i).getDateCreated());
		}
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
