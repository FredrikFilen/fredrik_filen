package uppgift_3_new;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

public class SampleController {
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
	private TextField timeDisplay;

	@FXML
	private TableView tableView;

	@FXML
	private TableColumn<DateAndTime, String> dateColumn;

	@FXML
	private TableColumn<DateAndTime, String> timeColumn;

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

	public String printDateTime() {
		LocalDateTime localDate = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String myDateTime = localDate.format(format);
		return myDateTime;

	}

	public String printTime(String text1) {
		String timeToSave = text1;
		return timeToSave;

	}

	public void saveTimeAndDate() {
		dateColumn.setCellValueFactory((new PropertyValueFactory<>("dateTime")));
		timeColumn.setCellValueFactory((new PropertyValueFactory<>("time")));

		dateColumn.setCellFactory(value);

	}

}
