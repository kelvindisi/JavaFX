package application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class FXMLBeginner extends Application {
	
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
		Parent root = FXMLLoader.load(getClass().getResource("FXMLBegginer.fxml"));
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
