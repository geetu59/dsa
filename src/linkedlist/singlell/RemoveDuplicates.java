package linkedlist.singlell;
/*Remove duplicates present in ll: O(N) time, O(1) space*/
public class RemoveDuplicates {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(7);
        Node tail = new Node(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = tail;

        head = removeDuplicates(head);
        printList(head);
    }

    private static Node removeDuplicates(Node head) {
        if(head==null) return null;
        Node curr=head;
        while(curr!=null && curr.next!=null){
            if(curr.data==curr.next.data){
                curr.next=curr.next.next;
            }
            else
            curr=curr.next;
        }
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
