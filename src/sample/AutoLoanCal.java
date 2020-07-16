package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sun.rmi.rmic.IndentingWriter;

import java.io.*;
import java.util.Scanner;

public class AutoLoanCal {

    public void lCal()throws Exception{
        Stage fifthStage = new Stage();

        fifthStage.setTitle("Auto Loan Calculator");

        Main homepg = new Main();
        Stage mainStage = new Stage();

        TabPane root5 = new TabPane();

        //Tab1 starts here(Years)
        Tab tab1 = new Tab("No. of monthly payments");
        AnchorPane aPane = new AnchorPane();

        Label lb1 = new Label("Interest rate(annual): ");
        lb1.setLayoutX(50);
        lb1.setLayoutY(30);

        TextField tf1 = new TextField();
        tf1.setLayoutX(200);
        tf1.setLayoutY(30);

        Label lb2 = new Label("Payment: ");
        lb2.setLayoutX(50);
        lb2.setLayoutY(70);

        TextField tf2 = new TextField();
        tf2.setLayoutX(200);
        tf2.setLayoutY(70);

        Label lb4 = new Label("Loan amount: ");
        lb4.setLayoutX(50);
        lb4.setLayoutY(110);

        TextField tf4 = new TextField();
        tf4.setLayoutX(200);
        tf4.setLayoutY(110);


        Button btnCal = new Button("Calculate");
        btnCal.setLayoutX(160);
        btnCal.setLayoutY(250);

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
        homebtn.setLayoutY(250);

        Label rlbl2 = new Label();
        rlbl2.setLayoutX(400);
        rlbl2.setLayoutY(100);

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
        setPersistentValues(tf1,tf2,tf4,"!11","!12","!14");

        btnCal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                erLbl.setText("");
                double yCalc = yearsCalc(tf1, tf2, tf4, erLbl);
                rlbl1.setText(String.valueOf("Time taken in years to\ncompletely\npay the mortgage:   "+yCalc));

                double nomp = noOfMonthlyPayments(tf1, tf2, tf4, erLbl);
                rlbl2.setText("Number of monthly payments:  "+nomp);

                try (BufferedWriter bf = new BufferedWriter(new FileWriter("StoredData.txt", true))) {
                    bf.write("Auto loan calculator-No. of monthly payments-***");
                    bf.newLine();
                    bf.write("Interestrate!11:  "+tf1.getText());
                    bf.newLine();
                    bf.write("Payment!12:  "+tf2.getText());
                    bf.newLine();
                    bf.write("Loanamount!14:  "+tf4.getText());
                    bf.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //        Keyboard in tab1

        TextField t3typingtf = new TextField();
        t3typingtf.setLayoutX(20);
        t3typingtf.setLayoutY(300);
        t3typingtf.setPromptText("Type here");
        t3typingtf.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(3))));

        Button t3k0 = new Button("  0  ");
        t3k0.setLayoutX(40);
        t3k0.setLayoutY(440);

        t3k0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t3typingtf.getText()+"0";
                t3typingtf.setText(a);
            }
        });

        Button t3k1 = new Button("  1  ");
        t3k1.setLayoutX(80);
        t3k1.setLayoutY(440);

        t3k1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t3typingtf.getText()+"1";
                t3typingtf.setText(a);
            }
        });

        Button t3k2 = new Button("  2  ");
        t3k2.setLayoutX(120);
        t3k2.setLayoutY(440);

        t3k2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t3typingtf.getText()+"2";
                t3typingtf.setText(a);
            }
        });

        Button t3k3 = new Button("  3  ");
        t3k3.setLayoutX(160);
        t3k3.setLayoutY(440);

        t3k3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t3typingtf.getText()+"3";
                t3typingtf.setText(a);
            }
        });

        Button t3k4 = new Button("  4  ");
        t3k4.setLayoutX(200);
        t3k4.setLayoutY(440);

        t3k4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t3typingtf.getText()+"4";
                t3typingtf.setText(a);
            }
        });

        Button t3k5 = new Button("  5  ");
        t3k5.setLayoutX(240);
        t3k5.setLayoutY(440);

        t3k5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t3typingtf.getText()+"5";
                t3typingtf.setText(a);
            }
        });

        Button t3k6 = new Button("  6  ");
        t3k6.setLayoutX(280);
        t3k6.setLayoutY(440);

        t3k6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t3typingtf.getText()+"6";
                t3typingtf.setText(a);
            }
        });

        Button t3k7 = new Button("  7  ");
        t3k7.setLayoutX(320);
        t3k7.setLayoutY(440);

        t3k7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t3typingtf.getText()+"7";
                t3typingtf.setText(a);
            }
        });

        Button t3k8 = new Button("  8  ");
        t3k8.setLayoutX(360);
        t3k8.setLayoutY(440);

        t3k8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t3typingtf.getText()+"8";
                t3typingtf.setText(a);
            }
        });

        Button t3k9 = new Button("  9  ");
        t3k9.setLayoutX(400);
        t3k9.setLayoutY(440);

        t3k9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t3typingtf.getText()+"9";
                t3typingtf.setText(a);
            }
        });

        Button t3kDot = new Button("  .  ");
        t3kDot.setLayoutX(340);
        t3kDot.setLayoutY(480);

        t3kDot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t3typingtf.getText()+".";
                t3typingtf.setText(a);
            }
        });

        Button t3kDel = new Button("delete");
        t3kDel.setLayoutX(380);
        t3kDel.setLayoutY(480);

        t3kDel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = t3typingtf.getText();
                if ((result != null) && (result.length() > 0)) {
                    String c = result.substring(0, result.length() - 1);
                    t3typingtf.setText(c);
                }else t3typingtf.setText("");
            }
        });

        Button t3kMinus = new Button("  -  ");
        t3kMinus.setLayoutX(300);
        t3kMinus.setLayoutY(480);

        t3kMinus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t3typingtf.getText()+"-";
                t3typingtf.setText(a);
            }
        });

        Button t3clear = new Button("clear");
        t3clear.setLayoutX(45);
        t3clear.setLayoutY(480);

        t3clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t3typingtf.setText("");
            }
        });


        Button t3setBtn1 = new Button("Set typed value\nas 'Interest rate'");
        t3setBtn1.setLayoutX(20);
        t3setBtn1.setLayoutY(340);

        t3setBtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = t3typingtf.getText();
                tf1.setText(b);
                t3typingtf.setText("");
            }
        });

        Button t3setBtn2 = new Button("Set typed value\nas 'Payment'");
        t3setBtn2.setLayoutX(140);
        t3setBtn2.setLayoutY(340);

        t3setBtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = t3typingtf.getText();
                tf2.setText(b);
                t3typingtf.setText("");
            }
        });

        Button t3setbtn3 = new Button("Set typed value\nas 'Loan amount'");
        t3setbtn3.setLayoutX(260);
        t3setbtn3.setLayoutY(340);

        t3setbtn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = t3typingtf.getText();
                tf4.setText(b);
                t3typingtf.setText("");
            }
        });

        Button t3clearbtn1 = new Button("clear ^");
        t3clearbtn1.setLayoutX(45);
        t3clearbtn1.setLayoutY(390);

        t3clearbtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tf1.setText("");
            }
        });

        Button t3clearbtn2 = new Button("clear ^");
        t3clearbtn2.setLayoutX(170);
        t3clearbtn2.setLayoutY(390);

        t3clearbtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tf2.setText("");
            }
        });

        Button t3clearbtn5 = new Button("clear ^");
        t3clearbtn5.setLayoutX(280);
        t3clearbtn5.setLayoutY(390);

        t3clearbtn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tf4.setText("");
            }
        });

