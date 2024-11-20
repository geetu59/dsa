package tree;

public class HeightOfBT {
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

        System.out.println(height(root));
    }

    private static int height(Node root) {
        if (root == null) return 0;
        else return Math.max(height(root.left), height(root.right)) + 1;
    }
}
