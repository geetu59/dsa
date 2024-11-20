package tree;

public class MaxSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node node1 = new Node(2);
        Node node2 = new Node(5);
        Node node3 = new Node(-2);
//        Node node4 = new Node(1);
//        Node node5 = new Node(3);
//        Node node6 = new Node(4);
        root.left = node1;
        root.right = node2;
        root.right.right = node3;
//        root.left.right = node4;
//        root.right.left = node5;
//        root.right.right = node6;

        findMaxSum(root);
        System.out.println(maxSum);
    }

    static int maxSum = Integer.MIN_VALUE;

    private static int findMaxSum(Node root) {
        if (root == null) return 0;
        int leftSum = Math.max(0, findMaxSum(root.left));
        int rightSum = Math.max(0, findMaxSum(root.right));
        int currSum = root.key + leftSum + rightSum;
        maxSum = Math.max(maxSum, currSum);
        return root.key + Math.max(leftSum, rightSum);
    }

/*    static int maxSum1 = Integer.MIN_VALUE;

    private static int findMaxSum1(Node root) {
        if (root == null) return 0;
        int leftSum = findMaxSum(root.left);
        int rightSum = findMaxSum(root.right);

        int currMax = Math.max(Math.max(leftSum, rightSum) + root.key, root.key);
        int currSum = Math.max(currMax, root.key + leftSum + rightSum);
        maxSum1 = Math.max(maxSum1, currSum);
        return currMax;
    }*/
}
