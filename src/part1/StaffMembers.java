// -----------------------------------------------------
// Assignment #4
// Part: (1)
// Written by: Zhihong Guo(40038183),Tiantian Ji(27781083)
// -----------------------------------------------------

/**
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */
public class StaffMembers extends Employee {

    /*
    *private attribute
    */
    private long salary;
    private String performanceCode;

    /*
   default constructor
    */
    public StaffMembers() {
    }

    /**
     *Parametrized constructor
     * @param employeeID
     * @param firstName
     * @param familyName
     * @param cityOfResidence
     * @param hireYear
     * @param salary
     * @param performanceCode
     */
    public StaffMembers(long employeeID,String firstName,String familyName,String cityOfResidence,int hireYear,long salary, String performanceCode) {
        super(employeeID,firstName,familyName,cityOfResidence,hireYear);
        this.salary = salary;
        this.performanceCode = performanceCode;
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

    public String getPerformanceCode() {
        return performanceCode;
    }

    public void setPerformanceCode(String performanceCode) {
        this.performanceCode = performanceCode;
    }
}
