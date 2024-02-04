package linkedlist.singlell;

/*
 * Search in linkedlist:iterative, recursive and tell the position
 * */
public class Search {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(searchIteratively(head, 20));
        System.out.println(searchRecursively(head, 30));
    }

    private static int searchRecursively(Node head, int x) {
        if (head == null) return -1;
        if (head.data == x) return 1;
        int res = searchRecursively(head.next, x);
        if (res == -1) return -1;
        return res + 1;
    }

    private static int searchIteratively(Node head, int x) {
        int pos = 0;
        Node curr = head;
        while (curr != null) {
            pos++;
            if (curr.data == x) {
                return pos;
            }
            curr = curr.next;
        }
        return -1;
    }
}
