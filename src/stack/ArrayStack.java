package stack;

//fixed size array implementation of stack O(1) time, Memory is saved as pointers are not involved.
//2 problems, 1. Doesn't handle underflow:when top=-1 and you are trying to pop and overflow: when stack is full Although this is handled in this implementation
// 2. No dynamic resizing -> Use arrayList for this
public class ArrayStack {
    int capacity;
    int top;
    Integer arr[];

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        arr = new Integer[capacity];
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
    }

    public void push(int x) {
        if (top < capacity - 1) {
            this.top++;
            arr[top] = x;
        }
    }

    public int peek() {
        if (top > 0)
            return arr[this.top];
        return -1;
    }

    public int pop() {
        if (this.top < 0) return -1;
        else {
            int x = arr[top];
            top--;
            return x;
        }
    }

    public int size() {
        return this.top + 1;
    }

    public boolean isEmpty() {
        return this.top==-1;
    }
}
