// -----------------------------------------------------
// Assignment #4
// Part: (2)
// Written by: Zhihong Guo(40038183),Tiantian Ji(27781083)
// -----------------------------------------------------

/**
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */
public class Subscription extends Suppliers{

    /*
    private attribute
     */
    private String SubscriptionType;
    private double subscriptionAmount;

    /*
    default constructor
     */
    public Subscription() {
    }

    /*
    Parametrized constructor
     */
    public Subscription(long supplierID, String supplierName1,String companyName, int startYear, long billNumber,  String subscriptionType, double subscriptionAmount) {
        super(supplierID,supplierName1, companyName, startYear, billNumber);
        this.SubscriptionType = subscriptionType;
        this.subscriptionAmount = subscriptionAmount;
    }

    /*
    getters and setters
     */
    public String getSubscriptionType() {
        return SubscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        SubscriptionType = subscriptionType;
    }

    public double getSubscriptionAmount() {
        return subscriptionAmount;
    }

    public void setSubscriptionAmount(double subscriptionAmount) {
        this.subscriptionAmount = subscriptionAmount;
    }
}
