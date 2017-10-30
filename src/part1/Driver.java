// -----------------------------------------------------
// Assignment #4
// Part: (1)
// Written by: Zhihong Guo(40038183),Tiantian Ji(27781083)
// -----------------------------------------------------

import java.util.Scanner;

/**
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */
public class Driver {
    public static void main(String[] args) {
        new Driver().run();
    }

    /*
    menu that calls the required methods in  both Find and Add classes (or it can call a specific method inside them since they are all public)
     */
    public void run(){
        Scanner input = new Scanner(System.in);
        Find openFind = new Find();
        Add openAdd = new Add();
        int user = 0;
        do {
            System.out.println("What do you want to do?");
            System.out.println("1.add new Full-time faculty records");
            System.out.println("2.add new Part-time faculty records");
            System.out.println("3.add new TA records");
            System.out.println("4.add new staff records");
            System.out.println("5.find the term salaries of both Part-time faculties and TAs");
            System.out.println("6.find the highest and lowest Full-time faculty salary");
            System.out.println("7.increase the staff salaries");
            System.out.println("8.Exit");
            user = input.nextInt();
            if(user == 1){
                openAdd.addFTRecords();
            }else if(user == 2){
                openAdd.addPTRecords();
            }else if(user == 3) {
                openAdd.addTARecords();
            }else if(user == 4){
                openAdd.addStaff();
            }else if(user == 5){
                openFind.startFindTermSalary();
            }else if(user == 6){
                openFind.startfindHighest_and_Lowest_FT_Salary();
            }else if(user == 7){
                openFind.startIncrease_Staff_Salary();
            }else if(user == 8 ){
                System.out.println("Bye Bye");
                System.exit(0);
            }

        }while (user != 8);
    }
}
