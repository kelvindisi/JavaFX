package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CloseProgram extends Application {
	private Button btn;
	private static Stage window;
	
	public static void main(String[] args) {
		launch(args);		
	}
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Main Application");
		
		StackPane layout = new StackPane();
		btn = new Button("Close Program");
		btn.setOnAction(e -> closeConfirm());
		
		layout.getChildren().add(btn);
		Scene scene = new Scene(layout, 300, 200);
		
		window.setOnCloseRequest(e -> {
			e.consume();
			closeConfirm();
		});
		window.setScene(scene);
		window.show();
	}
	
	public static void closeConfirm() {
		boolean confirmClose = ConfirmBox.display("Close", "Are you sure you want to close? ");
		if (confirmClose)
			window.close();
	}
}

