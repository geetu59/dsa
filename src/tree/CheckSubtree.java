package tree;

import java.util.ArrayList;

public class CheckSubtree {
    public static void main(String[] args) {
        Node root1 = new Node(10);
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(40);
        Node node4 = new Node(50);
        root1.left = node1;
        root1.right = node2;
        root1.right.left = node3;
        root1.right.right = node4;

        Node root2 = new Node(30);
        Node node5 = new Node(40);
        Node node6 = new Node(50);
        root2.left = node5;
        root2.right = node6;

        System.out.println(isSubtree(root1, root2));

        System.out.println(isSubtreeThere(root1, root2));
    }

    private static boolean isSubtreeThere(Node root1, Node root2) {
        if (root1==null) return false;
        if (root2==null) return true;
        return isSubtreeUtil(root1, root2);
    }

    private static boolean isSubtreeUtil(Node root1, Node root2) {
        if (root1==null) return false;
        if(isIdentical(root1, root2)){
            return true;
        }
        return isSubtreeUtil(root1.left, root2) || isSubtreeUtil(root1.right, root2);
    }

    private static boolean isIdentical(Node root1, Node root2) {
        if (root1==null && root2==null) return true;
        if (root1!=null && root2!=null && root1.key== root2.key)
            return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
        return false;
    }

    private static boolean isSubtree(Node root1, Node root2) {
        ArrayList<Integer> res1 = new ArrayList<>();
        ArrayList<Integer> res2 = new ArrayList<>();
        ArrayList<Integer> res3 = new ArrayList<>();
        ArrayList<Integer> res4 = new ArrayList<>();

        res1 = preOrder(root1, res1);
        res2 = preOrder(root2, res2);
        res3 = inOrder(root1, res3);
        res4 = inOrder(root2, res4);
        //if (res1.containsAll(res2) && res3.containsAll(res4)) return true; //this will not work
        if (isSuitable(res1, res2) && isSuitable(res3, res4)) return true;
        return false;
    }

    private static boolean isSuitable(ArrayList<Integer> res1, ArrayList<Integer> res2) {
        int n = res1.size();
        int m = res2.size();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (!res1.get(i + j).equals(res2.get(j))) break;
            }
            if (j == m && m!=1) return true;
        }
        return false;
    }

    private static ArrayList<Integer> preOrder(Node root, ArrayList<Integer> res) {
        if (root != null) {
            res.add(root.key);
            preOrder(root.left, res);
            preOrder(root.right, res);
        }
        return res;
    }

    private static ArrayList<Integer> inOrder(Node root, ArrayList<Integer> res) {
        if (root != null) {
            inOrder(root.left, res);
            res.add(root.key);
            inOrder(root.right, res);
        }
        return res;
    }
}
