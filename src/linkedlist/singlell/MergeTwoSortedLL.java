package linkedlist.singlell;

/*You have 2 sorted ll, merge them so that resultant ll is also sorted
 * O(m+n) time and O(1) space
 * */
public class MergeTwoSortedLL {
    public static void main(String[] args) {
        Node head1 = new Node(10);
        Node node2 = new Node(30);
        Node node3 = new Node(50);
        Node node4 = new Node(70);
        Node node5 = new Node(80);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node head2 = new Node(10);
        Node node6 = new Node(20);
        Node node7 = new Node(60);
        Node node8 = new Node(90);
        Node node9 = new Node(100);
        head2.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        Node head = merge(head1, head2);
        printList(head);
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    private static Node merge(Node head1, Node head2) {
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
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        if (head1 == null) tail.next = head2;
        else tail.next = head1;
        return head;
    }
}
