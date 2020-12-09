package uppgift_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	// running before start
	public void init() {

	}

	// main stuff
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("Assets/person.png")));
			primaryStage.setTitle("Person manager");
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// runs on exit
	public void stop() {
		SampleController.writeToXML(SampleController.personList);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
