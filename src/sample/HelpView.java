package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelpView {
    public void help() throws IOException{
        Stage sixthStage = new Stage();
        sixthStage.setTitle("Help");
        Pane root6 = new Pane();

        Main homepg = new Main();
        Stage mainStage = new Stage();

        Label t4lbl1 = new Label("\t\t\tWelcome\n\n* Please enter relevant details to get the accurate " +
                "results. \n* Always enter your all details asked here in numbers without using any letters or " +
                "special characteristics.\n* Do not continue with empty cells.");
        t4lbl1.setLayoutX(50);
        t4lbl1.setLayoutY(100);

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

        root6.getChildren().add(t4lbl1);
        root6.getChildren().add(homebtn);

        Scene scene = new Scene(root6,700,600);
        sixthStage.setScene(scene);
        sixthStage.show();
    }
}
