package stack;

import java.util.Stack;

import static stack.InfixToPostfix.precedence;

/*Convert infix expression to prefix.
 *  Time and space: O(N)
 *  We are traversing thru' array once, so theta(N). For each operand, we print it -> o(1) work. For every operator, we do push->O(1) and pop->O(1),
 *  when we reverse string, it is also theta(N), so overall complexity is theta(N)
 *  Approach is exactly same as that of infix to postfix, changes are: we traverse from right to left and reverse the resultant string
 * */
public class InfixToPrefix {
    public static void main(String[] args) {
        String exp = "x+y*z/w+u";
        System.out.println(infixToPrefix(exp));
    }

    private static String infixToPrefix(String exp) {
        StringBuilder result = new StringBuilder(); //used string builder as String doesnt have reverse method
        Stack<Character> stack = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c))
                result.append(c);
            else if (c == ')')
                stack.push(c);
            else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) > precedence(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty())
            result.append(stack.pop());
        return String.valueOf(result.reverse());
    }
}
