package uppgift_5;

import java.io.IOException;
import java.net.URL;
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

	@FXML
	private Button signupButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void login(ActionEvent event) throws IOException {
		for (int i = 0; i < Main.userList.size(); i++) {
			User selectedUser = Main.userList.get(i);

			if (selectedUser.getUserName().equals(userNameTextField.getText())
					&& selectedUser.getPassword().equals(passwordTextfield.getText())) {
				// login successful

				// passes the selectedUser to main screen
				MainController.setUser(selectedUser);

				Parent parent = FXMLLoader.load(getClass().getResource("Main.fxml"));
				Scene main = new Scene(parent);

				// get stage information
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(main);
				window.show();

			} else {
				// login unsuccesful
				try {
					wrongPasswordLabel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

	@FXML
	void createUser(ActionEvent event) {
		String username = userNameTextField.getText();
		String password = passwordTextfield.getText();
		User newUser = new User();
		newUser.setPassword(password);
		newUser.setUserName(username);
		Main.userList.add(newUser);
	}

}
