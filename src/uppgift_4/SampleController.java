package uppgift_4;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
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
	private Label lastNameLabel;

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
	private Button saveChanges;

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

		readFromXML();
	}

	public static ObservableList<Person> listForTable = FXCollections.observableArrayList();
	static List<Person> personList = new ArrayList<>();

	@FXML
	void pressAddButton(ActionEvent event) {
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
		Person personSelected = (Person) tableView.getSelectionModel().getSelectedItems().get(0);

		tableView.getItems().remove(personSelected);
		personList.remove(personSelected);

		writeToXML(personList);
	}

	@FXML
	void pressUpdateButton(ActionEvent event) {
		saveChanges.setDisable(false);

		Person personSelected = (Person) tableView.getSelectionModel().getSelectedItem();

		firstNameTextField.setText(personSelected.getFirstName());
		lastNameTextField.setText(personSelected.getLastName());
		ageTextField.setText(personSelected.getAge());
	}

	@FXML
	void pressSaveChangesButton(ActionEvent event) {

		Person personSelected = (Person) tableView.getSelectionModel().getSelectedItem();
		personSelected.setFirstName(firstNameTextField.getText());
		personSelected.setLastName(lastNameTextField.getText());
		personSelected.setAge(ageTextField.getText());

		tableView.refresh();
	}

	@FXML
	void pressSaveButton(ActionEvent event) {
		writeToXML(personList);
	}

	public static void writeToXML(List<Person> personList) {
		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(new FileOutputStream((new File("./src/uppgift_4/Assets/person.xml"))));
		} catch (FileNotFoundException fileNotFound) {
			System.out.println("Error: while creating or openeing the file person.xml");
		}

		encoder.writeObject(personList);
		System.out.println("Write done(hopefully)");

		encoder.close();
	}

	public void readFromXML() {
		XMLDecoder decoder = null;
		try {
			decoder = new XMLDecoder(new FileInputStream((new File("./src/uppgift_4/Assets/person.xml"))));
			System.out.println("File stream opened and XMLDecoder created");

			personList = (List<Person>) decoder.readObject();

			for (int i = 0; i < personList.size(); i++) {
				tableView.getItems().add(personList.get(i));
			}

			System.out.println("Read successful from person.xml (I think)");

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File person.xml not found");

		} finally {
			if (decoder != null) {
				decoder.close();
				System.out.println("decoder closed");
			}

		}

	}

}