//        Keyboard ended here

        root5.getTabs().add(tab1);

        tab1.setContent(aPane);
        aPane.getChildren().add(lb1);
        aPane.getChildren().add(lb2);
        aPane.getChildren().add(lb4);

        aPane.getChildren().add(tf1);
        aPane.getChildren().add(tf2);
        aPane.getChildren().add(tf4);

        aPane.getChildren().add(btnCal);
        aPane.getChildren().add(rlbl1);
        aPane.getChildren().add(erLbl);
        aPane.getChildren().add(homebtn);
        aPane.getChildren().add(rlbl2);

        //keyboard children
        aPane.getChildren().add(t3k0);
        aPane.getChildren().add(t3k1);
        aPane.getChildren().add(t3k2);
        aPane.getChildren().add(t3k3);
        aPane.getChildren().add(t3k4);
        aPane.getChildren().add(t3k5);
        aPane.getChildren().add(t3k6);
        aPane.getChildren().add(t3k7);
        aPane.getChildren().add(t3k8);
        aPane.getChildren().add(t3k9);
        aPane.getChildren().add(t3kDot);
        aPane.getChildren().add(t3kDel);
        aPane.getChildren().add(t3typingtf);
        aPane.getChildren().add(t3setBtn1);
        aPane.getChildren().add(t3setBtn2);
        aPane.getChildren().add(t3setbtn3);
        aPane.getChildren().add(t3kMinus);
        aPane.getChildren().add(t3clear);
        aPane.getChildren().add(t3clearbtn1);
        aPane.getChildren().add(t3clearbtn2);
        aPane.getChildren().add(t3clearbtn5);
