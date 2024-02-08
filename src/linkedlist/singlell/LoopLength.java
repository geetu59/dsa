package linkedlist.singlell;

import java.util.HashSet;

import static linkedlist.singlell.Delete.printList;

/* Problem 1: Detect loop:
 * Sol 1: Traverse twice O(N^2)
 * Sol 2: Modify Node structure to include boolean visited O(N)
 * Sol 3: Modification of linkedlist references as we point each node to Node temp and if we find that a node is already pointing to temp then loop is there
 * Sol 4: O(N) time and space, insert nodes in hashset and search if node is already there then it's a loop
 * Sol 5: Floyd's Cycle Detection where we have slow and fast ptr O(m+n), m=nodes traversed which were not in loop, n= nodes in loop, we say it is O(N), N=nodes in ll
 * Problem 2: find length of loop, 1->2->3->4->5->2 point back
 * Problem 3: Find first node of loop
 * Problem 4: Remove loop
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

        //Sol 5: FLoyd's cycle detection
        System.out.println(detectLoopFloyd(head));

        //Problem 2: find length of loop
        System.out.println(lengthOfLoop(head));

        //Problem 3: Find first node of loop
        System.out.println(firstNode(head).data);

        //Problem 4: Remove loop
        removeLoop(head);
        printList(head);
    }

    private static Node firstNode(Node head) {
        Node slow=head;
        Node fast=head;
        while (slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast)
                break;
        }
        if (slow!=fast) return null;
        if (fast==head) return head;
        slow=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
            return slow;
    }

    private static boolean detectLoopFloyd(Node head) {
        Node slow=head;
        Node fast=head;
        while (slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast)
                return true;
        }
        return false;
    }

    private static void removeLoop(Node head) {
        if (head == null) return;
        Node slow = head;
        Node fast = head;
        //Detect loop, if we've 3 nodes(no loop), fast will point to third node and on fast.next.next,
        // we will get null ptr and if 4 nodes are there, then fast=null and hence this condiiton in while loop
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //This condition comes after updating slow and fast as both are pointing to head initially and this condition will become true in that case
            if (slow == fast)
                break;
        }
        //means loop doesnt exist
        if (slow!=fast) return;
        slow = head;
        //if loop starts from first node only then head and fast both points to head and hence handle separately to remove loop
        if (fast==head)
        {
            while (fast.next!=slow)
                fast=fast.next;
            fast.next=null;
            return;
        }
        //ideally slow==fast then we will reach common node but since we need previous one as we wanted to point that to null and hence we checkeed next, though we can use prev ptr also
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next=null;
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
