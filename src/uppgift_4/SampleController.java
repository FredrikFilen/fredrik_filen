package uppgift_4;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController implements Initializable {
	Person person = new Person();

	@FXML
	private TextField firstNameTextField;

	@FXML
	private TextField lastNameTextField;

	@FXML
	private TextField ageTextField;

	@FXML
	private Label firstNameLabel;

	@FXML
	private Label ageLabel;

	@FXML
	private Button updateButton;

	@FXML
	private Button addButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Button saveButton;

	@FXML
	private TableView<Person> tableView;

	@FXML
	private TableColumn<Person, String> firstNameColumn;

	@FXML
	private TableColumn<Person, String> lastNameColumn;

	@FXML
	private TableColumn<Person, String> ageColumn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

		// tableView.setItems(personInfo);

	}

	public static ObservableList<Person> listForTable = FXCollections.observableArrayList();
	List<Person> personList = new ArrayList<>();

	@FXML
	void pressAddButton(ActionEvent event) {
		// personInfo.add(new Person(firstNameTextField.getText(),
		// lastNameTextField.getText(), ageTextField.getText()));
		person = new Person();
		person.setFirstName(firstNameTextField.getText());
		person.setLastName(lastNameTextField.getText());
		person.setAge(ageTextField.getText());
		tableView.getItems().add(person);

		listForTable.add(person);
		personList.add(person);

	}

	@FXML
	void pressDeleteButton(ActionEvent event) {

	}

	@FXML
	void pressUpdateButton(ActionEvent event) {

	}

	@FXML
	void pressSaveButton(ActionEvent event) {
		writeToXML(personList);
	}

	public static void writeToXML(List list) {
		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("person.xml")));
		} catch (FileNotFoundException fileNotFound) {
			System.out.println("Error: while creating or openeing the file person.xml");
		}

		encoder.writeObject(list);
		System.out.println("Write done(hopefully)");
		encoder.close();
	}

	public static void readFromXML() {
		XMLDecoder decoder = null;
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("person.xml")));
		} catch (FileNotFoundException e) {

		}
	}

}
