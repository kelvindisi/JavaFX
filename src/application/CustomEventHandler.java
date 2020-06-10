package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.*;

public class CustomEventHandler extends Application implements EventHandler<ActionEvent>{
	private Button btn;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("JavaFx");
		StackPane layout = new StackPane();
		btn = new Button("Click Me!");
		btn.setOnAction(this);
		layout.getChildren().add(btn);
		Scene scene = new Scene(layout, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == btn) {
			System.out.println("Clicked Me");
		}
	}

}
