// -----------------------------------------------------
// Assignment #4
// Part: (1)
// Written by: Zhihong Guo(40038183),Tiantian Ji(27781083)
// -----------------------------------------------------

/**
 * @author Zhihong Guo,Tiantian Ji
 * @version 1.8
 */

/*
LinkedList
 */
public class LinkedList {

    /**
     *private attribute
     */
    private LinkedListNode headNode;
    private int size;

    /**
     *default constructor
     */
    public LinkedList(){

    }

    /**
     * getNode() will return the specific node
     * @param index is an integer value
     * @return a node value
     */
    private LinkedListNode getNode(int index){
        LinkedListNode node = headNode;
        for (int i = 0; i < index; i++) {
            if (node != null) {
                node = node.getNextNode();
            }
        }
        return node;
    }

    /**
     *
     * @return the size of linked list
     */
    public int size(){
        size = 0;
        LinkedListNode node = headNode;
        while (node != null){//counter
            node =node.getNextNode();
            size++;
        }
        return size;
    }

    /**
     *get() will return a specific object
     * @param index is an integer value
     * @return a Object value
     */
    public Object get(int index){
        Object value = null;
        if(headNode != null) {
            value = getNode(index).getValue();
        }
        return value;
    }

    /**
     *indexOf() a long value then return which node has it
     * @param value is a long value
     * @return an integer value
     */
    public int indexOf(long value){
        LinkedListNode node = headNode;
        int index = 0;
        long value1 = 0;
        while(node != null) {
            if(node != null) {
                if(value != value1){
                    node = node.getNextNode();
                    value1 = ((Full_Time_Faculty_Members)node.getValue()).getSalary();
                    index++;
                } else{
                    return index;
                }
            }
            else {
                index = -1;
                break;
            }
        }
        return index;
    }

    /**
     *add() input a object then add to the lined list
     * @param value is an object value
     */
    public void add(Object value){
        LinkedListNode node = headNode;
        if (node == null){
            headNode = new LinkedListNode(value);
        }
        else  {
            while (node != null) {
                if (node.getNextNode() != null) {
                    node = node.getNextNode();
                } else break;
            }
            LinkedListNode add = new LinkedListNode(value);
            node.setNextNode(add);
        }
    }
}
