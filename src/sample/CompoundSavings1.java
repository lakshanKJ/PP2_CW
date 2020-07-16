package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

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
        btnCal.setLayoutX(250);
        btnCal.setLayoutY(220);

        Label rlbl1 = new Label();
        rlbl1.setLayoutX(400);
        rlbl1.setLayoutY(30);

        Label erLbl = new Label();
        erLbl.setLayoutX(160);
        erLbl.setLayoutY(220);
        erLbl.setTextFill(Color.web("#f2051e"));

        //    Home button

        Button homebtn = new Button("Home");
        homebtn.setLayoutX(330);
        homebtn.setLayoutY(220);


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

        setPersistentValues(tf1, tf2, tf4,tf5, "@11","@12","@14","@15");


        btnCal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                erLbl.setText("");
                double intRate = interstRate(tf1, tf2, tf4, tf5, erLbl);
                rlbl1.setText(String.valueOf("Interest rate(Annual):   "+intRate+" %"));

                try (BufferedWriter bf = new BufferedWriter(new FileWriter("StoredData.txt", true))) {
                    bf.write("Compound Savings1-Interest rate-***");
                    bf.newLine();
                    bf.write("Timeinyears@11:  "+tf1.getText());
                    bf.newLine();
                    bf.write("Presentvalue@12:  "+tf2.getText());
                    bf.newLine();
                    bf.write("Futurevalue@14:  "+tf4.getText());
                    bf.newLine();
                    bf.write("No.ofcompoundpaymentsperyear@15:  "+tf5.getText());
                    bf.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //        Keyboard in tab1

        TextField typingtf = new TextField();
        typingtf.setLayoutX(40);
        typingtf.setLayoutY(300);
        typingtf.setPromptText("Type here");
        typingtf.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(3))));

        Button k0 = new Button("  0  ");
        k0.setLayoutX(40);
        k0.setLayoutY(440);

        k0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = typingtf.getText()+"0";
                typingtf.setText(a);
            }
        });

        Button k1 = new Button("  1  ");
        k1.setLayoutX(80);
        k1.setLayoutY(440);

        k1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = typingtf.getText()+"1";
                typingtf.setText(a);
            }
        });

        Button k2 = new Button("  2  ");
        k2.setLayoutX(120);
        k2.setLayoutY(440);

        k2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = typingtf.getText()+"2";
                typingtf.setText(a);
            }
        });

        Button k3 = new Button("  3  ");
        k3.setLayoutX(160);
        k3.setLayoutY(440);

        k3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = typingtf.getText()+"3";
                typingtf.setText(a);
            }
        });

        Button k4 = new Button("  4  ");
        k4.setLayoutX(200);
        k4.setLayoutY(440);

        k4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = typingtf.getText()+"4";
                typingtf.setText(a);
            }
        });

        Button k5 = new Button("  5  ");
        k5.setLayoutX(240);
        k5.setLayoutY(440);

        k5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = typingtf.getText()+"5";
                typingtf.setText(a);
            }
        });

        Button k6 = new Button("  6  ");
        k6.setLayoutX(280);
        k6.setLayoutY(440);

        k6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = typingtf.getText()+"6";
                typingtf.setText(a);
            }
        });

        Button k7 = new Button("  7  ");
        k7.setLayoutX(320);
        k7.setLayoutY(440);

        k7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = typingtf.getText()+"7";
                typingtf.setText(a);
            }
        });

        Button k8 = new Button("  8  ");
        k8.setLayoutX(360);
        k8.setLayoutY(440);

        k8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = typingtf.getText()+"8";
                typingtf.setText(a);
            }
        });

        Button k9 = new Button("  9  ");
        k9.setLayoutX(400);
        k9.setLayoutY(440);

        k9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = typingtf.getText()+"9";
                typingtf.setText(a);
            }
        });

        Button kDot = new Button("  .  ");
        kDot.setLayoutX(340);
        kDot.setLayoutY(480);

        kDot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = typingtf.getText()+".";
                typingtf.setText(a);
            }
        });

        Button kDel = new Button("delete");
        kDel.setLayoutX(380);
        kDel.setLayoutY(480);

        kDel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = typingtf.getText();
                if ((result != null) && (result.length() > 0)) {
                    String c = result.substring(0, result.length() - 1);
                    typingtf.setText(c);
                }else typingtf.setText("");
            }
        });

        Button kMinus = new Button("  -  ");
        kMinus.setLayoutX(300);
        kMinus.setLayoutY(480);

        kMinus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = typingtf.getText()+"-";
                typingtf.setText(a);
            }
        });

        Button clear = new Button("clear");
        clear.setLayoutX(45);
        clear.setLayoutY(480);

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                typingtf.setText("");
            }
        });


        Button setBtn1 = new Button("Set typed value\nas 'Time in years'");
        setBtn1.setLayoutX(20);
        setBtn1.setLayoutY(340);

        setBtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = typingtf.getText();
                tf1.setText(b);
                typingtf.setText("");
            }
        });

        Button setBtn2 = new Button("Set typed value\nas 'Present value'");
        setBtn2.setLayoutX(140);
        setBtn2.setLayoutY(340);

        setBtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = typingtf.getText();
                tf2.setText(b);
                typingtf.setText("");
            }
        });

        Button setBtn4 = new Button("Set typed value\nas 'Future value'");
        setBtn4.setLayoutX(260);
        setBtn4.setLayoutY(340);

        setBtn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = typingtf.getText();
                tf4.setText(b);
                typingtf.setText("");
            }
        });

        Button setBtn5 = new Button("Set typed value as 'Number of\ncompound payments per year'");
        setBtn5.setLayoutX(380);
        setBtn5.setLayoutY(340);

        setBtn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = typingtf.getText();
                tf5.setText(b);
                typingtf.setText("");
            }
        });

        Button clearbtn1 = new Button("clear ^");
        clearbtn1.setLayoutX(45);
        clearbtn1.setLayoutY(390);

        clearbtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tf1.setText("");
            }
        });

        Button clearbtn2 = new Button("clear ^");
        clearbtn2.setLayoutX(170);
        clearbtn2.setLayoutY(390);

        clearbtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tf2.setText("");
            }
        });

        Button clearbtn3 = new Button("clear ^");
        clearbtn3.setLayoutX(280);
        clearbtn3.setLayoutY(390);

        clearbtn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tf4.setText("");
            }
        });

        Button clearbtn4 = new Button("clear ^");
        clearbtn4.setLayoutX(430);
        clearbtn4.setLayoutY(390);

        clearbtn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tf5.setText("");
            }
        });

