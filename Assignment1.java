import java.util.*;
import java.lang.*;
public class Assignment1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int NumberOfStudents = input.nextInt(); // This will be maintained as the number of remaining students.
        // I will subtract 1 from it everytime a student gets placed
        for (int c = 0; c < NumberOfStudents; c++) {
            float cgpa = input.nextFloat();
            String branch_name = input.next().toUpperCase(); // Converting all to uppercase to avoid lower branch names
            // cases.
            if (!(branch_name.equals("CSSS")) && !(branch_name.equals("CSE")) && !(branch_name.equals("CSD")) && !(branch_name.equals("CSAM")) && !(branch_name.equals("CSB")) && !(branch_name.equals("ECE"))  )
                System.out.println("Please Enter a valid branch");
            // This if statement is to check for different branch names other than mentioned.
            else {
                Student s1 = new Student(cgpa);
                s1.setBranch(branch_name);

            }
        }
        System.out.println("--- - Students registered - ---");

        while (NumberOfStudents > 0) {
            int query = input.nextInt();
            /////////////////////////////query1 begins///////////////////////////////////////////////////////
            if (query == 1) {
                Company cmp1 = new Company(); // creating a new company
                String company_name = input.next(); // taking input of company name
                cmp1.name = company_name; // name of company is set
                System.out.println("Number of Eligible courses: ");
                int ncourses = input.nextInt(); // taking input for number of courses
                cmp1.setNumberOfCourses(ncourses);
                for (int y = 0; y < ncourses; y++) {
                    String coursename = input.next().toUpperCase(); // converting the coursenames to upper cases
                    // to avoid lower case problems.
                    cmp1.Course_Criteria.add(coursename);
                    //This will add the strings of the courses to the arraylist of the company
                    // maintaing the course criteria.
                }
                System.out.println("Number of required students: ");
                int requiredstudents = input.nextInt(); // Taking number of required students for the company
                cmp1.capacity = requiredstudents;
                Placement_Office.DisplayCompany(cmp1); // Here is the command for displaying the details of company
                System.out.println("Enter scores for the technical round ");
                ////////////////////////////////////////////////////////////////////////////
                for (int t = 0; t < cmp1.Course_Criteria.size(); t++) { // Traversing the arraylist
                    String tempstring = cmp1.Course_Criteria.get(t);
                    // In the following six comparisons, I compared the string obtained from the arraylist
                    // of company to the branch_name string
                    // This is done to get the roll number of students of different branches
                    // to display  and ask for the technical score of that student
                    if (tempstring.equals("CSSS")) {
                        cmp1.Applicable_Students = cmp1.Applicable_Students + Student.csss_strength;
                        // this will update the number of applicable students
                        for (int s = 0; s < Student.CSSS_Students.size(); s++) {
                            Student tempstudent = Student.CSSS_Students.get(s);
                            System.out.println("Enter score for Roll no. " + tempstudent.getRollNumber());
                            float scoreget = input.nextInt();
                            tempstudent.C_S.insert(scoreget, cmp1.name);
                            // once the score is obtained, I am updating the score and the
                            // corresponding company in the linkedlist of student C_S
                            cmp1.finallist.addAll(Student.CSSS_Students);
                            //This will merge the list of finallist and particular branch list
                        }
                    }
                    if (tempstring.equals("CSE")) {
                        cmp1.Applicable_Students = cmp1.Applicable_Students + Student.cse_strength;
                        for (int s = 0; s < Student.CSE_Students.size(); s++) {
                            Student tempstudent = Student.CSE_Students.get(s);
                            System.out.println("Enter score for Roll no. " + tempstudent.getRollNumber());
                            float scoreget = input.nextInt();
                            tempstudent.C_S.insert(scoreget, cmp1.name);
                            cmp1.finallist.addAll(Student.CSE_Students);
                        }
                    }
                    if (tempstring.equals("CSD")) {
                        cmp1.Applicable_Students = cmp1.Applicable_Students + Student.csd_strength;
                        for (int s = 0; s < Student.CSD_Students.size(); s++) {
                            Student tempstudent = Student.CSD_Students.get(s);
                            System.out.println("Enter score for Roll no. " + tempstudent.getRollNumber());
                            float scoreget = input.nextInt();
                            tempstudent.C_S.insert(scoreget, cmp1.name);
                            cmp1.finallist.addAll(Student.CSD_Students);
                        }
                    }
                    if (tempstring.equals("CSB")) {
                        cmp1.Applicable_Students = cmp1.Applicable_Students + Student.csb_strength;
                        for (int s = 0; s < Student.CSB_Students.size(); s++) {
                            Student tempstudent = Student.CSB_Students.get(s);
                            System.out.println("Enter score for Roll no. " + tempstudent.getRollNumber());
                            float scoreget = input.nextInt();
                            tempstudent.C_S.insert(scoreget, cmp1.name);
                            cmp1.finallist.addAll(Student.CSB_Students);
                        }
                    }
                    if (tempstring.equals("CSAM")) {
                        cmp1.Applicable_Students = cmp1.Applicable_Students + Student.csam_strength;
                        for (int s = 0; s < Student.CSAM_Students.size(); s++) {
                            Student tempstudent = Student.CSAM_Students.get(s);
                            System.out.println("Enter score for Roll no. " + tempstudent.getRollNumber());
                            float scoreget = input.nextInt();
                            tempstudent.C_S.insert(scoreget, cmp1.name);
                            cmp1.finallist.addAll(Student.CSAM_Students);
                        }
                    }
                    if (tempstring.equals("ECE")) {
                        cmp1.Applicable_Students = cmp1.Applicable_Students + Student.ece_strength;
                        for (int s = 0; s < Student.ECE_Students.size(); s++) {
                            Student tempstudent = Student.ECE_Students.get(s);
                            System.out.println("Enter score for Roll no. " + tempstudent.getRollNumber());
                            float scoreget = input.nextInt();
                            tempstudent.C_S.insert(scoreget, cmp1.name);
                            cmp1.finallist.addAll(Student.ECE_Students);

                        }
                    }


                }

            }
            ///////////////////////////////////////////////////////////////////query1 over///////////////////////////


            if (query == 2) {
                Placement_Office.removeStudents(); // Already the method was made for solving this
            }
            if (query == 3) {
                Placement_Office.removeCompanies();
            }
            if (query == 4) {
                System.out.println(NumberOfStudents + " students left.");
            }
            if (query == 5) {
                Placement_Office.DisplayAvailableCompanies();
            }
            ///////////////////////////query 6 begins/////////////////////////////////////////
            if (query == 6) {
                String cmpny_name = input.next(); // Taking the company name
                int counter2 = 0;
                for (int h = 0; h < Company.Companies.size(); h++) { // Traversing the list of companies
                    if (cmpny_name.equals(Company.Companies.get(h).name)) {
                        counter2++;
                        Company nayi = Company.Companies.get(h);
                        if (nayi.capacity < nayi.Applicable_Students) { // if required students is less than available
                            while (nayi.capacity > 0) {
                                Student selected = nayi.BestinList(nayi.finallist); // already made method
                                nayi.selectStudent(selected); // the student is selected
                                NumberOfStudents = NumberOfStudents - 1; // decrementing the total remaining students
                                nayi.capacity = nayi.capacity - 1; // is company ki capacity kam ho jaaegi
                            }
                            nayi.ApplicationStatus = "CLOSED";
                        }
                        if (nayi.capacity >= nayi.Applicable_Students) { // if required jyada ho but available hi naa ho
                            for (int u = 0; u < nayi.finallist.size(); u++) {
                                nayi.selectStudent(nayi.finallist.get(u)); // sab ko le lenge jo bhi hai finallist me
                            }
                            NumberOfStudents = NumberOfStudents - nayi.Applicable_Students;
                            // remaining students will be previous - available bachhe for that company
                            nayi.ApplicationStatus = "CLOSED";
                        }
                    }
                }
                if (counter2 == 0)
                    System.out.println("The mentioned company does not exist"); // The company was not in the list of
                //companies
                for (int l= 0; l < Company.Companies.size(); l++) {
                    if (cmpny_name.equals(Company.Companies.get(l).name)) {
                        Company yo = Company.Companies.get(l);
                        yo.ShowSelectedStudentsRN(); // already made method to display the roll numbers
                    }
                }
            }
            ////////////////////////query 6 ends////////////////////////////////////////////

            if (query == 7) {
                String cmpny_name = input.next();
                int counter3 = 0;
                for (int p = 0; p < Company.Companies.size(); p++) {
                    if (cmpny_name.equals(Company.Companies.get(p).name)) {
                        counter3++;
                        Placement_Office.DisplayCompany(Company.Companies.get(p)); // Already made method
                    }
                }
                if (counter3 == 0)
                    System.out.println("The mentioned company does not exist");

            }
            if (query == 8) {
                long rollnum = input.nextLong();
                Student.Studentdetails(rollnum); // Already made method
            }
            if (query == 9) {
                long rollnum2 = input.nextLong();
                Placement_Office.Company_Scores(rollnum2); // Already made method
            }
        }
    }
}
class Student // The student class
{
    private float CGPA; //The Cgpa of each student will be stored
    // RollNumber unique and progressing from 1;
    private long RollNumber = 1;
    public static long counter; // This static variable will ensure that rollnumber is incremented for every object
    private String Branch;
    public LL C_S = new LL(); // this linkedlist object will hold the name of companies and the corresponding score
    // in the technical round//
    public String Placement_Status= "Not Placed"; // The status of the student's placement.
    private String Company_placed = "Not Placed Yet"; // The company in which the student finally get placed
    public static ArrayList<Student> Students = new ArrayList<Student>();
    // This Arraylist will store all the students objects which are instantiated. This will help in not loosing the
    // students when we remove them from LOS(List Of Students) of Placement class.
    // Now I am creating static variables to store the batch strength of each batch.
    public static int csam_strength;
    public static int cse_strength;
    public static int csb_strength;
    public static int csss_strength;
    public static int ece_strength;
    public static int csd_strength;
    // Here I am initializing the Arraylist of all the batches separately
    //These Arraylists will hold particular batch students for convenience
    public static ArrayList<Student> CSSS_Students = new ArrayList<Student>();
    public static ArrayList<Student> CSE_Students = new ArrayList<Student>();
    public static ArrayList<Student> CSD_Students = new ArrayList<Student>();
    public static ArrayList<Student> CSB_Students = new ArrayList<Student>();
    public static ArrayList<Student> CSAM_Students = new ArrayList<Student>();
    public static ArrayList<Student> ECE_Students = new ArrayList<Student>();

