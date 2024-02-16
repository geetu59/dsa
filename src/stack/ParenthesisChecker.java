package stack;

import java.util.ArrayDeque;
/*O(N) time and space*/
public class ParenthesisChecker {
    public static void main(String[] args) {
        String s = "[[}]";
        System.out.println(parenChecker(s));
    }

    private static boolean parenChecker(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty()) return false; //"{}} or "]" to handle this case as peek will give null ptr
                else if (matching(stack.peek(), c))
                    stack.pop();
                else return false; //"{[}}" return false at the moment, no need to check further
            }
        }
        return stack.isEmpty(); // "{{" to handle this case, so cant directly return true
    }

    static boolean matching(char x1, char x2) {
        return (x1 == '(' && x2 == ')') || (x1 == '{' && x2 == '}') || (x1 == '[' && x2 == ']');
    }
}
