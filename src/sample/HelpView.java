package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class HelpView {
    public void help() throws IOException{
        Stage sixthStage = new Stage();
        sixthStage.setTitle("Help");
        Pane root6 = new Pane();

        Main homepg = new Main();
        Stage mainStage = new Stage();

        Label lbl4 = new Label("\t\t\tHelp View");
        lbl4.setLayoutX(50);
        lbl4.setLayoutY(50);
        lbl4.setFont(Font.font("Verdana", FontWeight.BOLD, 18));

        Label lbl1 = new Label("* Please enter relevant details to get the accurate " +
                "results. \n* Always enter your all details asked here in numbers without using any letters or " +
                "special characteristics.\n* Do not continue with empty cells.\n* When entering interest rate, it " +
                "should be written in decimals (Eg-: 22% means 0.22)\n* Home - You can navigate to home screen" +
                " using “Home” button placed in any screen.\n* App Keyboard - Enter the value through the app " +
                "keyboard placed below each screen. \nAfter entering please press the relevant ’set as’ button " +
                "to set the value to relevant text field.\n* Clear - Entered value through the app " +
                "keyboard which is placed in typing text field will be cleared.\n* Clear^ - Value entered to " +
                "respective text field will be cleared. (The relevant text field can be identified \nas the text " +
                "setting button is placed on top of this.)");
        lbl1.setLayoutX(50);
        lbl1.setLayoutY(100);

        Label lbl5 = new Label("Privacy Contents");
        lbl5.setLayoutX(50);
        lbl5.setLayoutY(280);
        lbl5.setFont(Font.font("Verdana", FontWeight.BOLD, 10));

        Label lbl2 = new Label("* Our app can store the data that you are entering" +
                " here.");
        lbl2.setLayoutX(50);
        lbl2.setLayoutY(300);

        Label lbl3 = new Label("Thank you for using our app!");
        lbl3.setLayoutX(50);
        lbl3.setLayoutY(400);
//Image
        FileInputStream input = new FileInputStream("Images/Help.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(250);
        imageView.setFitWidth(250);
        imageView.setLayoutX(390);
        imageView.setLayoutY(300);

        //    Home button

        Button homebtn = new Button("Home");
        homebtn.setLayoutX(100);
        homebtn.setLayoutY(500);


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

        root6.getChildren().add(lbl1);
        root6.getChildren().add(lbl2);
        root6.getChildren().add(lbl3);
        root6.getChildren().add(lbl4);
        root6.getChildren().add(lbl5);
        root6.getChildren().add(homebtn);
        root6.getChildren().add(imageView);

        sixthStage.setResizable(false);
        Scene scene = new Scene(root6,700,600);
        sixthStage.setScene(scene);
        sixthStage.show();
    }
}
