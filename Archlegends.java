import java.util.*;
import java.lang.*;
public class Archlegends
{
    public static void main(String[] args) {
        Game.Welcome_Menu();
        Hero player;
        Graph g_new = new Graph();// Making the layout of the game here...
        Node tempnode1 = g_new.getStart();
        Scanner input = new Scanner(System.in);
        while (true) { // Ye loop tab tak chalegi jab tak user 3 press kar ke exit naa kar le. So basically agar koi player
            // har bhi jaaye we will have to keep him inside this loop.
            int option = input.nextInt();
        if (option == 1) { // Will create a new user here
            System.out.println("Enter Username");
            String username = input.next();
            System.out.println("Choose a Hero");
            System.out.println("1) Warrior");
            System.out.println("2) Thief");
            System.out.println("3) Mage");
            System.out.println("4) Healer");
            int option1 = input.nextInt();
            Game.Create_User(username,option1);
            System.out.println("Log in to play the game. Exiting");
        }
        if (option ==2) {
            System.out.println("Enter Username");
            String tempname = input.next();
            int verified = Game.VerifyUser(tempname);
            if (verified == 0)
            {
                System.out.println("Invalid Username.");
                break;
            }
            int wins = 0; //Initializing a variable which will keep count of number of wins of the user.
            while (true) // This loop keeps running until the player is alive. Once he loses, this loop will terminate
            {
                Game.DisplayLocations(tempnode1); // Displaying the possible locations for the user
                Game.GiveHint(tempnode1);
                int option1 = input.nextInt(); // We are taking the input for the location choice here.
                int k = 0;// Ye wo variable hai, jise hum 1 kar ke is outer loop ko break karenge
                int goback = 0;
                if (option1 == -1){ // Agar user -1 kar deta hai to we will have to exit..
                    tempnode1 = g_new.getStart(); // Once a user exits, the game will restart for all users including him.
                    break;
                }
                if (option1 == 4)
                {
                    goback++;
                }
                Node selected_node =  Game.ChooseNode(tempnode1, option1); // Whatever he chooses to do, we will get the node out of it
                Monster opponent = Game.getOpponent(selected_node);// Finding the mosnter in the present location
                Hero user = Game.getCurrent_user(); // getting the user who is going to fight the monster.
                if (option1 == 1 || option1 == 2 || option1 == 3 || option1 == 4){ // matlab ki user ne apna location choose kar liya hai.
                    int counter = 1; // will keep count of the speacial moves
                    int x = 0; //same work as counter
                    while (true) { // this loop will regualte the results of the game after each round/ will terminate when one round is finished
                        while (user.getHP() > 0 && opponent.getHP() > 0) { // This loop will end when one of the fighters looses.
                            if (counter < 4) {
                                System.out.println("Choose move:");
                                System.out.println("1) Attack");
                                System.out.println("2) Defense");
                                int choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.println("You chose to attack.");
                                    user.Attack(opponent);
                                    opponent.Attack_After_Attack(user);
                                    counter++;
                                }
                                if (choice == 2) {
                                    System.out.println("You chose to defend");
                                    opponent.Attack_After_Defense(user);
                                    counter++;
                                }
                            } else if (counter == 4) {
                                System.out.println("Choose move:");
                                System.out.println("1) Attack");
                                System.out.println("2) Defense");
                                System.out.println("3) Speacial Attack");
                                int choice2 = input.nextInt();
                                if (choice2 == 1) {
                                    System.out.println("You chose to attack.");
                                    user.Attack(opponent);
                                    opponent.Attack_After_Attack(user);
                                    counter = 4;
                                }
                                if (choice2 == 2) {
                                    System.out.println("You chose to defend");
                                    opponent.Attack_After_Defense(user);
                                    counter = 4;
                                }
                                if (choice2 == 3) {
                                    System.out.println("Speacial Power Activated.");
                                    System.out.println("Performing Speacial Attack.");
                                    if (user.getHerotype().equals("Thief")) {
                                        user.Use_Speacial_Power(opponent);
                                        opponent.Attack_After_Attack(user);
                                        System.out.println("Speacial Power deactivated.");
                                        counter = 1;
                                    }
                                    if (user.getHerotype().equals("Healer")) {
                                        user.Use_Speacial_Power(opponent);
                                        opponent.Attack_After_Attack(user);
                                        x++;
                                        if (x % 3 == 0 && x > 0) {
                                            counter = 1;
                                        }
                                        if (x % 3 != 0) {
                                            counter = 4;
                                        }

                                    }
                                    if (user.getHerotype().equals("Mage")) {
                                        user.Use_Speacial_Power(opponent);
                                        opponent.Attack_After_Attack(user);
                                        x++;
                                        if (x % 3 == 0 && x > 0) {
                                            counter = 1;
                                        }
                                        if (x % 3 != 0) {
                                            counter = 4;
                                        }
                                    }
                                    if (user.getHerotype().equals("Warrior")) {
                                        user.Use_Speacial_Power(opponent);
                                        user.Attack(opponent);
                                        opponent.Attack_After_Attack(user);
                                        user.Use_Normal_Power(opponent); // Har baar waapas normal banaa deta hun.
                                        x++;
                                        if (x % 3 == 0 && x > 0) {
                                            counter = 1;
                                        }
                                        if (x % 3 != 0) {
                                            counter = 4;
                                        }
                                    }

                                }
                            }
                        }
                        /////// one round of fighting ends here
                        // Now we will judge the winner and then do the essentials before moving the user to the next location
                        if (opponent.getHP() <= 0) {
                            if (goback == 0) {
                                wins++;
                                user.setLevel(user.getLevel() + 1);
                                user.setXP(user.getXP() + 20 * selected_node.getData2());
                                if (user.getLevel() == 2) {
                                    user.setMaxHP(100);
                                    user.setHP(100);
                                }
                                if (user.getLevel() == 3) {
                                    user.setMaxHP(200);
                                    user.setHP(200);
                                }
                                if (user.getLevel() == 4) {
                                    user.setMaxHP(250);
                                    user.setHP(250);
                                }
                                if (wins <= 3) {
                                    user.setAttacking_Power(user.getAttacking_Power() + 1);
                                    user.setDefending_Power(user.getDefending_Power() + 1);
                                    System.out.println("Monster killed!");
                                    System.out.println((selected_node.getData2() * 20) + " XP awarded!");
                                    System.out.println("Level Up: Level " + user.getLevel());
                                    System.out.println("Fight won. Proceeding to the next location.");
                                    if (user.getLevel() == 2) {
                                        if (user.getXP() >= 20) {
                                            tempnode1 = selected_node;
                                            break;
                                        } else {
                                            System.out.println("You need more XP to qualify for next level. Please play this level again");
                                            System.out.println("Earn " + (20 - user.getXP()) + "XPs more");
                                            tempnode1 = tempnode1;
                                            break;
                                        }
                                    }
                                    if (user.getLevel() == 3) {
                                        if (user.getXP() >= 40) {
                                            tempnode1 = selected_node;
                                            break;
                                        } else {
                                            System.out.println("You need more XP to qualify for next level. Please play this level again");
                                            System.out.println("Earn " + (40 - user.getXP()) + "XPs more");
                                            tempnode1 = tempnode1;
                                            break;
                                        }
                                    }
                                    if (user.getLevel() == 4) {
                                        if (user.getXP() >= 60) {
                                            tempnode1 = selected_node;
                                            break;
                                        } else {
                                            System.out.println("You need more XP to qualify for next level. Please play this level again");
                                            System.out.println("Earn " + (60 - user.getXP()) + "XPs more");
                                            tempnode1 = tempnode1;
                                            break;
                                        }
                                    }
                                }
                                if (wins == 4) {
                                    tempnode1 = g_new.getStart();
                                    System.out.println("Congratulations! You won the game");
                                    k = 1;
                                    break;
                                }
                            }
                            if (goback == 1) {
                                wins = wins;
                                user.setLevel(user.getLevel());
                                user.setXP(user.getXP() + 20 * selected_node.getData2());
                                if (user.getLevel() == 2) {
                                    user.setMaxHP(100);
                                    user.setHP(100);
                                }
                                if (user.getLevel() == 3) {
                                    user.setMaxHP(200);
                                    user.setHP(200);
                                }
                                if (user.getLevel() == 4) {
                                    user.setMaxHP(250);
                                    user.setHP(250);
                                }
                                tempnode1 = selected_node;
                                goback = 0;
                                break;
                            }
                        }
                        if (user.getHP() <= 0) {
                            System.out.println("You lost the game!");
                            System.out.println("You can try again.");
                            tempnode1 = g_new.getStart();
                            user.setHP(100);
                            user.setMaxHP(100);
                            user.setLevel(1);
                            user.setXP(0);
                            wins = 0;
                            k = 1;
                            break;
                        }
                    }
                }
                if (k == 1)
                {
                    break;
                }
            }

        }
        if (option == 3) // The outermost loop will break if option chosen is 3.
        {
            break;
        }
            Game.Welcome_Menu();
    }
    }
}

