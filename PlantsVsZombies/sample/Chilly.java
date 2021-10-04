package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Chilly extends Plants {
    public Chilly(int x, int y, GridPane gp) throws FileNotFoundException {
        super(x, y);
        this.setPrice(125);
        FileInputStream inputstreamsplan = new FileInputStream("Jalapeno1.png");
        Image imagespla = new Image(inputstreamsplan, 50, 50, false, false);
        ImageView splant = new ImageView(imagespla);
        gp.add(splant, x, y);
        this.setImage(splant);
    }
}
