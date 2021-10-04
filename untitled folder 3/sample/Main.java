package sample;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.util.Duration;


public class Main extends Application  {

    public Main() throws FileNotFoundException {
    }
    ArrayList<Plants> plants = new ArrayList<Plants>();
    String pname;
    int SunTokens = 50;
    boolean check = false;
    Point pressed = new Point(0,0);
    Stage window;
    Alert light = new Alert();
    Rectangle rect = new Rectangle(30,30,40,40);
    RotateTransition rotate = new RotateTransition();

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        GameGrid Home = new GameGrid();
      Scene scenehome = new Scene(Home.getGridPane(),800,600);
      scenehome.getStylesheets().add(Main.class.getResource("homebuttons.css").toExternalForm());
        window.setScene(scenehome);
        Level level = new Level(1);
        GameGrid Game = new GameGrid(level);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(10), new TimeHandler1(Game.getGridPane(), Game.getScore()));
        Timeline timeline = new Timeline(kf1);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        Scene scenep = new Scene(Game.getGridPane(),1280,720);
      ZombieCreator zombie = new ZombieCreator();
        zombie.setGridPane(Game.getGridPane());
        Thread t1 = new Thread(zombie);
        t1.start();
        t1.join();
        scenep.getStylesheets().add(Main.class.getResource("homebuttons.css").toExternalForm());
        scenep.setOnMousePressed(e -> {
                int x = (int) e.getX();
                int y = (int) e.getY();
                if ((x <= 51.2) && (y >= 410) && (y <= 619)) {
                    if ((y >= 410) && (y <= 462) && (Integer.parseInt(Game.getScore().getText()) >= 100)) {
                        check = true;
                        pname = "PPlant";
                        Game.getScore().setText(Integer.toString(Integer.parseInt(Game.getScore().getText()) - 100));
                        }
                    if ((y >= 463) && (y <= 516) && (Integer.parseInt(Game.getScore().getText()) >= 50)) {
                        check = true;
                        pname = "Sunflower";
                        Game.getScore().setText(Integer.toString(Integer.parseInt(Game.getScore().getText()) - 50));

                    }
                    if ((y >= 517) && (y <= 566) && (Integer.parseInt(Game.getScore().getText()) >= 25)) {
                        check = true;
                        pname = "Walnut";
                        Game.getScore().setText(Integer.toString(Integer.parseInt(Game.getScore().getText()) - 25));
                    }
                    if ((y >= 567) && (y <= 619) && (Integer.parseInt(Game.getScore().getText()) >= 125)) {
                        check = true;
                        pname = "Chilly";
                        Game.getScore().setText(Integer.toString(Integer.parseInt(Game.getScore().getText()) - 125));
                    }
                } else {
                    if (check == true && (x >= 258) && (y >= 54) && (y <= 670)) {
                        int xPos = (int) Math.round(x / 50);
                        int yPos = (int) Math.round(y / 50);
                        if (yPos == 2 || yPos == 5 || yPos == 8 || yPos == 10 || yPos == 12) {
                            if (pname.equals("PPlant")) {
                                try {
                                    PeaPlant p = new PeaPlant(xPos, yPos, Game.getGridPane());
                                    plants.add(p);
                                    KeyFrame kf2 = new KeyFrame(Duration.seconds(3), new TimeHandler2(Game.getGridPane(), p));
                                    Timeline timeline2 = new Timeline(kf2);
                                    timeline2.setCycleCount(Animation.INDEFINITE);
                                    timeline2.play();

                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            if (pname.equals("Sunflower")) {
                                try {
                                    Sunflower sunflower = new Sunflower(xPos, yPos, Game.getGridPane());
                                    plants.add(sunflower);
                                    KeyFrame kf = new KeyFrame(Duration.seconds(10), new TimeHandler(sunflower, Game.getGridPane(), scenep, Game.getScore()));
                                    Timeline timeline1 = new Timeline(kf);
                                    timeline1.setCycleCount(Animation.INDEFINITE);
                                    timeline1.play();
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            if (pname.equals("Walnut")) {
                                try {
                                    Walnut walnut = new Walnut(xPos, yPos, Game.getGridPane());
                                    plants.add(walnut);
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            if (pname.equals("Chilly")) {
                                try {
                                    Chilly chilly = new Chilly(xPos, yPos, Game.getGridPane());
                                    plants.add(chilly);
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                            }
                            check = false;
                        }
                    }
                }
        });
        Home.getNewGame().setOnAction(e-> window.setScene(scenep));
        Game.getOptions().setOnAction(e-> {
            int g = light.displaynew();
            if (g==1){
                window.close();

            }
            else if(g==3){
                window.setScene(scenehome);

            }
        });
///////////////////////////////////////////////////////
        Home.getResumeGame().setOnAction(e-> {
            int g = light.displayres();

        });



//////////////////////////////////
        Home.getExitGame().setOnAction(e-> window.close());

        window.show();


    }
    public Point DoIt(MouseEvent e)
    {
        Point p = new Point(e.getX(), e.getY());
        return p;
    }


    public static void main(String[] args) {
        launch(args);
    }

}

class Point
{
   private int X;
    private int Y;
    public Point(int x, int y)
    {
        X= x;
        Y= y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
class TimeHandler implements EventHandler<ActionEvent>
{
    GridPane gp;
    Sunflower sf;
    Scene sc;
    Label l1;
    public TimeHandler(Sunflower sf1, GridPane gp1, Scene sc1, Label l11)
    {
        sf = sf1;
        gp = gp1;
        sc = sc1;
        l1 = l11;
    }
    public void handle(ActionEvent event)
    {
        try {
            ImageView img = sf.SunCreate(gp);
            img.setOnMouseClicked(z -> {
                gp.getChildren().remove(img);
                l1.setText(Integer.toString(Integer.parseInt(l1.getText()) + 25));


            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class TimeHandler1 implements EventHandler<ActionEvent>
{
    GridPane gp;
    Label l1;
    public TimeHandler1(GridPane gp1, Label l11)
    {
        gp = gp1;
        l1 = l11;
    }
    @Override
    public void handle(ActionEvent e)
    {
        try {
            SunTokens st = new SunTokens(gp);
            ImageView img = st.getImage();
            img.setOnMouseClicked(z -> {
                gp.getChildren().remove(img);
                l1.setText(Integer.toString(Integer.parseInt(l1.getText()) + 25));
            });
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
class TimeHandler2 implements EventHandler<ActionEvent>
{
    GridPane gp;
    PeaPlant pp;

    public TimeHandler2(GridPane gp1, PeaPlant pp1)
    {
        gp = gp1;
        pp = pp1;

    }
    @Override
    public void handle(ActionEvent e)
    {
        try {
            ImageView img = pp.createPea();
            KeyFrame kf = new KeyFrame(Duration.seconds(3), new TimeHandler3(gp, img));
            Timeline timeline = new Timeline(kf);
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
class TimeHandler3 implements EventHandler<ActionEvent>
{
    GridPane gp;
    ImageView img;

    public TimeHandler3(GridPane gp1, ImageView img1)
    {
        gp = gp1;
        img = img1;
    }
    @Override
    public void handle(ActionEvent e)
    {
        Duration dur = Duration.millis(10000);
        TranslateTransition translation = new TranslateTransition(dur, img);
        translation.setByX(1000);
        translation.play();
    }
}

