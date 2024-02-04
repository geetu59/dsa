package linkedlist.singlell;

public class Node {
    public int data; //data type of data is the one which will tell us the type of ll
    public Node next; //self-referential

    public Node(int data) {
        this.data = data;
        this.next = null; //can ignore, by def it's null only in java
    }
}
