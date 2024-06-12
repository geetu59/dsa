package recursion;

import java.util.ArrayList;
import java.util.HashMap;

/*Given a keypad and an N digit number which is represented by array a[ ], the task is to list all words which are possible
by pressing these numbers.
Input: N = 3, a[] = {2, 3, 4}
Output: adg adh adi aeg aeh aei afg afh afi bdg bdh bdi beg beh bei bfg bfh bfi cdg cdh cdi ceg ceh cei cfg cfh cfi
Explanation: When we press 2,3,4 then adg, adh, adi, ... cfi are the list of possible words.
Time Complexity: O(4N * N).
Auxiliary Space: O(N).*/
public class WordsFromPhoneDigit {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4};
        System.out.println(allWords(arr, 3));
    }

    private static ArrayList<String> allWords(int[] arr, int n) {
        //to store all string
        ArrayList<String> result = new ArrayList<>();
        //hashmap to identify the chars corresponding to digit
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, " ");
        hashMap.put(2, "ABC");
        hashMap.put(3, "DEF");
        hashMap.put(4, "GHI");
        hashMap.put(5, "JKL");
        hashMap.put(6, "MNO");
        hashMap.put(7, "PQRS");
        hashMap.put(8, "TUV");
        hashMap.put(9, "WXYZ");
        hashMap.put(0, " ");

        //if n=0, then empty string needs to be returned
        if (n == 0) {
            result.add("");
            return result;
        }
        //hashMap to pass the digit and chars corresponding to it, index to maintain the position of digit, output to store the final string
        //which can be put up into result list
        listOfNumbers(hashMap, arr, n, 0, "", result);
        return result;
    }

    private static void listOfNumbers(HashMap<Integer, String> hashMap, int[] arr, int n, int index,
                                      String output, ArrayList<String> result) {
        //if index reached last digit, that means now strings are generated
        if (index == n) {
            result.add(output);
            return;
        }
        //get the digit
        int digit = arr[index];
        //get length of chars at digit
        int lengthOfCharsInNumber = hashMap.get(digit).length();
        //for each character, fix it, and further call next digit and fix it..., for each char in digit, we are fixing and moving ahead
        for (int i = 0; i < lengthOfCharsInNumber; i++) {
            listOfNumbers(hashMap, arr, n, index + 1, output + hashMap.get(digit).charAt(i), result);
        }
    }
}
