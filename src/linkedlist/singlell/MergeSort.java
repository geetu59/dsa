package linkedlist.singlell;

/*O(m)*/
public class MergeSort {
    public static void main(String[] args) {
        Node head = new Node(50);
        Node node2 = new Node(10);
        Node node3 = new Node(70);
        Node node4 = new Node(40);
        Node node5 = new Node(50);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head = mergeSort(head);
        printList(head);
    }

    private static Node mergeSort(Node head) {
        //Relate it to merget sort in arrays
        //if(l<r) This condition is put so that there are atleast 2 elements in array and for us to check 2 elements in ll, below condition
        if (head != null && head.next != null)
        {
            //cal mid
            Node slow = head;
            Node fast = head;
            Node prev = null;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            //kept track of prev as we need to segregate 2 lists and element before mid should point to null
            prev.next = null;
            Node head1 = slow;
            //we used to pass, arr,low,mid and arr, mid+1,high as we had arr and we wanted to segregate into halves, here we will create 2 heads
            head = mergeSort(head);
            head1 = mergeSort(head1);
            //arr,l,mid,r but here we need to merge 2 lists
            head = merge(head, head1);

        }
        return head;
    }

    static Node merge(Node head1, Node head2) {
        if (head1 == null) return head2; //if first list is empty
        if (head2 == null) return head1; //if second list is empty
        Node head, tail;
        //following the same approach as that of arrays
        if (head1.data < head2.data) {
            head = tail = head1;
            head1 = head1.next;
        } else {
            head = tail = head2;
            head2 = head2.next;
        }
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        //if elements of other list are present then just connect it to tail as it is already sorted
        if (head1 == null) tail.next = head2;
        else tail.next = head1;
        return head;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
