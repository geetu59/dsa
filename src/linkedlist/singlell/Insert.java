package linkedlist.singlell;

/*
 * Insertion in linkedlist: begin, mid, end
 * Traversal: iterative, recursive
 * */
public class Insert {
    public static void main(String[] args) {
        Node head = null;
        //insertion in ll happens in reverse order, ones which are inserted first will come at the end
        head = insertNodeInBeginning(head, 10);  //O(1)
        head = insertNodeInBeginning(head, 20);
        head = insertNodeInBeginning(head, 30);
        head = insertNodeAtEnd(head, 40); //O(N)
        head = insertNodeInMiddle(head, 50, 3);
        traverseIterative(head);
        System.out.println();
        traverseRecursive(head);
    }

    private static Node insertNodeInMiddle(Node head, int x, int pos) {
        Node temp = new Node(x);
        if (pos == 1) {
            temp.next = head;
            return temp;
        }
        Node curr = head;
        for (int i = 0; i <= pos - 2 && curr != null; i++)
            curr = curr.next;
        if (curr == null) return head;
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    private static Node insertNodeAtEnd(Node head, int x) {
        if (head == null)
            return new Node(x);
        Node curr = head;
        Node temp = new Node(x);
        while (curr.next != null)
            curr = curr.next;
        curr.next = temp;
        return head;
    }

    private static void traverseIterative(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    private static void traverseRecursive(Node head) {
        if (head == null) return;
        System.out.print(head.data + " ");
        traverseRecursive(head.next);
    }

    private static Node insertNodeInBeginning(Node head, int x) {
        if (head == null)
            return new Node(x);
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }
}
