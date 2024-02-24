package stack;

import java.util.Stack;

/*Perform all basic stack operations including getMin() in O(1)
Can't store min in a value becaz that value might be popped and we will not have track of previous min
* Sol 1: Naive sol, O(N) time and space. Push and pop are normal operations. For min, traverse thru' stack and store elements in auxiliary stack or array and find min
* Sol 2: Maintain auxiliary stack which maintains min at top. O(1) time and O(N) space
* Sol 3: Assume all elements to be positive. O(1) time and space. We will maintain min value and maintain value in stack accordingly to get next min if this min is popped
  Sol 4: Same as sol 3, just optimised one to consider negative values also*/
public class GetMinFn {
    //For sol 2
    static Stack<Integer> mainStack = new Stack<>();
    static Stack<Integer> auxStack = new Stack<>();

    //For sol 3
    static Stack<Integer> stack = new Stack<>();
    static int min;

    //For sol 4
    static Stack<Integer> stack1 = new Stack<>();


    public static void main(String[] args) {
        //Sol2: better sol
        push(5);
        push(10);
        push(20);
        System.out.println(getMin());
        push(2);
        push(6);
        push(4);
        pop();
        pop();
        push(2);
        System.out.println(getMin());
        pop();
        push(1);
        pop();
        pop();
        System.out.println(getMin());

        //Sol3: Efficient sol
        System.out.println("Efficient sol: ");
        push1(5);
        push1(10);
        System.out.println(getMin1());
        push1(20);
        push1(2);
        push1(6);
        System.out.println(getMin1());
        push1(4);
        System.out.println(pop1());
        System.out.println(pop1());
        push1(2);
        System.out.println(pop1());
        push1(1);
        System.out.println(pop1());
        System.out.println(pop1());
        System.out.println(peek1());
        System.out.println(getMin1());

        //Sol4: Efficient sol for negative nos also
        System.out.println("Efficient sol: ");
        push2(5);
        push2(10);
        System.out.println(getMin2());
        push2(20);
        push2(2);
        push2(6);
        System.out.println(getMin2());
        push2(4);
        System.out.println(pop2());
        System.out.println(pop2());
        push2(2);
        System.out.println(pop2());
        push2(1);
        System.out.println(pop2());
        System.out.println(pop2());
        System.out.println(peek2());
        System.out.println(getMin2());
    }

    private static int getMin2() {
        return stack1.isEmpty() ? -1 : min; //as min will contain current min
    }

    private static int peek2() {
        if (stack1.isEmpty()) return -1;
        Integer peek = stack1.peek();
        return peek <= min ? min : peek; //if peek value is <=0 it means it had min value which will be present in min
    }

    private static int pop2() {
        Integer pop = stack1.pop();
        if (pop <= min) { //if pop<=0, means min value is in pop, now we need to update min also, eg: peek = -3, min=2, prev min=5, min-peek=5, so min is updated
            int popped = min;
            min = 2 * min - pop;
            return popped;
        }
        return pop;
    }

    private static void push2(int x) {
        if (stack1.isEmpty()) {
            min = x;
            stack1.push(x);
        } else if (min >= x) { //if min is greater than x, that means min needs to be updated. If you update it directly
            // then you'll lose hold of prev min, which is needed becaz if this value is deleted then we need prev min.
            // but we have only stack and min var, so taking advantage of the fact that all values in stack are +, we
            // will store x-min. If we pop, then min is returned and min-pop will be our new min
            min = x;
            /*Why did we do 2x? we know x<=min and this is what we want so, 2x-min should also be less than x, x-min<=0, x-min + x<= 0+x, 2x-min<=x, proved)*/
            stack1.push(2 * x - min);
        } else
            stack1.push(x);
    }

    private static int getMin1() {
        return stack.isEmpty() ? -1 : min; //as min will contain current min
    }

    private static int peek1() {
        if (stack.isEmpty()) return -1;
        Integer peek = stack.peek();
        return peek <= 0 ? min : peek; //if peek value is <=0 it means it had min value which will be present in min
    }

    private static int pop1() {
        Integer pop = stack.pop();
        if (pop <= 0) { //if pop<=0, means min value is in pop, now we need to update min also, eg: peek = -3, min=2, prev min=5, min-peek=5, so min is updated
            int popped = min;
            min = min - pop;
            return popped;
        }
        return pop;
    }

    private static void push1(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.push(x);
        } else if (min >= x) { //if min is greater than x, that means min needs to be updated. If you update it directly
            // then you'll lose hold of prev min, which is needed becaz if this value is deleted then we need prev min.
            // but we have only stack and min var, so taking advantage of the fact that all values in stack are +, we
            // will store x-min. If we pop, then min is returned and min-pop will be our new min
            min = x;
            stack.push(x - min);
        } else
            stack.push(x);
    }

    static void push(int x) {
        mainStack.push(x);
        if (auxStack.isEmpty()) auxStack.push(x);
        //if value to be added in aux stack is smaller than peek, that means we have got a new smaller, so push it.
        //Used = as let's say same value was already present, then also we need to push as on pop the already present value can be removed
        if (auxStack.peek() >= mainStack.peek())
            auxStack.push(x);
    }

    static int pop() {
        if (mainStack.isEmpty()) return -1;
        if (auxStack.peek() == mainStack.peek())
            auxStack.pop(); //if peek of both are same, that means we are removing smallest element only
        return mainStack.pop();
    }

    static int getMin() {
        return auxStack.peek();
    }

}
