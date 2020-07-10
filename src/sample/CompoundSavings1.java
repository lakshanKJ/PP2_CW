package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CompoundSavings1 {

    public void fCal()throws Exception{
        Stage secondStage = new Stage();

        secondStage.setTitle("Compound Savings(without regular contributions)");

        Main homepg = new Main();
        Stage mainStage = new Stage();

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

        Button btnCal = new Button("Calculate");
        btnCal.setLayoutX(160);
        btnCal.setLayoutY(300);

        Label rlbl1 = new Label();
        rlbl1.setLayoutX(400);
        rlbl1.setLayoutY(30);

        Label erLbl = new Label();
        erLbl.setLayoutX(160);
        erLbl.setLayoutY(220);
        erLbl.setTextFill(Color.web("#f2051e"));

        //    Home button

        Button homebtn = new Button("Home");
        homebtn.setLayoutX(250);
        homebtn.setLayoutY(300);


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
//            if (scene.focusOwnerProperty().get() instanceof TextArea) {
//                TextArea focusedTextArea = (TextArea) scene.focusOwnerProperty().get();
//            }
            @Override
            public void handle(ActionEvent event) {
                erLbl.setText("");
                double intRate = interstRate(tf1, tf2, tf4, tf5, erLbl);
                rlbl1.setText(String.valueOf("Interest rate(Annual):   "+intRate+" %"));
            }
        });

        //        Keyboard in tab1

        TextField typingtf = new TextField();
        typingtf.setLayoutX(130);
        typingtf.setLayoutY(450);
        typingtf.setPromptText("Type here");
        typingtf.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(3))));

        Button k0 = new Button("0");
        k0.setLayoutX(40);
        k0.setLayoutY(350);

        k0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                typingtf.setText("0");
            }
        });

        Button k1 = new Button("1");
        k1.setLayoutX(70);
        k1.setLayoutY(350);

        k1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                typingtf.setText("1");
            }
        });

        Button k2 = new Button("2");
        k2.setLayoutX(100);
        k2.setLayoutY(350);

        Button k3 = new Button("3");
        k3.setLayoutX(130);
        k3.setLayoutY(350);

        Button k4 = new Button("4");
        k4.setLayoutX(160);
        k4.setLayoutY(350);

        Button k5 = new Button("5");
        k5.setLayoutX(190);
        k5.setLayoutY(350);

        Button k6 = new Button("6");
        k6.setLayoutX(220);
        k6.setLayoutY(350);

        Button k7 = new Button("7");
        k7.setLayoutX(250);
        k7.setLayoutY(350);

        Button k8 = new Button("8");
        k8.setLayoutX(280);
        k8.setLayoutY(350);

        Button k9 = new Button("9");
        k9.setLayoutX(310);
        k9.setLayoutY(350);

        Button kDot = new Button(" .");
        kDot.setLayoutX(240);
        kDot.setLayoutY(390);

        Button kDel = new Button("delete");
        kDel.setLayoutX(280);
        kDel.setLayoutY(390);


        Button setBtn1 = new Button("Send this value to\n'Time in years'");
        setBtn1.setLayoutX(20);
        setBtn1.setLayoutY(500);

        Button setBtn2 = new Button("Send this value to\n'Present value'");
        setBtn2.setLayoutX(140);
        setBtn2.setLayoutY(500);

        Button setBtn4 = new Button("Send this value to\n'Future value'");
        setBtn4.setLayoutX(260);
        setBtn4.setLayoutY(500);

        Button setBtn5 = new Button("Send this value to\n'Number of compound\npayments per year'");
        setBtn5.setLayoutX(380);
        setBtn5.setLayoutY(500);

        root2.getTabs().add(tab1);

        tab1.setContent(aPane);
        aPane.getChildren().add(lb1);
        aPane.getChildren().add(lb2);
        aPane.getChildren().add(lb4);
        aPane.getChildren().add(lb5);

        aPane.getChildren().add(tf1);
        aPane.getChildren().add(tf2);
        aPane.getChildren().add(tf4);
        aPane.getChildren().add(tf5);

        aPane.getChildren().add(btnCal);
        aPane.getChildren().add(rlbl1);
        aPane.getChildren().add(erLbl);
        aPane.getChildren().add(homebtn);
