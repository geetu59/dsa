package stack;

//Efficient sol O(1) time and space
public class TwoStacksArray {
    Integer[] arr;
    int capacity;
    int top1;
    int top2;

    public TwoStacksArray(int capacity) {
        this.capacity = capacity;
        arr = new Integer[capacity];
        this.top1 = -1;
        this.top2 = capacity;
    }

    public static void main(String[] args) {
        TwoStacksArray stack = new TwoStacksArray(10);
        stack.push1(1);
        stack.push1(2);
        stack.push2(3);
        stack.push2(4);
        stack.pop1();
        stack.pop2();
        System.out.println(stack.peek1());
        System.out.println(stack.peek2());
        System.out.println(stack.isEmpty1());
        System.out.println(stack.isEmpty2());
        System.out.println(stack.size1());
        System.out.println(stack.size2());
    }

    boolean push1(int x) {
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
            return true;
        }
        return false;
    }

    int pop1() {
        int x;
        if (top1 != -1) {
            x = arr[top1];
            top1--;
            return x;
        }
        return -1;
    }

    int peek1() {
        return top1 == -1 ? -1 : arr[top1];
    }

    int size1() {
        return top1 + 1;
    }

    boolean isEmpty1() {
        return top1 == -1;
    }

    boolean push2(int x) {
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
            return true;
        }
        return false;
    }

    int pop2() {
        int x;
        if (top2 != capacity) {
            x = arr[top2];
            top2++;
        } else return -1;
        return x;
    }

    int peek2() {
        return top2 == capacity ? -1 : arr[top2];
    }

    int size2() {
        return capacity - top2;
    }

    boolean isEmpty2() {
        return top2 == capacity;
    }
}
