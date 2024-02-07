package linkedlist.singlell;

import java.util.HashSet;

/* find length of loop, 1->2->3->4->5->2 point back
 * Detect loop:
 * Sol 1: Traverse twice O(N^2)
 * Sol 2: Modify Node structure to include boolean visited O(N)
 * Sol 3: Modification of linkedlist references as we point each node to Node temp and if we find that a node is already pointing to temp then loop is there
 * Sol 4: O(N) time and space, insert nodes in hashset and search if node is already there then it's a loop
 * */
public class LoopLength {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node tail = new Node(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = tail;
        makeLoop(head, tail, 2);
        //Sol 1
        System.out.println(detectLoop(head));

        //Sol 2
        NewNode head1 = new NewNode(1);
        NewNode node5 = new NewNode(2);
        NewNode node6 = new NewNode(3);
        NewNode node7 = new NewNode(4);
        NewNode tail1 = new NewNode(5);
        head1.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = tail1;
        makeLoop(head1, tail1, 2);
        System.out.println(findLoop(head1));

        //Sol 3
        Node head2 = new Node(1);
        Node nodeA = new Node(2);
        Node nodeB = new Node(3);
        head2.next = nodeA;
        nodeA.next = nodeB;
        nodeB.next = nodeA;
        System.out.println(detectLoopByModifyingll(head2));

        //Sol 4
        System.out.println(detectLoopUsingHashSet(head));

        System.out.println(lengthOfLoop(head));
    }

    private static boolean detectLoopUsingHashSet(Node head) {
        HashSet<Node> hashSet = new HashSet<>();
        Node curr = head;
        while (curr != null) {
            if (hashSet.contains(curr))
                return true;
            hashSet.add(curr);
            curr = curr.next;
        }
        return false;
    }

    private static boolean detectLoopByModifyingll(Node head) {
        Node temp = new Node(1);
        Node curr = head;
        while (curr != null) {
            if (curr.next == null) return false;
            if (curr.next == temp)
                return true;
            Node curr_next = curr.next;
            curr.next = temp;
            curr = curr_next;
        }
        return false;
    }

    private static boolean findLoop(NewNode head1) {
        if (head1 == null) return false;
        NewNode curr = head1;
        while (curr != null) {
            if (curr.visited)
                return true;
            curr.visited = true;
            curr = curr.next;
        }
        return false;
    }

    private static boolean detectLoop(Node head) {
        if (head == null) return false;
        if (head.next == head) return true;
        Node curr1 = head;
        for (int i = 0; curr1 != null; i++) {
            Node curr2 = head;
            Node temp = curr1.next;
            for (int j = 0; j < i; j++) {
                if (temp == curr2)
                    return true;
                curr2 = curr2.next;
            }
            curr1 = curr1.next;
        }
        return false;
    }

    private static int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int result = 1;
                Node curr = slow;
                while (curr.next != slow) {
                    result++;
                    curr = curr.next;
                }
                return result;
            }
        }
        return 0;
    }

    private static void makeLoop(Node head, Node tail, int pos) {
        if (pos == 0) return;
        Node curr = head;
        for (int i = 1; i < pos; i++)
            curr = curr.next;
        tail.next = curr;
    }

    private static void makeLoop(NewNode head, NewNode tail, int pos) {
        if (pos == 0) return;
        NewNode curr = head;
        for (int i = 1; i < pos; i++)
            curr = curr.next;
        tail.next = curr;
    }


}

class NewNode {
    int data;
    NewNode next;
    boolean visited;

    public NewNode(int data) {
        this.data = data;
    }
}
