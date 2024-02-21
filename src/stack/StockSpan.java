package stack;

import java.util.Arrays;
import java.util.Stack;

/*Stock Span Problem: The stock span problem is a financial problem where we have a series of N daily price quotes for a
 stock and we need to calculate the span of the stock's price for all N days. The span Si of the stock's price on a given
 day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock
 on the current day is less than its price on the given day.
 Sol 1: Naive sol: Time: O(N^2) Space: O(N) if you want to store values of span. traverse the array twice. No stack used
 Sol 2: Use stack to store previous greatest, time: O(N), might seems as if it's quadratic becaz of 2 loops. but outer loop
 is linear and push pop takes O(1) and each item is pushed and poped once
 If elements are in increasing order, then space would not be used much as you are putting one element in stack and then popping it out
 If elements are in decreasing order, then stack with size n is created
 */
public class StockSpan {
    public static void main(String[] args) {
        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        //Naive sol
        int span[]= new int[7];
        System.out.println("Naive sol: ");
        calculateSpan(arr, span);

        //Calculate span using single stack tine and space: O(N)
        System.out.println("Using stack: ");
        calculateSpanUsingStack(arr);
    }

    /*we will store all previously encountered greater elements in stack and since we have to look for nearest greatest
    element, that means last in first out and hence stack is reqd*/
    private static void calculateSpanUsingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); //stack will store indexes of greater elements encountered
        System.out.println("1"); //create stack and push first value and print 1 as for first value it'll always be 1
        for (int i=1;i<arr.length;i++){ //since we already went thru first element of array, hence starting with 1
            while (stack.isEmpty()==false && arr[stack.peek()]<=arr[i]) //out of the list of all greatest elements, if we encounter any which is smaller than current element, then it'd not be required anymore and hence pop
                stack.pop();
            int span=stack.isEmpty()? i+1:i-stack.peek(); //if stack is empty, that means current element is the greatest encountered till now and hence indx+1 will be the span else current index - nearest greatest index will be the span
            System.out.println(span);
            stack.push(i); //we need to push as it might be possible that this lement is grester than next one
        }
    }

    private static void calculateSpan(int[] arr, int[] span) {
        //traverse each of the elements in array
        for (int i = 0; i < arr.length; i++) {
            span[i] = 1; //it'll never be <1 coz we look for element <= current
            for (int j = i - 1; j >= 0 && arr[j] <= arr[i]; j--) { //reverse loop becaz we have to stop when we encounter nearest greatest  element
                span[i]++;
            }
        }
        System.out.println(Arrays.toString(span));
    }
}
