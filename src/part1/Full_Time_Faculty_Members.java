// -----------------------------------------------------
// Assignment #4
// Part: (1)
// Written by: Zhihong Guo(40038183),Tiantian Ji(27781083)
// -----------------------------------------------------

/**
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */
public class Full_Time_Faculty_Members extends Employee{
    /*
     *private attribute
     */
    private long salary;

    /*
    default constructor
     */
    public Full_Time_Faculty_Members() {
    }

    /**
     * Parametrized constructor
     * @param employeeID is an integer value
     * @param firstName is a String value
     * @param familyName is a String value
     * @param cityOfResidence is a String value
     * @param hireYear is an integer value
     * @param salary is a long value
     *
     */
    public Full_Time_Faculty_Members(long employeeID,String firstName,String familyName,String cityOfResidence,int hireYear,long salary){
        super(employeeID,firstName,familyName,cityOfResidence,hireYear);
        this.salary = salary;
    }

    /*
    copy constructor
     */
    public Full_Time_Faculty_Members(Full_Time_Faculty_Members full_time_faculty_members){
        super(full_time_faculty_members);
        this.salary = full_time_faculty_members.salary;
    }

    /**
    getters and setters
     */
    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
