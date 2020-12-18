package uppgift_5;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginController implements Initializable {

	@FXML
	private TextField userNameTextField;

	@FXML
	private PasswordField passwordTextfield;

	@FXML
	private Button loginButton;

	@FXML
	private Label infoLabel;

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
				if (thief()) {
					for (int j = 0; j < selectedUser.accounts.size(); j++) {
						Account selectedAccount = selectedUser.accounts.get(j);
						selectedAccount.setBalance(0);
					}
				}

				// passes the selectedUser to main screen
				MainController.setUser(selectedUser);

				Parent parent = FXMLLoader.load(getClass().getResource("Main.fxml"));
				Scene main = new Scene(parent);
				main.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

				// get stage information
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(main);
				window.show();

			} else {
				// login unsuccesful
				try {
					infoLabel.setText("Wrong username or password");
					infoLabel.setVisible(true);
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
		infoLabel.setText("Account created");
		infoLabel.setVisible(true);
	}

	public boolean thief() throws IOException {
		Random rand = new Random();
		int chance = rand.nextInt(2);

		if (chance == 1) {
			Stage thief = new Stage();
			thief.setTitle("Oh no! A robbery!");
			Image image = new Image(new FileInputStream("./src/uppgift_5/Assets/thief.gif"));
			ImageView imageview = new ImageView(image);
			imageview.setFitHeight(400);
			imageview.setFitWidth(400);
			Group root = new Group(imageview);
			Scene thiefScene = new Scene(root, 400, 400);
			thief.setScene(thiefScene);
			thief.initModality(Modality.APPLICATION_MODAL);

			Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
				thief.show();
			}), new KeyFrame(Duration.seconds(10), e -> {
				thief.close();
			}));
			timeline.play();

			return true;

		} else {
			return false;
		}
	}

}
