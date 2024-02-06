package linkedlist.singlell;

//find middle of linkedlist, for even numbered list, middle should be second one.
public class MiddleLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        //Naive solution, requires 2 traversal O(N)
        middleLinkedList(head);

        //optimal sol, 1 traversal, slow and fast reference O(N)
        midLinkedList(head);

        Node node = insertInMid(head, 5);
        printList(node);

    }

    //till the time fast reaches end, slow will be in middle.
    private static void midLinkedList(Node head) {
        if (head == null) return;
        Node slow = head;
        Node fast = head;
        //fast.next != null fr odd nodes, fast != null for even nodes,
        // anyways we've to put as fast.next is what we are trying to access, so fast shouldnt be null to access next
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
    }

    private static void middleLinkedList(Node head) {
        if (head == null) return;
        int count = 0;
        Node curr = head;
        //got number of elements of linkedlist
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        //element at count/2 is the output
        curr = head;
        for (int i = 0; i < count / 2; i++)
            curr = curr.next;
        System.out.println(curr.data);
    }

    public static Node insertInMid(Node head, int data){
        Node temp = new Node(data);
        if(head==null) return temp;
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        temp.next=slow.next;
        slow.next=temp;
        return head;
    }
    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
