package sample;

import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PeaPlant extends Plants {
    private PeaBullet pb;
    private boolean peavisible;
    private GridPane gp;
    public PeaPlant(int x, int y, GridPane gp1) throws IOException {
        super(x, y);
        this.setPrice(100);
        gp = gp1;
        FileInputStream inputstreampplan = new FileInputStream("pz6.gif");
        Image imagepla = new Image(inputstreampplan,50,50,false, false);
        ImageView pplant = new ImageView(imagepla);
        this.setImage(pplant);
        gp.add(this.getImage(), x, y);
   }
   public ImageView createPea() throws IOException {
       pb = new PeaBullet(this.getPosX(), this.getPosY(), gp);
       return pb.getImage();
   }
    public PeaBullet getPeaBullet()
    {
        return pb;
    }
}
