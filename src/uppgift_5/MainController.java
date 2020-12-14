package uppgift_5;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainController implements Initializable {

	@FXML
	private TextField userNameTextField;

	@FXML
	private PasswordField passwordTextfield;

	@FXML
	private Button loginButton;

	public static ArrayList<User> userList = new ArrayList<User>(XML.decode());

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		createUser();

	}

	@FXML
	void login(ActionEvent event) {

	}

	public void createUser() {
		User user = new User();
		user.setUserName("admin");
		user.setPassword("test");
		userList.add(user);

	}

}
