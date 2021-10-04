import java.util.*;
import java.lang.*;

public class test2
{
    public static void main(String[] args) {
        Merchant Jack = new Merchant("Jack");
        Jack.setAddress("Delhi");
        Merchant.ListOfMerchants.add(Jack);
        Merchant John = new Merchant("John");
        John.setAddress("Kolkata");
        Merchant.ListOfMerchants.add(John);
        Merchant James = new Merchant("James");
        James.setAddress("Bengaluru");
        Merchant.ListOfMerchants.add(James);
        Merchant Jeff = new Merchant("Jeff");
        Jeff.setAddress("Mumbai");
        Merchant.ListOfMerchants.add(Jeff);
        Merchant Joseph = new Merchant("Joseph");
        Joseph.setAddress("Chennai");
        Merchant.ListOfMerchants.add(Joseph);

        Customer Ali = new Customer("Ali");
        Customer.ListOfCustomers.add(Ali);
        Ali.setAddress("Delhi");
        Customer Nobby = new Customer("Nobby");
        Nobby.setAddress("Kolkata");
        Customer.ListOfCustomers.add(Nobby);
        Customer Bruno = new Customer("Bruno");
        Customer.ListOfCustomers.add(Bruno);
        Bruno.setAddress("Bengaluru");
        Customer Borat = new Customer("Borat");
        Customer.ListOfCustomers.add(Borat);
        Borat.setAddress("Chennai");
        Customer Alaadeen = new Customer("Alaadeen");
        Customer.ListOfCustomers.add(Alaadeen);
        Alaadeen.setAddress("Mumbai");

        Mercury.DisplayMainMenu(); // Displaying the main menu
        Scanner input = new Scanner(System.in);
        while (true) {
            int query = input.nextInt();
            if (query == 1) {
                Merchant.DisplayListOfMerchants();
                long num1 = input.nextLong(); // num1 is the ID number of the logged in Merchant
                Merchant tempMerchant = Merchant.getMerchant(num1); // Getting the merchant from the Id of the merchant
                Merchant.DisplayMerchantMenu(num1);
                while (true) {
                    int num2 = input.nextInt();
                    if (num2 == 1) {
                        System.out.println("Enter Item Details");
                        System.out.println("Item name");
                        String tempname = input.next();
                        System.out.println("Item Price");
                        double tempprice = input.nextDouble();
                        System.out.println("Item Quantity");
                        long tempquantity = input.nextLong();
                        System.out.println("Item Category");
                        String tempcategory = input.next();
                        tempMerchant.addItem(tempname, tempprice, tempquantity, tempcategory);
                    }
                    if (num2 == 2) {
                        System.out.println("Choose item by code");
                        tempMerchant.showMyItemsDetails();
                        long tempid = input.nextLong();
                        Item tempitem = Item.getItem(tempid); // getting the item object from the id of the object
                        System.out.println("Enter Edit Details");
                        System.out.println("Item Price:");
                        double u1 = input.nextDouble();
                        System.out.println("Item Quantity:");
                        long u2 = input.nextLong();
                        tempitem.editDetails(u1, u2);


                    }
                    if (num2 == 3) {
                        System.out.println("Choose a category");
                        Item.displayAllCategories();
                        int  id4 = input.nextInt();
                        Item.display_items_from_given_categories(id4);
                    }
                    if (num2 == 4) {
                        // will show the merchant user the list of all his items
                        System.out.println("Choose item by code:");
                        tempMerchant.showMyItemsDetails();
                        long id5 = input.nextLong();
                        Item tempitem3 = Item.getItem(id5); // Getting the merchant from the ID of the merchant
                        System.out.println("Choose offer");
                        System.out.println("1) buy one get one");
                        System.out.println("2) 25% off");
                        int random = input.nextInt();
                        tempitem3.chooseOffer(random);
                        Item.showItemDetails(tempitem3);

                    }
                    if (num2 == 5) {
                        System.out.println(tempMerchant.getSlots_won());
                    }
                    if (num2 == 6) {
                        break;
                    }
                    Merchant.DisplayMerchantMenu(num1);

                }
            }
            if (query == 2) {
                Customer.DisplayCustomers();
                long id6 = input.nextLong();
                Customer tempcustomer = Customer.getCustomer(id6);
                Customer.DisplayCustomerMenu(tempcustomer);
                while (true) {
                    int num3 = input.nextInt();
                    if (num3 == 1) {
                        Item.displayAllCategories();
                        int tempo = input.nextInt();
                        Item.display_items_from_given_categories(tempo);
                        System.out.println("Enter item code");
                        long code = input.nextLong();
                        Item tempitem4 = Item.getItem(code); // This is the item which the customer will buy
                        System.out.println("Enter item quantity");
                        long tempquantity = input.nextLong();
                        tempitem4.setRequestedQuantity(tempquantity);
                        System.out.println("Choose methods of Transaction");
                        System.out.println("1) Buy item");
                        System.out.println("2) Add items to cart");
                        System.out.println("3) Exit");
                        while(true) {
                            int choice = input.nextInt();
                            if (choice == 1) {
                                tempcustomer.Direct_buy(tempitem4, tempquantity);
                                break;
                            }
                            if (choice == 2) {
                                tempcustomer.AddtoCart(tempitem4);
                                break;
                            }
                            if (choice == 3) {
                                break;
                            }
                            Customer.DisplayCustomerMenu(tempcustomer);

                        }

                    }
                    if (num3 == 2)
                    {
                        tempcustomer.Checkout();
                    }
                    if (num3 == 3)
                    {
                        double ans = tempcustomer.getTotalRewardsWon();
                        System.out.println("Total Rewards Won: " + ans);
                    }
                    if (num3 == 4)
                    {
                        tempcustomer.RecentTransactions();
                    }
                    if (num3 ==5)
                    {
                        break;
                    }
                    Customer.DisplayCustomerMenu(tempcustomer);
                }
            }
            if ( query == 3 )
            {
                Mercury.DisplayList();
                char tempchar = input.next().charAt(0);
                Long tempid = input.nextLong();
                if (tempchar == 'C' || tempchar == 'c')
                {
                    Customer tempcustomer2 = Customer.getCustomer(tempid);
                    Customer.DisplayCustomerDetails(tempcustomer2);
                }
                if (tempchar == 'M' || tempchar =='m')
                {
                    Merchant tempmerchant2 = Merchant.getMerchant(tempid);
                    Merchant.DisplayMerchantDetails(tempmerchant2);
                }
            }
            if (query ==4)
            {
                System.out.println(Mercury.getAccountBalance());
            }
            if (query == 5)
            {
                break;
            }
            Mercury.DisplayMainMenu();
        }
    }

}

