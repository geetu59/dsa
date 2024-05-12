package array;

/*Equilibrium Point: if sum of elements on left and right of ith element are same, then we say, we've equilibrium point.
 * Eg: {4,2,-2} sum on left of 4 is 0 and right of 4 is also 0
 * Naive sol: consider ith element as equilibrium point, find sum on left of ith element and right of it also, if they are same,
 * then return true, O(N*N) time and O(1) space
 * Efficient sol: store prefix and suffix sum in an array, then traverse thru given array and check if prefix[i-1]=suffix[i+!] becaz they'll store
 * sum till now. O(N) -> 3 times time and O(N) -> 2 N sized array space
 * Efficient: theta(N) time(2 traversals) and O(1) space
 */
public class EquilibriumPoint {
    public static void main(String[] args) {
        int arr[] = {3, 4, 8, -9, 20, 6};
        //int arr1[] = {3, 4, 8, -9, 9, 7};
        //Naive
        System.out.println(eqPoint(arr));
        //Efficient 1
        System.out.println(equilibriumPoint(arr));
        //Efficient 2
        System.out.println(equiPoint(arr));
    }

    private static boolean equiPoint(int[] arr) {
        int totalSum = 0;
        //find totalSum of elements of all array
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        //for ith elements, rightSum=whatever we have -arr[i] becaz it is initialised with totalSUm right now
        //leftSum=what we have + arr[i]but that will happen later becaz we want left sum till i-1 only which is already present there
        int prefixSum = 0, suffixSum = totalSum;
        for (int i = 0; i < arr.length; i++) {
            suffixSum -= arr[i];
            if (prefixSum == suffixSum) return true;
            prefixSum += arr[i];
        }
        return false;
    }

    private static boolean equilibriumPoint(int[] arr) {
        //find prefix sum
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        //find suffix sum
        int[] suffixSum = new int[arr.length];
        suffixSum[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i > 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr[i];
        }

        //traverse and check if they match, we cannot consider corner elements as we check at i-1 and i+1,
        // so there, value will not be supported
        for (int i = 1; i < arr.length - 1; i++) {
            if (prefixSum[i - 1] == suffixSum[i + 1]) return true;
        }

        //for corner elements, for first element, left=0, right=total sum, which we will get at prefixSum[arr.length-1]
        //for last element, right=0, left=total sum, which we will get at suffixSum[0]
        if (prefixSum[arr.length - 1] == suffixSum[0]) return true;
        return false;
    }

    private static boolean eqPoint(int[] arr) {
        //consider ith element as equilibrium point, O(N) time as might be possible that we don't need to traverse for all i
        //and we find ith element quite quickly. theta(N) for internal loops as they'll always traverse till end
        for (int i = 0; i < arr.length; i++) {
            int sumLeft = 0, sumRight = 0;
            //find sum on left of ith element
            for (int j = 0; j < i; j++) {
                sumLeft += arr[j];
            }
            //find sum on right of ith element
            for (int k = i + 1; k < arr.length; k++) {
                sumRight += arr[k];
            }
            //if they match then we have equilibrium point
            if (sumLeft == sumRight) return true;
        }
        return false;
    }
}