class Hero
{

    private String Name;
    private String Herotype;
    private long XP = 0; // At the start
    private long HP = 100; // At the beginning of the game
    private long Level=1;
    private long MaxHP = 100;
    private long Attacking_Power; // This will be the XP deducted from the opponents xp when the user attacks
    private long Defending_Power;
    private boolean Speacial_Power = false;
    public void setMaxHP(long maxhp)
    {
        MaxHP= maxhp;
    }
    public long getMaxHP()
    {
        return MaxHP;
    }
    public void setLevel(long level)
    {
        Level = level;
    }
    public long getLevel()
    {
        return Level;
    }
    public void setDefending_Power(long l)
    {
        Defending_Power = l;
    }
    public long getDefending_Power()
    {
        return Defending_Power;
    }
    protected void setAttacking_Power(long l)
    {
        Attacking_Power = l;
    }
    protected long getAttacking_Power()
    {
        return Attacking_Power;
    }
    protected boolean getSpeacial_Power()
    {
        return Speacial_Power;
    }
    protected void setSpeacial_Power(boolean var )
    {
        Speacial_Power = var;
    }
    public void setXP(long num)
    {
        XP = num;
    }
    public long getXP()
    {
        return XP;
    }
    public void setHP(long num3)
    {
        HP = num3;
    }
    public long getHP()
    {
        return HP;
    }
    protected void setName(String name)
    {
        Name = name;
    }
    protected String getName()
    {
        return Name;
    }
    protected void setHerotype(String ht)
    {
        Herotype = ht;
    }
    protected String getHerotype()
    {
        return Herotype;
    }
    public void ShowDetails()
    {
        System.out.println("Username: " + this.getName() +". Hero type: " + this.getHerotype() + ".");
    }
    public void Attack(Monster mons)
    {
        // Does damage to the opponents
    }
    public void Defense()
    {
        // Less HP damage to the hero
    }
    public void Use_Speacial_Power(Monster monster)
    {
        // code for using speacial methods
    }
    public void Use_Normal_Power(Monster monster)
    {
        // code for using normal powers
    }

}


