package tree;

public class Diameter {
    static int res = 0;
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        root.left = node1;
        root.right = node2;
        root.left.left = node3;
        root.left.right = node4;
        root.right.left = node5;
        root.right.right = node6;
        //O(N*N)
        System.out.println(diameter(root));
        //O(N)
        diamterOpt(root);
        System.out.println(res);
    }

    private static int diamterOpt(Node root) {
        if (root == null) return 0;
        int lh = diamterOpt(root.left);
        int rh = diamterOpt(root.right);
        res = Math.max(res, 1 + lh + rh);
        return 1 + Math.max(lh, rh);
    }

    private static int diameter(Node root) {
        if (root == null) return 0;
        int d1 = 1 + height(root.left) + height(root.right);
        int d2 = diameter(root.left); //making root's left node as root node and then evaluate
        int d3 = diameter(root.right);
        return Math.max(d1, Math.max(d2, d3));
    }

    private static int height(Node root) {
        if (root == null) return 0;
        else return 1 + Math.max(height(root.left), height(root.right));
    }

}
