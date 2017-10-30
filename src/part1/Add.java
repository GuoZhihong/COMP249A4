// -----------------------------------------------------
// Assignment #4
// Part: (1)
// Written by: Zhihong Guo(40038183),Tiantian Ji(27781083)
// -----------------------------------------------------


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

public class Add {

    /*
    private attributes
     */
    private ArrayList<StaffMembers> staffArrayList;
    private ArrayList<Full_Time_Faculty_Members> fullTimeFacultyArrayList;
    private ArrayList<Part_Time_Faculty_Members> partTimeFacultyArrayList;
    private ArrayList<TAs> TAArrayList;
    private ArrayList<Long> idArrayList = new ArrayList<Long>();

    /*
     * A private method that reads Staff to Array List
     */
    private void readStaffToList(){
        Scanner sc = null;
        staffArrayList = new ArrayList<StaffMembers>();//create a Staff member array list
        StaffMembers staff = new StaffMembers();

        long id ;
        String firstName;
        String lastName;
        String city;
        int hireYear;
        long salary;
        String performanceCode;
        try{
            sc = new Scanner(new FileInputStream("Staff.txt"));//open the input stream

            while (sc.hasNextLine()){//read the file until the end

                id = sc.nextLong();
                firstName = sc.next();
                lastName = sc.next();
                city = sc.next();
                hireYear = sc.nextInt();
                salary = sc.nextLong();
                performanceCode = sc.next();

                staff = new StaffMembers(id,firstName,lastName,city,hireYear,salary,performanceCode);//create a new staff using the information just read
                staffArrayList.add(staff);//add staff to list

                String q = sc.nextLine();//turn to next line
            }



        }
        /*
        exceptions
         */
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        catch (IOException e){
            System.out.println("IO exception");
        }catch (NoSuchElementException E){
        }//catch the exception

        sc.close();// input stream closes

       





    }

    /*
    a method that prompts the user to enter staff information and adds it in the array list
     */
    public void addStaff(){
        Scanner kb = new Scanner(System.in);
        long id ;
        String firstName;
        String lastName;
        String city;
        int hireYear;
        long salary;
        String performanceCode;

        System.out.println("please enter staff id");
        id = kb.nextLong();
        while(id != -1){//keeps looping when id is not -1

            System.out.println("please enter first name");
            firstName = kb.next();
            System.out.println("please enter last name");
            lastName = kb.next();
            System.out.println("please enter city");
            city = kb.next();
            System.out.println("please enter hire year");
            hireYear = kb.nextInt();
            System.out.println("please enter fixed annual salary");
            salary = kb.nextLong();
            System.out.println("please enter performance code");
            performanceCode = kb.next();

            StaffMembers staff = new StaffMembers(id,firstName,lastName,city,hireYear,salary,performanceCode);//create new staff using the information provided by users
            staffArrayList.add(staff);//add it to list

            System.out.println("please enter staff id, enter -1 if you want to finish");
            id = kb.nextLong();
            if(id == -1){//stop adding when entering -1
                System.out.println("finish entering staff information");
            }
        }


    }

    /*
    a private method that write the array list to txt
     */
    private void writeToText(){
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new FileOutputStream("Staff.txt"));// open the input stream

