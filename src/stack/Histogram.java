package stack;

import java.util.Stack;

import static stack.NextSmallest.nextSmallest;
import static stack.PreviousSmallest.previousSmallest;

/* Largest Rectangular Area: You are given an array = {6, 2, 5, 1} where each element represents height of bars in histogram
 * and width being 1 only. Find the largest area formed by these bars. For above case, it'd be 6. If you consider second bar,
 *  2+2+2=6 or infact first bar itself makes it 6.
 * Naive sol: Traverse thru' each of the elements, considering it as the lowest one. Let's say you are on xth element,
 * then go to it's left and right, until you don't find element less than xth on both sides becaz xth should be the lowest one for us.
 * If element is greater or equal, then add arr[x] to count as that's the lowest we are considering. Then consider max(res, count)
 * to get max area. Time: theta(n*n)
 * Better sol: The inner loops in above approach is to find smallest element on both sides. As you stop the moment you encounter one.
 * We can use stock span problem approach to find smallest on both sides. Time: theta(n) space: 2 auxiliary arrays ans 2 stacks.
 * Efficient sol: We will evaluate the element when we pop, not when we push(the way we did in stock span problem). O(N) time and space.
 * Space becaz only single stack is used and time becaz all elements are pushed and popped only once. N push and N pop operations so 2N.
 */
public class Histogram {
    public static void main(String[] args) {
        int arr[] = {60, 20, 50, 40, 10, 50, 60};

        System.out.println("Naive sol: ");
        System.out.println(getMaxArea(arr));

        System.out.println("Better sol: ");
        System.out.println(getLargeArea(arr));

        System.out.println("Efficient sol: ");
        System.out.println(getMaximumArea(arr));
    }

    private static int getMaximumArea(int[] arr) {
        Stack<Integer> stack = new Stack<>(); //store previous min only
        int result = 0;
        for (int i = 0; i < arr.length; i++) { //traversing thru each element.
            //we are processing elements during pop time. if arr[stack.peek()] >= arr[i] that means it needs to be removed from stack as it is not min now
            //so popped element is current element and min to the left of it would be top and min to the right of it would be arr[i]. This is clear from condition
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                Integer pop = stack.pop(); //Evaluation happens for the popped element i.e. popped element is considered as xth
                int curr = arr[pop] * (stack.isEmpty() ? i : i - stack.peek() - 1); //as we are processing popped element
                result = Integer.max(curr, result);
            }
            stack.push(i); //push performed later.
        }
        //all elements needs to be checked and the ones left in stack arent considered, so consider them till stack is empty
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            int curr = arr[pop] * (stack.isEmpty() ? arr.length : arr.length - stack.peek() - 1);
            result = Integer.max(curr, result);
        }
        return result;
    }

    private static int getLargeArea(int[] arr) {
        int result = 0; //initialize result to 0
        int[] prev = previousSmallest(arr); //find prev smallest of all elements, which we were doing as part of loop in naive sol, but here we will do in a single go for all elements
        int[] next = nextSmallest(arr); //find next smallest of all elements
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            curr += (i - prev[i] - 1) * arr[i];
            curr += (next[i] - i - 1) * arr[i];
            result = Integer.max(result, curr);
        }
        return result;
    }

    private static int getMaxArea(int[] arr) {
        int result = 0;
        //traverse each element considering it to be lowest
        for (int i = 0; i < arr.length; i++) {
            int count = arr[i]; //as it'll have height of current bar
            for (int j = i - 1; j >= 0; j--) { //traversing towards left from given element as we need to consider immediate one first
                if (arr[j] >= arr[i]) //since arr[i] is min so we need to have elements >= it
                    count += arr[i]; //add arr[i] as that's min you are considering
                else break; //the moment we encounter < element, we will not get max area
            }
            for (int k = i + 1; k < arr.length; k++) { //traversing towards right from given element as we need to consider immediate one first
                if (arr[k] >= arr[i]) //since arr[i] is min so we need to have elements >= it
                    count += arr[i]; //add arr[i] as that's min you are considering
                else break; //the moment we encounter < element, we will not get max area
            }
            result = Integer.max(result, count);
        }
        return result;
    }
}
