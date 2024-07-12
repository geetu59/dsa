package recursion;

/*Out of all the possible subsets, tell number of subsets which has same sum as per ask
* Time: 2^N recursive calls for leaf+ 2^N-1 recursive call for internal nodes, theta(2^N)*/
public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {10, 20, 15};
        System.out.println(subsetSumCount(arr, 3, 25));
    }

    private static int subsetSumCount(int[] arr, int n, int sum) {
        if (n == 0) return sum == 0 ? 1 : 0;
        return subsetSumCount(arr, n - 1, sum) + subsetSumCount(arr, n - 1, sum - arr[n - 1]);
    }
}
