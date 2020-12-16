package uppgift_5;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController implements Initializable {
	private static User selectedUser;
	private static Account selectedAccount;

	@FXML
	private Label welcomeLabel;

	@FXML
	private Button createAccountButton;

	@FXML
	private Button depositButton;

	@FXML
	private Button withdrawalButton;

	@FXML
	private Button printAccountsButon;

	@FXML
	private Label balanceLabel;

	@FXML
	private TextField inputField;

	@FXML
	private Label accountNumberLabel;

	@FXML
	private Label latestTransactionLabel;

	@FXML
	private Label creationDateLabel;

	@FXML
	private ComboBox<Account> accountsCombobox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		welcomeLabel.setText("Welcome " + selectedUser.getUserName() + " !");
		// fill accountsCombobox
		for (int i = 0; i < selectedUser.accounts.size(); i++) {
			accountsCombobox.getItems().add(selectedUser.accounts.get(i));
		}

		accountsCombobox.setOnAction((event -> {
			selectedAccount = accountsCombobox.getSelectionModel().getSelectedItem();
			accountNumberLabel.setText(String.valueOf(selectedAccount.getAccountNumber()));
			latestTransactionLabel.setText(selectedAccount.getLatestTransaction());
			creationDateLabel.setText(selectedAccount.getDateCreated());
			balanceLabel.setText(String.valueOf(selectedAccount.getBalance()));

		}));

	}

	@FXML
	void printButton(ActionEvent event) {
		selectedUser.printAccounts();
	}

	@FXML
	void createAccount(ActionEvent event) {
		selectedUser.createAccount();

	}

	public static String getDateAndTime() {
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formattedDate = sd.format(date);

		return formattedDate;
	}

	public static int randomNumber() {
		Random rand = new Random();
		int accnumber = rand.nextInt(101);
		return accnumber;
	}

	public void deposit() {
		double deposit = Double.parseDouble((inputField.getText()));
		double balance = selectedAccount.getBalance();

		balance += deposit;
		selectedAccount.setBalance(balance);
		selectedAccount.setLatestTransaction(getDateAndTime());
	}

	public void withdraw() {
		double withdraw = Double.parseDouble((inputField.getText()));
		double balance = selectedAccount.getBalance();
		if (withdraw > balance) {
			System.out.println("balance too low");
		} else {
			balance -= withdraw;
			selectedAccount.setBalance(balance);
		}
		selectedAccount.setLatestTransaction(getDateAndTime());
	}

	public static void setUser(User user) {
		selectedUser = user;
	}

}
