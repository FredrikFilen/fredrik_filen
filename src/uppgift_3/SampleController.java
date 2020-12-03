package uppgift_3;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SampleController implements Initializable {
	int milliseconds = 0;
	int seconds = 0;
	int minutes = 0;
	String text1;
	Timeline timeLine;

	@FXML
	private Button startButton;

	@FXML
	private Button resetButton;

	@FXML
	private Button clearHistoryButton;

	@FXML
	private TextField timeDisplay;

	@FXML
	private TableView<DateAndTime> tableView;

	@FXML
	private TableColumn<DateAndTime, String> dateTime;

	@FXML
	private TableColumn<DateAndTime, String> timeColumn;

	@FXML
	private Button mysteryButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dateTime.setCellValueFactory(new PropertyValueFactory<>("date"));
		timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));

		tableView.setItems(savedTime);

	}

	ObservableList<DateAndTime> savedTime = FXCollections.observableArrayList();

	@FXML
	void startTimer(ActionEvent event) {

		if (startButton.getText().equals("START")) {
			startButton.setText("STOP");
			startButton.setStyle("-fx-background-color: red");
			newTimeline();

		} else {
			startButton.setText("START");
			startButton.setStyle("-fx-background-color: green");
			timeLine.stop();
			savedTime.add(new DateAndTime(text1));
		}

	}

	@FXML
	void resetTimer(ActionEvent event) {
		timeLine.stop();
		milliseconds = 0;
		seconds = 0;
		minutes = 0;

		timeDisplay.setText("00 : 00 : 000");
		startButton.setText("START");
		startButton.setStyle("-fx-background-color: green");

	}

	@FXML
	void clearHistory(ActionEvent event) {
		tableView.getItems().clear();
	}

	void newTimeline() {
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
			text1 = String.format("%02d : %02d : %03d", minutes, seconds, milliseconds);
			timeDisplay.setText(text1);
		}));
		timeLine.setCycleCount(Animation.INDEFINITE);
		timeLine.play();
	}

	@FXML
	void mysteryMode(ActionEvent event) {
		Stage mystery = new Stage();
		final File file = new File("mystery.mp4");
		final String MEDIA_URL = file.toURI().toString();

		Media media = new Media(MEDIA_URL);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		Group root = new Group();
		root.getChildren().add(mediaView);
		Scene scene = new Scene(root, 854, 480);
		mystery.setScene(scene);
		mystery.setTitle("CATS");

		mystery.show();

	}

}
