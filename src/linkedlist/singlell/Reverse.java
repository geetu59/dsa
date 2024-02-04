package linkedlist.singlell;

public class Reverse {
static Node head;
    public static void main(String[] args) {
        head = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverse();
        printList();
    }

    private static void reverse() {
        Node curr=head;
        Node prev=null;
        while (curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            head=prev;
        }
    }

    private static void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
