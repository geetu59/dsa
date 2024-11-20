package tree;

public class FoldableTree {
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

        System.out.println(isFoldable(root));
    }

    private static boolean isFoldable(Node root) {
        if (root == null) return true;
        return isFoldableUtil(root.left, root.right);
    }

    private static boolean isFoldableUtil(Node node1, Node node2) {
        if (node1 == null && node2 == null) return true;
        if ((node1 == null && node2 != null) || (node2 == null && node1 != null)) return false;
        return isFoldableUtil(node1.left, node2.right) && isFoldableUtil(node1.right, node2.left);
    }
}
