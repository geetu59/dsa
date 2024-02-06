package linkedlist.singlell;

public class AddTwoLinkedList {
    public static void main(String[] args) {
        Node first = new Node(4);
        Node node1 = new Node(5);
        first.next = node1;
        Node second = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        second.next = node2;
        node2.next = node3;

        Node node = addTwoLists(first, second);
        printList(node);
    }

    private static Node addTwoLists(Node first, Node second) {
        first = reverse(first);
        second = reverse(second);
        Node curr1 = first;
        Node curr2 = second;
        int carry = 0;
        Node sumNode = null;
        while (curr1 != null || curr2 != null || carry == 1) {
            int sum = carry;
            if (curr1 != null)
                sum += curr1.data;
            if (curr2 != null)
                sum += curr2.data;
            int digit = sum % 10;
            carry = sum / 10;
            Node node = new Node(digit);
            node.next = sumNode;
            sumNode = node;
            if (curr1 != null)
                curr1 = curr1.next;
            if (curr2 != null)
                curr2 = curr2.next;
        }
        return sumNode;
    }

    private static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