/////////////////////////////////////////////////////////////////////////////////////////////////
class Warrior extends Hero
{
    public Warrior(String name,String ht)
    {
        this.setHerotype(ht);
        this.setXP(0);
        this.setName(name);
        this.setAttacking_Power(10);
        this.setDefending_Power(3);
    }

    @java.lang.Override
    public void Attack(Monster mons)
    {
        if (mons.getHP() - this.getAttacking_Power() > 0) {
            mons.setHP(mons.getHP() - this.getAttacking_Power());
            System.out.println("You attacked and inflicted " + this.getAttacking_Power() + " damage to the monster");
            System.out.println("Your HP: " + this.getHP() + "/" + this.getMaxHP() + " Monster's HP: " + mons.getHP() + "/" + mons.getMaxHP());
        }
        else{
            mons.setHP(0);
            System.out.println("You attacked and inflicted " + this.getAttacking_Power() + " damage to the monster");
            System.out.println("Your HP: " + this.getHP() + "/" + this.getMaxHP() + " Monster's HP: " + mons.getHP() + "/" + mons.getMaxHP());
        }
    }

    @java.lang.Override
    public void Use_Speacial_Power(Monster monster) {
        this.setAttacking_Power(15);
        this.setDefending_Power(8);
    }
    @java.lang.Override
    public void Use_Normal_Power(Monster monster){
        this.setAttacking_Power(10);
        this.setDefending_Power(3);
    }

}


/////////////////////////////////////////////////////////////////////////////
class Thief extends Hero
{
    private long stolen_HP;
    public Thief(String name,String ht)
    {
        this.setHerotype(ht);
        this.setName(name);
        this.setXP(0);
        this.setAttacking_Power(6);
        this.setDefending_Power(4);
    }
    @java.lang.Override
    public void Attack(Monster mons1)
    {
        if (mons1.getHP() - this.getAttacking_Power() > 0) {
            mons1.setHP(mons1.getHP() - this.getAttacking_Power());
            System.out.println("You attacked and inflicted " + this.getAttacking_Power() + " damage to the monster");
            System.out.println("Your HP: " + this.getHP() + "/" + this.getMaxHP() + " Monster's HP: " + mons1.getHP() + "/" + mons1.getMaxHP());

            // damage 6 HP of the opponent
        }
        else {
            mons1.setHP(0);
            System.out.println("You attacked and inflicted " + this.getAttacking_Power() + " damage to the monster");
            System.out.println("Your HP: " + this.getHP() + "/" + this.getMaxHP() + " Monster's HP: " + mons1.getHP() + "/" + mons1.getMaxHP());
        }
    }

    @java.lang.Override
    public void Use_Speacial_Power(Monster monster) {
        this.stolen_HP = (monster.getHP()*3)/10;
        if (this.getHP() + this.stolen_HP <= 100) {
            this.setHP(this.getHP() + this.stolen_HP);
        }
        if (this.getHP() + this.stolen_HP > 100) {
            this.setHP(this.getMaxHP());
        }
        if (monster.getHP() - this.stolen_HP > 0) {
            monster.setHP(monster.getHP() - this.stolen_HP);
            System.out.println("You have stolen " + this.stolen_HP + "Hp from the monster!");
            System.out.println("Your HP: " + this.getHP() + "/" + this.getMaxHP() + " Monster's HP: " + monster.getHP() + "/" + monster.getMaxHP());
        }
        else{
            monster.setHP(0);
            System.out.println("You have stolen " + this.stolen_HP + "Hp from the monster!");
            System.out.println("Your HP: " + this.getHP() + "/" + this.getMaxHP() + " Monster's HP: " + monster.getHP() + "/" + monster.getMaxHP());
        }
    }
}


////////////////////////////////////////////////////////////////////
class Mage extends Hero
{
    private long reduced_HP;
    public Mage(String name,String ht)
    {
        this.setHerotype(ht);
        this.setName(name);
        this.setXP(0);
        this.setAttacking_Power(5);
        this.setDefending_Power(5);
    }
    @java.lang.Override
    public void Attack(Monster mons2)
    {
        if (mons2.getHP() - this.getAttacking_Power() > 0) {
            mons2.setHP(mons2.getHP() - this.getAttacking_Power());
            System.out.println("You attacked and inflicted " + this.getAttacking_Power() + " damage to the monster");
            System.out.println("Your HP: " + this.getHP() + "/" + this.getMaxHP() + " Monster's HP: " + mons2.getHP() + "/" + mons2.getMaxHP());
            // damage 5 HP of the opponent

        }
        else
        {
            mons2.setHP(0);
            System.out.println("You attacked and inflicted " + this.getAttacking_Power() + " damage to the monster");
            System.out.println("Your HP: " + this.getHP() + "/" + this.getMaxHP() + " Monster's HP: " + mons2.getHP() + "/" + mons2.getMaxHP());

        }
    }

