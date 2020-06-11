package application;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.application.Application;

public class AlertParent extends Application {
	private Button btn;
	
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
		StackPane layout = new StackPane();
		
		btn = new Button("Show Alert");
		btn.setOnAction(e -> {
			AlertBox.display("Successfull", "You have successfully triggered alert");
		});
		
		layout.getChildren().add(btn);
		Scene scene = new Scene(layout, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
