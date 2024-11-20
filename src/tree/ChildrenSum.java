package tree;

public class ChildrenSum {
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

        System.out.println(isChildrenSum(root));
    }

    private static int isChildrenSum(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int sum = 0;
        if (root.left != null) sum += root.left.key;
        if (root.right != null) sum += root.right.key;
        if(root.key==sum){
            if(isChildrenSum(root.left) == 1 && isChildrenSum(root.right) == 1)
                return 1;
            else return 0;
        }
        else
            return 0;
    }
}
