package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage arg0) {
		try {
		Parent rootFXML = FXMLLoader.load(getClass().getResource("Application.fxml"));
		Scene sceneFXML = new Scene(rootFXML);
		
		arg0.setTitle("Reality Tips");
		arg0.setScene(sceneFXML);
		arg0.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
