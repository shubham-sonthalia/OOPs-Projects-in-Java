package sample;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Confirm {
    boolean status;

    public boolean  display(String title, String message) {
        Stage window = new Stage();
        Button b1 = new Button("YES");
        Button b2 = new Button("NO");
        b1.setOnAction(e -> {status=true;
            window.close();} );
        b2.setOnAction(e -> {status=false;window.close();});
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label label = new Label();
        label.setText(message);


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,b1,b2);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout,250,250);
        window.setScene(scene);
        window.showAndWait();
        return status;
    }

}

