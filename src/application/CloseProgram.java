package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CloseProgram extends Application {
	private Button btn;
	
	public static void main(String[] args) {
		launch(args);		
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Main Application");
		
		StackPane layout = new StackPane();
		btn = new Button("Close");
		
		layout.getChildren().add(btn);
		Scene scene = new Scene(layout, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

