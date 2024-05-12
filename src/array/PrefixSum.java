package array;

/*Given queries which has arr, left, right. Find sum from left to right
 * Eg: {1,2,3,4,5} prefixSum(a,1,3), a[1]+a[2]+a[3]
 * Naive sol: theta(l-r+1) or O(N) time and O(1) space. Traverse from l to r and store sum
 * Efficient sol: theta(N) time and theta(N) space. We will pre-process the array and computer prefix sum.
 *
 * Problem 2: Calculate weighted sum. Eg: a:{2,3,5,4,6,1} getWSum(2,3) -> 1*a[2] + 2*a[3] getWSum(0,3) -> 1*a[0] + 2*a[1] + 3*a[2]+ 4*a[3]
 * Basically, sum from left to right, ith value (where i starting from l) as (i-l+1)*a[i], segregating this, if I find sum(l->r)(i*a[i]) - (l-1)*sum(l->r)a[i])*/
public class PrefixSum {
    public static void main(String[] args) {
        int arr[] = {2, 8, 3, 9, 6, 5, 4};
        //Naive sol
        System.out.println(prefixSum(arr, 1, 4));
        //Efficient sol
        System.out.println(getSum(arr, 1, 4));
        //PS:2 weighted sum
        System.out.println(getWSum(arr, 1, 4));
    }

    /*sum(l->r)(i*a[i]) - (l-1)*sum(l->r)a[i]) It has 2 parts sum(l->r)(i*a[i]) and (l-1)*sum(l->r)a[i])*/
    private static int getWSum(int[] arr, int left, int right) {
        //Evaluation sum(l->r)(i*a[i])
        int[] preWSum = new int[arr.length];
        fillPrefix(arr, preWSum);

        //Evaluation for (l-1)*sum(l->r)a[i])
        int[] preArray = new int[arr.length];
        fillPrefixSum(arr, preArray);


        return preWSum[right] - (left - 1) * preArray[right];
    }

    private static void fillPrefix(int[] arr, int[] preWSum) {
        preWSum[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            preWSum[i] = preWSum[i - 1] + i * arr[i];
        }
    }

    private static int getSum(int[] arr, int left, int right) {
        //for each  ith element, we will pre-compute sums till arr[i] and store it in preArray
        int[] preArray = new int[arr.length];
        //we are not considering this prefixSum as part of time complexity, we've O(1) time
        fillPrefixSum(arr, preArray);
        //if left is 0, then sum at right is the answer else sum at right - sum till left -1 will be answer
        if (left == 0) return preArray[right];
        else return preArray[right] - preArray[left - 1];
    }

    private static void fillPrefixSum(int[] arr, int[] preArray) {
        preArray[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preArray[i] = preArray[i - 1] + arr[i];
        }
    }

    private static int prefixSum(int[] arr, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
