package uppgift_5;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController implements Initializable {
	private static User selectedUser;
	private static Account selectedAccount;

	@FXML
	private Label welcomeLabel;

	@FXML
	private Label infoLabel;

	@FXML
	private Button createAccountButton;

	@FXML
	private Button deleteAccountButton;

	@FXML
	private Button depositButton;

	@FXML
	private Button withdrawalButton;

	@FXML
	private TextField inputField;

	@FXML
	private Button changePasswordButton;

	@FXML
	private TableView<Account> tableview;

	@FXML
	private TableColumn<Account, String> accountNumberColumn;

	@FXML
	private TableColumn<Account, String> balanceColumn;

	@FXML
	private TableColumn<Account, String> latestTransactionColumn;

	@FXML
	private TableColumn<Account, String> dateCreatedColumn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		welcomeLabel.setText("Welcome " + selectedUser.getUserName() + " !");

		// fill tableview
		accountNumberColumn.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
		balanceColumn.setCellValueFactory(new PropertyValueFactory<>("balance"));
		latestTransactionColumn.setCellValueFactory(new PropertyValueFactory<>("latestTransaction"));
		dateCreatedColumn.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));

		for (int i = 0; i < selectedUser.accounts.size(); i++) {
			tableview.getItems().add(selectedUser.accounts.get(i));
		}

		tableview.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				depositButton.setDisable(false);
				withdrawalButton.setDisable(false);
				inputField.setDisable(false);
				infoLabel.setText("Enter amount");
				infoLabel.setAlignment(Pos.CENTER);
			}
		});

	}

	@FXML
	void createAccount(ActionEvent event) {
		selectedUser.createAccount();

		int selection = selectedUser.accounts.size() - 1;
		tableview.getItems().add(selectedUser.accounts.get(selection));
		tableview.refresh();

	}

	@FXML
	void deleteAccount(ActionEvent event) {
		selectedAccount = (Account) tableview.getSelectionModel().getSelectedItem();
		tableview.getItems().remove(selectedAccount);
		selectedUser.accounts.remove(selectedAccount);
		tableview.refresh();
	}

	@FXML
	void changePassword(ActionEvent event) throws IOException {
		Stage passwordChange = new Stage();
		passwordChange.setTitle("Change Password");
		passwordChange.getIcons().add(new Image(getClass().getResourceAsStream("Assets/logo.png")));
		Parent parent = FXMLLoader.load(getClass().getResource("passwordChange.fxml"));
		Scene passwordChangeScene = new Scene(parent);
		passwordChangeScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		passwordChange.setScene(passwordChangeScene);
		passwordChange.initModality(Modality.APPLICATION_MODAL);
		passwordChange.show();
	}

	public static String getDateAndTime() {
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formattedDate = sd.format(date);

		return formattedDate;
	}

	public static int randomNumber() {
		Random rand = new Random();
		int accnumber = rand.nextInt(10001);
		return accnumber;
	}

	public void deposit() {
		selectedAccount = (Account) tableview.getSelectionModel().getSelectedItem();
		double deposit = Double.parseDouble((inputField.getText()));
		double balance = selectedAccount.getBalance();

		balance += deposit;
		selectedAccount.setBalance(balance);
		selectedAccount.setLatestTransaction(getDateAndTime());

		tableview.refresh();
	}

	public void withdraw() {
		selectedAccount = (Account) tableview.getSelectionModel().getSelectedItem();
		double withdraw = Double.parseDouble((inputField.getText()));
		double balance = selectedAccount.getBalance();
		if (withdraw > balance) {
			System.out.println("balance too low");
		} else {
			balance -= withdraw;
			selectedAccount.setBalance(balance);
		}
		selectedAccount.setLatestTransaction(getDateAndTime());

		tableview.refresh();
	}

	public static void setUser(User user) {
		selectedUser = user;
	}

	public static User getUser() {
		return selectedUser;
	}

}