//        Keyboard ended here

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
//keyboard children
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
        aPane.getChildren().add(kMinus);
        aPane.getChildren().add(clear);
        aPane.getChildren().add(clearbtn1);
        aPane.getChildren().add(clearbtn2);
        aPane.getChildren().add(clearbtn3);
        aPane.getChildren().add(clearbtn4);
//keyboard children ended

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

        Label t2lb5 = new Label("Number of\ncompound payments\nper year: ");
        t2lb5.setLayoutX(50);
        t2lb5.setLayoutY(150);

        TextField t2tf5 = new TextField();
        t2tf5.setLayoutX(200);
        t2tf5.setLayoutY(150);

        Button t2btnCal = new Button("Calculate");
        t2btnCal.setLayoutX(250);
        t2btnCal.setLayoutY(220);

        Label t2rlbl1 = new Label();
        t2rlbl1.setLayoutX(400);
        t2rlbl1.setLayoutY(30);

        Label t2erLbl = new Label();
        t2erLbl.setLayoutX(160);
        t2erLbl.setLayoutY(220);
        t2erLbl.setTextFill(Color.web("#f2051e"));

        //    Home button

        Button t2homebtn = new Button("Home");
        t2homebtn.setLayoutX(330);
        t2homebtn.setLayoutY(220);


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
        setPersistentValues(t2tf1, t2tf2, t2tf3,t2tf5, "@21","@22","@23","@25");

        t2btnCal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t2erLbl.setText("");
                double futVal = futureVal(t2tf3,t2tf1,t2tf2,t2tf5,t2erLbl);
                t2rlbl1.setText("Future value: £ "+futVal);

                try (BufferedWriter bf = new BufferedWriter(new FileWriter("StoredData.txt", true))) {
                    bf.write("Compound Savings1-Future value-***");
                    bf.newLine();
                    bf.write("Timeinyears@21:  "+t2tf1.getText());
                    bf.newLine();
                    bf.write("Presentvalue@22:  "+t2tf2.getText());
                    bf.newLine();
                    bf.write("Interestrate@23:  "+t2tf3.getText());
                    bf.newLine();
                    bf.write("No.ofcompoundpaymentsperyear@25:  "+t2tf5.getText());
                    bf.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //        Keyboard in tab2

        TextField t2typingtf = new TextField();
        t2typingtf.setLayoutX(40);
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


        Button t2setBtn1 = new Button("Set typed value\nas 'Time in years'");
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

        Button t2setBtn2 = new Button("Set typed value\nas 'Present value'");
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

        Button t2setBtn4 = new Button("Set typed value\nas 'Interest rate'");
        t2setBtn4.setLayoutX(260);
        t2setBtn4.setLayoutY(340);

        t2setBtn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = t2typingtf.getText();
                t2tf3.setText(b);
                t2typingtf.setText("");
            }
        });

        Button t2setBtn5 = new Button("Set typed value as 'Number of\ncompound payments per year'");
        t2setBtn5.setLayoutX(380);
        t2setBtn5.setLayoutY(340);

        t2setBtn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = t2typingtf.getText();
                t2tf5.setText(b);
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

        Button t2clearbtn3 = new Button("clear ^");
        t2clearbtn3.setLayoutX(280);
        t2clearbtn3.setLayoutY(390);

        t2clearbtn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t2tf3.setText("");
            }
        });

        Button t2clearbtn4 = new Button("clear ^");
        t2clearbtn4.setLayoutX(430);
        t2clearbtn4.setLayoutY(390);

        t2clearbtn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t2tf5.setText("");
            }
        });

