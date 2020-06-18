package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.collections.*;

public class TableDesign extends Application {
	Stage window;
	TableView<Person> table;
	
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Table Design");
		BorderPane layout = new BorderPane();
		
		// First Name Column
		TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
		firstNameCol.setMinWidth(250);
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
		table.setItems(getPeople());
		table.getColumns().addAll(firstNameCol, lastNameCol, salaryCol);
		
		layout.setCenter(table);
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		window.show();
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
