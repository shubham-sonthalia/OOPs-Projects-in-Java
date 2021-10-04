import java.util.*;
import java.util.concurrent.TimeUnit;

class SnakeBiteException extends RuntimeException{
    public SnakeBiteException(String message)
    {
        super(message);
    }
}
class CricketBiteException extends RuntimeException{
    public CricketBiteException(String message)
    {
        super(message);
    }
}
class VultureBiteException extends RuntimeException{
    public VultureBiteException(String message)
    {
        super(message);
    }
}
class TrampolineException extends RuntimeException{
    public TrampolineException(String message)
    {
        super(message);
    }
}
class GameWinnerException extends RuntimeException{
    public GameWinnerException(String message)
    {
        super(message);
    }
}
class StartWithSixException extends RuntimeException{
    public StartWithSixException(String message)
    {
        super(message);
    }
}
class MaxTilesException extends RuntimeException{
    public MaxTilesException(String message)
    {
        super(message);
    }
}

public class Game
{
    private static long Max_Tiles;
    private static String user;
    private static int counter = 1;
    private static int snake_bite = 0;
    private static int vulture_bite = 0;
    private static int cricket_bite = 0;
    private static int trampolines = 0;
    public static void main(String[] args) {
        boolean done = false;
        Scanner input = new Scanner(System.in);
        Dice d1 = new Dice();
        while(!done)
        {
            System.out.println(">>Enter the number of tiles on the race track(length)");
            try{
                long num = input.nextLong();
                try{
                    if (num > 10)
                    {
                        Max_Tiles = num;
                        done = true;
                    }
                    else if(num <=10)
                    {
                        throw new MaxTilesException("MaxTilesException Caused");
                    }
                }
                catch(MaxTilesException m)
                {
                    System.out.println(">>Please enter a number greater than 10");
                    System.out.println(">>Try Again");
                }

            }
            catch(InputMismatchException in) {
                System.out.println(">>Wrong Input");
                System.out.println(">>Try again");
            }
        }
        System.out.println(">>Setting up the race track...");
        Tiles.setMax(Max_Tiles);
        Snake.setNumber_Of_Tiles();
        Vulture.setNumber_Of_Tiles();
        Cricket.setNumber_Of_Tiles();
        Trampoline.setNumber_Of_Tiles();
        White.setNumber_Of_Tiles();
        Snake.setSteps();
        Vulture.setSteps();
        Cricket.setSteps();
        Trampoline.setSteps();
        System.out.println(">>Danger: There are " + Snake.getNumber_Of_Tiles() + ", " + Cricket.getNumber_Of_Tiles() + ", "+
                Vulture.getNumber_Of_Tiles() + " numbers of Snakes, Cricket and Vultures respectively on your track!");
        System.out.println(">>Danger: Each Snake, Cricket, and Vultures can throw you back by " + Snake.getSteps() +
        " " + Cricket.getSteps() + " " + Vulture.getSteps() + " number of tiles respectively!");
        System.out.println(">>Good News: There are " + Trampoline.getNumber_Of_Tiles() + " number of Trampolines on your track!");
        System.out.println(">>Good News: Each Trampoline can help you advance by " + Trampoline.getSteps() + " number of tiles");
        System.out.println(">>Number of White tiles: " + White.getNumber_Of_Tiles());
        boolean done2 = false;
        while(!done2)
        {
            System.out.println(">>Enter the player name");
            try{
                Scanner un = new Scanner(System.in);
                String name = un.next();
                user = name;
                done2 = true;
            }
            catch(InputMismatchException im)
            {
                System.out.println(">> Please enter a valid name");
                System.out.println(">> Try Again");
            }
        }
            System.out.println(">>Starting the game with " + user + " at Tile-1");
            System.out.println(">>Control transferred to the Computer for rolling the Dice for " + user);

        boolean done1 = false;
        while(!done1){
            System.out.println(">>Hit enter to start the game");
            try{
                Scanner in=new Scanner(System.in);
                String Enter = in.nextLine();
                if (Enter.equals(""))
                {
                    System.out.println(">>Game Started === === === === ===>>>>");
                    done1 = true;
                }
                else{
                    throw new InputMismatchException("wrong input");
                }
            }
            catch(InputMismatchException ip)
            {
                System.out.println(">>Please press return key to start the game.");
                System.out.println(">>Try Again");
            }
        }

        MyGenericList<Tiles> Game_Map = new MyGenericList<Tiles>(Max_Tiles); // The arraylist where the
        // game will run
        try {
            for (int i = 0; i < (int) Snake.getNumber_Of_Tiles(); i++) {
                Tiles s1 = new Snake();
                Game_Map.add(s1);
            }
            for (int j = 0; j < (int) Vulture.getNumber_Of_Tiles(); j++) {
                Tiles v1 = new Vulture();
                Game_Map.add(v1);
            }
            for (int k = 0; k < (int) Cricket.getNumber_Of_Tiles(); k++) {
                Tiles c1 = new Cricket();
                Game_Map.add(c1);
            }
            for (int l = 0; l < (int) Trampoline.getNumber_Of_Tiles(); l++) {
                Tiles t1 = new Trampoline();
                Game_Map.add(t1);
            }
            for (int m = 0; m < White.getNumber_Of_Tiles(); m++) {
                Tiles w1 = new White();
                Game_Map.add(w1);
            }
        }
        catch (ArrayIndexOutOfBoundsException i)
        {
            System.out.println("The array is full");
        }
        Game_Map.Shuffle_The_List(); // Shuffling the list to get a random map of the game..
        Game_Map.remove((Game_Map.size() - 1));
        Tiles t2 = new White();
        Game_Map.add(t2);
        int pointer = 0;
        while(pointer != (Game_Map.size() - 1))
        {
           int num = d1.RollDice();
            System.out.println(">>[Roll-"+ counter + "]: " + user + " rolled " + num + " at Tile-" + (pointer + 1));
            counter++;
            try {
                if (pointer == 0) {
                    if (num != 6)
                    {
                        throw new StartWithSixException("Not Six");
                    }
                    else {
                        System.out.println("You are out of the cage! You get a free roll");
                        int num2 = d1.RollDice();
                        System.out.println(">>[Roll-"+ counter + "]: " + user + " rolled " + num2 + " at Tile-" + (pointer + 1));
                        counter++;
                        pointer += num2;
                    }
                }
                else {
                    if((pointer + num) >= (Game_Map.size() - 1))
                    {
                        try {
                            System.out.println(">>  " + user + " moved to Tile " + Game_Map.size() + " as it can't go ahead further");
                            pointer = Game_Map.size() - 1;
                            throw new GameWinnerException("Game won");
                        }
                        catch(GameWinnerException gm)
                        {
                            System.out.println(user + " wins the race in " + counter + " rolls");
                        }
                        finally{
                            System.out.println(">> Total snake Bites: " + snake_bite);
                            System.out.println(">> Total Vulture Bites: " + vulture_bite);
                            System.out.println(">> Total Cricket Bites: " + cricket_bite);
                            System.out.println(">> Total Trampolines: "+ trampolines);
                        }
                    }
                    else {
                        pointer = pointer + num;
                    }
                    if (pointer == Game_Map.size() - 1)
                    {
                        break;
                    }
                    System.out.println("landed on Tile " + (pointer + 1) );
                    System.out.println(">>   Trying to shake the Tile-" + (pointer + 1));
                    Tiles tempTile = Game_Map.get(pointer).ShakeTile(Game_Map, pointer);
                    if (tempTile instanceof Snake)
                    {
                        snake_bite++;
                        throw new SnakeBiteException("Snake here");
                    }
                    else if(tempTile instanceof Vulture)
                    {
                        vulture_bite++;
                        throw new VultureBiteException("Vulture here");
                    }
                    else if(tempTile instanceof Cricket)
                    {
                        cricket_bite++;
                        throw new CricketBiteException(("Cricket here"));
                    }
                    else if(tempTile instanceof Trampoline)
                    {
                        trampolines++;
                        throw new TrampolineException("Trampoline here");
                    }
                    else if (tempTile instanceof White)
                    {
                        System.out.println(">> I am a white tile!");
                        System.out.println(">> " + user + " moved to Tile-" + (pointer + 1));
                    }
                }
            }
            catch(StartWithSixException se)
            {
                System.out.print(", OOPs you need 6 to start.");
            }
            catch(SnakeBiteException sb)
            {
                System.out.println(">>   Hiss..! I am a snake, you go back " + Snake.getSteps() + " tiles");
                if (pointer - Snake.getSteps() <= 0)
                {
                    pointer = 0;
                    System.out.println(">>  " + user + " moved to Tile " + (pointer + 1) + " as it can't go back further");
                }
                else
                {
                    pointer = pointer - (int)Snake.getSteps();
                    System.out.println(">>  " + user + " moved to Tile " + (pointer + 1));
                }

            }
            catch(VultureBiteException vb)
            {
                System.out.println(">> Yapping..!! I am a Vulture, you go back " + Vulture.getSteps() + " tiles");
                if (pointer - Vulture.getSteps() <= 0)
                {
                    pointer = 0;
                    System.out.println(">>  " + user + " moved to Tile " + (pointer + 1) + " as it can't go back further");
                }
                else
                {
                    pointer = pointer - (int)Vulture.getSteps();
                    System.out.println(">>  " + user + " moved to Tile " + (pointer + 1));
                }
            }
            catch(CricketBiteException cb)
            {
                System.out.println(">> Chirp..!! I am a Cricket, you go back " + Cricket.getSteps() + " tiles");

                if ((pointer - Cricket.getSteps()) <= 0) {
                    pointer = 0;
                    System.out.println(">>  " + user + " moved to Tile " + (pointer + 1) + " as it can't go back further");
                } else {
                    pointer = pointer - (int)(Cricket.getSteps());
                    System.out.println(">>  " + user + " moved to Tile " + (pointer + 1));
                }
            }
            catch(TrampolineException tb)
            {
                System.out.println(">>  PingPong..!! I am a Trampoline, you advance " + Trampoline.getSteps()+ " tiles");
                if (pointer + Trampoline.getSteps() >= (Game_Map.size() - 1))
                {
                    try {
                        System.out.println(">>  " + user + " moved to Tile " + Game_Map.size() + " as it can't go ahead further");
                        pointer = Game_Map.size() - 1;
                        throw new GameWinnerException("Game won");
                    }
                    catch(GameWinnerException gm)
                    {
                        System.out.println(user + " wins the race in " + counter + " rolls");
                    }
                    finally{
                        System.out.println(">> Total snake Bites: " + snake_bite);
                        System.out.println(">> Total Vulture Bites: " + vulture_bite);
                        System.out.println(">> Total Cricket Bites: " + cricket_bite);
                        System.out.println(">> Total Trampolines: "+ trampolines);
                    }
                }
                else
                {
                    pointer = pointer + (int) Trampoline.getSteps();
                    System.out.println(">>  " + user + " moved to Tile " + (pointer + 1));
                }
            }

            //try
            //{
              //  TimeUnit.SECONDS.sleep(1);

            //}
           // catch ( InterruptedException e)
            //{

            //}
        }
    }
}