    public void setRollNumber(long rolln)
    {
        RollNumber = rolln; // for setting the roll numbers
    }
    public long getRollNumber(){
        return RollNumber; // To get the roll numbers
    }
    public void setCGPA(float cgpa)
    {
        this.CGPA = cgpa;
    }
    public float getCGPA()
    {
        return CGPA;
    }
    /////////////Constructor of Student Class/////////////
    public Student(float cgpa)
    {
        Students.add(this);
        Placement_Office.LOS.add(this);
        this.setCGPA(cgpa);
        this.setRollNumber(RollNumber + counter);
        counter++;

    }
    public Student()
    {
        this.setRollNumber(0); // For all the objects who are instantiated in any other method
        // I am setting their roll number to be zero. Also , I will initiate them with this constructor//
    }
    /////////////////////////////////////////////////////////
    public void setBranch(String branch)
    {
        this.Branch = branch;
        if (branch.equals("CSSS"))
        {
            CSSS_Students.add(this); // Adding the student to arraylist of csss students
            csss_strength++;           // Incrementing the strength of the CSSS batch
        }
        if (branch.equals("CSD"))
        {
            CSD_Students.add(this);
            csd_strength++;
        }
        if (branch.equals("CSB"))
        {
            CSB_Students.add(this);
            csb_strength++;
        }
        if (branch.equals("CSE"))
        {
            CSE_Students.add(this);
            cse_strength++;
        }
        if (branch.equals("CSAM"))
        {
            CSAM_Students.add(this);
            csam_strength++;
        }
        if (branch.equals("ECE"))
        {
            ECE_Students.add(this);
            ece_strength++;
        }
    }
    /////////////////////////////////////////////////////////////////
    public String getBranch()
    {
        return Branch;
    }
    public void setCompany_placed(String cp)
    {
        this.Company_placed = cp;
    }
    public String getCompany_placed()
    {
        return Company_placed;
    }
    //////////////////////////////////////////////////////////////////
    /////// This method is for the opiton 8. I created a Student Array because the arraylist in
    // placement office will be updated when a student will be removed. But this arraylist will not be updated
    public static void Studentdetails(long you) {
        for (int n = 0; n < Student.Students.size(); n++) { // Traversing in the list of students to get the same
            // Roll number
            long match = Student.Students.get(n).getRollNumber(); // match will hold the roll number of every object
            // while traversing
            if (match == you) { // roll number matched
                System.out.println(Student.Students.get(n).getRollNumber());
                System.out.println(Student.Students.get(n).getCGPA());
                System.out.println(Student.Students.get(n).getBranch());
                System.out.println("Placement Status: " + Student.Students.get(n).Placement_Status);
                if (Student.Students.get(n).Placement_Status.equals("Placed")) {
                    System.out.println(Student.Students.get(n).Company_placed);
                }

            }
        }

    }
    /////////////////////////////////////////////////////////////////////////

}

