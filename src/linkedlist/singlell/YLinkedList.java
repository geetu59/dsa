package linkedlist.singlell;

import java.util.HashSet;

import static java.lang.Math.abs;
import static java.lang.Math.nextUp;

/* ">-" This shaped ll is there, find intersection point
 * Sol 1: O(m+n) tme and O(n) auxillary space
 * Sol 2: O(m+n) time and O(1) auxillary space
 * */
public class YLinkedList {
    public static void main(String[] args) {
        Node head1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node head2 = new Node(60);
        head2.next = node4;
        node4.next = node5;

        //Sol 1
        System.out.println(intersectionPoint(head1, head2));
        //Sol 2
        System.out.println(intersectPoint(head1, head2));
    }

    private static int intersectPoint(Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;
        int count1 = 0;
        int count2 = 0;
        while (curr1 != null) {
            count1++;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            count2++;
            curr2 = curr2.next;
        }
        curr1 = count1 >= count2 ? head1 : head2;
        for (int i=0; i<abs(count2-count1);i++){
            curr1=curr1.next;
        }
        curr2 = count1 >= count2 ? head2 : head1;
        while (curr1!=null && curr2!=null){
            if (curr1==curr2)
                return curr1.data;
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return -1;
    }

    private static int intersectionPoint(Node head1, Node head2) {
        HashSet<Node> set = new HashSet<>();
        Node curr = head1;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }
        Node curr2 = head2;
        //though hashset doesn't store elements in fixed order but since we are traversing one by one of second ll, so it'll find first node only
        while (curr2 != null) {
            if (set.contains(curr2))
                return curr2.data;
            curr2 = curr2.next;
        }
        return curr2 == null ? -1 : curr2.data;
    }
}
