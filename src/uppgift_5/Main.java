package uppgift_5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	public void init() {

	}

	public static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		try {
			// primaryStage.getIcons().add(new
			// Image(getClass().getResourceAsStream("Assets/logo.png")));
			primaryStage.setTitle("My bank");
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene login = new Scene(root);
			login.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(login);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void stop() {
		XML.encode(LoginController.userList);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
