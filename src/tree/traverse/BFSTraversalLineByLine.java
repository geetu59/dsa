package tree.traverse;

import tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversalLineByLine {

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
        Node node5 = new Node(4);
        Node node6 = new Node(4);
        Node node7 = new Node(2);
        root1.left = (node5);
        root1.left.left = (node6);
        root1.left.right = node7;
        traverse(root);
        System.out.println(levelOrder(root1));
    }

    private static void traverse(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (queue.size() > 1) {
            Node curr = queue.poll();
            if (curr == null) {
                System.out.println();
                queue.add(null);
                continue;
            }
            System.out.print(curr.key + " ");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    static ArrayList<ArrayList<Integer>> levelOrder(Node node) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int levelCount = q.size();
            ArrayList<Integer> currList = new ArrayList<>();
            for (int i = 0; i < levelCount; i++) {
                Node curr = q.poll();
                currList.add(curr.key);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            res.add(currList);
        }
        return res;
    }
}