//keyboard
        aPane.getChildren().add(k0);
        aPane.getChildren().add(k1);
        aPane.getChildren().add(k2);
        aPane.getChildren().add(k3);
        aPane.getChildren().add(k4);
        aPane.getChildren().add(k5);
        aPane.getChildren().add(k6);
        aPane.getChildren().add(k7);
        aPane.getChildren().add(k8);
        aPane.getChildren().add(k9);
        aPane.getChildren().add(kDot);
        aPane.getChildren().add(kDel);
        aPane.getChildren().add(typingtf);
        aPane.getChildren().add(setBtn1);
        aPane.getChildren().add(setBtn2);
        aPane.getChildren().add(setBtn4);
        aPane.getChildren().add(setBtn5);


//        Tab 2 Starts here (Final value)
        Tab tab2 = new Tab("Future value");

        AnchorPane t2aPane = new AnchorPane();

        Label t2lb1 = new Label("Time in years: ");
        t2lb1.setLayoutX(50);
        t2lb1.setLayoutY(30);

        TextField t2tf1 = new TextField();
        t2tf1.setLayoutX(200);
        t2tf1.setLayoutY(30);

        Label t2lb2 = new Label("Present value: ");
        t2lb2.setLayoutX(50);
        t2lb2.setLayoutY(70);

        TextField t2tf2 = new TextField();
        t2tf2.setLayoutX(200);
        t2tf2.setLayoutY(70);

        Label t2lb3 = new Label("Interest rate(Annual): ");
        t2lb3.setLayoutX(50);
        t2lb3.setLayoutY(110);

        TextField t2tf3 = new TextField();
        t2tf3.setLayoutX(200);
        t2tf3.setLayoutY(110);
        t2tf3.setPromptText("\t\t\t\t\t\t%");

        Label t2lb5 = new Label("Number of\ncompound payments\nper year: ");
        t2lb5.setLayoutX(50);
        t2lb5.setLayoutY(150);

        TextField t2tf5 = new TextField();
        t2tf5.setLayoutX(200);
        t2tf5.setLayoutY(150);

        Button t2btnCal = new Button("Calculate");
        t2btnCal.setLayoutX(160);
        t2btnCal.setLayoutY(300);

        Label t2rlbl1 = new Label();
        t2rlbl1.setLayoutX(400);
        t2rlbl1.setLayoutY(30);

        Label t2erLbl = new Label();
        t2erLbl.setLayoutX(160);
        t2erLbl.setLayoutY(220);
        t2erLbl.setTextFill(Color.web("#f2051e"));

        //    Home button

        Button t2homebtn = new Button("Home");
        t2homebtn.setLayoutX(250);
        t2homebtn.setLayoutY(300);


        t2homebtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) t2homebtn.getScene().getWindow();
                stage.close();
                try {
                    homepg.start(mainStage);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        t2btnCal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t2erLbl.setText("");
                double futVal = futureVal(t2tf3,t2tf1,t2tf2,t2tf5,t2erLbl);
                t2rlbl1.setText("Future value:  "+futVal);
            }
        });

        root2.getTabs().add(tab2);
        tab2.setContent(t2aPane);
        t2aPane.getChildren().add(t2lb1);
        t2aPane.getChildren().add(t2lb2);
        t2aPane.getChildren().add(t2lb3);
        t2aPane.getChildren().add(t2lb5);

        t2aPane.getChildren().add(t2tf1);
        t2aPane.getChildren().add(t2tf2);
        t2aPane.getChildren().add(t2tf3);
        t2aPane.getChildren().add(t2tf5);

        t2aPane.getChildren().add(t2btnCal);
        t2aPane.getChildren().add(t2rlbl1);
        t2aPane.getChildren().add(t2erLbl);
        t2aPane.getChildren().add(t2homebtn);
