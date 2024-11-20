package tree.view;

import tree.Node;
import tree.Pair;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
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

        bottomView(root);
    }

    private static void bottomView(Node root) {
        if (root == null) return;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            Node curr = pair.node;
            int hd = pair.hd;

            map.put(hd, curr.key);
            if (curr.left != null) q.add(new Pair(curr.left, hd - 1));
            if (curr.right != null) q.add(new Pair(curr.right, hd + 1));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
