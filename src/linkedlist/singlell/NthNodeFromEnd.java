package linkedlist.singlell;

/*
 * Find nth node from the end
 * Sol 1: Find length of loop and traverse till (n-k+1)th node O(n) + O(n-k+1)
 * Sol 2: Two pointer approach
 * */
public class NthNodeFromEnd {
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

        //Sol:1
        findNthNode(head, 2);

        //Sol: 2
        System.out.println(searchNthNode(head, 4));
    }

    private static int searchNthNode(Node head, int k) {
        if(head==null) return -1;
        Node first=head;
        for(int i=0;i<k;i++){
            if(first==null) return -1;
            first=first.next;
        }
        Node second=head;
        while(first!=null){
            first=first.next;
            second=second.next;
        }
        return second.data;
    }

    private static void findNthNode(Node head, int k) {
        if (head == null) return;
        int length = 0;
        Node curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        if (length < k) return;
        curr = head;
        for (int i = 0; i < length - k; i++)
            curr = curr.next;
        System.out.println(curr.data);
    }
}
