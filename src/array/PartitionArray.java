package array;

/*Partition array into 3 parts, such that sum of elements of each part is equal.
 * Eg: a:{1,3,6,2,7,1,2,8} -> [1, 3, 6], [2, 7, 1], [2, 8], return true else return false
 * Sol1: O(N*N*N) time
 * Sol2: O(N*N) time
 * Sol3: O(N) time and O(1) space
 * Sol4: O(N) time and space*/
public class PartitionArray {
    private static int pos1=-1;
    private static int pos2=-1;
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 2, 7, 1, 2, 8};
        //O(N*N*N) time
        System.out.println(equiSum1(arr));
        System.out.println(equiSum2(arr));
        System.out.println(equiSum3(arr));
        System.out.println(equiSum4(arr));
    }

    private static boolean equiSum4(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        int totalSum = arr[0];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            totalSum += arr[i];
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int[] suffixSum = new int[n];
        suffixSum[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr[i];
        }

        int i = 0, j = n - 1;
        while (i < j - 1) {
            if (prefixSum[i] == totalSum / 3) pos1 = i;
            if (suffixSum[j] == totalSum / 3) pos2 = j;
            if (pos1 != -1 && pos2 != -1) {
                if (prefixSum[pos2 - 1] - prefixSum[pos1] == totalSum / 3) return true;
                else return false;
            }
            if (prefixSum[i] < suffixSum[j]) i++;
            else j--;
        }
        return false;
    }

    private static boolean equiSum3(int[] arr) {
        int sum = 0, count = 0;
        int n = arr.length;
        if (n < 3) return false;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        if (totalSum % 3 != 0) return false;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == totalSum / 3) {
                count++;
                sum = 0;
            }
        }
        return count == 3;
    }

    private static boolean equiSum1(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        if (totalSum % 3 != 0) return false;
        int i = 0, sum1 = 0;
        while (i < n - 2) {
            sum1 += arr[i];
            int sum2 = 0;
            int j = i + 1;
            while (j < n - 1) {
                sum2 += arr[j];
                int sum3 = 0;
                int k = j + 1;
                while (k < n) {
                    sum3 += arr[k];
                    if (sum1 == sum2 && sum2 == sum3) return true;
                    k++;
                }
                j++;
            }
            i++;
        }
        return false;
    }

    private static boolean equiSum2(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        if (totalSum % 3 != 0) return false;
        int partSum = totalSum / 3;
        int i = 0, j = n - 1;
        int sum1 = arr[i], sum3 = arr[j];
        while (i + 1 < j) {
            if (sum1 == partSum && sum3 == partSum) return true;
            if (sum1 != partSum) {
                i++;
                sum1 += arr[i];
            }
            if (sum3 != partSum) {
                j--;
                sum3 += arr[j];
            }
        }
        return false;
    }
}
