package deque;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*Find maximum of sub-arrays of size k.
 * Naive sol: Using array, time: O(N*k) space: O(1)
 * Efficient sol: Using deque, time: O(N) space: O(k) Since we need to remove from first and last and add at last,
 * these 3 operations can be done using deque. Although time complexity seems higher as we have 2 loops but on observing carefully,
 * on every item, we do 1 insertion and 1 del in deque, and complexity of both is O(1) i.e. we are doing @N operations in total, which
 * makes it O(N)*/
public class MaxOfSubArrays {
    public static void main(String[] args) {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        //Naive sol
        printMax(arr, k);
        //Optimal sol
        maxSubArray(arr, k);
    }

    private static void maxSubArray(int[] arr, int k) {
        //deque will be of size k and it'll store the max of current window at front.
        Deque<Integer> deque = new LinkedList<>();
        //if arr[i]>deque.last, then remove elements from deque and add arr[i] becaz we dont need elements smaller than
        // arr[i] as it'll not be useful, we want to find max. If arr[i]<deque.back then simply add becaz that element 
        // might turn out to be greater than upcoming arr[i]s. Eg: deq: 4, arr[i]=3, arr={3,2,1} then adding 3 to deq, 
        // will be useful for upcoming window.
        //we will first process k elements, i.e. the first window, first subarray of size k
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i); //we prefer storing indexes in deque becaz if front of deque is max but it is not in our current window, we can remove it easily
        }
        //handling n-k elements becaz now, one element will be added each time and we will keep printing front of deque
        for (int i = k; i < arr.length; i++) {
            System.out.println(arr[deque.peekFirst()]);
            //the elements which are not in current window is removed from deque
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            //same logic as above
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
    }

    private static void printMax(int[] arr, int k) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < arr.length - k + 1; i++) {
            int max = arr[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Integer.max(max, arr[j]);
            }
            array.add(max);
        }
        System.out.println(array);
    }
}
