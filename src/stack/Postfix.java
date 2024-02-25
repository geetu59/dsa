package stack;

import java.util.Stack;

/*Evaluate postfix expression. We have only operator and operands. Stack will store operands. O(String size) time and space*/
public class Postfix {
    public static void main(String[] args) {
        String exp = "100 200 + 2 / 5 * 7 +";
        System.out.println(evaluatePostfix(exp));
    }

    private static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();
        /*1. for loop, if ' ' continue*/
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == ' ') continue;
            //since digit can be 13 also, can be more than 9, so to consider it as a number, we applied below logic
            //if digit was a single digit, we will push it else make it as 2 digit before pushing to stack
            if (Character.isDigit(c)) {
                //if all digits are single and there's no space then we dont need below logic, simply stack.push(c-'0');
                int n = 0;
                while (Character.isDigit(c)) {
                    n = n * 10 + c - '0';
                    i++;
                    c = exp.charAt(i);
                }
                i--;
                stack.push(n);
            } else { //if it is operator, pop top 2 elements, apply operator and push result back
                int o1 = stack.pop();
                int o2 = stack.pop();
                stack.push(evaluate(o1, o2, c));
            }
        }
        return stack.pop();
    }

    private static int evaluate(int o1, int o2, char c) {
        switch (c) {
            case '*':
                return o2 * o1;
            case '/':
                return o2 / o1;
            case '+':
                return o2 + o1;
            case '-':
                return o2 - o1;
        }
        return 0;
    }
}
