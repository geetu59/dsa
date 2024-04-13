package array;

import static array.LargestElement.largestEfficient;

/*Find second Largest element.
 * Naive sol: O(N) only but 2 traversals. First get largest and then check largest out of all expect that largest element.
 * Efficient sol: O(N) single traversal. Find both simultaneously in one traversal.*/
public class SecondLargestElement {
    public static void main(String[] args) {
//        int arr[]={10,10,10};
        int[] arr = {20, 10, 20, 8, 12};
        System.out.println(secondLargestNaive(arr));
        System.out.println(secondLargest(arr));
    }

    private static int secondLargest(int[] arr) {
        int largest = 0, result = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[largest]) {
                result = largest;
                largest = i;
            }
            //as we've to ignore arr[i]==arr[largest] case eg: {5,8,12,12}
            else if (arr[i] != arr[largest]) {
                if (result == -1 || arr[i] > arr[result])
                    result = i; //if result is getting populated for the first time eg: {12,12,12,7}
            }
        }
        return result;
    }

    private static int secondLargestNaive(int[] arr) {
        int largest = largestEfficient(arr);
        int result = -1;// kept -1 as it is possible that there is no second largest eg: {10,10,10}
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[largest]) {
                if (result == -1) result = i;
                else if (arr[i] > arr[result]) result = i;
            }
        }
        return result;
    }
}
