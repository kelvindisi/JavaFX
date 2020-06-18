package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class MenuDesign extends Application {
	Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Design Menu");
		
		BorderPane layout = new BorderPane();
		StackPane topLayout = new StackPane();
		
		MenuBar menu = new MenuBar();
		// File Menu
		Menu fileMenu = new Menu("_File");
		
		MenuItem newFile = new MenuItem("New File");
		MenuItem open_file = new MenuItem("Open File...");
		SeparatorMenuItem separator = new SeparatorMenuItem();
		MenuItem save = new MenuItem("Save");
		MenuItem save_as = new MenuItem("Save As...");
		
		fileMenu.getItems().addAll(newFile, open_file, separator, save, save_as);
		menu.getMenus().addAll(fileMenu);
		
		topLayout.getChildren().addAll(menu);
		
		layout.setTop(topLayout);
		
		window.setScene(new Scene(layout, 500, 400));		
		window.show();
	}
}
