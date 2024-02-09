package linkedlist.singlell;

//XOR ll is memory efficient version of doubly ll, where we  store XOR(prev, next)
public class XORLinkedList {
    static XorNode head;

    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);
        printList();
    }

    private static void printList() {
        XorNode prev = null;
        XorNode curr = head;
        while (curr != null) {
            System.out.println(curr.data + " ");
            XorNode temp = curr;
            curr = xor(prev, curr.npx);
            prev = temp;
        }
    }

    private static void insert(int x) {
        XorNode newNode = new XorNode(x);
        newNode.npx = xor(null, head); //inserting in begining, so prev=null and next=head as next nore would be head
        if (head != null) {
            XorNode next = xor(null, head.npx);
            head.npx = xor(newNode, next);
        }
        head = newNode;
    }

    private static XorNode xor(XorNode node1, XorNode node2) {
        return node1 == null ? node2 : node2 == null ? node1 : null;
    }

}

class XorNode {
    int data;
    XorNode npx;

    public XorNode(int data) {
        this.data = data;
    }

    public long getAddress() {
        return System.identityHashCode(this);
    }
}