//        Keyboard ended here

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
        t2aPane.getChildren().add(t2setBtn4);
        t2aPane.getChildren().add(t2setBtn5);
        t2aPane.getChildren().add(t2kMinus);
        t2aPane.getChildren().add(t2clear);
        t2aPane.getChildren().add(t2clearbtn1);
        t2aPane.getChildren().add(t2clearbtn2);
        t2aPane.getChildren().add(t2clearbtn3);
        t2aPane.getChildren().add(t2clearbtn4);
//keyboard children ended

//Tab 3 starts here
        Tab tab3 = new Tab("Time taken");

        AnchorPane t3aPane = new AnchorPane();

        Label t3lb1 = new Label("Interest rate(Annual): ");
        t3lb1.setLayoutX(50);
        t3lb1.setLayoutY(30);

        TextField t3tf1 = new TextField();
        t3tf1.setLayoutX(200);
        t3tf1.setLayoutY(30);

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
        t3btnCal.setLayoutX(250);
        t3btnCal.setLayoutY(220);

        Label t3rlbl1 = new Label();
        t3rlbl1.setLayoutX(400);
        t3rlbl1.setLayoutY(30);

        Label t3erLbl = new Label();
        t3erLbl.setLayoutX(160);
        t3erLbl.setLayoutY(220);
        t3erLbl.setTextFill(Color.web("#f2051e"));

        //    Home button

        Button t3homebtn = new Button("Home");
        t3homebtn.setLayoutX(330);
        t3homebtn.setLayoutY(220);


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
        setPersistentValues(t3tf1, t3tf2, t3tf4,t3tf5, "@31","@32","@34","@35");

        t3btnCal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t3erLbl.setText("");
                double nOfP = noOfPayments(t3tf1, t3tf2, t3tf4, t3tf5, t3erLbl);
                t3rlbl1.setText("Time taken in years:  "+nOfP);

                try (BufferedWriter bf = new BufferedWriter(new FileWriter("StoredData.txt", true))) {
                    bf.write("Compound Savings1-Time taken-***");
                    bf.newLine();
                    bf.write("Interestrate@31:  "+t3tf1.getText());
                    bf.newLine();
                    bf.write("Presentvalue@32:  "+t3tf2.getText());
                    bf.newLine();
                    bf.write("Futurevalue@34:  "+t3tf4.getText());
                    bf.newLine();
                    bf.write("No.ofcompoundpaymentsperyear@35:  "+t3tf5.getText());
                    bf.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //        Keyboard in tab3

        TextField t3typingtf = new TextField();
        t3typingtf.setLayoutX(40);
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
                t3tf1.setText(b);
                t3typingtf.setText("");
            }
        });

        Button t3setBtn2 = new Button("Set typed value\nas 'Present value'");
        t3setBtn2.setLayoutX(140);
        t3setBtn2.setLayoutY(340);

        t3setBtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = t3typingtf.getText();
                t3tf2.setText(b);
                t3typingtf.setText("");
            }
        });

        Button t3setBtn4 = new Button("Set typed value\nas 'Future value'");
        t3setBtn4.setLayoutX(260);
        t3setBtn4.setLayoutY(340);

        t3setBtn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = t3typingtf.getText();
                t3tf4.setText(b);
                t3typingtf.setText("");
            }
        });

        Button t3setBtn5 = new Button("Set typed value as 'Number of\ncompound payments per year'");
        t3setBtn5.setLayoutX(380);
        t3setBtn5.setLayoutY(340);

        t3setBtn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = t3typingtf.getText();
                t3tf5.setText(b);
                t3typingtf.setText("");
            }
        });

        Button t3clearbtn1 = new Button("clear ^");
        t3clearbtn1.setLayoutX(45);
        t3clearbtn1.setLayoutY(390);

        t3clearbtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t3tf1.setText("");
            }
        });

        Button t3clearbtn2 = new Button("clear ^");
        t3clearbtn2.setLayoutX(170);
        t3clearbtn2.setLayoutY(390);

        t3clearbtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t3tf2.setText("");
            }
        });

        Button t3clearbtn3 = new Button("clear ^");
        t3clearbtn3.setLayoutX(280);
        t3clearbtn3.setLayoutY(390);

        t3clearbtn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t3tf4.setText("");
            }
        });

        Button t3clearbtn4 = new Button("clear ^");
        t3clearbtn4.setLayoutX(430);
        t3clearbtn4.setLayoutY(390);

        t3clearbtn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t3tf5.setText("");
            }
        });

