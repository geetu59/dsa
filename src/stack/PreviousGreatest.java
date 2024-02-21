package stack;

import java.util.Stack;

/*Find position-wise previous greater element. If you are at xth element, then find previous closest greatest element nearest to xth element
 * Sol 1: Naive sol O(N*N) time
 * Sol 2: Efficient sol based on stock span problem O(N), O(2N) is worst case as N push and N pop operations will happen*/
public class PreviousGreatest {
    public static void main(String[] args) {
        int arr[] = {15, 10, 18, 12, 4, 6, 2, 8};

        //Naive sol
        System.out.println("Naive sol: ");
        prevGreater(arr);

        //Efficient sol
        System.out.println("Efficient sol: ");
        previousGreater(arr);
    }

    private static void previousGreater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("-1");
        stack.push(arr[0]); //we are pushing elements here, not index as per in stock span problem becaz we are concerned about element not count here
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() < arr[i])
                stack.pop();
            int greatest = stack.isEmpty() ? -1 : stack.peek();
            System.out.println(greatest);
            stack.push(arr[i]);
        }
    }

    private static void prevGreater(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    System.out.println(arr[j]);
                    break;
                }
            }
            if (j == -1) System.out.println("-1");
        }
    }
}
