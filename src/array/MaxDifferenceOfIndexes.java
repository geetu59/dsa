package array;

import static java.lang.Math.max;

/*find the maximum of j - i subjected to the constraint of a[i] < a[j] and i < j. Eg: {26, 1, 8, 2, 24, 5, 29, 1, 27}, 1 and 27, subtract indexes of both
 * Naive: Run 2 loops and when a[i]<a[j] find max=max(j-i, max) O(N*N) complexity
 * Efficient: store min element from left in left array and store max element from right in right array. Then traverse them to get result. O(N) time and space*/
public class MaxDifferenceOfIndexes {
    public static void main(String[] args) {
        int a[] = {26, 1, 8, 2, 24, 5, 29, 1, 27};
        System.out.println(maxIndexDifference(a, 9));
        System.out.println(maxIndexDiff(a, 9));
    }

    private static int maxIndexDifference(int[] a, int n) {
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] < a[j])
                    max = max(j - i, max);
            }
        }
        return max;
    }

    static int maxIndexDiff(int a[], int n) {
        int[] left = new int[n]; //stores min from left
        left[0] = 0;
        int[] right = new int[n]; //stores max from right
        right[n - 1] = n - 1;
        //fill in left arr
        for (int i = 1; i < n; i++) {
            if (a[i] < a[left[i - 1]]) {
                left[i] = i;
            } else {
                left[i] = left[i - 1];
            }
        }
        //fill in right arr
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > a[right[i + 1]]) {
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }

        int i = 0, j = 0, max = -1;
        while (i < n && j < n) {
            if (a[left[i]] <= a[right[j]]) {
                max = Integer.max(max, right[j] - left[i]);
                j++;
            } else i++;
        }
        return max;
    }
}
