package uppgift_5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PasswordChangeController {

	@FXML
	private Button savePasswordButton;

	@FXML
	private TextField newPasswordField;

	@FXML
	private Label infoLabel;

	@FXML
	void savePassword(ActionEvent event) {

		MainController.getUser().setPassword(newPasswordField.getText());
		infoLabel.setVisible(true);
	}

}
