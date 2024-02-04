package linkedlist.singlell;

/* find length of loop, 1->2->3->4->5->2 point back
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
        System.out.println(lengthOfLoop(head));
    }

    private static int lengthOfLoop(Node head) {
        Node slow=head;
        Node fast=head;
        while (slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                int result=1;
                Node curr=slow;
                while (curr.next!=slow){
                    result++;
                    curr=curr.next;
                }
                return result;
            }
        }
        return 0;
    }

    private static void makeLoop(Node head, Node tail, int pos) {
        if(pos==0) return;
        Node curr=head;
        for(int i=1;i<pos;i++)
            curr=curr.next;
        tail.next=curr;
    }

}
