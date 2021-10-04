package sample;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.IOException;

interface Movable
{
    public void move();
}

public class PeaBullet implements Movable  {
    private ImageView image;
    private int PosX;
    private int PosY;

    public PeaBullet(int x, int y, GridPane gp) throws IOException
    {
        PosY = y;
        PosX = x;
        FileInputStream OptionPlant3 = new FileInputStream("bullet.png");
        Image imageplant3 = new Image(OptionPlant3, 15, 15, false, false);
        ImageView splant3 = new ImageView(imageplant3);
        this.image = splant3;
        gp.add(this.image, x, y);
    }
    public int getPosX()
    {
        return PosX;
    }

    public int getPosY() {
        return PosY;
    }
    public ImageView getImage()
    {
        return image;
    }
    @Override
    public void move()
    {
        PosX = PosX + 1;
    }
}
