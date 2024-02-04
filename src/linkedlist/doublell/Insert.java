package linkedlist.doublell;

/*
 * insert in doubly ll: begin, end, mid: before and after given node, position starts from 1
 * */
public class Insert {
    static Node head;

    public static void main(String[] args) {
        //if we pass head as method param, then it is pass by value and it'll update the local head and hence on doing
        // head=temp, it'll not work, now head used is the one on top which is getting updated
        insertAtBegin(1); //O(1) time and space
        insertAtBegin(2);
        insertAtEnd(3);
        insertAtEnd(4); //O(N)
        insertBeforePos(8, 9);
        insertBeforePos(4, 5);
        insertBeforePos(1, 7);
        insertBeforePos(2, 8);
        //7 8 2 1 3 5 4
        insertAfterPos(20, 10);
        insertAfterPos(8, 11);
        insertAfterPos(7, 12);
        insertAfterPos(1, 13);
        insertAfterPos(2, 14);
        //7->13->14->8->2->1->3->5->4->12
        printList(head);
    }

    private static void insertAfterPos(int pos, int x) {
        Node temp = new Node(x);
        Node curr = head;
        for (int i = 1; i < pos && curr != null; i++)
            curr = curr.next;
        if (curr == null) return;
        temp.next = curr.next;
        temp.prev = curr;
        if (curr.next != null) curr.next.prev = temp;
        curr.next = temp;
    }

    /*
     * pos==1, pos>length, end 1->2->3
     * */
    private static void insertBeforePos(int pos, int x) {
        Node temp = new Node(x);
        if (pos == 1) {
            temp.next = head;
            if (head != null)
                head.prev = temp;
            head = temp;
        } else {
            Node curr = head;
            for (int i = 1; i < pos - 1 && curr != null; i++)
                curr = curr.next;
            if (curr == null)
                return;
            temp.next = curr.next;
            temp.prev = curr;
            if (curr.next != null)
                curr.next.prev = temp;
            curr.next = temp;
        }
    }

    private static void insertAtEnd(int x) {
        Node temp = new Node(x);
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = temp;
        temp.prev = curr;
    }

    private static void insertAtBegin(int x) {
        Node temp = new Node(x);
        temp.next = head;
        if (head != null)
            head.prev = temp;
        head = temp;
    }

    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
           System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
