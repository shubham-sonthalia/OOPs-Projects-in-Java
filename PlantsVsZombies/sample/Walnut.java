package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Walnut extends Plants {

    Walnut(int x, int y, GridPane gp) throws FileNotFoundException {
        super(x, y);
        this.setPrice(25);
        FileInputStream inputstreamsplan = new FileInputStream("walnut.gif");
        Image imagespla = new Image(inputstreamsplan, 40, 40, false, false);
        ImageView splant = new ImageView(imagespla);
        gp.add(splant, x, y);
        this.setImage(splant);
    }
}