//        Keyboard ended here

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

        //keyboard children
        t3aPane.getChildren().add(t3k0);
        t3aPane.getChildren().add(t3k1);
        t3aPane.getChildren().add(t3k2);
        t3aPane.getChildren().add(t3k3);
        t3aPane.getChildren().add(t3k4);
        t3aPane.getChildren().add(t3k5);
        t3aPane.getChildren().add(t3k6);
        t3aPane.getChildren().add(t3k7);
        t3aPane.getChildren().add(t3k8);
        t3aPane.getChildren().add(t3k9);
        t3aPane.getChildren().add(t3kDot);
        t3aPane.getChildren().add(t3kDel);
        t3aPane.getChildren().add(t3typingtf);
        t3aPane.getChildren().add(t3setBtn1);
        t3aPane.getChildren().add(t3setBtn2);
        t3aPane.getChildren().add(t3setBtn4);
        t3aPane.getChildren().add(t3setBtn5);
        t3aPane.getChildren().add(t3kMinus);
        t3aPane.getChildren().add(t3clear);
        t3aPane.getChildren().add(t3clearbtn1);
        t3aPane.getChildren().add(t3clearbtn2);
        t3aPane.getChildren().add(t3clearbtn3);
        t3aPane.getChildren().add(t3clearbtn4);