// Dice Class;/////
final class Dice
{
    public int RollDice()
    {
        Random num1 = new Random();
        int n =  num1.nextInt(6) + 1;
        return n;
    }
}

//////////////////////////////////////////////
///// Tile Classes//////////////////////////////////
abstract class Tiles {
    private static long Max;
    public static long getMax() {
        return Max;
    }
    public static void setMax(long max) {
        Max = max;
    }
    public Tiles ShakeTile(MyGenericList mylist,int index)
    {
        Tiles t1 =  (Tiles) mylist.get(index);
        return t1;
    }
    protected abstract void ThrowException(MyGenericList mylist, int index);
}
class Snake extends Tiles{
    private static long Number_Of_Tiles;
    private static long steps;
    public static void setNumber_Of_Tiles()
    {
        Random number = new Random();
        int w = (int) Tiles.getMax();
        long n = (long) (number.nextInt(w/5) + 1);
        Number_Of_Tiles = n;
    }
    public static long getNumber_Of_Tiles()
    {
        return Number_Of_Tiles;
    }
    public static void setSteps()
    {
        Random number = new Random();
        long n = (long) (number.nextInt(10) + 1);
        steps = n;
    }
    public static long getSteps()
    {
        return steps;
    }
    @java.lang.Override
    public void ThrowException(MyGenericList mylist, int index)
    {
        try{
            if (mylist.get(index) instanceof Snake)
            {
                throw new SnakeBiteException("Snake Bite");
            }
        }
        catch(SnakeBiteException sb)
        {
            System.out.println("It's a snake");
        }
    }
}

