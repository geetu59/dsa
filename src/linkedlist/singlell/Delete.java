package linkedlist.singlell;

/*
 * Deletetion in linkedlist: begin, mid, end
 * Delete given node, last node cant be deleted using this node
 * Traversal: iterative
 * */
public class Delete {
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
        deleteNode(node2);
        printList(head);

        System.out.println();
        head = deleteFromBeginning(head); //O(1)
        printList(head);

        System.out.println();
        head = deleteFromMiddle(head, 30);
        printList(head);
        System.out.println();

        head = deleteFromEnd(head);//O(n)
        printList(head);
    }

    private static void deleteNode(Node del) {
        del.data=del.next.data;
        del.next=del.next.next;
    }

    private static Node deleteFromEnd(Node head) {
        if (head == null || head.next == null)
            return null;
        Node curr = head;
        while (curr.next.next != null)
            curr = curr.next;
        curr.next = null;
        return head;
    }

    private static Node deleteFromMiddle(Node head, int x) {
        Node curr = head;
        Node prev = head;
        if (head == null || head.next == null)
            return null;
        while (curr != null) {
            if (curr.data == x) {
                prev.next = curr.next;
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    private static Node deleteFromBeginning(Node head) {
        if (head == null) return null;
        return head.next;
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
