package linkedlist.singlell;

import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.Stack;

/* Check if linked list is Palindrome
* Sol 1: Naive sol, using stack, O(N) time and space
* Sol 2: Theta(N) Time complexity with no extra space, find middle, reverse nodes after middle and compare
* */
public class Palindromell {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node tail = new Node(1);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = tail;

        System.out.println(isPalindrome(head));
        System.out.println(isPalin(head));
    }

    private static boolean isPalin(Node head) {
        if (head==null || head.next==null) return true;
        Node slow=head;
        Node fast=head;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node rev = reverseList(slow.next);
        Node curr=head;
        while (rev!=null){
            if (curr.data!=rev.data)
                return false;
            curr=curr.next;
            rev=rev.next;
        }
        return true;
    }

    private static Node reverseList(Node head) {
        Node curr=head;
        Node prev = null;
        while (curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    private static boolean isPalindrome(Node head) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        Node curr=head;
        while (curr!=null){
            stack.push(curr.data);
            curr=curr.next;
        }
        curr=head;
        while (curr.next!=null){
            if (stack.pop()!=curr.data)
                return false;
            curr=curr.next;
        }
        return true;
    }
}
