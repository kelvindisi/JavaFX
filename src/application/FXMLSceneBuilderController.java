package application;

import javafx.fxml.FXML;

public class FXMLSceneBuilderController {
	@FXML
	public void btnLoginClick() {
		AlertBox.display("Login", "You have been logged in");
	}
}
