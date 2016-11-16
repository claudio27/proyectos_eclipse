package aplicacion;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Group root = new Group();
			
			Label label = new Label("Hola Mundo!"); 
			root.getChildren().add(label);
			
			Scene scene = new Scene(root, 200, 200);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
