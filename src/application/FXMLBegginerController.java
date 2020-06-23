package application;

import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class FXMLBegginerController implements Initializable {
	public Button button;
	
	public void handleButtonClick()
	{
		button.setText("Ouch! Why did you click me?");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		button.setText("Text set on initializer");		
	}
}
