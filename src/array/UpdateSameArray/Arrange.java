package array.UpdateSameArray;

import java.util.Arrays;

/*Given an array arr[] of size N where every element is in the range from 0 to n-1. Rearrange the given array so that the
 transformed array arrT[i] becomes arr[arr[i]].
 Eg: arr[] = {4,0,2,1,3} Output: 3 4 2 0 1
Explanation:
arr[arr[0]] = arr[4] = 3
arr[arr[1]] = arr[0] = 4
arr[arr[2]] = arr[2] = 2
arr[arr[3]] = arr[1] = 0
arr[arr[4]] = arr[3] = 1
and so on. So, arrT becomes {3, 4, 2, 0, 1}
Naive sol: O(N) time and space. Start storing elements in other array. If you make changes in current array, you will
lose track of element which was already present at that position.
Efficient sol: The array elements of the given array lies from 0 to n-1. Now an array element is needed that can store two
different values(current and new once) at the same time. To achieve this every element at ith index is incremented by
(arr[arr[i]] % n)*n.After the increment operation of first step, every element holds both old values and new values.
Old value can be obtained by arr[i]%n and a new value can be obtained by arr[i]/n.
How this can be achieved?
Let's assume an element is a and another element is b, both the elements are less than n. So if an element a is incremented
by b*n. So the element becomes a + b*n so when a + b*n is divided by n then the value is b and a + b*n % n is a.*/
public class Arrange {
    public static void main(String[] args) {
        int arr[] = {4, 0, 2, 1, 3};
        //naive
        arrange(arr);
        //efficient
        rearrange(arr);
    }

    private static void rearrange(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[arr[i]] % arr.length) * arr.length + arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] / arr.length);
        }
    }

    private static void arrange(int[] arr) {
        int temp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[arr[i]];
        }
        System.out.println(Arrays.toString(temp));
    }
}
