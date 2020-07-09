package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CompoundSavings1 {

    public void fCal()throws Exception{
        Stage secondStage = new Stage();

        secondStage.setTitle("Compound Savings(without regular contributions)");
        TabPane root2 = new TabPane();
//Tab1 starts here(Interest rate)
        Tab tab1 = new Tab("Interest rate");
        AnchorPane aPane = new AnchorPane();

        Label lb1 = new Label("Time in years: ");
        lb1.setLayoutX(50);
        lb1.setLayoutY(30);

        TextField tf1 = new TextField();
        tf1.setLayoutX(200);
        tf1.setLayoutY(30);

        Label lb2 = new Label("Present value: ");
        lb2.setLayoutX(50);
        lb2.setLayoutY(70);

        TextField tf2 = new TextField();
        tf2.setLayoutX(200);
        tf2.setLayoutY(70);
//Payment
//        Label lb3 = new Label("Payment: ");
//        lb3.setLayoutX(50);
//        lb3.setLayoutY(110);
//
//        TextField tf3 = new TextField();
//        tf3.setLayoutX(200);
//        tf3.setLayoutY(110);

        Label lb4 = new Label("Future value: ");
        lb4.setLayoutX(50);
        lb4.setLayoutY(110);

        TextField tf4 = new TextField();
        tf4.setLayoutX(200);
        tf4.setLayoutY(110);

        Label lb5 = new Label("Number of\ncompound payments\nper year: ");
        lb5.setLayoutX(50);
        lb5.setLayoutY(150);

        TextField tf5 = new TextField();
        tf5.setLayoutX(200);
        tf5.setLayoutY(150);
//radio button
//        Label lb6 = new Label("Payment due at the ");
//        lb6.setLayoutX(50);
//        lb6.setLayoutY(270);
//
//        RadioButton radBtn1 = new RadioButton();
//        radBtn1.setLayoutX(170);
//        radBtn1.setLayoutY(270);
//
//        Label lb7 = new Label("beginning ");
//        lb7.setLayoutX(200);
//        lb7.setLayoutY(270);
//
//        RadioButton radBtn2 = new RadioButton();
//        radBtn2.setLayoutX(260);
//        radBtn2.setLayoutY(270);
//
//        Label lb8 = new Label("end");
//        lb8.setLayoutX(280);
//        lb8.setLayoutY(270);
//
//        Label lb9 = new Label("of each period ");
//        lb9.setLayoutX(200);
//        lb9.setLayoutY(290);
//
        Button btnCal = new Button("Calculate");
        btnCal.setLayoutX(160);
        btnCal.setLayoutY(220);

        Label rlbl1 = new Label();
        rlbl1.setLayoutX(400);
        rlbl1.setLayoutY(30);

        btnCal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double intRate = interstRate(tf1, tf2, tf4, tf5);
                rlbl1.setText(String.valueOf(intRate));
            }
        });


//        Tab 2 Starts here (Final value)
        Tab tab2 = new Tab("Cars");
        Tab tab3 = new Tab("Boats");






        root2.getTabs().add(tab1);

        tab1.setContent(aPane);
        aPane.getChildren().add(lb1);
        aPane.getChildren().add(lb2);
//        aPane.getChildren().add(lb3);
        aPane.getChildren().add(lb4);
        aPane.getChildren().add(lb5);
//        aPane.getChildren().add(lb6);
//        aPane.getChildren().add(lb7);
//        aPane.getChildren().add(lb8);
//        aPane.getChildren().add(lb9);

        aPane.getChildren().add(tf1);
        aPane.getChildren().add(tf2);
//        aPane.getChildren().add(tf3);
        aPane.getChildren().add(tf4);
        aPane.getChildren().add(tf5);

//        aPane.getChildren().add(radBtn1);
//        aPane.getChildren().add(radBtn2);
        aPane.getChildren().add(btnCal);

        aPane.getChildren().add(rlbl1);

        root2.getTabs().add(tab2);
        root2.getTabs().add(tab3);

        secondStage.setScene(new Scene(root2,700,600));
        secondStage.show();
    }

    public double interstRate(TextField tf1, TextField tf2, TextField tf4, TextField tf5){
        double A = Double.parseDouble(tf4.getText());
        double P = Double.parseDouble(tf2.getText());
        double n = Double.parseDouble(tf5.getText());
        double t = Double.parseDouble(tf1.getText());

        double r = n * (Math.pow((A/P),(1/(n * t))) - 1);
        double roundedR = Math.round(r * 100)/100.0;
        return roundedR;
    }
}

