package linkedlist.singlell;
/*
* swap node of linked list at kth position from begin and end where k starts from 1
* */
public class SwapKthNode {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node tail = new Node(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = tail;

        head = swapkthNode(head, 7, 2);
        printList(head);
    }

    private static Node swapkthNode(Node head, int n, int k) {
        //if k>n, no point to swap
        if (k>n) return head;
        //if kth node from begin and end are same
        if (2*k-1==n) return head;

        //get the prev and curr of kth node
        Node curr1=head;
        Node prev1=null;
        int count=k-1;
        while (count-->0){
            prev1=curr1;
            curr1=curr1.next;
        }

        //get the prev and curr of kth node from end
        Node curr2=head;
        Node prev2=null;
        count=n-k;
        while (count-- >0){
            prev2=curr2;
            curr2=curr2.next;
        }

        if (prev1!=null)
            prev1.next=curr2;

        if (prev2!=null)
            prev2.next=curr1;

        Node temp=curr1.next;
        curr1.next=curr2.next;
        curr2.next=temp;

        if (k==1)
            head=curr2;
        if (k==n)
            head=curr1;
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
