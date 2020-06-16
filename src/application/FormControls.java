package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Insets;


public class FormControls extends Application {
	Stage window;
	
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
		
		// CheckBox
		CheckBox checkBox = new CheckBox("Subscribe Magazine");
		CheckBox checkBox2 = new CheckBox("Auto Save");
		checkBox2.setSelected(true);
		
		Button submitCheckBox = new Button("CheckBox Submit");
		GridPane.setConstraints(checkBox, 0, 0);
		GridPane.setConstraints(checkBox2, 1, 0);
		GridPane.setConstraints(submitCheckBox, 2, 0);
		
		submitCheckBox.setOnAction(e -> handleCheckBox(checkBox, checkBox2));
		
		grid.getChildren().addAll(checkBox, checkBox2, submitCheckBox);
		
		
		Scene scene = new Scene(grid, 500, 600);
		
		window.setScene(scene);
		window.show();
	}
	
	// checkBox submit handling
	public void handleCheckBox(CheckBox box1, CheckBox box2) {
		String statem = "";
		if (box1.isSelected() && box2.isSelected())
			statem = "Subscribed Magazine and Enabled Auto Save";
		else if (box1.isSelected())
			statem = "Subscribed Magazine";
		else if (box2.isSelected())
			statem = "Enabled auto-save";
		else
			statem = "You have not selected any item";
		
		AlertBox.display("CheckBox Selection", statem);
	}

}
