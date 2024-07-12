package recursion;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/*You are given a string, print all permutations which can be made with that string. There can be n! permutations possible.
* We iterate from first to last index. For every index i, we swap the i-th character with the first index. This is how we fix
*  characters at the current first index, then we recursively generate all permutations beginning with fixed characters
* (by parent recursive calls). After we have recursively generated all permutations with the first character fixed,
* then we move the first character back to its original position so that we can get the original string back and fix the
* next character at first position.
* Time Complexity: O(N * N!), where N is the length of the string. Note that there are N! permutations and it requires
* O(N) time to print a permutation.
  Auxiliary Space: O(N), , where N is the length of the string.*/
public class PrintPermutations {
    public static void main(String[] args) {
        permutations("ABC", 0);
    }

    private static void permutations(String s, int i) {
        if (i == s.length() - 1) {
            System.out.println(s);
            return;
        }
        for (int j = i; j < s.length(); j++) {
            s = swap(s, i, j);
            permutations(s, i + 1);
            s = swap(s, i, j);
        }
    }

    private static String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    }
}
