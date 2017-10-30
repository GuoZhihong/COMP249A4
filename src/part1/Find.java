import java.io.*;
import java.util.Scanner;

// -----------------------------------------------------
// Assignment #4
// Part: (1)
// Written by: Zhihong Guo(40038183),Tiantian Ji(27781083)
// -----------------------------------------------------

/**
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */
public class Find {

    /**
     *
     * @param inputStream1 is a Scanner value
     * @param inputStream2 is a Scanner value
     * @throws IOException
     * findTermSalary() method calculates the combined total salary of part-time faculty and teaching assistants (TAs) and displays them
     */
    public static void findTermSalary(Scanner inputStream1, Scanner inputStream2) throws IOException {

        /*
        create Linked list and input information of part-time faculty members
         */
        LinkedList partTimeFaculty = new LinkedList();
        while(inputStream1.hasNext()){
            Part_Time_Faculty_Members partTimeFacultyMembers = new Part_Time_Faculty_Members();
            partTimeFacultyMembers.setEmployeeID(inputStream1.nextLong());
            partTimeFacultyMembers.setFirstName(inputStream1.next());
            partTimeFacultyMembers.setFamilyName(inputStream1.next());
            partTimeFacultyMembers.setCityOfResidence(inputStream1.next());
            partTimeFacultyMembers.setHireYear(inputStream1.nextInt());
            partTimeFacultyMembers.setHourlyRate(inputStream1.nextDouble());
            partTimeFacultyMembers.setNumberOfHoursOfCurrentTerm(inputStream1.nextInt());
            partTimeFacultyMembers.setNumberOfStudentInClass(inputStream1.nextInt());
            partTimeFaculty.add(partTimeFacultyMembers);
            if (inputStream1.hasNext())
                inputStream1.nextLine();
        }

        /*
        create Linked list and input information of TAs
         */
        LinkedList teachingAssistants = new LinkedList();
        while(inputStream2.hasNext()) {
            TAs tAs = new TAs();
            tAs.setEmployeeID(inputStream2.nextLong());
            tAs.setFirstName(inputStream2.next());
            tAs.setFamilyName(inputStream2.next());
            tAs.setCityOfResidence(inputStream2.next());
            tAs.setHireYear(inputStream2.nextInt());
            tAs.setClassificationOfTA(inputStream2.next());
            tAs.setCurrentNumberOfClasses(inputStream2.nextInt());
            tAs.setTotalNumberOfWorkingHours(inputStream2.nextInt());
            teachingAssistants.add(tAs);
            if (inputStream2.hasNext())
                inputStream2.nextLine();
        }

        /*
        calculate the total salary of part-time faculty
         */
        double totalSalariesOfPartTimeFaculties = 0.0;
        int extraPayment;
        double hourlyRate;
        int numberOfHoursOfCurrentTerm;

        for (int i = 0; i < partTimeFaculty.size(); i++) {

            hourlyRate = ((Part_Time_Faculty_Members) partTimeFaculty.get(i)).getHourlyRate();
            numberOfHoursOfCurrentTerm = ((Part_Time_Faculty_Members) partTimeFaculty.get(i)).getNumberOfHoursOfCurrentTerm();

            if(((Part_Time_Faculty_Members)partTimeFaculty.get(i)).getNumberOfStudentInClass() < 40) {
                totalSalariesOfPartTimeFaculties += (hourlyRate * numberOfHoursOfCurrentTerm);
            }else if(((Part_Time_Faculty_Members)partTimeFaculty.get(i)).getNumberOfStudentInClass() >= 40 && ((Part_Time_Faculty_Members)partTimeFaculty.get(i)).getNumberOfStudentInClass() <= 60){
                extraPayment = 500;
                totalSalariesOfPartTimeFaculties += (hourlyRate * numberOfHoursOfCurrentTerm) + extraPayment;
            }else {
                extraPayment = 1000;
                totalSalariesOfPartTimeFaculties += (hourlyRate * numberOfHoursOfCurrentTerm) + extraPayment;
            }
        }

        /*
        calculate the total salary of TAs
         */
        final double UD_TA = 18.25;
        final double GD_TA = UD_TA*1.2;
        double totalSalariesOfTA = 0.0;
        for (int i = 0; i <teachingAssistants.size() ; i++) {

            if(((TAs)teachingAssistants.get(i)).getClassificationOfTA().equals("Alum")){//if this TA is an alumnus,skip this round and to the next node.
                continue;

            } else {
                if(((TAs)teachingAssistants.get(i)).getClassificationOfTA().equals("UGrad")){
                    totalSalariesOfTA += UD_TA * ((TAs)teachingAssistants.get(i)).getTotalNumberOfWorkingHours();
                } else {
                    totalSalariesOfTA += GD_TA * ((TAs)teachingAssistants.get(i)).getTotalNumberOfWorkingHours();
                }
            }
        }

        /*
        calculate the combined total salary of part-time faculty and TAs
         */
        double totalSalariesOfTAAndPartTimeFaculties = totalSalariesOfPartTimeFaculties + totalSalariesOfTA;

        /*
        display total salaries
         */
        System.out.println("Total salaries of part-time faculties is $" + totalSalariesOfPartTimeFaculties);
        System.out.println("Total salaries of Ta students is $" + totalSalariesOfTA);
        System.out.println("Total salaries of Ta students and part-time faculties is $" + totalSalariesOfTAAndPartTimeFaculties+"\n");

        /*
        input stream close
         */
        inputStream1.close();
        inputStream2.close();
    }

