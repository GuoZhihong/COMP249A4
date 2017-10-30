// -----------------------------------------------------
// Assignment #4
// Part: (1)
// Written by: Zhihong Guo(40038183),Tiantian Ji(27781083)
// -----------------------------------------------------

/**
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */
public class TAs extends Employee {
    /*
     *private attribute
     */
    private String classificationOfTA;
    private int currentNumberOfClasses;
    private int totalNumberOfWorkingHours;

    /**
    default constructor
     */
    public TAs() {
    }

    /**
     *Parametrized constructor
     * @param employeeID
     * @param firstName
     * @param familyName
     * @param cityOfResidence
     * @param hireYear
     * @param classificationOfTA
     * @param currentNumberOfClasses
     * @param totalNumberOfWorkingHours
     */
    public TAs(long employeeID,String firstName,String familyName,String cityOfResidence,int hireYear,String classificationOfTA, int currentNumberOfClasses, int totalNumberOfWorkingHours) {
        super(employeeID,firstName,familyName,cityOfResidence,hireYear);
        this.classificationOfTA = classificationOfTA;
        this.currentNumberOfClasses = currentNumberOfClasses;
        this.totalNumberOfWorkingHours = totalNumberOfWorkingHours;
    }

    /**
     *
     * @param tAs is a TAs value
     */
    public TAs(TAs tAs){
        super(tAs);
        this.classificationOfTA = tAs.classificationOfTA;
        this.currentNumberOfClasses = tAs.currentNumberOfClasses;
        this.totalNumberOfWorkingHours = tAs.totalNumberOfWorkingHours;
    }

    /**
     getters and setters
     */
    public String getClassificationOfTA() {
        return classificationOfTA;
    }

    public void setClassificationOfTA(String classificationOfTA) {
        this.classificationOfTA = classificationOfTA;
    }

    public int getCurrentNumberOfClasses() {
        return currentNumberOfClasses;
    }

    public void setCurrentNumberOfClasses(int currentNumberOfClasses) {
        this.currentNumberOfClasses = currentNumberOfClasses;
    }

    public int getTotalNumberOfWorkingHours() {
        return totalNumberOfWorkingHours;
    }

    public void setTotalNumberOfWorkingHours(int totalNumberOfWorkingHours) {
        this.totalNumberOfWorkingHours = totalNumberOfWorkingHours;
    }
}
