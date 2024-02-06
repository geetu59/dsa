package linkedlist.singlell;
//check whether two linked lists are identical or not.
public class IsIdentical {
    public static void main(String[] args) {
        Node first = new Node(4);
        Node node1 = new Node(5);
        first.next = node1;
        Node second = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(5);
        second.next = node2;
//        node2.next = node3;
        System.out.println(isIdentical(first, second));
    }

    private static boolean isIdentical(Node head1, Node head2) {
        Node curr1=head1;
        Node curr2=head2;
        while(curr1!=null && curr2!=null){
            if(curr1.data == curr2.data){
                curr1=curr1.next;
                curr2=curr2.next;
            } else
                return false;
        }
        if(curr1==null && curr2==null)
            return true;
        return false;
    }
}