//keyboard children ended

        //Tab2 starts here(Payment)
        Tab tab2 = new Tab("Payment");
        AnchorPane t2aPane = new AnchorPane();

        Label t2lb1 = new Label("Interest rate(annual): ");
        t2lb1.setLayoutX(50);
        t2lb1.setLayoutY(30);

        TextField t2tf1 = new TextField();
        t2tf1.setLayoutX(200);
        t2tf1.setLayoutY(30);

        Label t2lb2 = new Label("Time taken in years: ");
        t2lb2.setLayoutX(50);
        t2lb2.setLayoutY(70);

        TextField t2tf2 = new TextField();
        t2tf2.setLayoutX(200);
        t2tf2.setLayoutY(70);

        Label t2lb4 = new Label("Loan amount: ");
        t2lb4.setLayoutX(50);
        t2lb4.setLayoutY(110);

        TextField t2tf4 = new TextField();
        t2tf4.setLayoutX(200);
        t2tf4.setLayoutY(110);


        Button t2btnCal = new Button("Calculate");
        t2btnCal.setLayoutX(160);
        t2btnCal.setLayoutY(250);

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
        t2homebtn.setLayoutY(250);


        t2homebtn.setOnAction(new EventHandler<ActionEvent>() {
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
        setPersistentValues(t2tf1,t2tf2,t2tf4,"!21","!22","!24");

        t2btnCal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t2erLbl.setText("");
                double pmnt = payment(t2tf1, t2tf2, t2tf4, t2erLbl);
                t2rlbl1.setText(String.valueOf("Monthly payment:  £ "+pmnt));

                try (BufferedWriter bf = new BufferedWriter(new FileWriter("StoredData.txt", true))) {
                    bf.write("Auto loan calculator-Payment-***");
                    bf.newLine();
                    bf.write("Interestrate!21:  "+t2tf1.getText());
                    bf.newLine();
                    bf.write("Timetakeninyears!22:  "+t2tf2.getText());
                    bf.newLine();
                    bf.write("Loanamount!24:  "+t2tf4.getText());
                    bf.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //        Keyboard in tab2

        TextField t2typingtf = new TextField();
        t2typingtf.setLayoutX(20);
        t2typingtf.setLayoutY(300);
        t2typingtf.setPromptText("Type here");
        t2typingtf.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(3))));

        Button t2k0 = new Button("  0  ");
        t2k0.setLayoutX(40);
        t2k0.setLayoutY(440);

        t2k0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t2typingtf.getText()+"0";
                t2typingtf.setText(a);
            }
        });

        Button t2k1 = new Button("  1  ");
        t2k1.setLayoutX(80);
        t2k1.setLayoutY(440);

        t2k1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t2typingtf.getText()+"1";
                t2typingtf.setText(a);
            }
        });

        Button t2k2 = new Button("  2  ");
        t2k2.setLayoutX(120);
        t2k2.setLayoutY(440);

        t2k2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t2typingtf.getText()+"2";
                t2typingtf.setText(a);
            }
        });

        Button t2k3 = new Button("  3  ");
        t2k3.setLayoutX(160);
        t2k3.setLayoutY(440);

        t2k3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t2typingtf.getText()+"3";
                t2typingtf.setText(a);
            }
        });

        Button t2k4 = new Button("  4  ");
        t2k4.setLayoutX(200);
        t2k4.setLayoutY(440);

        t2k4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t2typingtf.getText()+"4";
                t2typingtf.setText(a);
            }
        });

        Button t2k5 = new Button("  5  ");
        t2k5.setLayoutX(240);
        t2k5.setLayoutY(440);

        t2k5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t2typingtf.getText()+"5";
                t2typingtf.setText(a);
            }
        });

        Button t2k6 = new Button("  6  ");
        t2k6.setLayoutX(280);
        t2k6.setLayoutY(440);

        t2k6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t2typingtf.getText()+"6";
                t2typingtf.setText(a);
            }
        });

        Button t2k7 = new Button("  7  ");
        t2k7.setLayoutX(320);
        t2k7.setLayoutY(440);

        t2k7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t2typingtf.getText()+"7";
                t2typingtf.setText(a);
            }
        });

        Button t2k8 = new Button("  8  ");
        t2k8.setLayoutX(360);
        t2k8.setLayoutY(440);

        t2k8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t2typingtf.getText()+"8";
                t2typingtf.setText(a);
            }
        });

        Button t2k9 = new Button("  9  ");
        t2k9.setLayoutX(400);
        t2k9.setLayoutY(440);

        t2k9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t2typingtf.getText()+"9";
                t2typingtf.setText(a);
            }
        });

        Button t2kDot = new Button("  .  ");
        t2kDot.setLayoutX(340);
        t2kDot.setLayoutY(480);

        t2kDot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t2typingtf.getText()+".";
                t2typingtf.setText(a);
            }
        });

        Button t2kDel = new Button("delete");
        t2kDel.setLayoutX(380);
        t2kDel.setLayoutY(480);

        t2kDel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = t2typingtf.getText();
                if ((result != null) && (result.length() > 0)) {
                    String c = result.substring(0, result.length() - 1);
                    t2typingtf.setText(c);
                }else t2typingtf.setText("");
            }
        });

        Button t2kMinus = new Button("  -  ");
        t2kMinus.setLayoutX(300);
        t2kMinus.setLayoutY(480);

        t2kMinus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t2typingtf.getText()+"-";
                t2typingtf.setText(a);
            }
        });

        Button t2clear = new Button("clear");
        t2clear.setLayoutX(45);
        t2clear.setLayoutY(480);

        t2clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t2typingtf.setText("");
            }
        });


        Button t2setBtn1 = new Button("Set typed value\nas 'Interest rate'");
        t2setBtn1.setLayoutX(20);
        t2setBtn1.setLayoutY(340);

        t2setBtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = t2typingtf.getText();
                t2tf1.setText(b);
                t2typingtf.setText("");
            }
        });

        Button t2setBtn2 = new Button("Set typed value\nas 'Time in years'");
        t2setBtn2.setLayoutX(140);
        t2setBtn2.setLayoutY(340);

        t2setBtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = t2typingtf.getText();
                t2tf2.setText(b);
                t2typingtf.setText("");
            }
        });

        Button t2setbtn3 = new Button("Set typed value\nas 'Loan amount'");
        t2setbtn3.setLayoutX(260);
        t2setbtn3.setLayoutY(340);

        t2setbtn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = t2typingtf.getText();
                t2tf4.setText(b);
                t2typingtf.setText("");
            }
        });

        Button t2clearbtn1 = new Button("clear ^");
        t2clearbtn1.setLayoutX(45);
        t2clearbtn1.setLayoutY(390);

        t2clearbtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t2tf1.setText("");
            }
        });

        Button t2clearbtn2 = new Button("clear ^");
        t2clearbtn2.setLayoutX(170);
        t2clearbtn2.setLayoutY(390);

        t2clearbtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t2tf2.setText("");
            }
        });

        Button t2clearbtn5 = new Button("clear ^");
        t2clearbtn5.setLayoutX(280);
        t2clearbtn5.setLayoutY(390);

        t2clearbtn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t2tf4.setText("");
            }
        });

