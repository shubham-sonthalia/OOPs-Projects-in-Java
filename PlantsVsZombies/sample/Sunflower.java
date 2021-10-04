package sample;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Sunflower extends Plants {
    Button button;
    public Sunflower(int x, int y, GridPane gp) throws FileNotFoundException {
        super(x,y);
        this.setPrice(50);
        FileInputStream inputstreamsplan = new FileInputStream("pz5.gif");
        Image imagespla = new Image(inputstreamsplan, 50, 50, false, false);
        ImageView splant = new ImageView(imagespla);
        gp.add(splant, x, y);
//        gp.add(button, x, y);
        this.setImage(splant);

    }
    public ImageView SunCreate(GridPane gp) throws FileNotFoundException {
        SunTokens suns = new SunTokens(this.getPosX(), this.getPosY(), gp );
        return suns.getImage();
    }
    public Button getButton()
    {return button;}
//    public void collectSun()
//    {
//        button.setOnAction(e -> {
//            System.out.println("Hello");
//        });
//    }
}
