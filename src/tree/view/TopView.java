package tree.view;

import tree.Node;
import tree.Pair;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {
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

        topView(root);
    }

    private static void topView(Node root) {
        if (root == null) return;

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            Node curr = pair.node;
            int d = pair.hd;

            if (!map.containsKey(d))
                map.put(d, curr.key);
            if (curr.left != null) q.add(new Pair(curr.left, d - 1));
            if (curr.right != null) q.add(new Pair(curr.right, d + 1));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
