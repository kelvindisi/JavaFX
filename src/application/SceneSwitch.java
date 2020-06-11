package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class SceneSwitch extends Application{
	private Scene scene, scene2;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage window) {
		window.setTitle("My window application");
		StackPane layout = new StackPane();
		VBox layout2 = new VBox(10);
		
		Button btn = new Button("Go to scene two");
		Button btn2 = new Button("Go to scene one");
		Label label = new Label("Welcome to the most designed scene");
		Label label2 = new Label("Welcome to second Scene");
		
		btn.setOnAction(e -> window.setScene(scene2));
		btn2.setOnAction(e -> window.setScene(scene));
		
		
		layout.getChildren().addAll(label, btn);
		layout2.getChildren().addAll(label2, btn2);
		
		scene = new Scene(layout, 400, 400);
		scene2 = new Scene(layout2, 400, 400);
		
		window.setScene(scene2);
		window.show();
	}

}

