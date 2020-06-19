package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.collections.*;
import javafx.geometry.Insets;

public class TableDesign extends Application {
	Stage window;
	TableView<Person> table;
	
	TextField txtFirstName;
	TextField txtLastName;
	TextField txtSalary;
	
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Table Design");
		BorderPane layout = new BorderPane();
		
		// Input Table
		txtFirstName = new TextField();
		txtFirstName.setPromptText("First name");
		
		txtLastName = new TextField();
		txtLastName.setPromptText("Last Name");
		
		txtSalary = new TextField();
		txtSalary.setPromptText("Salary");
		
		Button btnAdd = new Button("Add");
		Button btnDelete = new Button("Delete");
		
		// Handle Add event
		btnAdd.setOnAction(e -> addNewItem());
		btnDelete.setOnAction(e -> deleteItems());
		
		HBox formLayout = new HBox(5);
		formLayout.setPadding(new Insets(10, 10, 10, 10));
		formLayout.getChildren().addAll(txtFirstName, txtLastName, txtSalary, btnAdd, btnDelete);
		
		
		// First Name Column
		TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
		firstNameCol.setMinWidth(250);
		firstNameCol.setEditable(true);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		
		// Last Name Column
		TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
		lastNameCol.setMinWidth(250);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		
		// Last Name Column
		TableColumn<Person, Double> salaryCol = new TableColumn<>("Salary");
		salaryCol.setMinWidth(200);
		salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
		
		// Add Columns
		table = new TableView<>();
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		table.setItems(getPeople());
		table.getColumns().addAll(firstNameCol, lastNameCol, salaryCol);
		
		layout.setCenter(table);
		layout.setBottom(formLayout);
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		window.show();
	}
	
	// Add new Item
	private void addNewItem() {
		Person newPerson = new Person();
		newPerson.setFirstName(txtFirstName.getText());
		newPerson.setLastName(txtLastName.getText());
		newPerson.setSalary(Double.parseDouble(txtSalary.getText()));
		
		table.getItems().add(newPerson);
		clearForm();
	}
	
	// Delete Selected items
	private void deleteItems() {
		ObservableList<Person> selectedItems, allItems;
		
		allItems = table.getItems();
		selectedItems = table.getSelectionModel().getSelectedItems();
		
		selectedItems.forEach(allItems::remove);
	}
	
	private void clearForm() {
		txtFirstName.clear();
		txtLastName.clear();
		txtSalary.clear();
	}
	private ObservableList<Person> getPeople() {
		ObservableList<Person> people = FXCollections.observableArrayList();
		
		people.add(new Person("Kelvin Ndisi", "Wambua", 230_456.00));
		people.add(new Person("Angela Mwende", "Jones", 460_000.00));
		people.add(new Person("Victore James", "Vincent", 80_000.00));
		people.add(new Person("Eunice Kanono", "Wambua", 110_345.00));
		people.add(new Person("Mathew James", "Mulwa", 23_345.00));
		people.add(new Person("Abigael Wavinya", "Ngungi", 224_323.00));
		
		return people;
	}

}