//keyboard children ended

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
        t4btnCal.setLayoutX(250);
        t4btnCal.setLayoutY(220);

        Label t4rlbl1 = new Label();
        t4rlbl1.setLayoutX(400);
        t4rlbl1.setLayoutY(30);

        Label t4erLbl = new Label();
        t4erLbl.setLayoutX(160);
        t4erLbl.setLayoutY(220);
        t4erLbl.setTextFill(Color.web("#f2051e"));

        //    Home button

        Button t4homebtn = new Button("Home");
        t4homebtn.setLayoutX(330);
        t4homebtn.setLayoutY(220);


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
        setPersistentValues(t4tf1, t4tf2, t4tf4,t4tf5, "@41","@42","@44","@45");

        t4btnCal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t4erLbl.setText("");
                double presentVal = presentValue(t4tf1, t4tf2, t4tf4, t4tf5, t4erLbl);
                t4rlbl1.setText("Present value: £ "+presentVal);

                try (BufferedWriter bf = new BufferedWriter(new FileWriter("StoredData.txt", true))) {
                    bf.write("Compound Savings1-Present value-***");
                    bf.newLine();
                    bf.write("Timeinyears@41:  "+t4tf1.getText());
                    bf.newLine();
                    bf.write("Interestrate@42:  "+t4tf2.getText());
                    bf.newLine();
                    bf.write("Futurevalue@44:  "+t4tf4.getText());
                    bf.newLine();
                    bf.write("No.ofcompoundpaymentsperyear@45:  "+t4tf5.getText());
                    bf.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //        Keyboard in tab4

        TextField t4typingtf = new TextField();
        t4typingtf.setLayoutX(40);
        t4typingtf.setLayoutY(300);
        t4typingtf.setPromptText("Type here");
        t4typingtf.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(3))));

        Button t4k0 = new Button("  0  ");
        t4k0.setLayoutX(40);
        t4k0.setLayoutY(440);

        t4k0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t4typingtf.getText()+"0";
                t4typingtf.setText(a);
            }
        });

        Button t4k1 = new Button("  1  ");
        t4k1.setLayoutX(80);
        t4k1.setLayoutY(440);

        t4k1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t4typingtf.getText()+"1";
                t4typingtf.setText(a);
            }
        });

        Button t4k2 = new Button("  2  ");
        t4k2.setLayoutX(120);
        t4k2.setLayoutY(440);

        t4k2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t4typingtf.getText()+"2";
                t4typingtf.setText(a);
            }
        });

        Button t4k3 = new Button("  3  ");
        t4k3.setLayoutX(160);
        t4k3.setLayoutY(440);

        t4k3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t4typingtf.getText()+"3";
                t4typingtf.setText(a);
            }
        });

        Button t4k4 = new Button("  4  ");
        t4k4.setLayoutX(200);
        t4k4.setLayoutY(440);

        t4k4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t4typingtf.getText()+"4";
                t4typingtf.setText(a);
            }
        });

        Button t4k5 = new Button("  5  ");
        t4k5.setLayoutX(240);
        t4k5.setLayoutY(440);

        t4k5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t4typingtf.getText()+"5";
                t4typingtf.setText(a);
            }
        });

        Button t4k6 = new Button("  6  ");
        t4k6.setLayoutX(280);
        t4k6.setLayoutY(440);

        t4k6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t4typingtf.getText()+"6";
                t4typingtf.setText(a);
            }
        });

        Button t4k7 = new Button("  7  ");
        t4k7.setLayoutX(320);
        t4k7.setLayoutY(440);

        t4k7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t4typingtf.getText()+"7";
                t4typingtf.setText(a);
            }
        });

        Button t4k8 = new Button("  8  ");
        t4k8.setLayoutX(360);
        t4k8.setLayoutY(440);

        t4k8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t4typingtf.getText()+"8";
                t4typingtf.setText(a);
            }
        });

        Button t4k9 = new Button("  9  ");
        t4k9.setLayoutX(400);
        t4k9.setLayoutY(440);

        t4k9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t4typingtf.getText()+"9";
                t4typingtf.setText(a);
            }
        });

        Button t4kDot = new Button("  .  ");
        t4kDot.setLayoutX(340);
        t4kDot.setLayoutY(480);

        t4kDot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t4typingtf.getText()+".";
                t4typingtf.setText(a);
            }
        });

        Button t4kDel = new Button("delete");
        t4kDel.setLayoutX(380);
        t4kDel.setLayoutY(480);

        t4kDel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String result = t4typingtf.getText();
                if ((result != null) && (result.length() > 0)) {
                    String c = result.substring(0, result.length() - 1);
                    t4typingtf.setText(c);
                }else t4typingtf.setText("");
            }
        });

        Button t4kMinus = new Button("  -  ");
        t4kMinus.setLayoutX(300);
        t4kMinus.setLayoutY(480);

        t4kMinus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String a = t4typingtf.getText()+"-";
                t4typingtf.setText(a);
            }
        });

        Button t4clear = new Button("clear");
        t4clear.setLayoutX(45);
        t4clear.setLayoutY(480);

        t4clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t4typingtf.setText("");
            }
        });


        Button t4setBtn1 = new Button("Set typed value\nas 'Time in years'");
        t4setBtn1.setLayoutX(20);
        t4setBtn1.setLayoutY(340);

        t4setBtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = t4typingtf.getText();
                t4tf1.setText(b);
                t4typingtf.setText("");
            }
        });

        Button t4setBtn2 = new Button("Set typed value\nas 'Interest rate'");
        t4setBtn2.setLayoutX(140);
        t4setBtn2.setLayoutY(340);

        t4setBtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = t4typingtf.getText();
                t4tf2.setText(b);
                t4typingtf.setText("");
            }
        });

        Button t4setBtn4 = new Button("Set typed value\nas 'Future value'");
        t4setBtn4.setLayoutX(260);
        t4setBtn4.setLayoutY(340);

        t4setBtn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = t4typingtf.getText();
                t4tf4.setText(b);
                t4typingtf.setText("");
            }
        });

        Button t4setBtn5 = new Button("Set typed value as 'Number of\ncompound payments per year'");
        t4setBtn5.setLayoutX(380);
        t4setBtn5.setLayoutY(340);

        t4setBtn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String b = t4typingtf.getText();
                t4tf5.setText(b);
                t4typingtf.setText("");
            }
        });

        Button t4clearbtn1 = new Button("clear ^");
        t4clearbtn1.setLayoutX(45);
        t4clearbtn1.setLayoutY(390);

        t4clearbtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t4tf1.setText("");
            }
        });

        Button t4clearbtn2 = new Button("clear ^");
        t4clearbtn2.setLayoutX(170);
        t4clearbtn2.setLayoutY(390);

        t4clearbtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t4tf2.setText("");
            }
        });

        Button t4clearbtn3 = new Button("clear ^");
        t4clearbtn3.setLayoutX(280);
        t4clearbtn3.setLayoutY(390);

        t4clearbtn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t4tf4.setText("");
            }
        });

        Button t4clearbtn4 = new Button("clear ^");
        t4clearbtn4.setLayoutX(430);
        t4clearbtn4.setLayoutY(390);

        t4clearbtn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t4tf5.setText("");
            }
        });

