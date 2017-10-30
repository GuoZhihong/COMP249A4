// -----------------------------------------------------
// Assignment #4
// Part: (2)
// Written by: Zhihong Guo(40038183),Tiantian Ji(27781083)
// -----------------------------------------------------

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */
public class Part2 {
    /*
    create a static array list to store the bill information, all of changes will be seen in this array list
     */
    private static ArrayList<Suppliers> suppliersArrayList;

    /*
    input the bill into the array list
     */
    private static void readToList() {
        suppliersArrayList = new ArrayList<Suppliers>();
        Scanner sc = null;
        long id;
        String serviceName;
        String companyName;
        int year;
        long billNumber;
        int hours;
        String type;
        double rate;
        double amount;
        double total;

        try {
            sc = new Scanner(new FileInputStream("Bills.txt"));//open the input stream
            while (sc.hasNextLine()) {//condition to take in bills
                id = sc.nextLong();
                serviceName = sc.next();
                companyName = sc.next();
                year = sc.nextInt();
                billNumber = sc.nextLong();
                if (sc.hasNextInt()) {//condition to read a services bill
                    hours = sc.nextInt();
                    rate = sc.nextDouble();
                    total = sc.nextDouble();
                    Services services = new Services(id, serviceName, companyName, year, billNumber, hours, rate, total);
                    suppliersArrayList.add(services);//put children object into father Suppliers array

                } else if (sc.hasNext()) {//condition to read a subscription bill
                    type = sc.next();
                    amount = sc.nextDouble();
                    Subscription subscription = new Subscription(id, serviceName, companyName, year, billNumber, type, amount);
                    suppliersArrayList.add(subscription);//put children object subscription bill into father Suppliers array
                }
                String q = sc.nextLine();//turn to next line
            }
        }
        /*
        exceptions
         */
        catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(0);
        }catch (IOException e) {
            System.out.println("IO exception");
            System.exit(0);
        }
        catch (NoSuchElementException e){
        }
        sc.close();//input stream closes
    }


    public void addBill() {
        long id;
        String name1;
        String name2;
        int year;
        long billNumber;
        int hours;
        String type;
        double rate;
        double amount;
        double total;

        Scanner kb = new Scanner(System.in);
        System.out.println("choose one type of bill");
        System.out.println("please enter 'Subscription' or 'Services'");
        String user = kb.next();
        if (user.equals("Subscription")) {
            System.out.println("please enter subscription id");
            do{
            	
            id = kb.nextLong();
            
            }while(exists(id));
            
            while (id != -1) {//keep adding until user stops

                System.out.println("supplier name");
                name1 = kb.next();
                System.out.println("company name");
                name2 = kb.next();
                System.out.println("year");
                year = kb.nextInt();
                System.out.println("bill number");
                billNumber = kb.nextLong();
                System.out.println("type");
                type = kb.next();
                System.out.println("amount");
                amount = kb.nextDouble();

                Subscription subscription = new Subscription(id, name1, name2, year, billNumber, type, amount);//create a new Subscription bill with parameters
                suppliersArrayList.add(subscription);//put children Subscription into father Suppliers array

                PrintWriter pw = null;
                try{
                    pw = new PrintWriter(new FileOutputStream("Bills.txt",true));//append to the original file
                    pw.println(id+" "+name1+" "+name2+" "+year+" "+billNumber+" "+type+" "+amount);
                }
                catch (FileNotFoundException e){
                    System.out.println("file not found");
                }//catch exception
                pw.close();

                System.out.println("please enter subscription id, enter -1 if you want to finish");
                
                do{
                	
                    id = kb.nextLong();
                    
                    }while(exists(id));
                
                if (id == -1) {//let the user decides to stop the input
                    System.out.println("finish entering subscription information");
                }
            }
        } else if (user.equals("Services")) {
            System.out.println("please enter service id");
            id = kb.nextLong();
            while (id != -1) {//keep adding until user stops

                System.out.println("service name");
                name1 = kb.next();
                System.out.println("company name");
                name2 = kb.next();
                System.out.println("year");
                year = kb.nextInt();
                System.out.println("bill number");
                billNumber = kb.nextLong();
                System.out.println("hour");
                hours = kb.nextInt();
                System.out.println("rate");
                rate = kb.nextDouble();
                System.out.println("total");
                total = kb.nextDouble();
                Services services = new Services(id, name1, name2, year, billNumber, hours, rate, total);
                suppliersArrayList.add(services);//put children Services into father Suppliers array

                PrintWriter pw = null;
                try{
                    pw = new PrintWriter(new FileOutputStream("Bills.txt",true));//append to the old file
                    pw.println(id+" "+name1+" "+name2+" "+year+" "+billNumber+" "+hours+" "+rate+" "+total);
                }
                catch (FileNotFoundException e){
                    System.out.println("file not found");
                }//catch exception
                pw.close();

                System.out.println("please enter service id, enter -1 if you want to finish");
                id = kb.nextLong();
                if (id == -1) {//display closing message
                    System.out.println("finish entering service information");
                }
            }
        }
    }

    public void updateBill(){
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the bill id that you want to update(only the first Id will be dealt with if there are duplicate IDs ");
        long updateID = kb.nextLong();
        int j = 0;
        /*
        locate the input ID that needs to be updated
         */
        for (j = 0; j < suppliersArrayList.size(); j++){
            if(suppliersArrayList.get(j).getSupplierID() == updateID)
                break;
        }
        if (suppliersArrayList.get(j) instanceof Subscription){//for the subscription bills
            Subscription subscription = (Subscription)suppliersArrayList.get(j);
            System.out.println("update 'Type' or 'Amount'");
            String userChoice = kb.next();
            if(userChoice.equals("Type")){
                System.out.println("please enter the type");
                String type = kb.next();
                subscription.setSubscriptionType(type);
            }
            else if(userChoice.equals("Amount")){
                System.out.println("please enter the amount");
                double amount = kb.nextDouble();
                subscription.setSubscriptionAmount(amount);
            }
        }
        else if (suppliersArrayList.get(j) instanceof Services){//for the service bills
            Services services = (Services)suppliersArrayList.get(j);
            System.out.println(" update 'numberOfHours' or 'totalBill'");
            String userChoice2 = kb.next();
            if(userChoice2.equals("numberOfHours")){
                System.out.println("please enter the number of hours");
                int hour = kb.nextInt();
                services.setNumberOfHours(hour);
            }
            else if(userChoice2.equals("totalBill")){
                System.out.println("please enter the total bill");
                double total = kb.nextDouble();
                services.setTotalBill(total);
            }
        }
        /*
        update the changed information to the original file
         */
        PrintWriter pw = null;
        try {

            pw = new PrintWriter(new FileOutputStream("Bills.txt"));
            for (int i = 0; i < suppliersArrayList.size(); i++) {
                if (suppliersArrayList.get(i) instanceof Subscription) {
                    pw.println(suppliersArrayList.get(i).getSupplierID()+" "+
                            (suppliersArrayList.get(i)).getServiceName()+" "+
                            suppliersArrayList.get(i).getCompanyName()+" "+
                            suppliersArrayList.get(i).getStartYear()+" "+
                            suppliersArrayList.get(i).getBillNumber()+" "+
                            ((Subscription) suppliersArrayList.get(i)).getSubscriptionType() +" "+
                            ((Subscription) suppliersArrayList.get(i)).getSubscriptionAmount());

                }
                else if (suppliersArrayList.get(i) instanceof Services){
                    pw.println(suppliersArrayList.get(i).getSupplierID()+" "+
                            suppliersArrayList.get(i).getServiceName()+" "+
                            suppliersArrayList.get(i).getCompanyName()+" "+
                            suppliersArrayList.get(i).getStartYear()+" "+
                            suppliersArrayList.get(i).getBillNumber()+" "+
                            ((Services) suppliersArrayList.get(i)).getHourRate() +" "+
                            ((Services) suppliersArrayList.get(i)).getNumberOfHours()+" "+
                            ((Services) suppliersArrayList.get(i)).getTotalBill());
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println ("file not found");
        }//catch exception
        pw.close();
    }

    /*
    to determine this ID is existed or not.
     */
    private boolean idIsExisted(long id){
        for (int i = 0; i < suppliersArrayList.size(); i++) {
            if (suppliersArrayList.get(i).getSupplierID() == id) {
                suppliersArrayList.remove(suppliersArrayList.get(i));
                System.out.println("The id you input is deleted");
                return true;
            }
        }
        return false;
    }

    /*
    remove the specific bill by its ID
     */
    public void removeBill(long id){
        /*
        locate input id in the array
         */
        boolean iDIsFound = idIsExisted(id);
        do {// if the id is not existed, user must keep inputting a new one until it is existed in the file
            if(!iDIsFound) {
                System.out.println("the ID you input is not existed please type it again");
                Scanner input = new Scanner(System.in);
                long ID = input.nextLong();
                iDIsFound = idIsExisted(ID);
            }else {
                break;
            }
        }while(!iDIsFound);


        /*
        change permanently in the original file
         */
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream("Bills.txt"));
            for (int i = 0; i < suppliersArrayList.size(); i++) {
                if (suppliersArrayList.get(i) instanceof Subscription) {
                    pw.println(suppliersArrayList.get(i).getSupplierID()+" "+
                            (suppliersArrayList.get(i)).getServiceName()+" "+
                            suppliersArrayList.get(i).getCompanyName()+" "+
                            suppliersArrayList.get(i).getStartYear()+" "+
                            suppliersArrayList.get(i).getBillNumber()+" "+
                            ((Subscription) suppliersArrayList.get(i)).getSubscriptionType() +" "+
                            ((Subscription) suppliersArrayList.get(i)).getSubscriptionAmount());

                }
                else if (suppliersArrayList.get(i) instanceof Services){
                    pw.println(suppliersArrayList.get(i).getSupplierID()+" "+
                            suppliersArrayList.get(i).getServiceName()+" "+
                            suppliersArrayList.get(i).getCompanyName()+" "+
                            suppliersArrayList.get(i).getStartYear()+" "+
                            suppliersArrayList.get(i).getBillNumber()+" "+
                            ((Services) suppliersArrayList.get(i)).getHourRate() +" "+
                            ((Services) suppliersArrayList.get(i)).getNumberOfHours()+" "+
                            ((Services) suppliersArrayList.get(i)).getTotalBill());
                }
            }
            iDIsFound = true;
        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
        }//catch exception
        iDIsFound = true;
        pw.close();
    }




    public void findSupllierTotalBills(){
        /*
         calculates the combined total bills for a specific supplier then display all
         */
        double totalServiceBill = 0;
        double totalSubscriptionAmount = 0;
        for (int i = 0; i < suppliersArrayList.size() ; i++) {
            if(suppliersArrayList.get(i) instanceof Services ){//only service bills under consideration
                totalServiceBill += ((Services) suppliersArrayList.get(i)).getTotalBill();
            }else {
                totalSubscriptionAmount += ((Subscription) suppliersArrayList.get(i)).getSubscriptionAmount();
            }
        }
        System.out.println("Total Service Bills are " + totalServiceBill);
        System.out.println();
        System.out.println("Total Subscription Amount are " +totalSubscriptionAmount);
        System.out.println();
    }



    public void findHighest_and_LowestService() {

        /*
        find the first Service bill appeared in the array
         */
        int counter = 0;
        for (int i = 0; i <suppliersArrayList.size() ; i++) {
            if((suppliersArrayList.get(i)) instanceof Services){
                break;
            }else {
                counter++;
            }
        }

        /*
        assume the first Service bill in the array is both the highest and lowest
         */
        double highestService = ((Services)suppliersArrayList.get(counter)).getHourRate();
        double lowestService = ((Services)suppliersArrayList.get(counter)).getHourRate();

        /*
        find out which services suppliers have the highest and the lowest hourly rate by compare each Service bill in the array with the first one
         */
        for (int i = 0; i < suppliersArrayList.size(); i++) {
            if(suppliersArrayList.get(i) instanceof Services) {//only Service bill under consideration
                if (((Services) suppliersArrayList.get(i)).getHourRate() >= highestService) {// find the highest service hourly rate
                    highestService = ((Services) suppliersArrayList.get(i)).getHourRate();
                } else if (((Services) suppliersArrayList.get(i)).getTotalBill() <= lowestService) {// find the lowest service hourly rate
                    lowestService = ((Services) suppliersArrayList.get(i)).getHourRate();
                }
            }
        }

        /*
        display full records of members that have the highest and lowest salaries
         */
        System.out.println("Following services suppliers have the highest hourly rate: ");
        for (int i = 0; i < suppliersArrayList.size(); i++) {
            if(suppliersArrayList.get(i) instanceof Services){// only service bill under consideration
                if(((Services) suppliersArrayList.get(i)).getHourRate() == highestService){//determine how many service bills have the highest hourly rate
                    System.out.println(suppliersArrayList.get(i).getCompanyName()+"  "+suppliersArrayList.get(i).getServiceName());
                }
            }else {
                continue;//turn to the next bill if it is not service bill
            }
        }
        System.out.println("Following services suppliers have the lowest hourly rate: ");
        for (int i = 0; i < suppliersArrayList.size(); i++) {
            if(suppliersArrayList.get(i) instanceof Services){// only service bill under consideration
                if(((Services) suppliersArrayList.get(i)).getHourRate() == lowestService){//determine how many service bills have the lowest hourly rate
                    System.out.println(suppliersArrayList.get(i).getCompanyName()+"  "+suppliersArrayList.get(i).getServiceName());
                }
            }else {
                continue;//turn to the next bill if it is not service bill
            }
        }
        System.out.println();
    }

    /*
    private method to determine the input id is existed or not
     */
    private boolean exists(long id){
    	for (int i = 0; i <suppliersArrayList.size() ; i++){
    		if (suppliersArrayList.get(i).getSupplierID() == id){
    			System.out.println("ID already exist, please enter a new one");
    			return true;
    		}
    	}
    	return false;
    }

    /*
    main drive
     */
    public static void main(String[] args) {
        new Part2().run();
    }

    /*
    menu
     */
    public void run(){
        readToList();//read bill file into the static array.
        Scanner input = new Scanner(System.in);
        int user = 0;
        do {
            System.out.println("What do you want to do?");
            System.out.println("1.add a new bill");
            System.out.println("2.update a bill");
            System.out.println("3.remove a bill");
            System.out.println("4.find total bills of both Service and Subscription");
            System.out.println("5.find the highest and lowest service hourly rate");
            System.out.println("6.Exit");
            user = input.nextInt();
            if(user == 1){
                addBill();
            }else if(user == 2){
                updateBill();
            }else if(user == 3){
                System.out.println("Type the ID of the bill that you want to remove");
                long id = input.nextLong();
                removeBill(id);
            }else if(user == 4){
                findSupllierTotalBills();
            }else if(user == 5){
                findHighest_and_LowestService();
            }else if(user == 6){
                System.out.println("Bye Bye");
                System.exit(0);
            }
        }while (user != 6);
    }
}