class Placement_Office
{
    public static ArrayList<Company> LOC=  new ArrayList<Company>(); // The list of companies which will be updated
    // consistently whenever a company is removed
    public static ArrayList<Student> LOS = new ArrayList<Student>(); // The list of students which will be uploaded
    // consistently whenever a student is removed


    // The following method is for option 2 of the input
    // Removing the selecting students
    //////////////////////////////////////////////////////////////////////////////
    public static void removeStudents()
    {
        int count =0;
        for (int j=0;j<LOS.size();j++) // Traversing in the LOS arraylist
        {
            Student temp = LOS.get(j);
            if (temp.Placement_Status.equals("Placed"))
            {
                count = count +1;
                System.out.println("Accounts removed for");
                System.out.println(temp.getRollNumber());
                LOS.remove(j); // Removing the student from the list of Students in the placement office
            }
        }
        if (count == 0)
            System.out.println("No placed students to remove");
        // If none of the student is placed, this will be printed
    }
    /////////////////////////////////////////////////////////////////////////////////
    // The following method is for option 3 of the input
    public static void removeCompanies()
    {
        int count1 = 0;
        for (int k =0; k< LOC.size();k++) // Traversing in the list of companies
        {
            Company tempc = LOC.get(k);
            if (tempc.ApplicationStatus.equals("CLOSED"))
            {
                count1++;
                System.out.println("Accounts removed for");
                System.out.println(tempc.name);
                LOC.remove(k); // Removing the company from the list of companies//
            }
        }
        if (count1 == 0)
            System.out.println("No Company is full"); // If none of the company is full then this will get printed
    }
    /////////////////////////////////////////////////////////////////////////////////
    // The following method is for option 1 and 7 as well of the input. when the company details are printed on the screen//
    public static void DisplayCompany(Company cmp)
    {
        System.out.println("Name: " + cmp.name);
        System.out.println("Course Criteria:");
        for (int l =0; l<cmp.Course_Criteria.size(); l++)
        {
            System.out.println(cmp.Course_Criteria.get(l));
        }
        System.out.println("Number of Required Students = " + cmp.capacity);
        System.out.println("Application Status = " + cmp.ApplicationStatus);
    }
    ////////////////////////////////////////////////////////////////////////////////
    // This method is designed for the option 5 of the input which will display all the companies whose application
    //status is open
    public static void DisplayAvailableCompanies()
    {
        int count2 = 0;
        for (int m=0; m< LOC.size();m++)
        {
            Company tempc = LOC.get(m);
            if (tempc.ApplicationStatus.equals("OPEN"))
            {
                count2++;
                System.out.println(tempc.name);
            }
        }
        if (count2== 0)
            System.out.println("Every company is full");
    }
    ///////////////////////////////////////////////////////////////////////////////
    // This method will be used for Option 9
    //Using the linkedlist named C_S, I will print the name of applied companies with the corresponding
    // scores in their technical round.
    public static void Company_Scores(float roll)