            for (StaffMembers staff: staffArrayList){
                pw.print(staff.getEmployeeID());
                pw.print(staff.getFirstName());
                pw.print(staff.getFamilyName());
                pw.print(staff.getCityOfResidence());
                pw.print(staff.getHireYear());
                pw.print(staff.getSalary());
                pw.print(staff.getPerformanceCode());
                pw.println();
            }//looping from 1st to last
        }
        /*
        exceptions
         */
        catch (FileNotFoundException e){
            System.out.println("file not found");
        }//catch exception
        pw.close();// output stream closes

    }
    ////////////////////////////////////////////////////////////////////////////////////

    /*
    private method that read FT employee to array .ist
     */
    private void readFTToList(){
        Scanner sc = null;
        fullTimeFacultyArrayList = new ArrayList<Full_Time_Faculty_Members>();
        Full_Time_Faculty_Members fullTimeFaculty = new Full_Time_Faculty_Members();

        long id ;
        String firstName;
        String lastName;
        String city;
        int hireYear;
        long salary;

        //try block that reads the file
        try{
            sc = new Scanner(new FileInputStream("Full-Time-Faculty.txt"));//open the input stream

            while (sc.hasNextLine()){
                id = sc.nextLong();
                firstName = sc.next();
                lastName = sc.next();
                city = sc.next();
                hireYear = sc.nextInt();
                salary = sc.nextLong();


                fullTimeFaculty = new Full_Time_Faculty_Members(id,firstName,lastName,city,hireYear,salary);// new a full time faculty
                fullTimeFacultyArrayList.add(fullTimeFaculty);//put it the array

                String q = sc.nextLine();//next line
            }

        }
        /*
        exceptions
         */
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        catch (IOException e){
            System.out.println("IO exception");
        }catch (NoSuchElementException e) {
        }

        sc.close();// input stream closes
    }

    /*
    prompt users to enter employee information and stores it into the array list
     */
    public void addFTRecords(){
        /*
        read all the information into the array list
         */
        readPTToList();
        readFTToList();
        readTAToList();
        readStaffToList();

        Scanner kb = new Scanner(System.in);
        long id ;
        String firstName;
        String lastName;
        String city;
        int hireYear;
        long salary;

        do{
            System.out.println("please enter full time faculty id");
            id = kb.nextLong();
            if(contains(id)){
                System.out.println("id already exists, please enter again");
            }
        }while(contains(id));//keep asking if the id already exists,

        while(id != -1){

            System.out.println("please enter first name");
            firstName = kb.next();
            System.out.println("please enter last name");
            lastName = kb.next();
            System.out.println("please enter city");
            city = kb.next();
            System.out.println("please enter hire year");
            hireYear = kb.nextInt();
            System.out.println("please enter salary");
            salary = kb.nextLong();


            Full_Time_Faculty_Members fullTimeFaculty = new Full_Time_Faculty_Members(id,firstName,lastName,city,hireYear,salary);
            fullTimeFacultyArrayList.add(fullTimeFaculty);//creat a new FT and add it into array list

            do{
                System.out.println("please enter full time faculty id, enter -1 if you want to finish");
                id = kb.nextLong();
                if(contains(id)){
                    System.out.println("id already exists, please enter again");
                }
            }while(contains(id));//keep asking if id already exists
            if(id == -1){
                System.out.println("finish entering full time faculty information");
            }
        }
        writeFTToText();// change the file permanently
    }

    /*
    a private method that write info in the list to txt
     */
    private void writeFTToText(){
        PrintWriter pw = null;

        //try block that tries to find and write in file
        try {
            pw = new PrintWriter(new FileOutputStream("Full-Time-Faculty.txt"));// open the output stream

            for (Full_Time_Faculty_Members fullTimeFaculty: fullTimeFacultyArrayList){
                pw.print(fullTimeFaculty.getEmployeeID()+" ");
                pw.print(fullTimeFaculty.getFirstName()+" ");
                pw.print(fullTimeFaculty.getFamilyName()+" ");
                pw.print(fullTimeFaculty.getCityOfResidence()+" ");
                pw.print(fullTimeFaculty.getHireYear()+" ");
                pw.println(fullTimeFaculty.getSalary());

            }
        }
        /*
        exceptions
         */
        catch (FileNotFoundException e){
            System.out.println("file not found");
        }//catch exception
        pw.close();//output stream closes

    }

    ///////////////////////////////////////////////////////////////////////

    /*
    private method that reads PT to list
     */
    private void readPTToList(){
        Scanner sc = null;
        partTimeFacultyArrayList = new ArrayList<Part_Time_Faculty_Members>();
        Part_Time_Faculty_Members partTimeFaculty = new Part_Time_Faculty_Members();//create an array list and a pt member

        long id ;
        String firstName;
        String lastName;
        String city;
        int hireYear;
        double hourlyRate;
        int numberOfHoursOfCurrentTerm;
        int numberOfStudents;

        try{
            sc = new Scanner(new FileInputStream("Part-Time-Faculty.txt"));
            while (sc.hasNextLine()){
                id = sc.nextLong();
                firstName = sc.next();
                lastName = sc.next();
                city = sc.next();
                hireYear = sc.nextInt();
                hourlyRate = sc.nextDouble();
                numberOfHoursOfCurrentTerm = sc.nextInt();
                numberOfStudents = sc.nextInt();
                partTimeFaculty = new Part_Time_Faculty_Members(id,firstName,lastName,city,hireYear,hourlyRate,numberOfHoursOfCurrentTerm,numberOfStudents);
                partTimeFacultyArrayList.add(partTimeFaculty);//add it to list

                String q = sc.nextLine();


            }// keep reading while file has next line

        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        catch (IOException e) {
            System.out.println("IO exception");
        }catch(NoSuchElementException e){

        }//catch exception
        sc.close();//input stream closes
    }

    /*
    prompt user to enter info than add it to array list
     */
    public void addPTRecords(){
        readPTToList();
        readFTToList();
        readTAToList();
        readStaffToList();


        Scanner kb = new Scanner(System.in);
        long id ;
        String firstName;
        String lastName;
        String city;
        int hireYear;
        double hourlyRate;
        int numberOfHoursOfCurrentTerm;
        int numberOfStudents;

        do{
            System.out.println("please enter part time faculty id");
            id = kb.nextLong();
            if(contains(id)){
                System.out.println("id already exists, please enter again");
            }
        }while(contains(id));
        while(id != -1){

            System.out.println("please enter first name");
            firstName = kb.next();
            System.out.println("please enter last name");
            lastName = kb.next();
            System.out.println("please enter city");
            city = kb.next();
            System.out.println("please enter hire year");
            hireYear = kb.nextInt();
            System.out.println("please enter hourly rate");
            hourlyRate = kb.nextDouble();
            System.out.println("please enter number of hours");
            numberOfHoursOfCurrentTerm = kb.nextInt();
            System.out.println("please enter number of students");
            numberOfStudents = kb.nextInt();


            Part_Time_Faculty_Members partTimeFaculty = new Part_Time_Faculty_Members(id,firstName,lastName,city,hireYear,hourlyRate,numberOfHoursOfCurrentTerm,numberOfStudents);
            partTimeFacultyArrayList.add(partTimeFaculty);

            do{
                System.out.println("please enter part time faculty id, enter -1 if you want to finish");
                id = kb.nextLong();
                if(contains(id)){
                    System.out.println("id already exists, please enter again");
                }
            }while(contains(id));
            if(id == -1){
                System.out.println("finish entering part time faculty information");
            }
        }
        writePTToText();

    }

    /*
    private method to write part time faculty into the file
     */
    private void writePTToText(){
        PrintWriter pw = null;


        try {
            pw = new PrintWriter(new FileOutputStream("Part-Time-Faculty.txt"));

            for (Part_Time_Faculty_Members partTimeFaculty: partTimeFacultyArrayList){
                pw.print(partTimeFaculty.getEmployeeID()+" ");
                pw.print(partTimeFaculty.getFirstName()+" ");
                pw.print(partTimeFaculty.getFamilyName()+" ");
                pw.print(partTimeFaculty.getCityOfResidence()+" ");
                pw.print(partTimeFaculty.getHireYear()+" ");
                pw.print(partTimeFaculty.getHourlyRate()+" ");
                pw.print(partTimeFaculty.getNumberOfHoursOfCurrentTerm()+" ");
                pw.println(partTimeFaculty.getNumberOfStudentInClass());

            }
        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
        }
        pw.close();

    }

    /*
    private method to read the ta record into the array list
     */
    private void readTAToList(){
        Scanner sc = null;
        TAArrayList = new ArrayList<TAs>();
        TAs ta = new TAs();

        long id ;
        String firstName;
        String lastName;
        String city;
        int hireYear;
        String classification;
        int numberOfClasses;
        int totalNumberOfWorkingHours;

        try{
            sc = new Scanner(new FileInputStream("TAs.txt"));

            while (sc.hasNextLine()){

                id = sc.nextLong();
                firstName = sc.next();
                lastName = sc.next();
                city = sc.next();
                hireYear = sc.nextInt();
                classification = sc.next();
                numberOfClasses = sc.nextInt();
                totalNumberOfWorkingHours = sc.nextInt();

                ta = new TAs(id,firstName,lastName,city,hireYear,classification,numberOfClasses,totalNumberOfWorkingHours);
                TAArrayList.add(ta);

                String q = sc.nextLine();

            }

        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        catch (IOException e){
            System.out.println("IO exception");
        }catch (NoSuchElementException e){
        }
        sc.close();
    }

    /*
    addTARecords() add the ta records into the array file then write to the old file
     */
    public void addTARecords(){
        readPTToList();
        readFTToList();
        readTAToList();
        readStaffToList();

        Scanner kb = new Scanner(System.in);
        long id ;
        String firstName;
        String lastName;
        String city;
        int hireYear;
        String classification;
        int numberOfClasses;
        int totalNumberOfWorkingHours;


        do{
            System.out.println("please enter TA id");
            id = kb.nextLong();
            if(contains(id)){
                System.out.println("id already exists, please enter again");
            }
        }while(contains(id));
        while(id != -1){

            System.out.println("please enter first name");
            firstName = kb.next();
            System.out.println("please enter last name");
            lastName = kb.next();
            System.out.println("please enter city");
            city = kb.next();
            System.out.println("please enter hire year");
            hireYear = kb.nextInt();
            do{
                System.out.println("please enter classification(UGrad, Grad, or Alum)");
                classification = kb.next();
                if(classification.equals("Alum")){
                    System.out.println(" Alum can't be a TA, please enter again");
                }
            }while(! classification.equals("UGrad") && ! classification.equals("Grad"));

            System.out.println("please enter number of hours");
            numberOfClasses = kb.nextInt();
            System.out.println("please enter number of students");
            totalNumberOfWorkingHours = kb.nextInt();


            TAs ta = new TAs(id,firstName,lastName,city,hireYear,classification, numberOfClasses,totalNumberOfWorkingHours);
            TAArrayList.add(ta);


            do{
                System.out.println("please enter TA id, enter -1 if you want to finish");
                id = kb.nextLong();
                if(contains(id)){
                    System.out.println("id already exists, please enter again");
                }
            }while(contains(id));
            if(id == -1){
                System.out.println("finish entering part time faculty information");
            }
        }
        writeTAToText();


    }

    /*
    private method to write ta record into file
     */
    private void writeTAToText(){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream("TAs.txt"));

            for (TAs ta: TAArrayList){
                pw.print(ta.getEmployeeID()+" ");
                pw.print(ta.getFirstName()+" ");
                pw.print(ta.getFamilyName()+" ");
                pw.print(ta.getCityOfResidence()+" ");
                pw.print(ta.getHireYear()+" ");
                pw.print(ta.getClassificationOfTA()+" ");
                pw.print(ta.getCurrentNumberOfClasses()+" ");
                pw.println(ta.getTotalNumberOfWorkingHours());

            }
        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
        }
        pw.close();

    }

    /*
    private method to see this id is contained or not
     */
    private boolean contains(Long id){

        for(Full_Time_Faculty_Members fullTimeFaculty: fullTimeFacultyArrayList){
            if(! idArrayList.contains(fullTimeFaculty.getEmployeeID())){
                idArrayList.add(fullTimeFaculty.getEmployeeID());
            }
        }
        for(Part_Time_Faculty_Members partTimeFaculty: partTimeFacultyArrayList){
            if(! idArrayList.contains(partTimeFaculty.getEmployeeID())){
                idArrayList.add(partTimeFaculty.getEmployeeID());
            }
        }
        for(TAs ta: TAArrayList){
            if(! idArrayList.contains(ta.getEmployeeID())){
                idArrayList.add(ta.getEmployeeID());
            }
        }

        for(StaffMembers staff: staffArrayList){
            if(! idArrayList.contains(staff.getEmployeeID())){
                idArrayList.add(staff.getEmployeeID());
            }
        }
        if(idArrayList.contains(id)){
            return true;
        }
        return false;
    }
}
