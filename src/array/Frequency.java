package array;

import java.util.HashMap;

/*Print frequency of elements in sorted array.
 * Naive sol: O(N) time and space using hashmap
 * Efficient sol: O(N) time and space O(1)*/
public class Frequency {
    public static void main(String[] args) {
        int arr[] = {10, 30, 30, 30, 30, 30};
        //Naive sol
        printFreq(arr);
        //Efficient sol
        printFrequency(arr);
    }

    private static void printFreq(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                hashMap.put(arr[i - 1], count);
                count = 1;
            }
        }
        hashMap.put(arr[arr.length - 1], count);
        System.out.println(hashMap);
    }

    private static void printFrequency(int[] arr) {
        int freq = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) freq++;
            else {
                System.out.println(arr[i - 1] + " " + freq);
                freq = 1;
            }
        }
        System.out.println(arr[arr.length - 1] + " " + freq);
    }
}