//        Keyboard ended here

        root5.getTabs().add(tab2);

        tab2.setContent(t2aPane);
        t2aPane.getChildren().add(t2lb1);
        t2aPane.getChildren().add(t2lb2);
        t2aPane.getChildren().add(t2lb4);

        t2aPane.getChildren().add(t2tf1);
        t2aPane.getChildren().add(t2tf2);
        t2aPane.getChildren().add(t2tf4);

        t2aPane.getChildren().add(t2btnCal);
        t2aPane.getChildren().add(t2rlbl1);
        t2aPane.getChildren().add(t2erLbl);
        t2aPane.getChildren().add(t2homebtn);

        //keyboard children
        t2aPane.getChildren().add(t2k0);
        t2aPane.getChildren().add(t2k1);
        t2aPane.getChildren().add(t2k2);
        t2aPane.getChildren().add(t2k3);
        t2aPane.getChildren().add(t2k4);
        t2aPane.getChildren().add(t2k5);
        t2aPane.getChildren().add(t2k6);
        t2aPane.getChildren().add(t2k7);
        t2aPane.getChildren().add(t2k8);
        t2aPane.getChildren().add(t2k9);
        t2aPane.getChildren().add(t2kDot);
        t2aPane.getChildren().add(t2kDel);
        t2aPane.getChildren().add(t2typingtf);
        t2aPane.getChildren().add(t2setBtn1);
        t2aPane.getChildren().add(t2setBtn2);
        t2aPane.getChildren().add(t2setbtn3);
        t2aPane.getChildren().add(t2kMinus);
        t2aPane.getChildren().add(t2clear);
        t2aPane.getChildren().add(t2clearbtn1);
        t2aPane.getChildren().add(t2clearbtn2);
        t2aPane.getChildren().add(t2clearbtn5);
