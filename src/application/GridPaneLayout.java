package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class GridPaneLayout extends Application {
	Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Login Form");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		// user_name
		Label usernameLabel = new Label("Username:");
		GridPane.setConstraints(usernameLabel, 0, 0);
//			INLINE STYLING
//		 usernameLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bolder;");
		TextField txtUsername = new TextField();
		txtUsername.setPromptText("johndoe");
		GridPane.setConstraints(txtUsername, 1, 0);
		
		grid.getChildren().addAll(usernameLabel, txtUsername);
		
		Label passwordLabel = new Label("Password:");
		GridPane.setConstraints(passwordLabel, 0, 1);
		PasswordField txtPassword = new PasswordField();
		txtPassword.setPromptText("MySecret");
		GridPane.setConstraints(txtPassword, 1, 1);
		
		grid.getChildren().addAll(passwordLabel, txtPassword);
		
		Button btnLogin = new Button("Login");
		GridPane.setConstraints(btnLogin, 1, 2);
		grid.getChildren().addAll(btnLogin);
		
		Button btnReset = new Button("Reset");
		btnReset.getStyleClass().add("button-blue");
		GridPane.setConstraints(btnReset, 2, 2);
		grid.getChildren().add(btnReset);
		
		
		btnLogin.setOnAction(e -> {
			setUserAgentStylesheet(STYLESHEET_CASPIAN);
		});
		
		btnReset.setOnAction(e -> {
			setUserAgentStylesheet(STYLESHEET_MODENA);
		});
		
		grid.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(grid, 400, 300);
		scene.getStylesheets().add("theme.css");
		window.setResizable(false);
		window.setScene(scene);
		
		window.show();
	}
}
