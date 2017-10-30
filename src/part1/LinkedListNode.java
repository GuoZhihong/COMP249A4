// -----------------------------------------------------
// Assignment #4
// Part: (1)
// Written by: Zhihong Guo(40038183),Tiantian Ji(27781083)
// -----------------------------------------------------

/**
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */
public class LinkedListNode {

    /**
     *private attribute
     */
    private Object value;
    private LinkedListNode nextNode = null;

    /**
     *default constructor
     */
    public LinkedListNode() {
    }

    /**
     *shallow copy
     * @param node
     */
    public LinkedListNode(LinkedListNode node) {
        this.value = node.value;
        this.nextNode = node.nextNode;
    }

    /***
     * Parametrized constructor
     * @param value
     */
    public LinkedListNode(Object value) {
        this.value = value;
    }

    /**
    getters and setters
     */
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public LinkedListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkedListNode nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * equalsTo to see if passing node is same as the current node
     * @param node
     * @return
     */
    public boolean equalsTo(LinkedListNode node){
        if(this.getValue() == node.getValue() && this.getNextNode() == node.getNextNode()){
            return true;
        }
        else
            return false;
    }

    /**
     *deep copy
     */
    public void copy(){
        new LinkedListNode().setValue(this.getValue());
    }
}
