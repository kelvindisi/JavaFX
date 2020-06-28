package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
//import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class FXMLScenerBuilder extends Application {
	private Stage window;
	
	public static void main(String[] args) {
		try {
			launch(args);
		} catch(Exception ex) {
			AlertBox.display("Error", ex.getMessage());
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("The application");
		
		Parent root = FXMLLoader.load(getClass().getResource("FXMLSceneBuilder.fxml"));
		window.setScene(new Scene(root));
//		window.setResizable(false);
		window.show();
	}
}
