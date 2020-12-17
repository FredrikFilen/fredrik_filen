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
		account.setBalance(0);
		account.setDateCreated(MainController.getDateAndTime());

		this.accounts.add(account);

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