//keyboard children ended
        fifthStage.setResizable(false);
        Scene scene = new Scene(root5,700,600);
        fifthStage.setScene(scene);
        fifthStage.show();
    }

    public double yearsCalc(TextField tf1, TextField tf2, TextField tf4, Label erLbl) {
        try {
            double r = Double.parseDouble(tf1.getText());
            double PMT = Double.parseDouble(tf2.getText());
            double A = Double.parseDouble(tf4.getText());

            double t = Math.log((1-((r*A)/PMT))/Math.log(1+r)*12);
            double roundedt = Math.round(t * 100.00) / 100.00;
            return roundedt;
        } catch (Exception ex) {
            erLbl.setText(String.valueOf("Invalid Details"));
        }
        return 0.0;
    }

    public double noOfMonthlyPayments(TextField tf1, TextField tf2, TextField tf4, Label erLbl) {
        try {
            double r = Double.parseDouble(tf1.getText());
            double PMT = Double.parseDouble(tf2.getText());
            double A = Double.parseDouble(tf4.getText());

            double t = Math.log((1-((r*A)/PMT))/Math.log(1+r)*12)*12;
            double roundedt = Math.round(t * 100.0) / 100.0;
            return roundedt;
        } catch (Exception ex) {
            erLbl.setText(String.valueOf("Invalid Details"));
        }
        return 0.00;
    }

    public double payment(TextField t2tf1, TextField t2tf2, TextField t2tf4, Label t2erLbl) {
        try {
            double r = Double.parseDouble(t2tf1.getText());
            double t = Double.parseDouble(t2tf2.getText());
            double A = Double.parseDouble(t2tf4.getText());

            double PMT = (A*(r/12)*Math.pow(1+(r/12),12*t))/(Math.pow(1+(r/12),12*t)-1);
            double roundedPMT = Math.round(PMT * 100.00) / 100.00;
            return roundedPMT;
        } catch (Exception ex) {
            t2erLbl.setText(String.valueOf("Invalid Details"));
        }
        return 0.0;
    }
    //three text fields
    public void setPersistentValues(TextField tfp1, TextField tfp2, TextField tfp3, String reg1,
                                    String reg2, String reg3) {
        try {
            Scanner s = new Scanner(new File("StoredData.txt"));
            while (s.hasNext()) {
                String row = s.nextLine();
                if (row.contains(reg1)) {
                    String[] splitRow = row.split("\\s+");
                    tfp1.appendText(splitRow[1]);
                } else if (row.contains(reg2)) {
                    String[] splitRow = row.split("\\s+");
                    tfp2.appendText(splitRow[1]);
                } else if (row.contains(reg3)) {
                    String[] splitRow = row.split("\\s+");
                    tfp3.appendText(splitRow[1]);
                } else {
                    System.out.println("Initial");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
