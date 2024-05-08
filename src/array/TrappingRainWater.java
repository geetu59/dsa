package array;

import static java.lang.Math.max;
import static java.lang.Math.min;

/* Trapping rain water
 * Given an array of N non-negative integers arr[] representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * Naive sol: consider arr[i] and check left and right max of it. theta(N*N) time and O(1) space
 * Efficient sol: Precompute lMax and rMax rather than computing it for every index. theta(N) time and theta(2N) space*/
public class TrappingRainWater {
    public static void main(String[] args) {
        int arr[] = {3, 0, 1, 2, 5};
        //int arr[] = {0, 1, 2, 3, 4};
        //int arr[] = {5, 4, 3, 2, 1};
        //int arr[] = {3, 0, 7, 2, 5};
        //Naive sol
        System.out.println(getWater(arr));
        //Efficient sol
        System.out.println(getRainWater(arr));
    }

    private static int getRainWater(int[] arr) {
        int res = 0;
        int n = arr.length;
        //compute lMax
        int[] lMax = new int[n];
        lMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            lMax[i] = max(arr[i], lMax[i - 1]);
        }
        //compute rMax
        int[] rMax = new int[n];
        rMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = max(arr[i], rMax[i + 1]);
        }
        //we just moved inner for loops of naive sol outside
        for (int i = 1; i < n - 1; i++) {
            res = res + (min(lMax[i], rMax[i]) - arr[i]);
        }
        return res;
    }

    private static int getWater(int[] arr) {
        int res = 0;
        //this loop actually tells the water which can come on top of ith bar. Since water cannot come on top of first or last bar as
        //there is nothing to support it, hence considering only middle bars. theta(N) time
        for (int i = 1; i < arr.length - 1; i++) {
            //Both internal for loops complexity is theta(N), hence theta(N*N) time.
            int lMax = arr[i];
            //checking the max height to support water on left of ith bar
            for (int j = 0; j < i; j++) {
                lMax = max(lMax, arr[j]);
            }
            int rMax = arr[i];
            //checking the max height to support water on right of ith bar
            for (int k = 0; k < arr.length; k++) {
                rMax = max(rMax, arr[k]);
            }
            //since min of left and right bar would be the amount of water which can be hold and need to subtract arr[i] so that
            //that much bar goes away
            res = res + (min(lMax, rMax) - arr[i]);
        }
        return res;
    }
}