    @java.lang.Override
    public void Use_Speacial_Power(Monster monster) {
        this.reduced_HP = (5*monster.getHP())/100;
        if (monster.getHP() - this.reduced_HP > 0) {
            monster.setHP(monster.getHP() - this.reduced_HP);
            System.out.println("Casting a spell and reducing the monster's HP by " + this.reduced_HP);
            System.out.println("Your HP: " + this.getHP() + "/" + this.getMaxHP() + " Monster's HP: " + monster.getHP() + "/" + monster.getMaxHP());
        }
        else{
            monster.setHP(0);
            System.out.println("Casting a spell and reducing the monster's HP by " + this.reduced_HP);
            System.out.println("Your HP: " + this.getHP() + "/" + this.getMaxHP() + " Monster's HP: " + monster.getHP() + "/" + monster.getMaxHP());
        }
    }
}


/////////////////////////////////////////////////////////
class Healer extends Hero
{
    private long increased_HP;
    public Healer(String name,String ht)
    {
        this.setHerotype(ht);
        this.setName(name);
        this.setXP(0);
        this.setAttacking_Power(4);
        this.setDefending_Power(8);
    }
    @java.lang.Override
    public void Attack(Monster mons3)
    {
        if (mons3.getHP() - this.getAttacking_Power() > 0) {
            mons3.setHP(mons3.getHP() - this.getAttacking_Power());
            System.out.println("You attacked and inflicted " + this.getAttacking_Power() + " damage to the monster");
            System.out.println("Your HP: " + this.getHP() + "/" + this.getMaxHP() + " Monster's HP: " + mons3.getHP() + "/" + mons3.getMaxHP());
            // damage 4 HP of the opponent
        }
        else {
            mons3.setHP(0);
            System.out.println("You attacked and inflicted " + this.getAttacking_Power() + " damage to the monster");
            System.out.println("Your HP: " + this.getHP() + "/" + this.getMaxHP() + " Monster's HP: " + mons3.getHP() + "/" + mons3.getMaxHP());
        }
    }

    @java.lang.Override
    public void Use_Speacial_Power(Monster monster) {
        this.increased_HP = (5*this.getHP())/100;
        if (this.getHP() + this.increased_HP <=100) {
            this.setHP(this.getHP() + this.increased_HP);
            System.out.println("You have inreased you HP by " + this.increased_HP + "!");
            System.out.println("Your HP: " + this.getHP() + "/" + this.getMaxHP() + " Monster's HP: " + monster.getHP() + "/" + monster.getMaxHP());
        }
        else{
            this.setHP(this.getMaxHP());
            System.out.println("You have inreased you HP by " + this.increased_HP + "!");
            System.out.println("Your HP: " + this.getHP() + "/" + this.getMaxHP() + " Monster's HP: " + monster.getHP() + "/" + monster.getMaxHP());


        }
    }
}


/////////////////////////////////////

class Monster
{
    private long HP;
    private long MaxHP;
    private int level;
    protected void setMaxHP(long xp)
    {
        MaxHP = xp;
    }
    protected long getMaxHP()
    {
        return MaxHP;
    }
    protected void setLevel(int n)
    {
        level = n;
    }
    protected int getLevel()
    {
        return level;
    }
    protected void setHP(long hp)
    {
        HP = hp;
    }
    protected long getHP()
    {
        return HP;
    }
    public void Attack_After_Defense(Hero user)
    {
        Random rand1 = new Random();
        long temp =0;
        long mean = this.getHP()/8;
        for (long i =1;i<mean*2;i++){
            temp += (mean - i)*(mean - i)/(mean*2 -1);
        }
        double num1 = Math.sqrt(temp);
        long standard_deviation = Math.round(num1);
        double num2 = (rand1.nextGaussian()*standard_deviation) + mean;
        long num3 = Math.round(num2); // This will be the value of XP which will be deducted from user.
        System.out.println("Monster atack reduced by " + user.getDefending_Power() + "!" );
        System.out.println("Your HP: " + user.getHP() + "/" + user.getMaxHP()+ " Monster's HP: " + this.getHP() + "/" + this.getMaxHP());
        System.out.println("Monster attack!");
        if (num3- user.getDefending_Power() > 0) {
            if((user.getHP() - num3 + user.getDefending_Power() )> 0 ) {
                user.setHP(user.getHP() - (num3 - user.getDefending_Power()));
                System.out.println("The monster attacked and inflicted " + (num3 - user.getDefending_Power()) + " damage to you.");
                System.out.println("Your HP: " + user.getHP() + "/" + user.getMaxHP() + " Monster's HP: " + this.getHP() + "/" + this.getMaxHP());
            }
            else {
                user.setHP(0);
                System.out.println("The monster attacked and inflicted " + (num3 - user.getDefending_Power()) + " damage to you.");
                System.out.println("Your HP: " + user.getHP() + "/" + user.getMaxHP() + " Monster's HP: " + this.getHP() + "/" + this.getMaxHP());
            }
        }
        else{
            user.setHP(user.getHP());
            System.out.println("The monster attacked and inflicted 0 damage to you.");
            System.out.println("Your HP: " + user.getHP() + "/" + user.getMaxHP() + " Monster's HP: " + this.getHP() + "/" + this.getMaxHP());
        }
    }
    public void Attack_After_Attack(Hero user) {
        Random rand1 = new Random();
        long temp = 0;
        long mean = Math.round(this.getHP() / 8);
        for (long i = 1; i < mean * 2; i++) {
            temp += (mean - i) * (mean - i) / (mean*2 - 1);
        }
        double num1 = Math.sqrt(temp);
        long standard_deviation = Math.round(num1);
        double num2 = (rand1.nextGaussian() * standard_deviation) + mean;
        long num3 = Math.round(num2); // This will be the value of XP which will be deducted from user.
        if (user.getHP() - num3 > 0) {
            user.setHP(user.getHP() - num3);
            System.out.println("Monster Attack!");
            System.out.println("The monster attacked and inflicted " + num3 + " damage to you.");
            System.out.println("Your HP: " + user.getHP() + "/" + user.getMaxHP() + " Monster's HP: " + this.getHP() + "/" + this.getMaxHP());
        }
        else
        {
            user.setHP(0);
            System.out.println("The monster attacked and inflicted " + num3 + " damage to you.");
            System.out.println("Your HP: " + user.getHP() + "/" + user.getMaxHP() + " Monster's HP: " + this.getHP() + "/" + this.getMaxHP());

        }
    }
}


