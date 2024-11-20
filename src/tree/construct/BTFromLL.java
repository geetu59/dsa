package tree.construct;

import linkedlist.singlell.Node;

import java.util.LinkedList;
import java.util.Queue;

import static tree.traverse.DFSTraversal.inOrder;

public class BTFromLL {
    public static void main(String[] args) {
        //ll
        Node head = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);
        Node node5 = new Node(50);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        tree.Node node = null;
        tree.Node root = buildTree(head, node);
        inOrder(root);
    }

    private static tree.Node buildTree(Node head, tree.Node node) {
        if (head==null) {
            node=null;
            return node;
        }
        Queue<tree.Node> q = new LinkedList<>();
        node = new tree.Node(head.data);
        q.add(node);
        head=head.next;
        while (head!=null){
            tree.Node parent = q.poll();
            tree.Node leftChild = new tree.Node(head.data);
            parent.left= leftChild;
            q.add(leftChild);
            head=head.next;
            if (head!=null){
                tree.Node rightChild = new tree.Node(head.data);
                parent.right= rightChild;
                q.add(rightChild);
                head=head.next;
            }
        }
        return node;
    }
}
