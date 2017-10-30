// -----------------------------------------------------
// Assignment #4
// Part: (2)
// Written by: Zhihong Guo(40038183),Tiantian Ji(27781083)
// -----------------------------------------------------

/**
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */
public class Services extends Suppliers {
    /*
    private attribute
     */
    private int numberOfHours;
    private double hourRate;
    private double totalBill;

    /*
    default constructor
     */
    public Services() {

    }

    /*
    Parametrized constructor
     */
    public Services(long supplierID, String serviceName, String companyName, int startYear, long billNumber, int numberOfHours, double hourRate, double totalBill) {
        super(supplierID, serviceName,companyName, startYear, billNumber);
        this.numberOfHours = numberOfHours;
        this.hourRate = hourRate;
        this.totalBill = totalBill;
    }

    /*
    getters and setters
     */
    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public double getHourRate() {
        return hourRate;
    }

    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }
}
