package stack;

/*You have 1 array, implement 2 stacks in that
 * This comes into picture as let's say we have contiguous memory for array and we have to utilise that much space to make 2 stacks
 * Naive sol: divide array into 2 halves, considering first half as stack 1 and other as stack 2. Problem is we've fixed sixe of 2 arrays
 * Maybe I want to put all elements in stack 1 and no element in stack 2, that would not be possible.
 * Efficient sol: stack 1 will start from beginning of array and stack 2 from end of array*/
public class TwoStacksInArray {
    Integer[] arr;
    int capacity;
    int top1;
    int top2;

    public TwoStacksInArray(int capacity) {
        this.capacity = capacity;
        arr = new Integer[capacity];
        this.top1 = -1;
        this.top2 = -1;
    }

    public static void main(String[] args) {
        TwoStacksInArray array = new TwoStacksInArray(10);
        //For even sized capacity
        array.push1(1);
        System.out.println(array.peek1());
    }

    boolean push1(int x) {
        if (top1 == capacity / 2 - 1)
            return false;
        else {
            top1++;
            arr[top1] = x;
        }
        return true;
    }

    int pop1() {
        if (top1 != -1) {
            arr[top1]--;
            top1--;
        } else return -1;
        return 0;
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
        if (top2 == capacity - 1)
            return false;
        else {
            top2++;
            arr[top2] = x;
        }
        return true;
    }

    int pop2() {
        if (top2 != capacity / 2 - 1) {
            arr[top2]--;
            top2--;
        } else return -1;
        return 0;
    }

    int peek2() {
        return top2 == capacity / 2 - 1 ? -1 : arr[top2];
    }

    int size2() {
        return top2 - top1;
    }

    boolean isEmpty2() {
        return top2 == capacity / 2 - 1;
    }
}