//        Keyboard ended here

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

        //keyboard children
        t4aPane.getChildren().add(t4k0);
        t4aPane.getChildren().add(t4k1);
        t4aPane.getChildren().add(t4k2);
        t4aPane.getChildren().add(t4k3);
        t4aPane.getChildren().add(t4k4);
        t4aPane.getChildren().add(t4k5);
        t4aPane.getChildren().add(t4k6);
        t4aPane.getChildren().add(t4k7);
        t4aPane.getChildren().add(t4k8);
        t4aPane.getChildren().add(t4k9);
        t4aPane.getChildren().add(t4kDot);
        t4aPane.getChildren().add(t4kDel);
        t4aPane.getChildren().add(t4typingtf);
        t4aPane.getChildren().add(t4setBtn1);
        t4aPane.getChildren().add(t4setBtn2);
        t4aPane.getChildren().add(t4setBtn4);
        t4aPane.getChildren().add(t4setBtn5);
        t4aPane.getChildren().add(t4kMinus);
        t4aPane.getChildren().add(t4clear);
        t4aPane.getChildren().add(t4clearbtn1);
        t4aPane.getChildren().add(t4clearbtn2);
        t4aPane.getChildren().add(t4clearbtn3);
        t4aPane.getChildren().add(t4clearbtn4);
//keyboard children ended
        secondStage.setResizable(false);
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

            double r = n * (Math.pow((A / P), (1 / (n * t))) - 1)*100;
            double roundedR = Math.round(r * 100.0) / 100.0;
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
            double roundedA = Math.round(A * 100.0) / 100.0;
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
//four text fields
    public void setPersistentValues(TextField tfp1, TextField tfp2, TextField tfp3, TextField tfp4, String reg1, String reg2, String reg3, String reg4){
        try {
            Scanner s = new Scanner(new File("StoredData.txt"));
            while (s.hasNext()){
                String row = s.nextLine();
                if (row.contains(reg1)){
                    String[] splitRow = row.split("\\s+");
                    tfp1.appendText(splitRow[1]);
                } else if (row.contains(reg2)){
                    String[] splitRow = row.split("\\s+");
                    tfp2.appendText(splitRow[1]);
                }else if (row.contains(reg3)){
                    String[] splitRow = row.split("\\s+");
                    tfp3.appendText(splitRow[1]);
                }else if (row.contains(reg4)){
                    String[] splitRow = row.split("\\s+");
                    tfp4.appendText(splitRow[1]);
                }else {
                    System.out.println("Initial - comp sav");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