    /**
     *
     * @param inputStream is a Scanner value
     * @throws IOException
     * findHighest_and_Lowest_FT_Salary() method finds the highest and lowest salary for any full-time faculty and displays them
     */
    public static void findHighest_and_Lowest_FT_Salary(Scanner inputStream) throws IOException{

        /*
        create Linked list and input information of full-time faculty members
         */
        LinkedList fullTimeFaculty = new LinkedList();
        while(inputStream.hasNext()){
            Full_Time_Faculty_Members fullTimeFacultyMembers = new Full_Time_Faculty_Members();
            fullTimeFacultyMembers.setEmployeeID(inputStream.nextLong());
            fullTimeFacultyMembers.setFirstName(inputStream.next());
            fullTimeFacultyMembers.setFamilyName(inputStream.next());
            fullTimeFacultyMembers.setCityOfResidence(inputStream.next());
            fullTimeFacultyMembers.setHireYear(inputStream.nextInt());
            fullTimeFacultyMembers.setSalary(inputStream.nextLong());
            fullTimeFaculty.add(fullTimeFacultyMembers);
            if (inputStream.hasNext())
                inputStream.nextLine();
        }
        /*
        find out who has the highest and lowest salary
         */
        long highestSalaries = ((Full_Time_Faculty_Members) fullTimeFaculty.get(0)).getSalary();
        long lowestSalaries = ((Full_Time_Faculty_Members) fullTimeFaculty.get(0)).getSalary();

        for (int i = 0; i < fullTimeFaculty.size(); i++) {
            if(((Full_Time_Faculty_Members)fullTimeFaculty.get(i)).getSalary() >= highestSalaries ) {
                highestSalaries = ((Full_Time_Faculty_Members) fullTimeFaculty.get(i)).getSalary();
            }else if(((Full_Time_Faculty_Members)fullTimeFaculty.get(i)).getSalary() <= lowestSalaries){
                lowestSalaries = ((Full_Time_Faculty_Members) fullTimeFaculty.get(i)).getSalary();
            }
        }

        /*
        find out how many members that have the highest and lowest salary
         */
        int numberOfMembersWithHighestSalary = 0;
        int numberOfMembersWithLowestSalary = 0;
        for (int i = 0; i < fullTimeFaculty.size(); i++) {
            if(highestSalaries == ((Full_Time_Faculty_Members) fullTimeFaculty.get(i)).getSalary()){
                numberOfMembersWithHighestSalary++;
            }else if(lowestSalaries == ((Full_Time_Faculty_Members) fullTimeFaculty.get(i)).getSalary()){
                numberOfMembersWithLowestSalary++;
            }
        }

        /*
        display full records of members that have the highest and lowest salaries
         */
        System.out.println("Following full-time faculties have the highest salary : ");
        do{
            System.out.println(display((Full_Time_Faculty_Members) fullTimeFaculty.get(fullTimeFaculty.indexOf(highestSalaries))));
            numberOfMembersWithHighestSalary--;
        }while (numberOfMembersWithHighestSalary > 0);

        System.out.println();

        System.out.println("Following full-time faculties have the lowest salary : ");
        do{
            System.out.println(display ((Full_Time_Faculty_Members) fullTimeFaculty.get(fullTimeFaculty.indexOf(lowestSalaries))));
            numberOfMembersWithLowestSalary--;
        }while (numberOfMembersWithLowestSalary > 0);
        System.out.println();
        /*
        input stream close
         */
        inputStream.close();
    }

