package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;

public class EmbendingLayout extends Application {
	Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Login Form");
		
		BorderPane layout = new BorderPane();
		
		HBox hLayout = new HBox();
		hLayout.getChildren().addAll(
				new Button("Home"),
				new Button("Settings"),
				new Button("Logout")
		);
		
		VBox vLayout = new VBox();
		vLayout.getChildren().addAll(
				new Button("C://"),
				new Button("D://")
		);
		
		layout.setTop(hLayout);
		layout.setRight(vLayout);
		
		Scene scene = new Scene(layout, 400, 500);
		
		window.setResizable(false);
		window.setScene(scene);
		
		window.show();
	}
}