//Tab 3 starts here
        Tab tab3 = new Tab("No. of Payments");

        AnchorPane t3aPane = new AnchorPane();

        Label t3lb1 = new Label("Interest rate(Annual): ");
        t3lb1.setLayoutX(50);
        t3lb1.setLayoutY(30);

        TextField t3tf1 = new TextField();
        t3tf1.setLayoutX(200);
        t3tf1.setLayoutY(30);
        t3tf1.setPromptText("\t\t\t\t\t\t%");

        Label t3lb2 = new Label("Present value: ");
        t3lb2.setLayoutX(50);
        t3lb2.setLayoutY(70);

        TextField t3tf2 = new TextField();
        t3tf2.setLayoutX(200);
        t3tf2.setLayoutY(70);

        Label t3lb4 = new Label("Future value: ");
        t3lb4.setLayoutX(50);
        t3lb4.setLayoutY(110);

        TextField t3tf4 = new TextField();
        t3tf4.setLayoutX(200);
        t3tf4.setLayoutY(110);

        Label t3lb5 = new Label("Number of\ncompound payments\nper year: ");
        t3lb5.setLayoutX(50);
        t3lb5.setLayoutY(150);

        TextField t3tf5 = new TextField();
        t3tf5.setLayoutX(200);
        t3tf5.setLayoutY(150);

        Button t3btnCal = new Button("Calculate");
        t3btnCal.setLayoutX(160);
        t3btnCal.setLayoutY(300);

        Label t3rlbl1 = new Label();
        t3rlbl1.setLayoutX(400);
        t3rlbl1.setLayoutY(30);

        Label t3erLbl = new Label();
        t3erLbl.setLayoutX(160);
        t3erLbl.setLayoutY(220);
        t3erLbl.setTextFill(Color.web("#f2051e"));

        //    Home button

        Button t3homebtn = new Button("Home");
        t3homebtn.setLayoutX(250);
        t3homebtn.setLayoutY(300);


        t3homebtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) t3homebtn.getScene().getWindow();
                stage.close();
                try {
                    homepg.start(mainStage);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        t3btnCal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t3erLbl.setText("");
                double nOfP = noOfPayments(t3tf1, t3tf2, t3tf4, t3tf5, t3erLbl);
                t3rlbl1.setText("No of Payments/time in years:  "+nOfP);
            }
        });

        root2.getTabs().add(tab3);

        tab3.setContent(t3aPane);
        t3aPane.getChildren().add(t3lb1);
        t3aPane.getChildren().add(t3lb2);
        t3aPane.getChildren().add(t3lb4);
        t3aPane.getChildren().add(t3lb5);

        t3aPane.getChildren().add(t3tf1);
        t3aPane.getChildren().add(t3tf2);
        t3aPane.getChildren().add(t3tf4);
        t3aPane.getChildren().add(t3tf5);

        t3aPane.getChildren().add(t3btnCal);
        t3aPane.getChildren().add(t3rlbl1);
        t3aPane.getChildren().add(t3erLbl);
        t3aPane.getChildren().add(t3homebtn);

        //Tab4 starts here(Present value)
        Tab tab4 = new Tab("Present value");
        AnchorPane t4aPane = new AnchorPane();

        Label t4lb1 = new Label("Time in years: ");
        t4lb1.setLayoutX(50);
        t4lb1.setLayoutY(30);

        TextField t4tf1 = new TextField();
        t4tf1.setLayoutX(200);
        t4tf1.setLayoutY(30);

        Label t4lb2 = new Label("Interest rate(Annual): ");
        t4lb2.setLayoutX(50);
        t4lb2.setLayoutY(70);

        TextField t4tf2 = new TextField();
        t4tf2.setLayoutX(200);
        t4tf2.setLayoutY(70);
        t4tf2.setPromptText("\t\t\t\t\t\t%");

        Label t4lb4 = new Label("Future value: ");
        t4lb4.setLayoutX(50);
        t4lb4.setLayoutY(110);

        TextField t4tf4 = new TextField();
        t4tf4.setLayoutX(200);
        t4tf4.setLayoutY(110);

        Label t4lb5 = new Label("Number of\ncompound payments\nper year: ");
        t4lb5.setLayoutX(50);
        t4lb5.setLayoutY(150);

        TextField t4tf5 = new TextField();
        t4tf5.setLayoutX(200);
        t4tf5.setLayoutY(150);

        Button t4btnCal = new Button("Calculate");
        t4btnCal.setLayoutX(160);
        t4btnCal.setLayoutY(300);

        Label t4rlbl1 = new Label();
        t4rlbl1.setLayoutX(400);
        t4rlbl1.setLayoutY(30);

        Label t4erLbl = new Label();
        t4erLbl.setLayoutX(160);
        t4erLbl.setLayoutY(220);
        t4erLbl.setTextFill(Color.web("#f2051e"));

        //    Home button

        Button t4homebtn = new Button("Home");
        t4homebtn.setLayoutX(250);
        t4homebtn.setLayoutY(300);


        t4homebtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) t4homebtn.getScene().getWindow();
                stage.close();
                try {
                    homepg.start(mainStage);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        t4btnCal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t4erLbl.setText("");
                double presentVal = presentValue(t4tf1, t4tf2, t4tf4, t4tf5, t4erLbl);
                t4rlbl1.setText("Present value:  "+presentVal);
            }
        });

        root2.getTabs().add(tab4);

        tab4.setContent(t4aPane);
        t4aPane.getChildren().add(t4lb1);
        t4aPane.getChildren().add(t4lb2);
        t4aPane.getChildren().add(t4lb4);
        t4aPane.getChildren().add(t4lb5);

        t4aPane.getChildren().add(t4tf1);
        t4aPane.getChildren().add(t4tf2);
        t4aPane.getChildren().add(t4tf4);
        t4aPane.getChildren().add(t4tf5);

        t4aPane.getChildren().add(t4btnCal);
        t4aPane.getChildren().add(t4rlbl1);
        t4aPane.getChildren().add(t4erLbl);
        t4aPane.getChildren().add(t4homebtn);

        Scene scene = new Scene(root2,700,600);
        secondStage.setScene(scene);
        secondStage.show();
    }

    public double interstRate(TextField tf1, TextField tf2, TextField tf4, TextField tf5, Label erLbl) {
        try {
            double A = Double.parseDouble(tf4.getText());
            double P = Double.parseDouble(tf2.getText());
            double n = Double.parseDouble(tf5.getText());
            double t = Double.parseDouble(tf1.getText());

            double r = n * (Math.pow((A / P), (1 / (n * t))) - 1);
            double roundedR = Math.round(r * 100) / 100.0;
            return roundedR;
        } catch (Exception ex) {
            erLbl.setText(String.valueOf("Invalid Details"));
        }
        return 0.0;

    }
    public double futureVal(TextField t2tf3, TextField t2tf1, TextField t2tf2, TextField t2tf5, Label t2erLbl){
        try {
            double P = Double.parseDouble(t2tf2.getText());
            double n = Double.parseDouble(t2tf5.getText());
            double t = Double.parseDouble(t2tf1.getText());
            double r = Double.parseDouble(t2tf3.getText());

            double A = P * (Math.pow((1 + (r / n)), (n * t)));
            double roundedA = Math.round(A * 100) / 100.0;
            return roundedA;
        }catch (Exception ex) {
            t2erLbl.setText(String.valueOf("Invalid Details"));
        }
        return 0.0;
    }
    public double noOfPayments(TextField t3tf1, TextField t3tf2, TextField t3tf4, TextField t3tf5, Label t3erLbl) {
        try {
            double A = Double.parseDouble(t3tf4.getText());
            double P = Double.parseDouble(t3tf2.getText());
            double n = Double.parseDouble(t3tf5.getText());
            double r = Double.parseDouble(t3tf1.getText());

            double t = (Math.log(A/P))/(n*(Math.log(1+(r/n))));
            double roundedT = Math.round(t * 100) / 100.0;
            return roundedT;
        } catch (Exception ex) {
            t3erLbl.setText(String.valueOf("Invalid Details"));
        }
        return 0.0;

    }
    public double presentValue(TextField t4tf1, TextField t4tf2, TextField t4tf4, TextField t4tf5, Label t4erLbl){
        try {
            double A = Double.parseDouble(t4tf4.getText());
            double r = Double.parseDouble(t4tf2.getText());
            double n = Double.parseDouble(t4tf5.getText());
            double t = Double.parseDouble(t4tf1.getText());

            double P = A/(Math.pow((1+(r/n)),(n*t)));
            double roundedP = Math.round(P * 100) / 100.0;
            return roundedP;
        } catch (Exception ex) {
            t4erLbl.setText(String.valueOf("Invalid Details"));
        }
        return 0.0;
    }

}

