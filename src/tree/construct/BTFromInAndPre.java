package tree.construct;

import tree.Node;


public class BTFromInAndPre {
    static int preIndex = 0;

    public static void main(String[] args) {
        int[] in = {20, 10, 40, 30, 50};
        int[] pre = {10, 20, 30, 40, 50};
        Node root = buildTree(in, pre, 0, pre.length - 1);
        inOrder(root);
    }

    private static Node buildTree(int[] in, int[] pre, int start, int end) {
        if (start > end) return null;
        Node root = new Node(pre[preIndex++]);
        int inIndex = 0;
        for (int i = start; i <= end; i++) {
            if (in[i] == root.key) {
                inIndex = i;
                break;
            }
        }
        root.left = buildTree(in, pre, start, inIndex - 1);
        root.right = buildTree(in, pre, inIndex + 1, end);
        return root;
    }

    private static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.key);
            inOrder(root.right);
        }
    }
}