///////////////////////////////////////////////////////////////
class Goblins extends Monster
{
    public Goblins()
    {
        this.setHP(100);
        this.setMaxHP(100);
        this.setLevel(1);
    }

}


////////////////////////////////////////////////////////////
class Zombies extends Monster{

    public Zombies()
    {
        this.setHP(150);
        this.setMaxHP(150);
        this.setLevel(2);
    }

}


//////////////////////////////////////////////////////////////
class Fiends extends Monster{

    public Fiends()
    {
        this.setHP(200);
        this.setMaxHP(200);
        this.setLevel(3);
    }
}


/////////////////////////////////////////////////////////////
class Lionfang extends Monster{

    public Lionfang()
    {
        this.setHP(250);
        this.setMaxHP(250);
        this.setLevel(4);
    }

    @java.lang.Override
    public void Attack_After_Defense(Hero user)
    {
        Random number = new Random();
        int n = number.nextInt(10);
        if (n == 9)
        {
            System.out.println("Monster atack reduced by " + user.getDefending_Power() + "!" );
            System.out.println("Your HP: " + user.getHP() + "/" + user.getMaxHP()+ " Monster's HP: " + this.getHP() + "/" + this.getMaxHP());
            System.out.println("Monster attack!");
            long temphp = user.getHP();
            user.setHP(user.getHP()/2 + user.getDefending_Power());
            System.out.println("The monster attacked and inflicted " + (temphp/2 - user.getDefending_Power()) + " damage to you.");
            System.out.println("Your HP: " + user.getHP() + "/" + user.getMaxHP()+ " Monster's HP: " + this.getHP() + "/" + this.getMaxHP());
            ////////////////////
        }
        else{
            if (n<=8)
            {
                super.Attack_After_Defense(user);
            }
        }

    }

    @java.lang.Override
    public void Attack_After_Attack(Hero user) {
        Random number = new Random();
        int n = number.nextInt(10);
        if(n==9)
        {
            long temphp = user.getHP();
            user.setHP(user.getHP()/2);
            System.out.println("Monster Attack!");
            System.out.println("The monster attacked and inflicted " + temphp/2 + " damage to you.");
            System.out.println("Your HP: " + user.getHP() + "/" + user.getMaxHP()+ " Monster's HP: " + this.getHP() + "/" + this.getMaxHP());
        }
        else{
            if(n<=8)
            {
                super.Attack_After_Attack(user);
            }
        }

    }
}


