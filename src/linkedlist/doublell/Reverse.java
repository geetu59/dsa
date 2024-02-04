package linkedlist.doublell;

/*
 * Reverse doubly ll
 * */
public class Reverse {
    static Node head;

    public static void main(String[] args) {
        head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node tail = new Node(5);
        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = tail;
        tail.prev = node4;
        reverse();
        printList();
    }

    private static void reverse() {
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;
            head=curr;
            curr = curr.prev;
        }
    }

    private static void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
