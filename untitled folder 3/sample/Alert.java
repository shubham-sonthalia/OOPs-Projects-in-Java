package sample;

import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Alert {
    Button save = new Button("Save Progress");
    Button restart = new Button("Restart Level");
    Button mainb = new Button("Main menu");
    Button close = new Button("Close");
    int g=0;
    FileInputStream inputstreamp = new FileInputStream("pz3.jpg");
    Image image = new Image(inputstreamp);

    public Alert() throws FileNotFoundException {
    }

    public int displaynew() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Options");
        HBox mena = new HBox(10);
        BackgroundImage backgroundimageh = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimageh);
        mena.setBackground(background);
        mena.getChildren().addAll(save,restart,mainb);
        mena.setAlignment(Pos.CENTER);
        ////////////////////////////////////////
        save.setOnAction(e-> {
            g=1;
            window.close();
        });
        restart.setOnAction(e-> {
            g=2;
            window.close();
        });
        mainb.setOnAction(e -> {
            g=3;
            window.close();
        });

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(mena,350,100);
        scene.getStylesheets().add(Main.class.getResource("homebuttons.css").toExternalForm());
        window.setScene(scene);
        window.showAndWait();
        return g;

    }
    public int displayres(){
        BackgroundImage backgroundimageh = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimageh);
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Saved Games");
        Label holdon = new Label("Currently, there are no saved games");
        VBox es = new VBox(10);
        es.setBackground(background);
        es.setAlignment(Pos.CENTER);
        close.setOnAction(e-> window.close());
        es.getChildren().addAll(holdon,close);
        Scene scene = new Scene(es,200,300);
        scene.getStylesheets().add(Main.class.getResource("homebuttons.css").toExternalForm());
        window.setScene(scene);
        window.showAndWait();







        return g;

    }

}
