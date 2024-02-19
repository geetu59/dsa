package stack;

/*Implement k stacks in 1 array. O(1) time and space.
Naive sol: Divide array into k spaces and consider each of them as stack. Inefficiency of space and what if data is Student or bugger rather than int then it'd be problem
Efficient sol: use two extra arrays*/
public class KStacksInArray {
    //Efficient sol
    Integer[] arr; //actual array
    int capacity; //size of arr
    int free; //index of next free space available
    int k; //number of stacks we want in that array
    Integer[] top; //size=k, stores index of otp element of each stack
    Integer[] next; //n size, stores next available space initially and then later, previous of top values' index becaz
    // if I remove top, I need to update top as previous of current top


    public KStacksInArray(int capacity, int k) {
        this.capacity = capacity;
        this.k = k;
        this.arr = new Integer[capacity];
        this.free = 0;
        this.top = new Integer[k];
        this.next = new Integer[capacity];
        for (int i = 0; i < k; i++) {
            top[i] = -1;
        }
        for (int i = 0; i < capacity - 1; i++) {
            next[i] = i + 1;
        }
        next[capacity - 1] = -1;
    }

    public static void main(String[] args) {
        KStacksInArray kStacksInArray = new KStacksInArray(10, 3);

        // Let us put some items in stack number 2
        kStacksInArray.push(15, 2);
        kStacksInArray.push(45, 2);

        // Let us put some items in stack number 1
        kStacksInArray.push(17, 1);
        kStacksInArray.push(49, 1);
        kStacksInArray.push(39, 1);

        // Let us put some items in stack number 0
        kStacksInArray.push(11, 0);
        kStacksInArray.push(9, 0);
        kStacksInArray.push(7, 0);

        System.out.println("Popped element from stack 2 is " + kStacksInArray.pop(2));
        System.out.println("Popped element from stack 1 is " + kStacksInArray.pop(1));
        System.out.println("Popped element from stack 0 is " + kStacksInArray.pop(0));
    }

    boolean isEmpty(int sn) { //sn=stack number
        return top[sn] == -1; //since top stores top index of each stack, if it's -1 that means it's empty
    }

    boolean isFull(int sn) {
        return free == -1; //as free contains value of next available slot and next[last index]=-1. if that values goes
        // inside free that means stack is full
    }

    void push(int x, int sn) {
        //if it's full, cant push, overflow
        if (isFull(sn)) {
            System.out.println("Array is full");
            return;
        }
        int i = free;
        free = next[i];//free contains next available slot and next[i] is storing next available slot and hence we update it
        next[i] = top[sn]; //whatever top is rn, it'll come to next[i], so that when we pop top, we should have index of prev of top
        top[sn] = i; //current index where top of that stack is there
        arr[i] = x;//store value in actual arr
    }

    int pop(int sn) {
        //pop cannot be performed on empty stack, underflow
        if (isEmpty(sn)) {
            System.out.println("Stack is empty");
            return Integer.MAX_VALUE;
        }
        int i = top[sn]; //contains element's index to be popped
        top[sn] = next[i];
        next[i] = free;
        free = i;
        return arr[i]; //return element
    }
}
