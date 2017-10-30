// -----------------------------------------------------
// Assignment #4
// Part: (1)
// Written by: Zhihong Guo(40038183),Tiantian Ji(27781083)
// -----------------------------------------------------

/**
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */
public class Employee implements Ordered {

    /*
    private attributes
     */
    private long employeeID;
    private String firstName;
    private String familyName;
    private String cityOfResidence;
    private int hireYear;

    /*
    default constructor
     */
    public Employee() {
    }

    /**
     * Parametrized constructor
     * @param employeeID is an integer value
     * @param firstName is a String value
     * @param familyName is a String value
     * @param cityOfResidence is a String value
     * @param hireYear is an integer value
     */
    public Employee(long employeeID, String firstName, String familyName, String cityOfResidence, int hireYear) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.familyName = familyName;
        this.cityOfResidence = cityOfResidence;
        this.hireYear = hireYear;
    }

    /**
     * @param employee is an Employee value
     * copy constructor
     */
    public Employee(Employee employee){
        this.employeeID = employee.getEmployeeID();
        this.firstName = employee.getFirstName();
        this.familyName = employee.getFamilyName();
        this.cityOfResidence = employee.getCityOfResidence();
        this.hireYear = employee.getHireYear();
    }

    /**
     *
     * @param employee is an Object value
     * @return a boolean value
     * implements precedes() method from interface Ordered
     */
    public boolean precedes(Object employee){
        if(this.getHireYear() < ((Employee)employee).getHireYear()) {//downcast Object to Employee due to implement of Order interface
            return true;
        }else {
            return false;
        }
    }

    /**
     *
     * @param employee is an Object value
     * @return a boolean value
     * implements follows ()method from interface Ordered
     */
    public boolean follows(Object employee){
        if(this.getHireYear() > ((Employee)employee).getHireYear()) {//downcast Object to Employee due to implement of Order interface
            return true;
        }else{
            return false;
        }
    }

    /*
    getters and setters
     */
    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public int getHireYear() {
        return hireYear;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }
}
