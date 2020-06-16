package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Insets;


public class FormControls extends Application {
	Stage window;
	
	ListView<String> listView;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Windows");
		
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		// CheckBox row - 0
		CheckBox checkBox = new CheckBox("Subscribe Magazine");
		CheckBox checkBox2 = new CheckBox("Auto Save");
		checkBox2.setSelected(true);
		
		Button submitCheckBox = new Button("CheckBox Submit");
		GridPane.setConstraints(checkBox, 0, 0);
		GridPane.setConstraints(checkBox2, 1, 0);
		GridPane.setConstraints(submitCheckBox, 2, 0);
		
		submitCheckBox.setOnAction(e -> handleCheckBox(checkBox, checkBox2));
		
		grid.getChildren().addAll(checkBox, checkBox2, submitCheckBox);
		
		// ChoiceBox List row - 1
		Label choiceLabel = new Label("ChoiceBox");
		ChoiceBox<String> choice = new ChoiceBox<>();
		choice.getItems().addAll("Extra Small", "Small", "Medium", "Large", "Extra Large", "XXL");
		choice.setValue("Extra Small");
		GridPane.setConstraints(choiceLabel, 0, 1);
		GridPane.setConstraints(choice, 1, 1);
		
		choice.getSelectionModel().selectedItemProperty()
			.addListener((p, oldVal, newVal)-> {
				AlertBox.display("Choce Selection", String.format("Old: %s New: %s", oldVal, newVal));
			});
		
		grid.getChildren().addAll(choiceLabel, choice);
		
		// ComboBox row - 2
		Label comboLabel = new Label("ComboBox");
		GridPane.setConstraints(comboLabel, 0, 2);
		ComboBox<String> comboBox = new ComboBox<>();
		comboBox.getItems().addAll("Farmer", "Student", "Teacher", "Lecture", "Engineer", "Police");
		comboBox.setEditable(true);
		comboBox.setVisibleRowCount(4);
		comboBox.setOnAction(e -> {
			AlertBox.display("ComboBox Value", comboBox.getValue());
		});
		GridPane.setConstraints(comboBox, 1, 2);
		grid.getChildren().addAll(comboLabel, comboBox);
		
		// ListView row - 3
		String[] shop = new String[] {"Colgate", "Close-Up", "Sensodine", "White..x", "Sugar", "Bread", "Soda"};
		listView = new ListView<>();
		listView.setMaxHeight(180);
		listView.getItems().addAll(shop);
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		Button btnShop = new Button("Purchase");
		GridPane.setConstraints(btnShop, 1, 3);
		btnShop.setOnAction(e -> displayShoppingList());
		
		GridPane.setConstraints(listView, 0, 3);
		grid.getChildren().addAll(listView, btnShop);
	
		
		Scene scene = new Scene(grid, 500, 600);
		
		window.setScene(scene);
		window.show();
	}
	
	// checkBox submit handling
	public void handleCheckBox(CheckBox box1, CheckBox box2) {
		String statem = "";
		
		if (box1.isSelected())
			statem += " Subscribed Magazine";
		if (box2.isSelected())
			statem += " Enabled auto-save";
		if (!box1.isSelected() && !box2.isSelected())
			statem = "You have not selected any item";
		
		AlertBox.display("CheckBox Selection", statem.trim());
	}
	
	// List View handling
	public void displayShoppingList() {
		String msg = "";
		
		ObservableList<String> shopList = listView.getSelectionModel().getSelectedItems();
		for (String item: shopList) {
			msg += item + " ";
		}
		
		AlertBox.display("List View Items Selected", msg.trim());
	}

}
