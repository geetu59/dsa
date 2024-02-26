package stack;

import java.util.Stack;

/*Infix expression: When an operator is in-between every pair of operands. Eg: A + B * C + D
Postfix expression: When an operator is followed by every pair of operands. Eg: ABC*+D+
Why do we need postfix?
The compiler first scans the expression to evaluate the expression b * c, then again scans the expression to add a to it.
The result is then added to d after another scan. The repeated scanning makes it very inefficient and Infix expressions are easily
readable and solvable by humans whereas the computer cannot differentiate the operators and parenthesis easily so, it is better to
convert the expression to postfix(or prefix) form before evaluation.
The corresponding expression in postfix form is abc*+d+. The postfix expressions can be evaluated easily using a stack.
Time and space: O(N)
We are traversing thru' array once, so theta(N). For each operand, we print it -> o(1) work. For every operator, we do push->O(1) and pop->O(1), so overall complexity iis O(N)
Steps: Traverse from left to right. For each char, check if it's
1. operand: output it
2. (: push it
3. ): pop elements until you encounter (
4. operator:
a. if stack is empty then push it
b. Higher precedence than stack top, push it
c. Lower precedence: Pop until higher precedence is found
d. same precedence, use associativity
5. Pop all elements from stack
Stack will always have higher precedence element on top and will always contain operators
*/
public class InfixToPostfix {
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }

    private static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        String result = new String();
        //traverse thru' each char
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            //if char is operand, just output it
            if (Character.isLetterOrDigit(c))
                result += c;
                //if char is '(', push it in stack
            else if (c == '(') {
                stack.push(c);
            }
            //for ')', pop and print until you encounter '('
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            }
            //for operator
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    //if precedence is same then associativity from l->r, which will do the same
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') return "Invalid expression";
            result += stack.pop();
        }
        return result;
    }

    public static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1; //if '(' is encountered, it'll have lowest precedence
    }
}
