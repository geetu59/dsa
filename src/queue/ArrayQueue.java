package queue;

public class ArrayQueue {
    static int size;
    static int front;
    static int capacity;
    static int[] arr;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
        front = 0;
    }

    public static void main(String[] args) {

    }

    private static void enqueue(int x) {
        if (isFull()) return;
        arr[front] = x;
        front++;
        size++;
    }

    private static boolean isFull() {
        return size == capacity;
    }

    private static boolean isEmpty() {
        return size == 0;
    }

    private static void dequeue() {
        if (isEmpty()) return;
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }
}
