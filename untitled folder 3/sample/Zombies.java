package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class Zombies
{
    private ImageView image;
    private int health;
    private String name;
    private int CurPosX;
    private int CurPosY;
    private boolean stop = false;
    public Zombies(int x, int y)
    {
        CurPosX = x;
        CurPosY = y;
    }
    public void setCurPosX(int x)
    {
        CurPosX = x;
    }
    public int getCurPosX() {
        return CurPosX;
    }
    public int getCurPosY() {
        return CurPosY;
    }
    public int getHealth() {
        return health;
    }
    public String getName() {
        return name;
    }
    public void setHealth(int num)
    {
        this.health = num;
    }
    public void setName(String name1)
    {
        name = name1;
    }
    public ImageView getImage()
    {
        return image;
    }
    public void setImage(ImageView img)
    {
        image = img;
    }
    public boolean getStop()
    {
        return stop;
    }
    public void setStop(boolean t)
    {
        stop = t;
    }
}
class NZombie extends Zombies
{
    private Duration dur;
    private int lX;
    public NZombie(int x, int y, GridPane gp) throws FileNotFoundException
    {
        super(x, y);
        lX = 1254;
        this.setHealth(80);
        this.setName("NZombie");
        FileInputStream inputstreamnorz = new FileInputStream("pz4.gif");
        Image imagenorz = new Image(inputstreamnorz, 50, 50, false, false);
        ImageView norz = new ImageView(imagenorz);
        this.setImage(norz);
        norz.relocate(x,y);
       gp.add(this.getImage(), x, y);
        dur = Duration.millis(100000);
        TranslateTransition translation = new TranslateTransition(dur, norz);
        translation.setByX(-1000);
        translation.play();
//        KeyFrame kf = new KeyFrame(Duration.millis(10), new TimeHandler(this));
//        Timeline timeline = new Timeline(kf);
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();
    }

//    class TimeHandler implements EventHandler<ActionEvent>
//    {
//        NZombie z;
//        public TimeHandler(NZombie z1)
//        {
//            z = z1;
//        }
//        @Override
//        public void handle(ActionEvent e)
//        {
//            z.getImage().setLayoutX(z.getImage().getLayoutX()-1);
//        }
//    }
}
class CZombie extends Zombies{
    private Duration dur;
    public CZombie(int x, int y, GridPane gp) throws FileNotFoundException
    {
        super(x,y);
        this.setHealth(150);
        this.setName("CZombie");
        FileInputStream inputstreamnorz = new FileInputStream("z3.gif");
        Image imagenorz = new Image(inputstreamnorz, 50, 50, false, false);
        ImageView norz = new ImageView(imagenorz);
        this.setImage(norz);
        gp.add(norz, x, y);
        dur = Duration.millis(100000);
        TranslateTransition translation = new TranslateTransition(dur, norz);
        translation.setByX(-1000);
        translation.play();
    }
}
class NPZombie extends Zombies implements Movable{
    private Duration dur;
    public NPZombie(int x, int y, GridPane gp) throws FileNotFoundException {
        super(x,y);
        this.setHealth(150);
        this.setName("NewsPaperZombie");
        FileInputStream inputstreamnorz = new FileInputStream("nz.png");
        Image imagenorz = new Image(inputstreamnorz, 50, 50, false, false);
        ImageView norz = new ImageView(imagenorz);
        this.setImage(norz);
        gp.add(norz, x, y);
        KeyFrame kf = new KeyFrame(Duration.millis(10), new TimeHandler());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
//        dur = Duration.millis(100000);
//        TranslateTransition translation = new TranslateTransition(dur, norz);
//        translation.setByX(-1000);
//        translation.play();
    }
    @Override
    public void move()
    {
        this.getImage().setX(this.getImage().getX() - 1);
    }
    class TimeHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
            NPZombie.this.move();
        }
    }
}
class BZombie extends Zombies{
    private Duration dur;
    public BZombie(int x,  int y, GridPane gp) throws FileNotFoundException
    {
        super(x,y);
        this.setHealth(150);
        this.setName("BucketZombie");
        FileInputStream inputstreamnorz = new FileInputStream("bh.png");
        Image imagenorz = new Image(inputstreamnorz, 50, 50, false, false);
        ImageView norz = new ImageView(imagenorz);
        this.setImage(norz);
        gp.add(norz, x, y);
        dur = Duration.millis(100000);
        TranslateTransition translation = new TranslateTransition(dur, norz);
        translation.setByX(-1000);
        translation.play();
    }
}