class Customer implements ItemPrice {
    private String Name;
    private String Address;
    private long ID = 1;
    private int Number_Of_Purchases = 0; // Number of orders through Mercury
    private int temp_purchases = 1;
    private static long counter;
    private double Rewards_Balance = 0;
    private double TotalRewardsWon;
    private double Main_Balance = 100;
    private Stack Records = new Stack();
    public static ArrayList<Customer> ListOfCustomers = new ArrayList<Customer>();
    public ArrayList<Item> ListOfBoughtItems = new ArrayList<Item>();
    // An Arraylist to get the last 10 transactions of the customer
    public ArrayList<Item> ListOfPurchasedItems = new ArrayList<Item>();
    // An arraylist to maintain the items in the cart of a particular customer..

    public void setAddress(String address) {
        Address = address;
    }

    public String getAddress() {
        return Address;
    }

    public void setTotalRewardsWon(double totalRewardsWon) {
        TotalRewardsWon = totalRewardsWon;
    }

    public double getTotalRewardsWon() {
        return TotalRewardsWon;
    }

    public void setTemp_purchases(int temp_purchases) {
        this.temp_purchases = temp_purchases;
    }

    public int getTemp_purchases() {
        return temp_purchases;
    }

    public void setID(long id) {
        ID = id;
    }

