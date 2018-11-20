package scraping;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
			//this starts the original scene
			// ----------- done ----------
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.setX(500);
	        primaryStage.setY(50);
	        primaryStage.show();
	}
	
	public static void main(String[] args) throws IOException {
		launch(args);
	}
}
