package unterordner;


import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;



public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			VBox root = new VBox();
			Scene scene = new Scene(root,400,300);
			
			String[] answerQ1 = {"Was ist die Hauptstadt von Frankreich?","Berlin","Stuttgart","Paris","Paris"};
			String[] answerQ2 = {"Welches Betriebssystem stammt von Apple?","Windows","iOS","Linux","iOS"};
			String[] answerQ3 = {"In welchem Jahr wurde der Euro als Bargeld eingeführt?","1990","2001","2002","2002"};
			
			ToggleGroup q1 = addQuestion(root,answerQ1[0],answerQ1[1],answerQ1[2],answerQ1[3]);
			ToggleGroup q2 = addQuestion(root,answerQ2[0],answerQ2[1],answerQ2[2],answerQ2[3]);
			ToggleGroup q3 = addQuestion(root,answerQ3[0],answerQ3[1],answerQ3[2],answerQ3[3]);
			
			Label endLabel = new Label();
			Button sendButton = new Button("Absenden");
			sendButton.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent arg0) {
					if(getAnswer(q1).equals(answerQ1[4]) && getAnswer(q2).equals(answerQ2[4]) && getAnswer(q3).equals(answerQ3[4])) {
						endLabel.setText("Du hast gewonnen!");
					}else {
						endLabel.setText("Du hast verloren!");
					}
				}
			});
			
			root.getChildren().addAll(sendButton,endLabel);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("-");
			
			primaryStage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void init() throws Exception {
		
	}
	@Override
	public void stop() throws Exception {
		
	}
	public ToggleGroup addQuestion(VBox ShowOn,String question,String answer1,String answer2,String answer3) {
		Label frage = new Label(question);
		
		ToggleGroup tgroup = new ToggleGroup();
		RadioButton rb1 = new RadioButton(answer1);
		RadioButton rb2 = new RadioButton(answer2);
		RadioButton rb3 = new RadioButton(answer3);
		rb1.setToggleGroup(tgroup);
		rb2.setToggleGroup(tgroup);
		rb3.setToggleGroup(tgroup);
		ShowOn.getChildren().addAll(frage,rb1,rb2,rb3);
		return tgroup;
	}
	public String getAnswer(ToggleGroup group) {
		RadioButton rb = (RadioButton)group.getSelectedToggle();
		return rb.getText();
	}
}
