package tree;

import java.util.ArrayList;
import java.util.HashSet;

public class NodesAtKDistance {
    private static HashSet<Node> set;

    public static void main(String[] args) {
        Node root = new Node(10);
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(40);
        Node node4 = new Node(50);
        root.left = node1;
        root.right = node2;
        root.right.left = node3;
        root.right.right = node4;

        Node root1 = new Node(1);
        Node node5 = new Node(2);
        Node node6 = new Node(3);
        Node node7 = new Node(4);
        Node node8 = new Node(5);
        Node node9 = new Node(6);
        Node node10 = new Node(7);
        Node node11 = new Node(8);

        root1.left = node5;
        root1.right = node6;
        root1.left.left = node7;
        root1.left.right = node8;
        root1.right.left = node9;
        root1.right.right = node10;
        root1.right.left.right = node11;

        nodesAtKDistance(root, 2);
        System.out.println(numberOfNodesAtKDistance(root1, 2));
    }

    private static void nodesAtKDistance(Node root, int k) {
        if (root == null) return;
        if (k == 0) System.out.println(root.key);
        else {
            nodesAtKDistance(root.left, k - 1);
            nodesAtKDistance(root.right, k - 1);
        }
    }

    private static int numberOfNodesAtKDistance(Node root, int k) {
        set = new HashSet<>();
        ArrayList<Node> list = new ArrayList<>();
        getCount(root, k, list);
        return set.size();
    }
//Let's store Node not Integer to consider unique value of nodes, let's say 1 is root node and it is root node in it's subtrees as well.
    private static void getCount(Node root, int k, ArrayList<Node> list) {
        if (root == null) return;
        list.add(root);
        if (root.left == null && root.right == null) {
            if (list.size() - 1 >= k) {
                set.add(list.get(list.size() - 1 - k));
            }
        }
        getCount(root.left, k, list);
        getCount(root.right, k, list);
        list.remove(list.size() - 1);
    }
}
