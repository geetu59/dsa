package tree;

public class Mirror {
    public static void main(String[] args) {
        Node root = new Node(50);
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(10);
        Node node4 = new Node(20);
        root.left = node1;
        root.right = node2;
        root.right.left = node3;
        root.right.right = node4;

        mirror(root);
        System.out.println(root.key + " " + root.left.key + " " + root.right.key + " " + root.left.left.key + " " + root.left.right.key);
    }

    public static void mirror(Node node) {
        if (node == null) return;
        mirror(node.left);
        mirror(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
