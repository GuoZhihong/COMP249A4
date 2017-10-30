// -----------------------------------------------------
// Assignment #4
// Part: (1)
// Written by: Zhihong Guo(40038183),Tiantian Ji(27781083)
// -----------------------------------------------------

/**
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */
public class Part_Time_Faculty_Members extends Employee{

    /*
     *private attribute
     */
    private double hourlyRate;
    private int numberOfHoursOfCurrentTerm;
    private int numberOfStudentInClass;

    /**
    default constructor
     */
    public Part_Time_Faculty_Members() {
    }

    /**
    Parametrized constructor
     */
    public Part_Time_Faculty_Members(long employeeID,String firstName,String familyName,String cityOfResidence,int hireYear,double hourlyRate, int numberOfHoursOfCurrentTerm,int numberOfStudentInClass) {
        super(employeeID,firstName,familyName,cityOfResidence,hireYear);
        this.hourlyRate = hourlyRate;
        this.numberOfHoursOfCurrentTerm = numberOfHoursOfCurrentTerm;
        this.numberOfStudentInClass = numberOfStudentInClass;
    }

    /**
     getters and setters
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getNumberOfHoursOfCurrentTerm() {
        return numberOfHoursOfCurrentTerm;
    }

    public void setNumberOfHoursOfCurrentTerm(int numberOfHoursOfCurrentTerm) {
        this.numberOfHoursOfCurrentTerm = numberOfHoursOfCurrentTerm;
    }

    public int getNumberOfStudentInClass() {
        return numberOfStudentInClass;
    }

    public void setNumberOfStudentInClass(int numberOfStudentInClass) {
        this.numberOfStudentInClass = numberOfStudentInClass;
    }
}
