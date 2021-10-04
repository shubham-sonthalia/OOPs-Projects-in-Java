package sample;

import javafx.scene.layout.GridPane;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ZombieCreator implements Runnable{
    private GridPane gp;
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ZombieCreator()
    {
        list.add(2);
        list.add(5);
        list.add(8);
        list.add(10);
        list.add(12);
        Collections.shuffle(list);
    }
    public void setGridPane(GridPane gp1)
    {
        gp = gp1;
    }
    public GridPane getGridPane()
    {
        return gp;
    }
    public synchronized void run()
    {
        for( int i = 0; i < 5; i++)
        {

            try {
                NZombie zombie = new NZombie(24, list.get(i), this.getGridPane());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }




    }

}
