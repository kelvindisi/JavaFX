package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EventHandlerLambda extends Application {
	private Button btn;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("JavaFx");
		StackPane layout = new StackPane();
		btn = new Button("Click Me!");
		btn.setOnAction(event -> {
			System.out.println("Clicked me, through lambda expression");
		});
		layout.getChildren().add(btn);
		Scene scene = new Scene(layout, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

