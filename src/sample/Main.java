package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        CompoundSavings1 fc = new CompoundSavings1();
        CompoundSavings2 fc2 = new CompoundSavings2();
        MortgageCal mortCal = new MortgageCal();
        AutoLoanCal aLCal = new AutoLoanCal();
        HelpView helpV = new HelpView();

        primaryStage.setTitle("Home");

        Button btn1 = new Button("Compound Savings (without regular contributions)");
        btn1.setLayoutX(200);
        btn1.setLayoutY(150);
        btn1.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        Button btn4 = new Button("Compound Savings (with regular contributions)");
        btn4.setLayoutX(200);
        btn4.setLayoutY(200);
        btn4.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        Button btn2 = new Button("Mortgage Calculator");
        btn2.setLayoutX(270);
        btn2.setLayoutY(250);
        btn2.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        Button btn3 = new Button("Auto Loan Calculator");
        btn3.setLayoutX(270);
        btn3.setLayoutY(300);
        btn3.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        Button btn5 = new Button("--> Help <--");
        btn5.setLayoutX(290);
        btn5.setLayoutY(350);
        btn5.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        Label mLbl = new Label("Calculator Home");
        mLbl.setLayoutX(170);
        mLbl.setLayoutY(5);
        mLbl.setMinSize(580,100);
        mLbl.setTextFill(Color.web("#0a0a0a"));
        mLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 40));

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

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) btn2.getScene().getWindow();
                stage.close();
                try {
                    mortCal.mCal();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) btn3.getScene().getWindow();
                stage.close();
                try {
                    aLCal.lCal();
                } catch (Exception e) {
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

        FileInputStream input = new FileInputStream("Images/Cal.jpg");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(600);
        imageView.setFitWidth(700);
        imageView.setLayoutX(0);
        imageView.setLayoutY(0);


        Pane root= new Pane();
        root.getChildren().add(imageView);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        root.getChildren().add(btn5);
        root.getChildren().add(mLbl);


        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 700, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
