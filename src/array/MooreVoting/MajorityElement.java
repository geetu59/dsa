package array.MooreVoting;

/*Majority element is the one which occurs more than n/2 times in an array.
 * Eg: {8,8,6,6,6,4,6}, 7/2=3, should occur more than 3 times, so output is index of any occurrence of that element(6), eg: 2/3/4/6
 * Naive sol: O(N*N) time and O(1) space
 * Efficient sol: Moore's Voting Algo: O(N) time and O(1) space
 * This PS has 2 parts, one is to find the element which can be majority element i.e. max occurring element, other to check if it's
 * majority element or not i.e. if it occurs more than n/2 times.
 * Second part is clear, if you have res which contains any index of majority element, you can traverse thru' arr and calculate count
 * and check if it is more than n/2
 * First part is to find majority element. Watch video Majority Element under Arrays for clarity*/
public class MajorityElement {
    public static void main(String[] args) {
        int arr[] = {8, 8, 6, 6, 6, 4, 6};
        //Naive sol
        System.out.println(majorElement(arr));
        //Efficient sol Moore's Voting Algo
        System.out.println(majorityElement(arr));
    }

    private static int majorityElement(int[] arr) {
        //Find the candidate for majority element
        //res contains index of majority element and we will initialise it with 0 and count contains occurrences
        int res = 0, count = 1;
        //if one element increments the count, other decrements and nullify, until you encounter an element which keeps on incrementing
        //eg: 6 8 7 6 6, when 6, count=1, 8 count=0 res=1 count=1, 7 count=0 res=2 count=1, 6 count=0 res=3 count=1, 6 count=2
        for (int i = 1; i < arr.length; i++) {
            if (arr[res] == arr[i]) count++;
            else count--;
            if (count == 0) {
                res = i;
                count = 1;
            }
        }

        //Check if candidate found in first part is majority or not
        int count1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[res] == arr[i]) count1++;
        }
        if (count1 > arr.length / 2) return res;
        return -1;
    }

    private static int majorElement(int[] arr) {
        //consider each ith element to be the majority element and traverse to check the count of ith element to see if
        // it falls under majority element or not
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) count++;
            }
            if (count > arr.length / 2) return i;
        }
        return -1;
    }
}
