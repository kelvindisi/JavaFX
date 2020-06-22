package application;

import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.beans.property.*;

public class PropertyBindingProgram extends Application {
	Label fullNameLabel;
	TextField firstName;
	TextField lastName;
	
	public static void main(String[] args) {
		try {
			launch(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Main Window");
		HBox inputLayout = new HBox(10);
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(10, 10, 10, 10));
		
		StringProperty message = new SimpleStringProperty("Name: ");
		fullNameLabel = new Label();
		
		firstName = new TextField();
		firstName.setPromptText("First name");
		
		lastName = new TextField();
		lastName.setPromptText("Last name");
		
		fullNameLabel.textProperty().bind(
				message.concat(firstName.textProperty()
						.concat(" ")
						.concat(lastName.textProperty())
		));
		
		inputLayout.getChildren().addAll(firstName, lastName);
		layout.getChildren().addAll(inputLayout, fullNameLabel);
		
		Scene scene = new Scene(layout, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
