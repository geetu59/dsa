package tree.construct;

import tree.Node;

import java.util.HashMap;

import static tree.traverse.DFSTraversal.inOrder;

public class BTFromParentArray {
    public static void main(String[] args) {
        int parent[] = {-1, 0, 0, 1, 1, 3, 5};
        Node root = buildTree(parent);
        inOrder(root);
    }

    private static Node buildTree(int[] parent) {
        Node head = null;
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            map.put(i, new Node(i));
        }
        for (int i = 0; i < parent.length; i++) {
            int value = parent[i];
            if (value == -1) {
                head = map.get(i);
            } else {
                Node node = map.get(value);
                if (node.left != null) node.right = map.get(i);
                else node.left = map.get(i);
            }
        }
        return head;
    }
}