/////////////////////////////////////////////////
final class Game{
    public static ArrayList<Hero> ListOfUsers = new ArrayList<Hero>();
    private static Hero current_user;
    public static void setCurrent_user(Hero curuser)
    {
        current_user = curuser;
    }
    public static Hero getCurrent_user()
    {
        return current_user;
    }
    public static void Welcome_Menu()
    {
        System.out.println("Welcome to ArchLegends");
        System.out.println("Choose your option");
        System.out.println("1) New User");
        System.out.println("2) Existing User");
        System.out.println("3) Exit");
    }
    public static void Create_User(String usrname, int type)
    {
        if (type == 1)
        {
            String tempstring = "Warrior";
            Hero user = new Warrior(usrname,tempstring);
            ListOfUsers.add(user);
            System.out.println("User Creation done. ");
            user.ShowDetails();
        }
        else if(type ==2) {
            String tempstring = "Thief";
            Hero user = new Thief(usrname,tempstring);
            ListOfUsers.add(user);
            System.out.println("User Creation done. ");
            user.ShowDetails();
        }
        else if (type ==3) {
            String tempstring = "Mage";
            Hero user = new Mage(usrname,tempstring);
            ListOfUsers.add(user);
            System.out.println("User Creation done. ");
            user.ShowDetails();
        }
        else{
            String tempstring = "Healer";
            Hero user = new Healer(usrname,tempstring);
            ListOfUsers.add(user);
            System.out.println("User Creation done. ");
            user.ShowDetails();
        }

    }
    public static int VerifyUser(String s)
    {
        int counter = 0;
        for (int i =0;i<ListOfUsers.size();i++)
        {
            if (s.equals(ListOfUsers.get(i).getName()))
            {
                counter ++;
                System.out.println("User Found.... Logging in");
                System.out.println("Welcome " + s);
                Game.setCurrent_user(ListOfUsers.get(i));
            }
        }
        return counter;
    }
    public static void DisplayLocations(Node tmpnode){
        if (tmpnode.getPrev() != null) {
            if (tmpnode.getNext1() != null && tmpnode.getNext2() != null && tmpnode.getNext3() != null) {
                System.out.println("You are at Location " + tmpnode.getData1() + " Choose path: ");
                System.out.println("1) Go to Location " + tmpnode.getNext1().getData1());
                System.out.println("2) Go to Location " + tmpnode.getNext2().getData1());
                System.out.println("3) Go to location " + tmpnode.getNext3().getData1());
                System.out.println("4) Go back.");
                System.out.println("Enter -1 to exit");
            }
            if (tmpnode.getNext1() != null && tmpnode.getNext2() == null && tmpnode.getNext3() == null) {
                System.out.println("Wonderful! You will now fight Lionfang!");
                System.out.println("Moving to the location of Lionfang directly");
                System.out.println("Enter any numeric key to proceed: ");
            }
        }
        if (tmpnode.getPrev() == null) {
            System.out.println("You are at Location " + tmpnode.getData1() + " Choose path: ");
            System.out.println("1) Go to Location " + tmpnode.getNext1().getData1());
            System.out.println("2) Go to Location " + tmpnode.getNext2().getData1());
            System.out.println("3) Go to location " + tmpnode.getNext3().getData1());
            System.out.println("Enter -1 to exit");
        }
    }
    public static Monster getOpponent(Node tmpnode)
    {
        int num = tmpnode.getData2();
            if (num == 1) {
                Monster monster1 = new Goblins();
                System.out.println("Fight Started. You are fighting a level " + monster1.getLevel() + " monster");
                return monster1;
            }
            else if (num == 2) {
                Monster monster1 = new Zombies();
                System.out.println("Fight Started. You are fighting a level " + monster1.getLevel() + " monster");
                return monster1;
            }
            else if (num == 3){
                Monster monster1 = new Fiends();
                System.out.println("Fight Started. You are fighting a level " + monster1.getLevel() + " monster");
                return monster1;
            }
        else
        {
            Monster monster1 = new Lionfang();
            System.out.println("Final Stage. You are fighting a level 4 monster.");
            return monster1;
        }
    }
    public static Node ChooseNode(Node tmpnode, int num)
    {
        if (tmpnode.getNext1() != null && tmpnode.getNext2() != null && tmpnode.getNext3() != null) {
            if (num == 1) {
                System.out.println("Moving to Location " + tmpnode.getNext1().getData1());
                return tmpnode.getNext1();
            }
            else if (num == 2) {
                System.out.println("Moving to Location " + tmpnode.getNext2().getData1());
                return tmpnode.getNext2();
            }
            else if (num == 3) {
                System.out.println("Moving to Location " + tmpnode.getNext3().getData1());
                return tmpnode.getNext3();
            }
            else {
                System.out.println("Moving to Location " + tmpnode.getData1());
                return tmpnode;
            }
        }
        else {
            return tmpnode.getNext1();
        }
    }
    public static void GiveHint(Node tempnode) {
        if (tempnode.getNext1() != null && tempnode.getNext2() != null && tempnode.getNext3() != null){
            int number1 = tempnode.getNext1().getData2();
        int number2 = tempnode.getNext2().getData2();
        int number3 = tempnode.getNext3().getData2();
        if (number1 >= number3 && number2 >= number3) {
            System.out.println("Hint: Location " + tempnode.getNext3().getData1() + " has the easiest opponent.");
        } else if (number3 >= number1 && number2 >= number1) {
            System.out.println("Hint: Location " + tempnode.getNext1().getData1() + " has the easiest opponent.");
        } else if (number1 >= number2 && number3 >= number2) {
            System.out.println("Hint: Location " + tempnode.getNext2().getData1() + " has the easiest opponent.");
        }
    }
    else {
        System.out.println("All the best!");
        }
    }

}


////////////////////////////////////////////////////////////
class Node
{
    private Node next1;
    private Node next2;
    private Node next3;
    private Node prev;
    int data1;
    int data2;
    public void setNext1(Node n)
    {
        next1 = n;
    }
    public Node getNext1()
    {
        return next1;
    }
    public void setNext2(Node n)
    {
        next2 = n;
    }
    public Node getNext2()
    {
        return next2;
    }
    public void setNext3(Node n)
    {
        next3 = n;
    }
    public Node getNext3()
    {
        return next3;
    }
    public void setPrev(Node n)
    {
        prev= n;
    }
    public Node getPrev()
    {
        return prev;
    }
    public void setData1(int data)
    {
        data1 = data;
    }
    public int getData1()
    {
        return data1;
    }
    public void setData2(int data)
    {
        data2 = data;
    }
    public int getData2()
    {
        return data2;
    }

    public Node(int data1, int data2)
    {
        this.setData1(data1);
        this.setData2(data2);
    }

}


