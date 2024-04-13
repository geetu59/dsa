package array;

/*Largest element in array:
 * Naive sol: Traverse twice. Best case: theta(n) where largest element is at first position. Worst case is theta(n*n), O(N*N)-> Time complexity
 * Efficient sol: O(n)*/
public class LargestElement {
    public static void main(String[] args) {
        int arr[] = {5, 8, 20, 10};
        System.out.println(largestNaive(arr));
        System.out.println(largestEfficient(arr));
    }

    public static int largestEfficient(int[] arr) {
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[result]) result = i;
        }
        return result;
    }

    private static int largestNaive(int[] arr) {
        //consider arr[i] to be max and compare with all, if it becomes min, break the loop
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return -1; //this will never reach becaz there must be 1 element which is greatest
    }
}
