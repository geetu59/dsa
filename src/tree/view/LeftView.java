package tree.view;

import tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftView {
    static int maxLevel;

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

        System.out.println(leftView(root)); //10 20 40

        leftViewRecursively(root);
    }

    private static void leftViewRecursively(Node root) {
        recursiveView(root, 1);
    }

    private static void recursiveView(Node root, int level) {
        if (root == null) return;
        if (maxLevel < level) {
            System.out.println(root.key);
            maxLevel = level;
        }
        recursiveView(root.left, level + 1);
        recursiveView(root.right, level + 1);
    }

    private static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                if (i == 0) {
                    res.add(curr.key);
                }
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        return res;
    }

}