class Vulture extends Tiles{
    private static long Number_Of_Tiles;
    private static long steps;
    public Vulture()
    {
    }
    public static void setNumber_Of_Tiles()
    {
        Random number = new Random();
        int w = (int) Tiles.getMax();
        long n = (long) (number.nextInt(w/5) + 1);
        Number_Of_Tiles = n;
    }
    public static long getNumber_Of_Tiles()
    {
        return Number_Of_Tiles;
    }
    public static void setSteps()
    {
        Random number = new Random();
        long n = (long) (number.nextInt(10) + 1);
        steps = n;
    }
    public static long getSteps()
    {
        return steps;
    }
    @java.lang.Override
    public void ThrowException(MyGenericList mylist, int index)
    {
        try{
            if (mylist.get(index) instanceof Vulture)
            {
                throw new VultureBiteException("Vulture Bite");
            }
        }
        catch(VultureBiteException sb)
        {
            System.out.println("It's a Vulture");
        }
    }


}

class Cricket extends Tiles{
    private static long Number_Of_Tiles;
    private static long steps;
    public Cricket()
    {
    }
    public static void setNumber_Of_Tiles()
    {
        Random number = new Random();
        int w = (int) Tiles.getMax();
        long n = (long) (number.nextInt(w/5) + 1);
        Number_Of_Tiles = n;
    }
    public static long getNumber_Of_Tiles()
    {
        return Number_Of_Tiles;
    }
    public static void setSteps()
    {
        Random number = new Random();
        long n = (long) (number.nextInt(10) + 1);
        steps = n;
    }
    public static long getSteps()
    {
        return steps;
    }
    @java.lang.Override
    public void ThrowException(MyGenericList mylist, int index)
    {
        try{
            if (mylist.get(index) instanceof Cricket)
            {
                throw new CricketBiteException("Snake Bite");
            }
        }
        catch(CricketBiteException sb)
        {
            System.out.println("It's a Cricket");
        }
    }


}

