package recursion;

/*Given a string, you have to generate subsets. No of subsets can be 2^N.
 * Approach behind this is, if you calculate subsets of n-1 strings, which will be 2^(N-1), you'll be able to calculate subset of left char,
 * Eg: subsets of AB string, "" - "" C, A - A AC, B - B BC, AB - AB ABC, if you see subset of AB, it is 2^(N-1) and *2 is subset when adding C*/
public class PowerSet {
    public static void main(String[] args) {
        generateSubsets("ABC", "", 0);
    }

    private static void generateSubsets(String str, String curr, int i) {
        if (i == str.length()) {
            System.out.println(curr);
            return;
//            result.add(curr);
//            return result;
        }
        generateSubsets(str, curr, i + 1);
        generateSubsets(str, curr + str.charAt(i), i + 1);
//        return result; if you want to store in arrayList
    }
}
