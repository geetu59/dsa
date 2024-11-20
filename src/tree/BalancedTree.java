package tree;

public class BalancedTree {
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
//O(N*N)
        System.out.println(isBalanced(root));
//
        System.out.println(checkBalanced(root));
    }

    private static int checkBalanced(Node root) {
        if (root == null) return 0;
        int lh = checkBalanced(root.left);
        if (lh == -1) return -1;
        int rh = checkBalanced(root.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        else
            return Math.max(lh, rh) + 1;
    }

    private static boolean isBalanced(Node root) {
        if (root == null) return true;
        int lh = height(root.left);
        int rh = height(root.right);
        return (Math.abs(lh - rh) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int height(Node root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