    /*
    private method to display the information for full-time faculties
     */
    private static String display(Full_Time_Faculty_Members fullTimeFacultyMember){
        return fullTimeFacultyMember.getEmployeeID()+" "+
                fullTimeFacultyMember.getFirstName()+" "+
                fullTimeFacultyMember.getFamilyName()+" "+
                fullTimeFacultyMember.getCityOfResidence()+" "+
                fullTimeFacultyMember.getHireYear()+" "+
                fullTimeFacultyMember.getSalary();
    }

    /*
     Create a static LinkedList for the staff and Increase_Staff_Salary()method will write into it and outputIncreasedStaffSalary will output it into the same text file
     */
    static LinkedList staff = new LinkedList();
    /**
     *
     * @param inputStream is a Scanner value
     * @throws IOException
     * Increase_Staff_Salary()method will do following:
     * a. Open the Staff.txt file and read it into a Linked List similar to what you did above.
     * b. Iterate into all records and increase the salaries based on the performance evaluation code.
     * For example, if the salary of a staff is 62,000$ and the last evaluation code is B, then the salary must be changed to 65,720$, which reflects the 6% increase.
     * c. You must also reset all salary increase codes afterwards to E, so further calls for this method before the evaluation take place again (in another 3 years) do not result in multiple incorrect increases.
     */
    public static void Increase_Staff_Salary(Scanner inputStream) throws IOException{
        /*
        local variables
         */
        final double A = 1.08;
        final double B = 1.06;
        final double C = 1.03;
        final double D = 1.01;
        final double E = 1.0;

        /*
        create Linked list and input information of staff members
         */
        while(inputStream.hasNext()){
            StaffMembers staffMembers = new StaffMembers();
            staffMembers.setEmployeeID(inputStream.nextLong());
            staffMembers.setFirstName(inputStream.next());
            staffMembers.setFamilyName(inputStream.next());
            staffMembers.setCityOfResidence(inputStream.next());
            staffMembers.setHireYear(inputStream.nextInt());
            staffMembers.setSalary(inputStream.nextLong());
            staffMembers.setPerformanceCode(inputStream.next());
            staff.add(staffMembers);
            if (inputStream.hasNext())
                inputStream.nextLine();
        }
        /*
        input stream closed
         */
        inputStream.close();

        /*
        increase the salaries based on the performance evaluation code
        then reset all salary increase codes afterwards to E
         */
        for (int i = 0; i < staff.size() ; i++) {
            if(((StaffMembers)staff.get(i)).getPerformanceCode().equals("A") ){

                ((StaffMembers)staff.get(i)).setSalary((long) (((StaffMembers)staff.get(i)).getSalary() * A));
                ((StaffMembers)staff.get(i)).setPerformanceCode("E");

            }else if(((StaffMembers)staff.get(i)).getPerformanceCode().equals("B")){

                ((StaffMembers)staff.get(i)).setSalary((long) (((StaffMembers)staff.get(i)).getSalary() * B));
                ((StaffMembers)staff.get(i)).setPerformanceCode("E");

            }else if(((StaffMembers)staff.get(i)).getPerformanceCode().equals("C")){

                ((StaffMembers)staff.get(i)).setSalary((long) (((StaffMembers)staff.get(i)).getSalary() * C));
                ((StaffMembers)staff.get(i)).setPerformanceCode("E");

            }else if(((StaffMembers)staff.get(i)).getPerformanceCode().equals("D")){

                ((StaffMembers)staff.get(i)).setSalary((long) (((StaffMembers)staff.get(i)).getSalary() * D));
                ((StaffMembers)staff.get(i)).setPerformanceCode("E");

            }else if(((StaffMembers)staff.get(i)).getPerformanceCode().equals("E")){

                ((StaffMembers)staff.get(i)).setSalary((long) (((StaffMembers)staff.get(i)).getSalary() * E));
                ((StaffMembers)staff.get(i)).setPerformanceCode("E");

            }
        }
    }