    public long getID() {
        return ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setNumber_Of_Purchases(int num) {
        Number_Of_Purchases = num;
    }

    public int getNumber_Of_Purchases() {
        return Number_Of_Purchases;
    }

    public void setRewards_Balance(double rewards_Balance) {
        Rewards_Balance = rewards_Balance;
    }

    public double getRewards_Balance() {
        return Rewards_Balance;
    }

    public void setMain_Balance(double main_balance) {
        Main_Balance = main_balance;
    }

    public double getMain_Balance() {
        return Main_Balance;
    }

    public Customer(String name) {
        this.setName(name);
        this.setID(this.ID + counter);
        ++counter;
    }

    public Customer() {
        this.setID(0);
    }

    public static Customer getCustomer(long id) {
        Customer tempcust = new Customer();
        for (int g = 0; g < ListOfCustomers.size(); g++) {
            if (id == ListOfCustomers.get(g).getID()) {
                tempcust = ListOfCustomers.get(g);
            }
        }
        return tempcust;
    }

    // For the initial list of all customers
    public static void DisplayCustomers() {
        System.out.println("Choose Customer");
        for (int i = 0; i < ListOfCustomers.size(); i++) {
            System.out.println(ListOfCustomers.get(i).getID() + " " + ListOfCustomers.get(i).getName());
        }
    }

    public static void DisplayCustomerMenu(Customer customer1) {
        System.out.println("Welcome " + customer1.getName());
        System.out.println("Customer Menu");
        System.out.println("1) Search Item");
        System.out.println("2) Checkout Cart");
        System.out.println("3) Reward won");
        System.out.println("4) Print latest Orders");
        System.out.println("5) Exit");
    }

    @java.lang.Override
    public double getPrice(Item item1) {
        double price = 0;
        double tp = item1.getPrice(item1);

        if (item1.getOffer().equals("None") || item1.getOffer().equals("buy one get one")) {
            price = tp; // is case me buy one get one me mai bas quantity do kam kar doonga merchant ke stock me se
        }
        if (item1.getOffer().equals("25% off")) {
            price = (tp - (0.25 * tp));
        }

        return price;
    }

    public void Direct_buy(Item item3, long quantity) {
        if (item3.getOffer().equals("None") || item3.getOffer().equals("25% off") || (item3.getOffer().equals("buy one get one") && item3.getQuantity() == 1)) {
            if (item3.getQuantity() >= quantity) {
                Merchant tempmerchant = item3.getMerchant_name();
                ItemPrice P = new Customer();
                int counter = 0;
                double price = P.getPrice(item3); // Polymorphism used here to get the price which the customer will have to pay
                if (this.getMain_Balance() >= 1.005 * (price)*(quantity)) {
                    this.setMain_Balance(this.getMain_Balance() - 1.005 * (price)*(quantity));
                    counter++;
                } else {
                    System.out.println("entering in the else condition");
                    System.out.println(this.getRewards_Balance());
                    System.out.println(this.getTotalRewardsWon());
                    System.out.println((1.005 * (price)*quantity - this.getMain_Balance()));
                    if (this.getRewards_Balance() >= (1.005 * (price)*quantity - this.getMain_Balance())) {
                        System.out.println("Reward Balance " + this.getRewards_Balance());
                        this.setMain_Balance(0);
                        this.setRewards_Balance(this.getRewards_Balance() - (1.005*(price)*quantity - this.getMain_Balance()));
                        counter++;
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                }
                if (counter > 0) {
                    this.ListOfBoughtItems.add(item3);
                    item3.setQuantity(item3.getQuantity() - quantity); // Updating the quantity of the item.....
                    System.out.println("Item Successfully bought");
                    this.setNumber_Of_Purchases(this.getNumber_Of_Purchases() + 1);// The total number of orders of the person
                    item3.setPurchasedQuantity(item3.getPurchasedQuantity() + quantity);
                    Records.insert(item3.getNameOfProduct(),quantity,(price*quantity)*1.005,tempmerchant.getName());
                    tempmerchant.setContribution_to_Company(tempmerchant.getContribution_to_Company() + 0.01 * price*quantity);
                    Mercury.setAccountBalance(Mercury.getAccountBalance() + 0.01 * price*quantity);
                    if ((tempmerchant.getTempcontribution() + (0.01 * price*quantity)) >= 100) {
                        tempmerchant.setTempcontribution((tempmerchant.getTempcontribution() + (0.01 * price * quantity)) - 100);
                        tempmerchant.setMAX_LIMIT(tempmerchant.getMAX_LIMIT() + 1);
                        tempmerchant.setSlots_won(tempmerchant.getSlots_won() + 1);
                    } else {
                        tempmerchant.setTempcontribution(tempmerchant.getTempcontribution() + (0.01 * price*quantity));
                    }

                    if (this.getTemp_purchases() %5 == 0 ) {
                        System.out.println("Reward milaa hai");
                        this.setTemp_purchases((this.getTemp_purchases() + 1));
                        this.setRewards_Balance((this.getRewards_Balance() + 10));// Whenever the temp_purchases variable
                        // will become 5, the reward balance will increase by 10;
                        this.setTotalRewardsWon((this.getTotalRewardsWon() + 10)); // This will give the total reward money
                        // won by the customer
                    }
                    else{
                        this.setTemp_purchases((this.getTemp_purchases() + 1));
                    }
                    System.out.println("Balnce " +this.getMain_Balance() + " " +this.getRewards_Balance());
                }

            } else {
                System.out.println("Not sufficient quantity of the chosen item.");
            }

        }
        if (item3.getOffer().equals("buy one get one") && item3.getQuantity() > 1) {
            if (item3.getQuantity() >= 2 * (quantity)) {
                Merchant tempmerchant = item3.getMerchant_name();
                ItemPrice P = new Customer();
                int counter = 0;
                double price = P.getPrice(item3); // Polymorphism used here to get the price which the customer will have to pay
                if (this.getMain_Balance() >= 1.005 * (price)*quantity) {
                    this.setMain_Balance(this.getMain_Balance() - 1.005 * (price)*quantity);
                    counter++;
                } else {

                    if (this.getRewards_Balance() >= (1.005 * (price*quantity) - this.getMain_Balance())) {
                        this.setMain_Balance(0);
                        this.setRewards_Balance(this.getRewards_Balance() - (1.005 * (price*quantity) - this.getMain_Balance()));
                        counter++;
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                }
                if (counter > 0) {

                    this.ListOfBoughtItems.add(item3);
                    item3.setQuantity(item3.getQuantity() - 2 * quantity); // Updating the quantity of the item.....
                    System.out.println("Item Successfully bought");
                    this.setNumber_Of_Purchases(this.getNumber_Of_Purchases() + 1); // The total number of orders of the person
                    item3.setPurchasedQuantity(item3.getPurchasedQuantity() + 2*quantity);
                    this.Records.insert(item3.getNameOfProduct(),2*quantity,(price*quantity)*1.005,tempmerchant.getName());
                    tempmerchant.setContribution_to_Company(tempmerchant.getContribution_to_Company() + (0.01 * price*quantity));
                    Mercury.setAccountBalance(Mercury.getAccountBalance() + (0.01 * price*quantity));
                    if ((tempmerchant.getTempcontribution() + (0.01 * price*quantity)) >= 100){
                        tempmerchant.setTempcontribution((tempmerchant.getTempcontribution() + (0.01 * price*quantity)) - 100);
                        tempmerchant.setMAX_LIMIT(tempmerchant.getMAX_LIMIT() + 1);
                        tempmerchant.setSlots_won(tempmerchant.getSlots_won() + 1);
                    } else {
                        tempmerchant.setTempcontribution(tempmerchant.getTempcontribution() + 0.01 * price*quantity);
                    }

                    if (this.getTemp_purchases() %5 == 0 ) {
                        this.setTemp_purchases(this.getTemp_purchases() + 1);
                        this.setRewards_Balance((this.getRewards_Balance() + 10));// Whenever the temp_purchases variable
                        // will become 5, the reward balance will increase by 10;
                        this.setTotalRewardsWon((this.getTotalRewardsWon() + 10)); // This will give the total reward money
                        // won by the customer
                    }
                    else{
                        this.setTemp_purchases(this.getTemp_purchases() + 1);
                    }
                }
            } else {
                System.out.println("Insufficient quantity of the items chosen");
            }
        }
    }

    public int buythroughCart(Item item3, long quantity) {
        int success = 0;
        if (item3.getOffer().equals("None") || item3.getOffer().equals("25% off") || (item3.getOffer().equals("buy one get one") && item3.getQuantity() == 1)) {
            if (item3.getQuantity() >= quantity) {
                Merchant tempmerchant = item3.getMerchant_name();
                ItemPrice P = new Customer();
                int counter = 0;
                double price = P.getPrice(item3); // Polymorphism used here to get the price which the customer will have to pay
                if (this.getMain_Balance() >= 1.005 * (price)*quantity) {
                    this.setMain_Balance(this.getMain_Balance() - 1.005 * (price*quantity));
                    counter++;
                    success++;
                } else {
                    if (this.getRewards_Balance() >= (1.005 * (price*quantity) - this.getMain_Balance())) {
                        this.setMain_Balance(0);
                        this.setRewards_Balance(this.getRewards_Balance() - (1.005 * (price*quantity) - this.getMain_Balance()));
                        counter++;
                        success++;
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                }
                if (counter > 0) {
                    this.ListOfBoughtItems.add(item3);
                    item3.setQuantity(item3.getQuantity() - quantity); // Updating the quantity of the item.....
                    System.out.println("Item Successfully bought");
                    this.setNumber_Of_Purchases(this.getNumber_Of_Purchases() + 1);
                    // The total number of orders of the person
                    item3.setPurchasedQuantity(item3.getPurchasedQuantity() + quantity);
                    Records.insert(item3.getNameOfProduct(),quantity,(price*quantity)*1.005,tempmerchant.getName());
                    tempmerchant.setContribution_to_Company(tempmerchant.getContribution_to_Company() + (0.01 * price*quantity));
                    Mercury.setAccountBalance(Mercury.getAccountBalance() + (0.01 * price*quantity));
                    if ((tempmerchant.getTempcontribution() + (0.01 * price*quantity)) >= 100) {
                        tempmerchant.setTempcontribution((tempmerchant.getTempcontribution() + (0.01 * price*quantity)) - 100);
                        tempmerchant.setMAX_LIMIT(tempmerchant.getMAX_LIMIT() + 1);
                        tempmerchant.setSlots_won(tempmerchant.getSlots_won() + 1);
                    } else {
                        tempmerchant.setTempcontribution(tempmerchant.getTempcontribution() + (0.01 * price*quantity));
                    }
                }

            } else {
                System.out.println("Not sufficient quantity of the chosen item.");
            }

        }
        if (item3.getOffer().equals("buy one get one") && item3.getQuantity() > 1) {
            if (item3.getQuantity() >= 2 * (quantity)) {
                Merchant tempmerchant = item3.getMerchant_name();
                ItemPrice P = new Customer();
                int counter = 0;
                double price = P.getPrice(item3); // Polymorphism used here to get the price which the customer will have to pay
                if (this.getMain_Balance() >= 1.005 * (price*quantity)) {
                    this.setMain_Balance(this.getMain_Balance() - 1.005 * (price*quantity));
                    counter++;
                    success++;
                } else {
                    if (this.getRewards_Balance() >= (1.005 * (price*quantity) - this.getMain_Balance())) {
                        this.setMain_Balance(0);
                        this.setRewards_Balance(this.getRewards_Balance() - (1.005 * (price*quantity) - this.getMain_Balance()));
                        counter++;
                        success++;
                    } else {
                        System.out.println("Insufficient Balance");
                    }
                }
                if (counter > 0) {
                    this.ListOfBoughtItems.add(item3);
                    item3.setQuantity(item3.getQuantity() - 2 * quantity); // Updating the quantity of the item.....
                    System.out.println("Item Successfully bought");
                    this.setNumber_Of_Purchases(this.getNumber_Of_Purchases() + 1); // The total number of orders of the person
                    item3.setPurchasedQuantity(item3.getPurchasedQuantity() + 2*quantity);
                    Records.insert(item3.getNameOfProduct(),2*quantity,(price*quantity)*1.005,tempmerchant.getName());
                    tempmerchant.setContribution_to_Company(tempmerchant.getContribution_to_Company() + (0.01 * price*quantity));
                    Mercury.setAccountBalance(Mercury.getAccountBalance() + (0.01 * price*quantity));
                    if ((tempmerchant.getTempcontribution() + (0.01 * price*quantity)) >= 100) {
                        tempmerchant.setTempcontribution((tempmerchant.getTempcontribution() + (0.01 * price*quantity)) - 100);
                        tempmerchant.setMAX_LIMIT(tempmerchant.getMAX_LIMIT() + 1);
                        tempmerchant.setSlots_won(tempmerchant.getSlots_won() + 1);
                    } else {
                        tempmerchant.setTempcontribution(tempmerchant.getTempcontribution() + (0.01 * price*quantity));
                    }
                }
            } else {
                System.out.println("Insufficient quantity of the items chosen");
            }
        }
        return success;
    }

    public void AddtoCart(Item item) {
        this.ListOfPurchasedItems.add(item);
        System.out.println("Item added to Cart");
    }

    public void Checkout() {
        int successful_transactions = 0;
        while (true) {
            while (ListOfPurchasedItems.size() > 0) {
                int success = this.buythroughCart(ListOfPurchasedItems.get(0), ListOfPurchasedItems.get(0).getRequestedQuantity());
                ListOfPurchasedItems.remove(0);
                if (success == 0) {
                    break;
                } else {
                    successful_transactions++;
                }
            }
            break;
        }
        if (this.getTemp_purchases() %5 == 0 ) {
            this.setTemp_purchases((this.getTemp_purchases() + 1));
            this.setRewards_Balance((this.getRewards_Balance() + 10));// Whenever the temp_purchases variable
            // will become 5, the reward balance will increase by 10;
            this.setTotalRewardsWon((this.getTotalRewardsWon() + 10)); // This will give the total reward money
            // won by the customer
        }
        else{
            this.setTemp_purchases(this.getTemp_purchases() + 1);
        }
        }


    public void RecentTransactions()
    {
        int count = 0;
        Node cur = Records.top;
        while(cur != null)
        {
            System.out.println("Bought item " + cur.getitem_name() + " quantity: " + cur.getitem_quantity() + " for Rs "
            + cur.getitem_price() + " from Merchant: " + cur.getmerchant_name());
            cur = cur.next;
            count++;
            if (count >=10)
            {
                break;
            }
        }
    }
    public static void DisplayCustomerDetails(Customer tempc)
    {
        System.out.println("Name: " + tempc.getName());
        System.out.println("Address: " + tempc.getAddress());
        System.out.println("Number of order placed via the application: " + tempc.getNumber_Of_Purchases());
    }
}

class Merchant {

    private String Name;
    private String Address;
    private double Contribution_to_Company; // 1% of the price of the item sold to the merchant.
    private double tempcontribution; // This will get updated after every 100 contribution to company.
    private long ID = 1;
    private static long counter;
    private int slots_won;
    private int MAX_LIMIT = 10;
    public static ArrayList<Merchant> ListOfMerchants = new ArrayList<Merchant>();
    public  ArrayList<Item> ListOfItems = new ArrayList<Item>();

    public void setMAX_LIMIT(int MAX_LIMIT) {
        this.MAX_LIMIT = MAX_LIMIT;
    }

    public int getMAX_LIMIT() {
        return MAX_LIMIT;
    }

    public void setTempcontribution(double tempcontribution) {
        this.tempcontribution = tempcontribution;
    }

    public double getTempcontribution() {
        return tempcontribution;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAddress() {
        return Address;
    }

    public void setContribution_to_Company(double contribution) {
        Contribution_to_Company = contribution;
    }
    public double getContribution_to_Company(){
        return Contribution_to_Company;
    }
    public void setSlots_won(int slots_won){
        slots_won = slots_won;
    }
    public int getSlots_won(){
        return slots_won;
    }
    public void setID(long id)
    {
        ID = id;
    }
    public long getID()
    {
        return ID;
    }
    public Merchant(String Name) {
        this.setName(Name);
        this.setID(this.ID + counter);
        ++counter;
    }
    public Merchant(){
        this.setID(0);
    }
    // I am creating this method to get the merchant from the ID number of the merchant
    public static Merchant getMerchant(long id2)
    {
        Merchant tempMerchant = new Merchant();
        for (int u =0; u<ListOfMerchants.size(); u++)
        {
            if( id2 == ListOfMerchants.get(u).getID())
            {
                tempMerchant =  ListOfMerchants.get(u);
            }
        }
        return tempMerchant;
    }

    public static void DisplayListOfMerchants()
    {
        System.out.println("Choose Merchant: ");
        for (int i =0; i<ListOfMerchants.size(); i++)
        {
            System.out.println(ListOfMerchants.get(i).getID() + " " + ListOfMerchants.get(i).getName());
        }
    }
    public static void DisplayMerchantMenu(long tempnum)
    {
        int counter =0;
        for (int j =0; j<ListOfMerchants.size(); j++)
        {
            if (ListOfMerchants.get(j).getID() == tempnum)
            {
                counter++;
                System.out.println("Welcome " + ListOfMerchants.get(j).getName());
            }
        }
        if (counter == 0)
        {
            System.out.println("Please enter a valid ID of merchant.");
        }
        else {
            System.out.println("Merchant Menu");
            System.out.println("1) Add Item");
            System.out.println("2) Edit Item");
            System.out.println("3) Search by Category");
            System.out.println("4) Add Offer");
            System.out.println("5) Rewards won");
            System.out.println("6) Exit");
        }
    }
    // For Add Item option in the Merchant Menu
    public void addItem(String name, double price, long quantity, String category)
    {
        Item item1 = new Item(name);
        int counter = 0;
        if (ListOfItems.size() < MAX_LIMIT) {  // Checking for the condition of not allowing the merchant to
            // add more than maxlimit of the items.
            ListOfItems.add(item1); // Adding to the list of this particular merchant
            Item.ListOfAllItems.add(item1); // Adding to the list of all items maintained by the App.
            item1.setPrice(price);
            item1.setQuantity(quantity);
            item1.setCategory(category);
            item1.setMerchant_name(this); // The item will know about its merchant..
            Item.showItemDetails(item1);// printing the details of the product

            for (int i =0; i< Item.ListOfCategories.size(); i++){
                if ((Item.ListOfCategories.get(i)).equals(category)){
                    counter++; // Checking that if that category has been included earlier or not.
                }
            }
            if (counter == 0){
                Item.ListOfCategories.add(category);  // if it is a new category, then i will add it in the list of categories
            }
        }
        else {
            System.out.println("Maximum limit reached, cannot add more items.");
        }
    }
    // For the Edit Item Option of Merchant Menu
    // This will display the list of all items for the merchant
    public void showMyItemsDetails()
    {
        for (int l = 0; l < this.ListOfItems.size(); l++) {
            Item.showItemDetails(this.ListOfItems.get(l));
        }

    }
    public static void DisplayMerchantDetails(Merchant tempmerchant)
    {
        System.out.println("Name: " +  tempmerchant.getName());
        System.out.println("Address: " + tempmerchant.getAddress());
        System.out.println("Total Contribution to Company's account: " + tempmerchant.getContribution_to_Company());
    }



}

interface ItemPrice
{
    public double getPrice(Item item1); // I will extend this interface to Customer class. As the final price of any item will
    // depend on the offer applied on the object. So I am looking to apply the offer on a single item and then multiply
    // it with the quantity of the items bought by the customer... So, there will be a different definition of getPrice
    // in different classes i.e. Item and Customer. Also I can use polymorphism in this way..
}
class Item implements ItemPrice{
    private long ID = 1;
    private static long counter;
    private double Price;
    private String NameOfProduct;
    private String Category;
    private String Offer="None";
    private long Quantity;
    private long PurchasedQuantity;
    private long RequestedQuantity;
    private Merchant merchant_name;
    public static ArrayList<String> ListOfCategories = new ArrayList<String>();
    public static ArrayList<Item> ListOfAllItems = new ArrayList<Item>();

    public void setRequestedQuantity(long r)
    {
        RequestedQuantity = r;
    }
    public long getRequestedQuantity()
    {
        return RequestedQuantity;
    }
    public void setPurchasedQuantity(long num )
    {
        PurchasedQuantity = num;
    }
    public long getPurchasedQuantity()
    {
        return PurchasedQuantity;
    }
    public void setID(long ID) {
        this.ID = ID;
    }

    public long getID() {
        return ID;
    }
    public void setPrice(double price1)
    {
        Price = price1;
    }

    @java.lang.Override
    public double getPrice(Item item2) {
        return Price;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getCategory() {
        return Category;
    }

    public void setNameOfProduct(String nameOfProduct) {
        NameOfProduct = nameOfProduct;
    }

    public String getNameOfProduct() {
        return NameOfProduct;
    }

    public void setOffer(String offer) {
        Offer = offer;
    }

    public String getOffer() {
        return Offer;
    }

    public long getQuantity() {
        return Quantity;
    }

    public void setQuantity(long quantity) {
        Quantity = quantity;
    }

    public void setMerchant_name(Merchant merchant_name) {
        this.merchant_name = merchant_name;
    }

    public Merchant getMerchant_name() {
        return merchant_name;
    }

    public Item(String Name)
    {
        this.setNameOfProduct(Name);
        this.setID(this.ID + counter);
        ++counter;
    }
    public Item()
    {
        this.setID(0);
    }
    // A method to give item as return when given the ID of the item as an argument
    public static Item getItem(long id3)
    {
        Item tempItem = new Item();
        for (int m =0; m<ListOfAllItems.size();m++)
        {
            if (id3 == ListOfAllItems.get(m).getID())
            {
                tempItem = ListOfAllItems.get(m);
            }
        }
        return tempItem;
    }
    public static void showItemDetails(Item item1)
    {
        System.out.println(item1.getID() + " " + item1.getNameOfProduct() + " " + item1.getPrice(item1) + " " + item1.getQuantity() + " "
                + item1.getOffer() + " " + item1.getCategory());
    }
    // Editing the details of the item in the second query of the merchant class
    public void editDetails(double db, long lg)
    {
        this.setPrice(db);
        this.setQuantity(lg);
        this.setOffer("Null");
        Item.showItemDetails(this);
    }
    // For query 3 of Merchant class and query 1 of Customer Class
    public static void displayAllCategories()
    {
        int counter = 1;
        for (int h=0;h<ListOfCategories.size(); h++)
        {
            System.out.println(counter + ") " + ListOfCategories.get(h));
            counter++;
        }
    }
    public static void display_items_from_given_categories(int temp)
    {
        String tempstring = ListOfCategories.get(temp-1); // getting the string of the requested category
        for (int i=0;i<ListOfAllItems.size(); i++)
        {
            if ((ListOfAllItems.get(i).getCategory()).equals(tempstring))
            {
                Item.showItemDetails(ListOfAllItems.get(i));
            }
        }
    }
    // for option4 of merchant menu to change the offer status of an item
    public void chooseOffer(int random)
    {
        if (random == 1)
        {
            this.setOffer("buy one get one");
        }
        if (random == 2)
        {
            this.setOffer("25% off");
        }
        else{
            System.out.println("Invalid Input");
        }
    }
}

class Mercury{
    private static double AccountBalance;

    public static void setAccountBalance(double accountBalance) {
        AccountBalance = accountBalance;
    }

    public static double getAccountBalance() {
        return AccountBalance;
    }

    private Mercury()
    {}
    public static void DisplayMainMenu()
    {
        System.out.println("Welcome to Mercury");
        System.out.println("1) Enter as Merchant");
        System.out.println("2) Enter as Customer");
        System.out.println("3) See user details");
        System.out.println("4) Company Account Balance");
        System.out.println("5) Exit");
    }
    public static void DisplayList()
    {
        System.out.println("Customers: ");
        for (int i =0; i<Customer.ListOfCustomers.size();i++)
        {
            Customer tempc = Customer.ListOfCustomers.get(i);
            System.out.println(tempc.getID() + " " + tempc.getName());
        }
        System.out.println("Merchants: ");
        for (int j =0; j < Merchant.ListOfMerchants.size(); j++)
        {
            Merchant tempm = Merchant.ListOfMerchants.get(j);
            System.out.println(tempm.getID() + " " + tempm.getName());
        }

    }

}

class Node
{
    private String item_name;
    private long item_quantity;
    private double item_price;
    private String merchant_name;
    Node next;
    public Node()
    {
        this.next=null;
    }
    public void setitem_name(String name)
    {
        item_name = name;
    }
    public String getitem_name()
    {
        return item_name;
    }
    public void setitem_quantity(long q)
    {
        item_quantity = q;
    }
    public long getitem_quantity()
    {
        return item_quantity;
    }
    public void setitem_price(double d)
    {
        item_price = d;
    }
    public double getitem_price()
    {
        return item_price;
    }
    public void setmerchant_name(String m)
    {
        merchant_name = m;
    }
    public String getmerchant_name()
    {
        return merchant_name;
    }
}
class Stack {
    Node top;

    public Stack() {
        this.top = null;
    }

    public void insert(String item_name, long item_quantity, double item_price, String merchant_name) {
        Node tempnode = new Node();
        tempnode.setitem_name(item_name);
        tempnode.setitem_quantity(item_quantity);
        tempnode.setitem_price(item_price);
        tempnode.setmerchant_name(merchant_name);
        if (top == null) {
            top= tempnode;
        }
        else {
            tempnode.next = top;
            top = tempnode;
        }
    }



}











