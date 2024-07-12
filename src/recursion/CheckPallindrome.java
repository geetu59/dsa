package recursion;

/*Check if a string is pallindrome or not.
 * Idea is that first and last char should be same, so we will verify first and last char and call fn again for remaining chars
 * Base case: Either there's one char left or no char left, if that's the case then return true. Eg: abba, no char left. abcba,
 * one will be left and hence return true. Time: O(n) Space: n/2 recursive call, theta(n) space*/
public class CheckPallindrome {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(isPallindrome(s, 0, s.length() - 1));
    }

    private static boolean isPallindrome(String s, int start, int end) {
        if (start >= end) return true;
        //we need to check first and last char first then make recursive call becaz if they mismatch then we dont need to make
        //recursive call, this is called short circuiting
        return s.charAt(start) == s.charAt(end) && isPallindrome(s, start + 1, end - 1);
    }
}
