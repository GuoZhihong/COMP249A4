// -----------------------------------------------------
// Assignment #4
// Part: (1)
// Written by: Zhihong Guo(40038183),Tiantian Ji(27781083)
// -----------------------------------------------------

/**
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */
public interface Ordered {
    /**
     * @param object is an Object value
     * @return a boolean value
     * returns true if the Hire Year of the calling Employee precedes the Hire Year of the passed Employee (for example 1998 precedes 2017);
     * otherwise the method returns false.
     */
    public boolean precedes(Object object);

    /**
     * @param object is an Object value
     * @return a boolean value
     * returns true if the Hire Year of the calling Employee follows the Hire Year of the passed Employee (for example, 2016 follows 2009);
     * otherwise the method returns false.
     */
    public boolean follows(Object object);
}
