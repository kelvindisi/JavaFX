package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
	private static Stage alertStage;
	private static boolean result;
	
	public static boolean display(String title, String description) {
		alertStage = new Stage();
		alertStage.setTitle(title);
		alertStage.initModality(Modality.APPLICATION_MODAL);
		
		VBox layout = new VBox(10);
		HBox btnLayout = new HBox(10);
		
		Label label = new Label();
		label.setText(description);
		
		Button btnYes = new Button("Yes Continue!");
		Button btnNo = new Button("Don't do that!");
		btnYes.setOnAction(e ->  {
			result = true;
			closeMe();
		});
		btnNo.setOnAction(e -> {
			result = false;
			closeMe();
		});
		
		btnLayout.getChildren().addAll(btnYes, btnNo);
		btnLayout.setAlignment(Pos.CENTER);
		
		layout.getChildren().addAll(label, btnLayout);
		
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 300, 70);
		
		alertStage.setScene(scene);
		alertStage.setResizable(false);
		alertStage.showAndWait();
		
		return result;
	}
	
	private static void closeMe() {
		alertStage.close();
	}
}
