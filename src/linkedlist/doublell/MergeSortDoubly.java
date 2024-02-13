package linkedlist.doublell;

public class MergeSortDoubly {
    public static void main(String[] args) {
        Node head = new Node(7);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node node4 = new Node(8);
        Node node5 = new Node(1);
        Node node6 = new Node(2);
        Node tail = new Node(4);
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

        head = sortDoubly(head);
        printList(head);
    }

    private static Node sortDoubly(Node head) {
        if (head != null && head.next != null) {
            //cal mid
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            slow.prev.next = null;
            slow.prev = null;
            Node head1 = slow;
            head = sortDoubly(head);
            head1 = sortDoubly(head1);
            head = merge(head, head1);

        }
        return head;
    }

    static Node merge(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        Node head, tail;
        if (head1.data < head2.data) {
            head = tail = head1;
            head1 = head1.next;
        } else {
            head = tail = head2;
            head2 = head2.next;
        }
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                Node temp = tail;
                tail.next = head1;
                tail = head1;
                tail.prev = temp;
                head1 = head1.next;
            } else {
                Node temp = tail;
                tail.next = head2;
                tail = head2;
                tail.prev = temp;
                head2 = head2.next;
            }
        }
        if (head1 == null) {
            tail.next = head2;
            head2.prev=tail;
        } else {
            tail.next = head1;
            head1.prev=tail;
        }
        return head;
    }

    private static void printList(Node head) {
        Node temp = head;
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            temp = curr;
            curr = curr.next;
        }
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }

    }
}