class White extends Tiles{
    private static long Number_Of_Tiles;
    public White()
    {
    }
    public static void setNumber_Of_Tiles()
    {
        long n  = (Tiles.getMax() - (Snake.getNumber_Of_Tiles() + Vulture.getNumber_Of_Tiles() + Trampoline.getNumber_Of_Tiles() +
                Cricket.getNumber_Of_Tiles()));
        Number_Of_Tiles = n;
    }
    public static long getNumber_Of_Tiles()
    {
        return Number_Of_Tiles;
    }

    @java.lang.Override
    public void ThrowException(MyGenericList mylist, int index)
    {
        System.out.println("I am a white tile");
    }

}

class Trampoline extends Tiles{
    private static long Number_Of_Tiles;
    private static long steps;
    public Trampoline()
    {
    }
    public static void setNumber_Of_Tiles()
    {
        Random number = new Random();
        int w = (int) Tiles.getMax();
        long n = (long) (number.nextInt(w/5) + 1);
        Number_Of_Tiles = n;
    }
    public static long getNumber_Of_Tiles()
    {
        return Number_Of_Tiles;
    }
    public static void setSteps()
    {
        Random number = new Random();
        long n = (long) (number.nextInt(10) + 1);
        steps = n;
    }
    public static long getSteps()
    {
        return steps;
    }
    @java.lang.Override
    public void ThrowException(MyGenericList mylist, int index)
    {
        try{
            if (mylist.get(index) instanceof Snake)
            {
                throw new TrampolineException("Trampoline");
            }
        }
        catch(TrampolineException sb)
        {
            System.out.println("It's a Trampoline");
        }
    }


}


/////// Tiles ends here///////////////
///// Generic List starts here///////////

class MyGenericList <T> {
    private ArrayList <T> mylist;
    public MyGenericList(long n)
    {
        mylist = new ArrayList<T>((int) n);
    }
    public void add(T o)
    {
        mylist.add(o);
    }
    public T get(int i)
    {
        return mylist.get(i);
    }
    public void Shuffle_The_List()
    {
        Collections.shuffle(mylist, new Random());
    }
    public int size()
    {
        return mylist.size();
    }
    public void remove(int index)
    {
        mylist.remove(index);
    }
}
