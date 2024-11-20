package tree;

import java.util.LinkedList;
import java.util.Queue;
/*Find the rightmost node of a complete binary tree, assure you'll get complete binary tree in input*/
public class RightMostNode {
    public static void main(String[] args) {
        Node node = new Node(10);
        new Node(20);
        System.out.println(findR(node));
    }

    private static Node findR(Node root) {
        if (root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node res = null;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
            if (q.size()==1) res=q.poll();
        }
        return res;
    }
}
