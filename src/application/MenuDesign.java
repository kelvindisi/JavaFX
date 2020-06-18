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
		
		// CheckMenuItem
		Menu settings = new Menu("Settings");
		CheckMenuItem autoSave = new CheckMenuItem("Auto Save");
		settings.getItems().add(autoSave);
		autoSave.setOnAction(e -> {
			if (autoSave.isSelected())
				System.out.println("Auto save enabled");
			else
				System.out.println("Disabled auto save");
		});
		
		menu.getMenus().add(settings);
		
		// RadioMenuItem
		Menu difficulty = new Menu("Difficulty");
		ToggleGroup levelGroup = new ToggleGroup();
		RadioMenuItem easy = new RadioMenuItem("Easy");
		RadioMenuItem medium = new RadioMenuItem("Medium");
		RadioMenuItem hard = new RadioMenuItem("Hard");
		
		easy.setToggleGroup(levelGroup);
		medium.setToggleGroup(levelGroup);
		hard.setToggleGroup(levelGroup);
		medium.setSelected(true);
		
		difficulty.getItems().addAll(easy, medium, hard);
		
		menu.getMenus().add(difficulty);
		
		topLayout.getChildren().addAll(menu);
		
		layout.setTop(topLayout);
		
		window.setScene(new Scene(layout, 500, 400));		
		window.show();
	}
}
