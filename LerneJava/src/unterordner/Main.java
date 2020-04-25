package unterordner;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		System.out.println("Vor Launch");
		launch(args);
		System.out.println("Nach Launch");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Start Methode");
	}
	
	@Override
	public void init() throws Exception {
		System.out.println("Init Methode");
	}
	@Override
	public void stop() throws Exception {
		System.out.println("Stop Methode");
	}
}