////////////////////////////
class Graph
{
    private Node start;

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Graph()
    {
        Node tmpnode = new Node(0,0);
        this.setStart(tmpnode);
//////////////////1st round/////////////////////////////////
        Random rand2 = new Random();
        int level1 = rand2.nextInt(3) + 1;
        Node node1 = new Node(1,level1);
        node1.setPrev(start);
        int level2 = rand2.nextInt(3) + 1;
        Node node2 = new Node(2,level2);
        node2.setPrev(start);
        int level3 = rand2.nextInt(3) + 1;
        Node node3 = new Node(3,level3);
        node3.setPrev(start);
        start.setNext1(node1);
        start.setNext2(node2);
        start.setNext3(node3);
        ///////////////////// //////////////////////////////////////////////////
        //// Round 2 starts///////////
        int level4 = rand2.nextInt(3) + 1;
        Node node4 = new Node(4,level4);
        node4.setPrev(node1);
        int level5 = rand2.nextInt(3) + 1;
        Node node5 = new Node(5,level5);
        node5.setPrev(node1);
        int level6 = rand2.nextInt(3) + 1;
        Node node6 = new Node(6,level6);
        node6.setPrev(node1);
        node1.setNext1(node4);
        node1.setNext2(node5);
        node1.setNext3(node6);
        /////////////////////
        int level7 = rand2.nextInt(3) + 1;
        Node node7 = new Node(7,level7);
        node7.setPrev(node2);
        int level8 = rand2.nextInt(3) + 1;
        Node node8 = new Node(8,level8);
        node8.setPrev(node2);
        int level9 = rand2.nextInt(3) + 1;
        Node node9 = new Node(9,level9);
        node9.setPrev(node2);
        node2.setNext1(node7);
        node2.setNext2(node8);
        node2.setNext3(node9);
        ///////////////////////////////
        int level10 = rand2.nextInt(3) + 1;
        Node node10 = new Node(10,level10);
        node10.setPrev(node3);
        int level11 = rand2.nextInt(3) + 1;
        Node node11 = new Node(11,level11);
        node11.setPrev(node3);
        int level12 = rand2.nextInt(3) + 1;
        Node node12 = new Node(12,level12);
        node12.setPrev(node3);
        node3.setNext1(node10);
        node3.setNext2(node11);
        node3.setNext3(node12);
        /////////////////////////////////////////
        // Round 2 over//////////
        // Round 3 starting
        int level13 = rand2.nextInt(3) + 1;
        Node node13 = new Node(13,level13);
        node13.setPrev(node4);
        int level14 = rand2.nextInt(3) + 1;
        Node node14 = new Node(14,level14);
        node14.setPrev(node4);
        int level15 = rand2.nextInt(3) + 1;
        Node node15 = new Node(15,level15);
        node15.setPrev(node4);
        node4.setNext1(node13);
        node4.setNext2(node14);
        node4.setNext3(node15);
        ///////////////////////////////////////
        int level16 = rand2.nextInt(3) + 1;
        Node node16 = new Node(16,level16);
        node16.setPrev(node5);
        int level17 = rand2.nextInt(3) + 1;
        Node node17 = new Node(17,level17);
        node17.setPrev(node5);
        int level18 = rand2.nextInt(3) + 1;
        Node node18 = new Node(18,level18);
        node18.setPrev(node5);
        node5.setNext1(node16);
        node5.setNext2(node17);
        node5.setNext3(node18);
        ///////////////////////////////////////////
        int level19 = rand2.nextInt(3) + 1;
        Node node19 = new Node(19,level19);
        node19.setPrev(node6);
        int level20 = rand2.nextInt(3) + 1;
        Node node20 = new Node(20,level20);
        node20.setPrev(node6);
        int level21 = rand2.nextInt(3) + 1;
        Node node21 = new Node(21,level21);
        node21.setPrev(node6);
        node6.setNext1(node19);
        node6.setNext2(node20);
        node6.setNext3(node21);
        ///////////////////////////////////////////////////
        int level22 = rand2.nextInt(3) + 1;
        Node node22 = new Node(22,level22);
        node22.setPrev(node7);
        int level23 = rand2.nextInt(3) + 1;
        Node node23 = new Node(23,level23);
        node23.setPrev(node7);
        int level24 = rand2.nextInt(3) + 1;
        Node node24 = new Node(24,level24);
        node24.setPrev(node7);
        node7.setNext1(node22);
        node7.setNext2(node23);
        node7.setNext3(node24);
/////////////////////////////////////////////////////////////
        int level25 = rand2.nextInt(3) + 1;
        Node node25 = new Node(25,level25);
        node25.setPrev(node8);
        int level26 = rand2.nextInt(3) + 1;
        Node node26 = new Node(26,level26);
        node26.setPrev(node8);
        int level27 = rand2.nextInt(3) + 1;
        Node node27 = new Node(27,level27);
        node27.setPrev(node8);
        node8.setNext1(node25);
        node8.setNext2(node26);
        node8.setNext3(node27);
        ///////////////////////////////////////////////
        int level28 = rand2.nextInt(3) + 1;
        Node node28 = new Node(28,level28);
        node28.setPrev(node9);
        int level29 = rand2.nextInt(3) + 1;
        Node node29 = new Node(29,level29);
        node29.setPrev(node9);
        int level30 = rand2.nextInt(3) + 1;
        Node node30 = new Node(30,level30);
        node30.setPrev(node9);
        node9.setNext1(node28);
        node9.setNext2(node29);
        node9.setNext3(node30);
        //////////////////////////////////////////////
        int level31 = rand2.nextInt(3) + 1;
        Node node31 = new Node(31,level31);
        node31.setPrev(node10);
        int level32 = rand2.nextInt(3) + 1;
        Node node32 = new Node(32,level32);
        node32.setPrev(node10);
        int level33 = rand2.nextInt(3) + 1;
        Node node33 = new Node(33,level33);
        node33.setPrev(node10);
        node10.setNext1(node31);
        node10.setNext2(node32);
        node10.setNext3(node33);
        //////////////////////////////////////////////
        int level34 = rand2.nextInt(3) + 1;
        Node node34 = new Node(34,level34);
        node34.setPrev(node11);
        int level35 = rand2.nextInt(3) + 1;
        Node node35 = new Node(35,level35);
        node35.setPrev(node11);
        int level36 = rand2.nextInt(3) + 1;
        Node node36 = new Node(36,level36);
        node36.setPrev(node11);
        node11.setNext1(node34);
        node11.setNext2(node35);
        node11.setNext3(node36);
        //////////////////////////////////////////////
        int level37 = rand2.nextInt(3) + 1;
        Node node37 = new Node(37,level37);
        node37.setPrev(node12);
        int level38 = rand2.nextInt(3) + 1;
        Node node38 = new Node(38,level38);
        node38.setPrev(node12);
        int level39 = rand2.nextInt(3) + 1;
        Node node39 = new Node(39,level39);
        node39.setPrev(node12);
        node12.setNext1(node37);
        node12.setNext2(node38);
        node12.setNext3(node39);
        //////////////////////////////////////////////Round 3 over/////////////
        /////Round4/////////////////////////////////
        Node node40 = new Node(40,4);
        node40.setPrev(node13);
        node13.setNext1(node40);
        /////////////////////////////////
        Node node41 = new Node(41,4);
        node41.setPrev(node14);
        node14.setNext1(node41);
        //////////////////////////////////
        Node node42 = new Node(42,4);
        node42.setPrev(node15);
        node15.setNext1(node42);
        ///////////////////////////////////
        Node node43 = new Node(43,4);
        node43.setPrev(node16);
        node16.setNext1(node43);
        ///////////////////////////////////
        Node node44= new Node(44,4);
        node44.setPrev(node17);
        node17.setNext1(node44);
        ////////////////////////////////////
        Node node45 = new Node(45,4);
        node45.setPrev(node18);
        node18.setNext1(node45);
        ////////////////////////////////////
        Node node46 = new Node(46,4);
        node46.setPrev(node19);
        node19.setNext1(node46);
        ///////////////////////////////////
        Node node47 = new Node(47,4);
        node47.setPrev(node20);
        node20.setNext1(node47);
        ////////////////////////////////////
        Node node48= new Node(48,4);
        node48.setPrev(node21);
        node21.setNext1(node48);
//////////////////////////////////////////////
        Node node49 = new Node(49,4);
        node49.setPrev(node22);
        node22.setNext1(node49);
//////////////////////////////////////
        Node node50 = new Node(50,4);
        node50.setPrev(node23);
        node23.setNext1(node50);
        /////////////////////////////////////
        Node node51 = new Node(51,4);
        node51.setPrev(node24);
        node24.setNext1(node51);
        //////////////////////////////////////
        Node node52 = new Node(52,4);
        node52.setPrev(node25);
        node25.setNext1(node52);
        ////////////////////////////////////
        Node node53 = new Node(53,4);
        node53.setPrev(node26);
        node26.setNext1(node53);
        ///////////////////////////////////
        Node node54= new Node(54,4);
        node54.setPrev(node27);
        node27.setNext1(node54);
        /////////////////////////////////////
        Node node55= new Node(55,4);
        node55.setPrev(node28);
        node28.setNext1(node55);
        /////////////////////////////////////
        Node node56= new Node(56,4);
        node56.setPrev(node29);
        node29.setNext1(node56);
////////////////////////////////////////////////
        Node node57= new Node(57,4);
        node57.setPrev(node30);
        node30.setNext1(node57);
        ////////////////////////////////////
        Node node58= new Node(58,4);
        node58.setPrev(node31);
        node31.setNext1(node58);
        ////////////////////////////////////
        Node node59= new Node(59,4);
        node59.setPrev(node32);
        node32.setNext1(node59);
        ////////////////////////////////////
        Node node60= new Node(60,4);
        node60.setPrev(node33);
        node33.setNext1(node60);
        ////////////////////////////////////
        Node node61= new Node(61,4);
        node61.setPrev(node34);
        node34.setNext1(node61);
        ////////////////////////////////////
        Node node62= new Node(62,4);
        node62.setPrev(node35);
        node35.setNext1(node62);
        ////////////////////////////////////
        Node node63= new Node(63,4);
        node63.setPrev(node36);
        node36.setNext1(node63);
        ////////////////////////////////////
        Node node64= new Node(64,4);
        node64.setPrev(node37);
        node37.setNext1(node64);
        ////////////////////////////////////
        Node node65= new Node(65,4);
        node65.setPrev(node38);
        node38.setNext1(node65);
        ////////////////////////////////////
        Node node66= new Node(66,4);
        node66.setPrev(node39);
        node39.setNext1(node66);
        ////////////////////////////////////
    }

}


///////////////////////////


