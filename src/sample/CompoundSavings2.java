package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CompoundSavings2 {
    public void fCal2()throws Exception{
        Stage thirdStage = new Stage();

        thirdStage.setTitle("Compound Savings(with regular contributions)");

        Main homepg = new Main();
        Stage mainStage = new Stage();

        TabPane root3 = new TabPane();

        //Tab1 starts here(Interest rate)
        Tab tab1 = new Tab("Future value");
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
        Label lb3 = new Label("Payment: ");
        lb3.setLayoutX(50);
        lb3.setLayoutY(210);

        TextField tf3 = new TextField();
        tf3.setLayoutX(200);
        tf3.setLayoutY(210);

        Label lb4 = new Label("Interest rate(annual): ");
        lb4.setLayoutX(50);
        lb4.setLayoutY(110);

        TextField tf4 = new TextField();
        tf4.setLayoutX(200);
        tf4.setLayoutY(110);
        tf4.setPromptText("\t\t\t\t\t\t%");

        Label lb5 = new Label("Number of\ncompound payments\nper year: ");
        lb5.setLayoutX(50);
        lb5.setLayoutY(150);

        TextField tf5 = new TextField();
        tf5.setLayoutX(200);
        tf5.setLayoutY(150);

        //radio button
        Label lb6 = new Label("Payment due at the ");
        lb6.setLayoutX(50);
        lb6.setLayoutY(270);

        RadioButton radBtn1 = new RadioButton();
        radBtn1.setLayoutX(170);
        radBtn1.setLayoutY(270);

        Label lb7 = new Label("beginning ");
        lb7.setLayoutX(200);
        lb7.setLayoutY(270);

        RadioButton radBtn2 = new RadioButton();
        radBtn2.setLayoutX(260);
        radBtn2.setLayoutY(270);
        radBtn2.setSelected(true);

        Label lb8 = new Label("end");
        lb8.setLayoutX(280);
        lb8.setLayoutY(270);

        Label lb9 = new Label("of each period ");
        lb9.setLayoutX(200);
        lb9.setLayoutY(290);

        Button btnCal = new Button("Calculate");
        btnCal.setLayoutX(160);
        btnCal.setLayoutY(370);

        Label rlbl1 = new Label();
        rlbl1.setLayoutX(400);
        rlbl1.setLayoutY(30);

        Label erLbl = new Label();
        erLbl.setLayoutX(160);
        erLbl.setLayoutY(330);
        erLbl.setTextFill(Color.web("#f2051e"));

        //    Home button

        Button homebtn = new Button("Home");
        homebtn.setLayoutX(250);
        homebtn.setLayoutY(370);

        homebtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) homebtn.getScene().getWindow();
                stage.close();
                try {
                    homepg.start(mainStage);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        btnCal.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            erLbl.setText("");
            double fVal = futureValue(tf1, tf2,tf3, tf4, tf5, erLbl,radBtn1, radBtn2);
            rlbl1.setText(String.valueOf("Future Value:   "+fVal+" %"));
        }
    });

        root3.getTabs().add(tab1);

        tab1.setContent(aPane);
        aPane.getChildren().add(lb1);
        aPane.getChildren().add(lb2);
        aPane.getChildren().add(lb3);
        aPane.getChildren().add(lb4);
        aPane.getChildren().add(lb5);
        aPane.getChildren().add(lb6);
        aPane.getChildren().add(lb7);
        aPane.getChildren().add(lb8);
        aPane.getChildren().add(lb9);

        aPane.getChildren().add(tf1);
        aPane.getChildren().add(tf2);
        aPane.getChildren().add(tf3);
        aPane.getChildren().add(tf4);
        aPane.getChildren().add(tf5);

        aPane.getChildren().add(btnCal);
        aPane.getChildren().add(radBtn1);
        aPane.getChildren().add(radBtn2);
        aPane.getChildren().add(rlbl1);
        aPane.getChildren().add(erLbl);
        aPane.getChildren().add(homebtn);

        Scene scene = new Scene(root3,700,600);
        thirdStage.setScene(scene);
        thirdStage.show();
    }

    public double futureValue(TextField tf1, TextField tf2,TextField tf3, TextField tf4, TextField tf5, Label erLbl,RadioButton radbtn1,RadioButton radbtn2) {

            try {
                if (radbtn2.equals(true)) {
                double r = Double.parseDouble(tf4.getText());
                double P = Double.parseDouble(tf2.getText());
                double n = Double.parseDouble(tf5.getText());
                double t = Double.parseDouble(tf1.getText());
                double PMT = Double.parseDouble(tf5.getText());

                double A = (P * (Math.pow((1 + (r / n)), (n * t)))) + (PMT * ((Math.pow((1 + (r / n)), (n * t)) - 1) / (r / n)));
                double roundedA = Math.round(A * 100) / 100.0;
                return roundedA;

                }else erLbl.setText("Unsuccessful");
                return 0.0;

            } catch (Exception ex) {
                erLbl.setText("Invalid Details");
            }
            return 0.0;
    }
}
