package stack;

import java.util.ArrayDeque;
/*O(N) time and space*/
public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("aaaabbbbccccddddaaa"));
        System.out.println(removePairOfDuplicates("aaabbaacccd"));
    }

    private static String removePairOfDuplicates(String str) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == str.charAt(i))
                stack.pop();
            else {
                stack.push(str.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            s = stack.peek() + s;
            stack.pop();
        }
        return s;
    }

    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        // s.peek() str[i] same h if yes then remove from str else push,
        ArrayDeque<Character> stack = new ArrayDeque<>();
        result.append(str.charAt(0));
        stack.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (stack.peek() != str.charAt(i)) {
                result.append(str.charAt(i));
                stack.push(str.charAt(i));
            }
        }
        return String.valueOf(result);
    }
}
