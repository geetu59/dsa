package stack;

import java.util.Stack;

/*Largest rectangle with all 1s. Given a binary 2-D array. Find largest rectangle formed by the 1s.
 * Naive sol: Time: O(R^3*C*3)
 * 1. Consider every cell as starting point: O(R*C)
 * 2. Consider all sizes of rectangles with current cell as starting point: O(R*C)
 * 3. For all generated rects, check if all values are 1 and accordingly update result with bigger value: O(R*C)
 * Efficient sol: Using Histogram sol
 * 1. Consider each row as height in histogram. xth row will be the base of histogram and values above it will be added
 * if xth==1. If xth==0 means height is 0, so dont consider above values
 * 2. Apply histogram logic for each row values.
 * 3. Update max result
 * Time: theta(R*C), Space: theta(C) If you cannot modify input: theta(C) extra for arr, 3C basically*/
public class MaxRectangle {
    public static void main(String[] args) {
        int A[][] = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };
        //Efficient sol
        System.out.println(maxRectangle(A, 4));
    }

    private static int maxRectangle(int[][] a, int col) {
        int result = maxHist(a[0], col); //for first row, directly call histogram fn to calculate max height O(col)
        for (int i = 1; i < a.length; i++) { //for all rows, if value at a[i][j]=1, then add the value above it, if it is 0 then ignore. We are adding as we get more height O(row)
            for (int j = 0; j < col; j++) { //theta(col)
                if (a[i][j] == 1)
                    a[i][j] += a[i - 1][j];
            }
            result = Math.max(result, maxHist(a[i], col)); //O(col)
        }
        return result;
    }

    private static int maxHist(int[] arr, int col) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < col; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                Integer pop = stack.pop();
                int curr = arr[pop] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                result = Math.max(result, curr);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            int curr = arr[pop] * (stack.isEmpty() ? col : col - stack.peek() - 1);
            result = Math.max(result, curr);
        }
        return result;
    }
}
