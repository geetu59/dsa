package tree;

import java.util.LinkedList;
import java.util.Queue;

public class VerticalWidth {
    public static void main(String[] args) {
        Node root = new Node(50);
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(10);
        Node node4 = new Node(20);
        root.left = node1;
        root.right = node2;
        root.left.left = node3;
        root.right.right = node4;

        System.out.println(verticalWidth(root));
    }

    private static int verticalWidth(Node root) {
        if (root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            Node node = pair.node;
            int hd = pair.hd;
            min = Math.min(min, hd);
            max = Math.max(max, hd);
            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }
        return max - min + 1;
    }
}
