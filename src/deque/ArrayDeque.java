package deque;

/*Deque: Doubly ended queue: insert/del from both ends
 * Implement using ll: Use doubly ll and maintain head and tail
 * Implement using array:
 * a. Simple and inefficient implementation where front=0 and rear=size-1
 * b. Efficient implementation: Use circular array, O(1) for all operations
 * O(N) would be time complexity for Dynamic array*/
public class ArrayDeque {
    int size, capacity;
    int[] arr;

    public ArrayDeque(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
    }

    public static void main(String[] args) {
        ArrayDeque deque = new ArrayDeque(5);
        deque.insertFront(1);
        deque.insertFront(2);
        deque.insertFront(3);
        deque.insertRear(4);
        deque.insertRear(5);
        deque.insertRear(6);
        System.out.println(deque.deleteFront());
        System.out.println(deque.deleteRear());
        System.out.println(deque.getSize());
        System.out.println(deque.getFront());
        System.out.println(deque.getRear());
        System.out.println(deque.isEmpty());
        System.out.println(deque.isFull());
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private int getFront() {
        if (isEmpty()) return -1;
        return arr[0];
    }

    private int getRear() {
        if (isEmpty()) return -1;
        return arr[size - 1];
    }

    private void insertRear(int x) {
        if (isFull()) return;
        arr[size] = x;
        size++;
    }

    private int getSize() {
        return size;
    }

    private int deleteRear() {
        if (isEmpty()) return -1;
        int x = arr[size - 1];
        size--;
        return x;
    }

    private void insertFront(int x) {
        if (isFull()) return;
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = x;
        size++;
    }

    private int deleteFront() {
        if (isEmpty()) return -1;
        int x = arr[0];
        for (int i = 0; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return x;
    }
}
