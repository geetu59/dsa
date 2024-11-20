package tree;

public class MaxInBT {
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

        System.out.println(getMax(root));
    }

    private static int getMax(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        else return Math.max(root.key, Math.max(getMax(root.left), getMax(root.right)));
    }
}
