package stack;

import java.util.Stack;

import static stack.Postfix.evaluate;

/*Evaluate postfix expression. We have only operator and operands. Stack will store operands. O(String size) time and space
 * Same as that of postfix evaluation.
 * Difference:
 * 1. We will traverse from right to left in this/=
 * 2. Evaluation is pop1 x pop2 there it was pop2 x pop1
 * */
public class Prefix {
    public static void main(String[] args) {
        String exp = "+ 9 * 12 6";
        System.out.println(evaluatePrefix(exp));
    }

    private static int evaluatePrefix(String exp) {
        Stack<Integer> stack = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (c == ' ') continue;
            else if (Character.isDigit(c)) {
                //cant apply prefix evaluation logic here as we've encountered unit digit first
                int n = 0;
                int j = i;
                while (Character.isDigit(c)) {
                    i--;
                    c=exp.charAt(i);
                }
                i++;
                for (int k = i; k <= j; k++) {
                    n = n * 10 + exp.charAt(k) - '0';
                }
                stack.push(n);
            } else {
                Integer o1 = stack.pop();
                Integer o2 = stack.pop();
                stack.push(evaluate(o1, o2, c));
            }
        }
        return stack.pop();
    }
}
