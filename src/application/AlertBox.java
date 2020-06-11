package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
	private static Button btn;
	
	public static void display(String title, String description) {
		Stage alertStage = new Stage();
		alertStage.setTitle(title);
		alertStage.initModality(Modality.APPLICATION_MODAL);
		
		VBox layout = new VBox(10);
		
		Label label = new Label();
		label.setText(description);
		
		btn = new Button("Close Me!");
		btn.setOnAction(e -> {
			alertStage.close();
		});
		
		layout.getChildren().addAll(label, btn);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 300, 70);
		
		alertStage.setScene(scene);
		alertStage.setResizable(false);
		alertStage.showAndWait();
		
	}
}