    {       int counter=0;
        for (int n =0; n< LOS.size(); n++)
        {
            if (LOS.get(n).getRollNumber()== roll)
            {
                counter++;
                Node temp = LOS.get(n).C_S.head;
                if (temp==null)
                {
                    System.out.println("Not given the technical round of any company");
                    // This is because the linked list is not updated
                    // Maybe the student is not eligible for any company
                }
                else{
                    while(temp != null)
                    {
                        System.out.println(temp.getCmp() + " " + temp.getScore());
                        temp = temp.next;
                    }
                }
            }
        }
        if (counter == 0)
        {
            System.out.println("No student with the given roll number has an account");
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////
}


class Company
{
    public int capacity; // Required number of students by the company
    public String ApplicationStatus; // Application sTatus of the company
    public ArrayList<String> Course_Criteria = new ArrayList<String>();
    // This arraylist will hold the strings of branch names which is eligible for the company
    public String name; // Name of the company
    public ArrayList<Student> finallist = new ArrayList<Student>();
    // This list will hold the students who all are applicable for the admission in this company
    private int NumberOfCourses; // Like CSSS or CSE... How many different branches they are interested in.
    public ArrayList<Long> SelectedStudentsRN = new ArrayList<Long>();
    // This method will solve the input num 6. The arraylist will hold the roll numbers of selected students
    public static ArrayList<Company> Companies = new ArrayList<Company>();
    // This is a separate list of companies which will maintain all the companies created.
    // This list will not be updated when a company is removed
    public int Applicable_Students; // This is the number of all the students who are eligible for this company
    // basically this variable is the size of the finallist arraylist.
    /////// Constructor////////////////////////////////
    public Company() {
        this.ApplicationStatus = "OPEN";
        Placement_Office.LOC.add(this); //Adding this company to the list of companies maintained by Placement office
        Companies.add(this); // Adding this company to companies list which is maintained by the class itself.
    }
    ///////////////////////////////////////////////////
    public void setNumberOfCourses(int num1)
    {
        this.NumberOfCourses= num1;
    }
    ////////////////////////////////////////////////
    public int getNumberOfCourses()
    {
        return NumberOfCourses;
    }
    ///////////////////////////////////////////////
    //This method finds out the top priority student on the basis of his score
    // and CGPA who will be selected first by the company
    public Student BestinList(ArrayList<Student> list) // An arraylist of students will be passed and a student object
    // will be returned
    {
        float max = -1;
        Student winner = new Student();
        for (int i=0; i<list.size();i++)
        {   Node tempscore = list.get(i).C_S.head;
            while (tempscore.getCmp() != this.name)
            {
                tempscore = tempscore.next;
            }
            if (tempscore.getScore() > max )
            {
                max = tempscore.getScore();
                winner = list.get(i);
            }
            if ( tempscore.getScore() == max)
            {
                if (winner.getCGPA() < list.get(i).getCGPA())
                {
                    winner = list.get(i);
                }
            }

        }
        return winner;
    }
    ///////////////////////////////////////////////////////////////////////
    // The function responsible for selecting the students finally////
    public void selectStudent(Student st)
    {
        st.Placement_Status = "Placed";
        st.setCompany_placed(this.name);
        this.SelectedStudentsRN.add(st.getRollNumber());
    }
    /////////////////////////////////////////////////////////////////
    // This method will be used to solve the Option 6 of the query
    // to show the list of roll numbers of students who are selected
    // by the given company
    public void ShowSelectedStudentsRN()
    {
        if (SelectedStudentsRN.size()==0)
        {
            System.out.println("No student has been selected right now");
        }
        else {
            for (int b = 0; b < SelectedStudentsRN.size(); b++) {
                System.out.println("Roll number of Selected students: ");
                System.out.println(SelectedStudentsRN.get(b));
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////
}
class Node // Creating for the linkedlist
{
    private float Score; // will store score of students
    private String Cmp; //  will store corresponding company
    Node next;
    public Node()
    {
        this.next=null;
    }
    public void setScore(float Scoreb)
    {
        this.Score = Scoreb;
    }
    public float getScore()
    {
        return Score;
    }
    public void setCmp(String Cmpb)
    {
        this.Cmp = Cmpb;
    }
    public String getCmp()
    {
        return Cmp;
    }
}
class LL {
    Node head;

    public LL() {
        this.head = null;
    }

    public void insert(float Scores, String Cmps) {
        Node tempnode = new Node();
        tempnode.setScore(Scores);
        tempnode.setCmp(Cmps);
        if (head == null) {
            head = tempnode;
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = tempnode;
        }
    }


}



