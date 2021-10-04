package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class SunTokens implements Movable{
    private ImageView image;
    private int PosX;
    private int PosY;
    public SunTokens(int x, int y, GridPane gp) throws FileNotFoundException {
        PosX= x;
        PosY = y;
        FileInputStream OptionPlant2= new FileInputStream("sun.png");
        Image imageplant2 = new Image(OptionPlant2, 40, 40, false, false);
        ImageView splant2 = new ImageView(imageplant2);
        image = splant2;
        gp.add(this.getImage(), x, y);
    }
    public SunTokens(GridPane gp) throws FileNotFoundException {
        Random r1 = new Random();
        PosX = r1.nextInt(21) + 4;
        PosY = r1.nextInt(14);
        FileInputStream OptionPlant2= new FileInputStream("sun.png");
        Image imageplant2 = new Image(OptionPlant2, 60, 60, false, false);
        ImageView splant2 = new ImageView(imageplant2);
        image = splant2;
        gp.add(this.getImage(), PosX, PosY);
    }
    public ImageView getImage()
    {
        return image;
    }
    @Override
    public void move()
    {

    }

}
