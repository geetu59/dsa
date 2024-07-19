package array;

/*You are given heights of consecutive buildings. You can move from the roof of a building to the roof of next adjacent
building. You need to find the maximum number of consecutive steps you can put forward such that you gain an increase in altitude with each step.
Input: A[] = {1,2,2,3,2}
Output: 1 Explanation: 1, 2 or 2, 3 are the only consecutive buildings with increasing heights thus maximum number
of consecutive steps with increase in gain in altitude would be 1 in both cases.
Input:A[] = {1,2,3,4}
Output: 3 Explanation: 1 to 2 to 3 to 4 is the jump of length 3 to have maximum number of buildings with increasing heights, so maximum steps
with increasing altitude becomes 3.
Time: O(N)
This problem is simply nothing but finding increasing sub-arrays and max elements in each of them. Return one which has max elements. Since, we've to
look for increment only at each step and hence the approach
Eg: a={1,7,9,8,7,6,7,13,21} increasing sub-arrays: {1,7,9}, {6,7,13,21}*/
public class RoofTop {
    public static void main(String[] args) {
        int A[] = {1, 7, 9, 8, 7, 6, 7, 13, 21};
        System.out.println(maxStep(A, A.length));
    }

    static int maxStep(int A[], int N) {
        //final answer is stored in ans and prev contains current value, so we check all elements which are present in that increasing order
        //sub array and keep on updating prev with it and ans also, if we find drcreasing element, we bring prev=0 and start looking for
        //increasing sub array and count max elements present in it
        int ans = 0, prev = 0;
        for (int i = 1; i < N; i++) {
            if (A[i] > A[i - 1]) {
                prev++;
                ans = Math.max(ans, prev);
            } else {
                prev = 0;
            }
        }
        return ans;
    }
}
