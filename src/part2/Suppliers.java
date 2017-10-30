// -----------------------------------------------------
// Assignment #4
// Part: (2)
// Written by: Zhihong Guo(40038183),Tiantian Ji(27781083)
// -----------------------------------------------------

/**
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */
public class Suppliers {

    /*
    private attribute
     */
    private long  supplierID;
    private String serviceName;
    private String companyName;
    private int startYear;
    private long billNumber;

    /*
    default constructor
     */
    public Suppliers() {
    }

    /*
    Parametrized constructor
     */
    public Suppliers(long supplierID, String serviceName,String companyName, int startYear, long billNumber) {
        this.supplierID = supplierID;
        this.serviceName = serviceName;
        this.companyName = companyName;
        this.startYear = startYear;
        this.billNumber = billNumber;
    }

    /*
    getters and setters
     */
    public long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(long supplierID) {
        this.supplierID = supplierID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public long getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(long billNumber) {
        this.billNumber = billNumber;
    }
}
