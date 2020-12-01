package uppgift_3_old;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	int milliseconds = 0;
	int seconds = 0;
	int minutes = 0;

	Label display = new Label("00:00:000");
	Button startButton = new Button("START");
	Button resetButton = new Button("RESET");
	Timeline timeLine;

	String text1;

	@Override
	public void start(Stage stage) {
		stage.setTitle("stopwatch");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(20);
		grid.setPadding(new Insets(10));

		display.setFont(new Font("Helvetica", 40));
		display.setTextFill(Color.RED);
		display.setStyle("-fx-border-color:green; -fx-background-color: black;");
		timeLine = new Timeline(new KeyFrame(Duration.millis(1), e -> {
			milliseconds++;

			if (milliseconds == 1000) {
				milliseconds = 0;
				seconds++;
			}

			if (seconds == 60) {
				seconds = 0;
				minutes++;
			}
			text1 = String.format("%02d:%02d:%03d", minutes, seconds, milliseconds);
			display.setText(text1);

		}));
		timeLine.setCycleCount(Animation.INDEFINITE);

		grid.add(display, 0, 0);

		grid.add(startButton, 0, 1);
		startButton.setOnAction(ActionEvent -> {
			startTimer();
		});

		grid.add(resetButton, 1, 1);
		resetButton.setOnAction(ActionEvent -> {
			resetTimer();
		});

		TableView tableView = new TableView();
		TableColumn column1 = new TableColumn("1");
		TableColumn column2 = new TableColumn("2");
		TableColumn column3 = new TableColumn("3");

		tableView.setPrefWidth(300);
		tableView.setPrefHeight(400);
		column1.setPrefWidth(150);
		column2.setPrefWidth(50);
		column3.setPrefWidth(100);

		tableView.getColumns().add(column1);
		tableView.getColumns().add(column2);
		tableView.getColumns().add(column3);

		grid.add(tableView, 0, 4);

		Scene scene = new Scene(grid, 954, 1000);

		stage.setScene(scene);
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		stage.show();
	}

	public void startTimer() {
		if (startButton.getText().equals("START")) {
			startButton.setText("STOP");
			timeLine.play();
		} else {
			startButton.setText("START");
			timeLine.stop();
		}
	}

	public void resetTimer() {
		timeLine.stop();
		milliseconds = 0;
		seconds = 0;
		minutes = 0;

		display.setText("00:00:000");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
