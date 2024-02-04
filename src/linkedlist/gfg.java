package linkedlist;

//{ Driver Code Starts
// driver

import linkedlist.singlell.Node;

class GfG{

    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node first = new Node(4);
        Node node1 = new Node(5);
        Node second = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);


        first.next=node1;
        second.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
        Solution g = new Solution();
            Node res = g.swapkthnode(second, 2, 2);
            printList(res);

    }
}


class Solution{
    Node swapkthnode(Node head, int num, int K)
    {
        if(K>num)
            return head;
        Node curr1=head;
        Node curr2=head;
        Node prev1=null;
        Node prev2=null;
        for(int i=1;i<K;i++){
            prev1=curr1;
            curr1=curr1.next;
        }
        for(int i=1;i<num-K+1;i++){
            prev2=curr2;
            curr2=curr2.next;
        }
        if(K==1){
            curr2.next=curr1.next;
            curr1.next=null;
            prev2.next=curr1;
            if(curr1==prev2){
                curr2.next=curr1;
                curr1.next=null;
            }
            return curr2;
        }
        if(K==num){
            curr1.next=curr2.next;
            curr2.next=null;
            prev1.next=curr2;
            if(curr2==prev1){
                curr1.next=curr2;
                curr2.next=null;
            }
            return curr1;
        }
        prev1.next=curr2;
        Node temp1=curr1.next;
        Node temp2=curr2.next;
        curr1.next=temp2;
        curr2.next=curr1;
        if(prev2!=curr1) {
            curr2.next=temp1;
            prev2.next=curr1;
        }
        return head;
    }
}