    /**
     *
     * @param outputStream is a PrintWriter value
     * @throws IOException
     * outputIncreasedStaffSalary()method Saves the contents of the linked list into the Staff.txt file,hence permanently changing the salaries to reflect the increases, and resetting bonus codes.
     */
    public static void outputIncreasedStaffSalary(PrintWriter outputStream)throws IOException{
        for (int i = 0; i < staff.size() ; i++) {
            outputStream.print(((StaffMembers)staff.get(i)).getEmployeeID()+"  ");
            outputStream.print(((StaffMembers)staff.get(i)).getFirstName()+"  ");
            outputStream.print(((StaffMembers)staff.get(i)).getFamilyName()+"  ");
            outputStream.print(((StaffMembers)staff.get(i)).getCityOfResidence()+"  ");
            outputStream.print(((StaffMembers)staff.get(i)).getHireYear()+"  ");
            outputStream.print(((StaffMembers)staff.get(i)).getSalary()+"  ");
            outputStream.print(((StaffMembers)staff.get(i)).getPerformanceCode());
            outputStream.println();
        }
        outputStream.close();
    }

    /**
     *start method will call the required methods then a driver outside this class will call this method to do the actions
     */
    public static void startFindTermSalary() {
        Scanner sn1 = null;
        Scanner sn2 = null;

        /*
        this part executes the findTermSalary()method
         */
        try {
            sn1 = new Scanner(new FileInputStream("Part-Time-Faculty.txt"));
            sn2 = new Scanner(new FileInputStream("TAs.txt"));
            findTermSalary(sn1, sn2);
        } catch (FileNotFoundException e) {
            System.out.println("Problem with opening files.Cannot proceed");
            System.out.println("Program will terminate.");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error: An error has occurred while reading from the " + "Part-Time-Faculty.txt or TAs.txt" + " file. ");
            System.out.println("Program will terminate.");
            System.exit(0);
        }
    }

        /*
        this part executes the findHighest_and_Lowest_FT_Salary()method
         */
    public void startfindHighest_and_Lowest_FT_Salary() {

        Scanner sn3 = null;
        try {
            sn3 = new Scanner(new FileInputStream("Full-Time-Faculty.txt"));
            findHighest_and_Lowest_FT_Salary(sn3);
        } catch (FileNotFoundException e) {
            System.out.println("Problem with opening files.Cannot proceed");
            System.out.println("Program will terminate.");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error: An error has occurred while reading from the " + "Full-Time-Faculty.txt" + " file. ");
            System.out.println("Program will terminate.");
            System.exit(0);
        }
    }
        public void startIncrease_Staff_Salary(){
        /*
        this part executes the Increase_Staff_Salary()method
         */
        Scanner sn4 = null;
        try {
            sn4 = new Scanner(new FileInputStream("Staff.txt"));
            Increase_Staff_Salary(sn4);
        }
        catch (FileNotFoundException e) {
            System.out.println("Problem with opening files.Cannot proceed");
            System.out.println("Program will terminate.");
            System.exit(0);
        }catch (IOException e){
            System.out.println("Error: An error has occurred while reading from the " + "Staff.txt" + " file. ");
            System.out.println("Program will terminate.");
            System.exit(0);
        }

        /*
        this part executes the outputIncreasedStaffSalary()method
         */
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream("Staff.txt"));
            outputIncreasedStaffSalary(pw);
        }
        catch (FileNotFoundException e) {
            System.out.println("Problem with opening files.Cannot proceed");
            System.out.println("Program will terminate.");
            System.exit(0);
        }catch (IOException e){
            System.out.println("Error: An error has occurred while reading from the " + "Staff.txt" + " file. ");
            System.out.println("Program will terminate.");
            System.exit(0);
        }
    }
}
