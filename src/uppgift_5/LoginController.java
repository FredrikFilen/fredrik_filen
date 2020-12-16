package uppgift_5;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML
	private TextField userNameTextField;

	@FXML
	private PasswordField passwordTextfield;

	@FXML
	private Button loginButton;

	@FXML
	private Label wrongPasswordLabel;

	public static ArrayList<User> userList = new ArrayList<User>(XML.decode());

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void login(ActionEvent event) throws IOException {
		/*
		 * for (int i = 0; i < userList.size(); i++) { User selectedUser =
		 * userList.get(i); if
		 * (selectedUser.getUserName().equals(userNameTextField.getText()) &&
		 * selectedUser.getPassword().equals(passwordTextfield.getText())) {
		 * 
		 * 
		 * } else { wrongPasswordLabel.setVisible(true); } }
		 */

		Parent parent = FXMLLoader.load(getClass().getResource("Mainwindow.fxml"));
		Scene main = new Scene(parent);

		// get stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(main);
		window.show();
	}

	public void createUser(String username, String password) {
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		userList.add(user);

	}

}
