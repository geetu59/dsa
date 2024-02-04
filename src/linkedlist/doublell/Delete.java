package linkedlist.doublell;

/*
 * Delete in doubly ll: first, last, mid
 * */
public class Delete {
    static Node head;

    public static void main(String[] args) {
        head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node tail = new Node(7);
        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;
        node6.next = tail;
        tail.prev = node6;
        deleteFromBegin();
        deleteFromEnd();
        //2 3 4 5 6
        deleteAtPos(10);
        deleteAtPos(5);
        deleteAtPos(1);
        deleteAtPos(2);
        printList();
    }

    private static void deleteAtPos(int pos) {
        if (pos == 1) {
            if (head == null) return;
            if (head.next == null) head = null;
            else {
                head = head.next;
                head.prev = null;
            }
        } else {
            Node curr = head;
            for (int i = 1; i < pos && curr != null; i++)
                curr = curr.next;
            if (curr == null) return;
            curr.prev.next = curr.next;
            if (curr.next != null) curr.next.prev = curr.prev;
        }
    }

    private static void deleteFromEnd() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
        }
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.prev.next = null;
    }

    private static void deleteFromBegin() {
        if (head == null) return;
        if (head.next != null)
            head.next.prev = null;
        head = head.next;
    }

    private static void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
