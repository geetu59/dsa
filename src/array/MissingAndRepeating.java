package array;

import java.util.Arrays;

/*Given an unsorted array of size n. Array elements are in the range from 1 to n. One number from set {1, 2, …n} is missing
and one number occurs twice in the array. Our task is to find these two numbers.
Sol 1: Use sorting. Time: O(nlogn) Space: O(1)
Sol 2: Find sum and product Time: O(n) Space: O(1)
Sol 3: Hashing Time: O(n) Space: O(n) */
public class MissingAndRepeating {
    public static void main(String[] args) {
        int arr[] = {2, 3, 2, 1, 5};
        //Sol 1 Sorting
        //findMissingAndRepeatingUsingSorting(arr);
        //Sol 2 Find sum and product
        //findMissingAndRepeating(arr);
        //Sol 3 Hashing
        //findMissingAndRepeatingUsingHashing(arr);
        //Sol 4 Negative Indexing
        findMissingAndRepeatingUsingNegativeIndexing(arr);
    }

    private static void findMissingAndRepeatingUsingNegativeIndexing(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[Math.abs(arr[i]) - 1];
            if (temp < 0) {
                System.out.println("Repeating element: " + Math.abs(arr[i]));
            } else
            arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                System.out.println("Missing element: " + (i + 1));
            }
        }
    }

    private static void findMissingAndRepeatingUsingHashing(int[] arr) {
        Integer[] count = new Integer[arr.length + 1];
        Arrays.fill(count, 0);
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) System.out.println("Missing element " + i);
            if (count[i] == 2) System.out.println("Repeating element " + i);
        }
    }

    /* currSum = sum of nos in array
    sumN = sum of first n nos
    x = repeating no
    y = missing no
    currSum2 = sum of sq of nos in array
    sumN2 = sum of sq of first n nos
    currSum = sumN -x +y => y-x=currSum-sumN, let's name it diff
    currSum2 = sumN2 -x2 +y2 => y2-x2=currSum2-sumN2, let's name it sumDiff
    Now, if you divide above 2 equations, y2-x2/y-x = x+y = sumDiff/diff
    Now, y-x you already have, add above two/2 and get y and then get x*/
    private static void findMissingAndRepeating(int[] arr) {
        int n = arr.length;
        int currSum = 0, currSum2 = 0;
        int sumN = n * (n + 1) / 2, sumN2 = n * (n + 1) * (2 * n + 1) / 6;
        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            currSum2 += arr[i] * arr[i];
        }
        int diff = currSum - sumN; //y-x
        int sumDiff = currSum2 - sumN2; //y2-x2
        int sumOfXandY = sumDiff / diff; //x+y
        int y = (diff + sumOfXandY) / 2;
        int x = sumOfXandY - y;
        System.out.println("Missing element: " + x);
        System.out.println("Repeating element: " + y);
    }

    private static void findMissingAndRepeatingUsingSorting(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1])
                System.out.println("Repeating element " + i);
            else if (arr[i] == i) {
                System.out.println("Missing element " + (i + 1));
                return;
            }
        }
    }
}
