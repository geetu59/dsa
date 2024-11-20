package tree.construct;

import tree.Node;

public class BTFromInAndPost {
    static int postIndex = 7; //arr.length-1

    public static void main(String[] args) {
        int[] in = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] post = {8, 4, 5, 2, 6, 7, 3, 1};
        Node node = buildTree(in, post, 0, post.length - 1);
        inOrder(node);
    }

    private static Node buildTree(int[] in, int[] post, int start, int end) {
        if (start > end) return null;
        Node root = new Node(post[postIndex--]);
        int inIndex = 0;
        for (int i = start; i <= end; i++) {
            if (in[i] == root.key) {
                inIndex = i;
                break;
            }
        }
        root.right = buildTree(in, post, inIndex + 1, end);
        root.left = buildTree(in, post, start, inIndex - 1);
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
