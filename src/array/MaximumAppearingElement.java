package array;

/* Given 2 arrays left and right, find the element which occurs max in the range,
Eg: left: {1,2,5,15} right: {5,8,7,18}, ranges are: 1-5, 2-8, 5-7, 15-18, element occurring most in the ranges is 5.
Elements will be from 0 to 100 and no of elements can go till 10^6
Naive sol: Time: O(N*max) Space:O(max)
Efficient sol: Time: O(N+max) Space:O(max) We will be going to use prefix sum array technique. Watch Max Appearing ELement in Arrays GFG video
for better understanding*/
public class MaximumAppearingElement {
    public static void main(String[] args) {
        int[] left = {1, 4, 3, 1};
        int[] right = {15, 8, 5, 4};
        //Naive sol. This sol will not work if value of element is greater as we are creating freq array of that size
        System.out.println(maxAppear(left, right, 4));
        //Efficient sol
        System.out.println(maxAppearingElement(left, right, 4));
    }

    private static int maxAppearingElement(int[] left, int[] right, int n) {
        //create a freq array of size: max number which an element can hold +2 becaz further you are doing freq[right[i] + 1], so if max is 100
        //and right[i]=100 and you want to put value at 101th position in freq, then your freq arr should be of size 102.
        int freq[] = new int[102];
        //idea behind this is that we will mark 1 at a place where range begins, so value of freq at left[i]th position is 1 and
        //we will mark -1 at a place next to right[i]th position to show that range ended before this.
        for (int i = 0; i < n; i++) {
            freq[left[i]]++;
            freq[right[i] + 1]--;
        }
        //we will calculate prefix sum becaz now, we know ranges and when we do prefix sum, we are actually telling occurrence of the element in range
        //then we repeat the same logic as that of naive sol to find max value in freq array, we are just doing it in same loop
        int res = 0;
        for (int i = 1; i < 15; i++) {
            freq[i] += freq[i - 1];
            if (freq[res] < freq[i]) res = i;
        }
        return res;
    }

    private static int maxAppear(int[] left, int[] right, int n) {
        //We will create freq array of size 100 i.e. max value till which element can go and we will traverse thru whole array
        //and for each ith element, we will traverse from left to right range and accordingly update freq array
        //Time: O(N*max(becaz value at left[i]=1 and right[i]=100, so it will run max times))
        int freq[] = new int[100];
        for (int i = 0; i < n; i++) {
            for (int j = left[i]; j <= right[i]; j++) {
                freq[j]++;
            }
        }
        //check the max value in freq array and return index of it as res. Time: O(max)
        int res = 0;
        for (int i = 0; i < 100; i++) {
            if (freq[res] < freq[i]) res = i;
        }
        return res;
    }
}
