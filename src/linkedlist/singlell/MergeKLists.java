package linkedlist.singlell;

public class MergeKLists {
    public static void main(String[] args) {
//merge k list, so there is an arra of nodes which is divided into k parts, you have to sort it
        //[{3->7->5->null},{1->9->4->null},{2->7->8->null}] k=3
    }

    static Node mergeKList(Node[] arr, int K) {
        Node curr = arr[0];
        for (int i = 1; i < K; i++)
            curr = merge(curr, arr[i]);
        return curr;
    }

    //merge 2 sorted lists fn
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

}
