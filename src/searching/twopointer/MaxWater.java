package searching.twopointer;
/*Given an integer array representing the heights of N buildings, the task is to delete N-2 buildings such that the water
that can be trapped between the remaining two building is maximum. Note: The total water trapped between two buildings
is gap between them (number of buildings removed) multiplied by height of the smaller building.
Input: N = 6 height[] = {2,1,3,4,6,5} Output: 8
Explanation: The heights are 2 1 3 4 6 5. So we choose the following buildings 2,5  and remove others. Now gap between
two buildings is equal to 4, and the height of smaller one is 2. So answer is 2 * gap = 2*4 = 8. There is no answer greater than this.
Time: O(N)
Two Pointer Approach
Formula would be, height*width, width will be j-i-1, the difference between the two buildings and height will be min height out of those 2 buildings
becaz the one with min height will be able to hold that much water, so height will be decided by the one which is shorter.
Now, whosoever has min height, we need to go next building to it, becaz if height is more then height to hold water will be high, eg: 3,5, then 3 is
max height till which water can be hold. 4,5 then 4 will be max height
Watch GFG hint video for better understanding*/
public class MaxWater {
    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 4, 6, 5};
        System.out.println(maxWater(arr));
    }

    private static int maxWater(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            //if height[i] is small then go to next building to its right
            if (height[i] < height[j]) {
                max = Math.max(max, (j - i - 1) * height[i]);
                i++;
            } else if (height[j] < height[i]) { //if height[j] is small then go to next building to its left
                max = Math.max(max, (j - i - 1) * height[j]);
                j--;
            } else {
                max = Math.max(max, (j - i - 1) * height[i]);
                i++;
                j--;
            }
        }
        return max;
    }
}
