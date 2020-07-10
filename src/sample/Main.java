package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        CompoundSavings1 fc = new CompoundSavings1();
        CompoundSavings2 fc2 = new CompoundSavings2();
        HelpView helpV = new HelpView();

        primaryStage.setTitle("Home");

        Button btn1 = new Button("Compound Savings (without regular contributions)");
        btn1.setLayoutX(250);
        btn1.setLayoutY(100);

        Button btn4 = new Button("Compound Savings (with regular contributions)");
        btn4.setLayoutX(250);
        btn4.setLayoutY(200);

        Button btn2 = new Button("Mortgage Calculator");
        btn2.setLayoutX(250);
        btn2.setLayoutY(300);

        Button btn3 = new Button("Auto Loan Calculator");
        btn3.setLayoutX(250);
        btn3.setLayoutY(400);

        Button btn5 = new Button("--> Help <--");
        btn5.setLayoutX(250);
        btn5.setLayoutY(500);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) btn1.getScene().getWindow();
                stage.close();
                try {
                    fc.fCal();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) btn4.getScene().getWindow();
                stage.close();
                try {
                    fc2.fCal2();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) btn5.getScene().getWindow();
                stage.close();
                try {
                    helpV.help();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Pane root= new Pane();
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        root.getChildren().add(btn5);

        primaryStage.setScene(new Scene(root, 700, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
