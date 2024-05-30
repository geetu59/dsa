package array;

import java.util.ArrayList;

/*Consider the set of irreducible fractions A = {n/d | n≤d and d and gcd(n,d) = 1}.You are given a member of this set and
your task is to find the largest fraction in this set less than the given fraction. Note: this is a set and so all the members are unique.
Example 1:
Input: n = 1, d = 8 Output: 1249 9993
Explanation: 1/8 >= 1249/9993 and this is the largest fraction.
Expected Time Complexity: O(K) where K <= 104
Expected Space Complexity: O(1) */
public class FractionTrouble {
    public static void main(String[] args) {
        System.out.println(largestFraction(19, 27));
    }

    private static ArrayList<Integer> largestFraction(int n, int d) {
        ArrayList<Integer> result = new ArrayList<>();
        //best num and den i.e. greatest fraction less than given fraction is stored here and initial value of this fraction is 0
        int bestNum = 0, bestDen = 1;
        //In a/b, b can be max till 10k, so the idea is, we are finding a/b < n/d => to remove inequality, a*d<n*b => a*d = n*b-1 => a=(n*b-1)/d
        //so since we know n,d, we know b can be between 1-10k, so calculating a and then checking if gcd=1 as we want irreducible fraction.
        //For a/b to be best fraction, a/b > bestNum/bestDen, a*bestDen > b*bestNum and if that's the case  then update bestNum and bestDen
        for (int b = 1; b <= 10000; b++) {
            int a = (n * b - 1) / d;
            System.out.println(a + "both " + b);
            if (a > 0 && gcd(a, b) == 1) {
                if ((long) a * bestDen > (long) b * bestNum) {
                    bestNum = a;
                    bestDen = b;
                }
            }
        }
        result.add(bestNum);
        result.add(bestDen);
        return result;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
