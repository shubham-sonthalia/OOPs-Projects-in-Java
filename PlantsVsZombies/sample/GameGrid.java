package sample;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class GameGrid {
    private GridPane gp;
    private Level level;
    private Button NewGame;
    private Button ResumeGame;
    private Button ExitGame;
    private Button Options;
    private Label score;
    public GameGrid(Level level1) throws FileNotFoundException {
        gp = new GridPane();
        FileInputStream khaali = new FileInputStream("11.jpg");
        Image khali1 = new Image(khaali, 51.2, 51.2, false, false);
        ImageView khali2= new ImageView(khali1);
        ImageView khali3 = new ImageView(khali1);
        gp.add(khali2, 0, 5);
        gp.add(khali3, 0, 4);
        Label label1 = new Label();
        label1.setText("Sun Tokens:");
        gp.add(label1, 0, 4);
        score = new Label();
        score.setText("50");
        gp.add(score, 0,5);
        Options = new Button("Options");
        gp.add(Options, 23, 0);
        FileInputStream inputstreamgarden = new FileInputStream("pz2.jpg");
        Image imagegarden = new Image(inputstreamgarden, 1280, 720, false, false);
        BackgroundImage backgroundimagep = new BackgroundImage(imagegarden, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background backgroundp = new Background(backgroundimagep);
        gp.setBackground(backgroundp);

        ColumnConstraints C1 = new ColumnConstraints();
        C1.setPercentWidth(4);

        ColumnConstraints C2 = new ColumnConstraints();
        C2.setPercentWidth(4);
        ColumnConstraints C3 = new ColumnConstraints();
        C3.setPercentWidth(4);
        ColumnConstraints C4 = new ColumnConstraints();
        C4.setPercentWidth(4);
        ColumnConstraints C5 = new ColumnConstraints();
        C5.setPercentWidth(4);
        ColumnConstraints C6 = new ColumnConstraints();
        C6.setPercentWidth(4);
        ColumnConstraints C7 = new ColumnConstraints();
        C7.setPercentWidth(4);
        ColumnConstraints C8 = new ColumnConstraints();
        C8.setPercentWidth(4);
        ColumnConstraints C9 = new ColumnConstraints();
        C9.setPercentWidth(4);
        ColumnConstraints C10 = new ColumnConstraints();
        C10.setPercentWidth(4);
        ColumnConstraints C11 = new ColumnConstraints();
        C11.setPercentWidth(4);
        ColumnConstraints C12 = new ColumnConstraints();
        C12.setPercentWidth(4);
        ColumnConstraints C13 = new ColumnConstraints();
        C13.setPercentWidth(4);
        ColumnConstraints C14 = new ColumnConstraints();
        C14.setPercentWidth(4);
        ColumnConstraints C15 = new ColumnConstraints();
        C15.setPercentWidth(4);
        ColumnConstraints C16 = new ColumnConstraints();
        C16.setPercentWidth(4);
        ColumnConstraints C17 = new ColumnConstraints();
        C17.setPercentWidth(4);
        ColumnConstraints C18 = new ColumnConstraints();
        C18.setPercentWidth(4);
        ColumnConstraints C19 = new ColumnConstraints();
        C19.setPercentWidth(4);
        ColumnConstraints C20 = new ColumnConstraints();
        C20.setPercentWidth(4);
        ColumnConstraints C21 = new ColumnConstraints();
        C21.setPercentWidth(4);
        ColumnConstraints C22 = new ColumnConstraints();
        C22.setPercentWidth(4);
        ColumnConstraints C23 = new ColumnConstraints();
        C23.setPercentWidth(4);
        ColumnConstraints C24 = new ColumnConstraints();
        C24.setPercentWidth(4);
        ColumnConstraints C25 = new ColumnConstraints();
        C25.setPercentWidth(4);
        RowConstraints R1 = new RowConstraints();
        R1.setPercentHeight(14.0625);
        RowConstraints R2 = new RowConstraints();
        R2.setPercentHeight(14.0625);
        RowConstraints R3 = new RowConstraints();
        R3.setPercentHeight(14.0625);
        RowConstraints R4 = new RowConstraints();
        R4.setPercentHeight(14.0625);
        RowConstraints R5 = new RowConstraints();
        R5.setPercentHeight(14.0625);
        RowConstraints R6 = new RowConstraints();
        R6.setPercentHeight(14.0625);
        RowConstraints R7 = new RowConstraints();
        R7.setPercentHeight(14.0625);
        RowConstraints R8 = new RowConstraints();
        R8.setPercentHeight(14.0625);
        RowConstraints R9 = new RowConstraints();
        R9.setPercentHeight(14.0625);
        RowConstraints R10 = new RowConstraints();
        R10.setPercentHeight(14.0625);
        RowConstraints R11 = new RowConstraints();
        R11.setPercentHeight(14.0625);
        RowConstraints R12 = new RowConstraints();
        R12.setPercentHeight(14.0625);
        RowConstraints R13 = new RowConstraints();
        R13.setPercentHeight(14.0625);
        RowConstraints R14 = new RowConstraints();
        R14.setPercentHeight(14.0625);
        gp.getColumnConstraints().addAll(C1,C2, C3, C4, C5, C6, C7, C8, C10, C9, C11, C12, C13, C14, C15, C16, C17, C18, C19, C20, C21, C22, C23, C24, C25);
        gp.getRowConstraints().addAll(R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14);
        FileInputStream inputstreamslawn = new FileInputStream("pz8.png");
        Image imagelawn = new Image(inputstreamslawn, 50, 50, false, false);
        ImageView l1 = new ImageView(imagelawn);
        ImageView l2 = new ImageView(imagelawn);
        ImageView l3 = new ImageView(imagelawn);
        ImageView l4 = new ImageView(imagelawn);
        ImageView l5 = new ImageView(imagelawn);
        gp.add(l1,3, 2 );
        gp.add(l2,3, 5 );
        gp.add(l3,3, 8);
        gp.add(l4,3, 10);
        gp.add(l5,3, 12 );

        FileInputStream OptionPlant2= new FileInputStream("2.jpg");
        Image imageplant2 = new Image(OptionPlant2, 50, 50, false, false);
        ImageView splant2 = new ImageView(imageplant2);

        FileInputStream OptionPlant1 = new FileInputStream("1.jpg");
        Image imageplant1 = new Image(OptionPlant1, 50,50, false, false);
        ImageView splant1 = new ImageView(imageplant1);

        FileInputStream OptionPlant3 = new FileInputStream("3.jpg");
        Image imageplant3 = new Image(OptionPlant3, 50, 50, false, false);
        ImageView splant3 = new ImageView(imageplant3);

        FileInputStream OptionPlant4 = new FileInputStream("4.jpg");
        Image imageplant4 = new Image(OptionPlant4, 50, 50, false, false);
        ImageView splant4 = new ImageView(imageplant4);

        level = level1;
        if (level.getType() == 1)
        {
            gp.add(splant1, 0,8);
            gp.add(splant2, 0,9);
        }
        if(level.getType() == 2)
        {
            gp.add(splant1, 0,8);
            gp.add(splant2, 0,9);
            gp.add(splant3, 0, 10);
        }
        if(level.getType() >= 3) {
            gp.add(splant1, 0, 8);
            gp.add(splant2, 0, 9);
            gp.add(splant3, 0, 10);
            gp.add(splant4, 0, 11);
        }
    }
    public GameGrid() throws FileNotFoundException {
        gp = new GridPane();
        gp.setPadding(new Insets(10,10,10,10));
        gp.setHgap(8);gp.setVgap(6);
        FileInputStream inputstreamhome = new FileInputStream("pz1.jpg");
        Image imagehome = new Image(inputstreamhome);
        BackgroundImage backgroundimageh = new BackgroundImage(imagehome, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimageh);
        gp.setBackground(background);
        NewGame = new Button("New Game");
        ResumeGame =new Button("Load Game");
        ExitGame = new Button("Exit Game");
        GridPane.setConstraints(NewGame,45,39);
        GridPane.setConstraints(ResumeGame,45,40);
        GridPane.setConstraints(ExitGame,45,41);
        gp.getChildren().addAll(NewGame,ResumeGame,ExitGame);


    }

    public GridPane getGridPane() {
        return gp;
    }

    public Button getExitGame() {
        return ExitGame;
    }

    public Button getResumeGame() {
        return ResumeGame;
    }

    public Button getNewGame() {
        return NewGame;
    }

    public Button getOptions() {
        return Options;
    }
    public Label getScore()
    {
        return score;
    }
}
