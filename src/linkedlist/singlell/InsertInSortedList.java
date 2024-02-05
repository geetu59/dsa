package linkedlist.singlell;

/*
 * Insert in sorted list such that list remains sorted on insertion. first: O(1) last: theta(n) avg: theta(pos)
 * */
public class InsertInSortedList {
    static Node head;

    public static void main(String[] args) {
        insertInSortedList(7);
        insertInSortedList(8);
        insertInSortedList(2);
        insertInSortedList(1);
        insertInSortedList(3);
        insertInSortedList(5);
        traverse();
    }

    private static void insertInSortedList(int x) {
        Node temp = new Node(x);
        if (head == null)
            head = temp;
        else if (head.data >= x) {
            temp.next = head;
            head = temp;
        }
        else {
            Node curr = head;
            //make sure curr or curr.next should not be null
            while (curr.next != null && curr.next.data < x)
                curr = curr.next;
            //do these below steps in proper sequence
            temp.next = curr.next;
            curr.next = temp;
        }
    }

    private static void traverse() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
