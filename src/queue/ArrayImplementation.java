package queue;

import java.util.LinkedList;
import java.util.Queue;

/* Implement Queue using array: FIFO
Efficient implementation where enqueue and dequeue is O(1). Use circular array.*/
public class ArrayImplementation {
    //we are maintaining front as it will not be 0 always. Not maintaining rear as we will be able to get it with these
    static int capacity;
    static int front;
    static int size;
    static int[] arr;

    public ArrayImplementation(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
        front = 0;
    }

    public static void main(String[] args) {
        ArrayImplementation arrayImplementation = new ArrayImplementation(10);
        enque(10);
        enque(20);
        enque(30);
        enque(40);
        enque(50);
        deque();
        deque();
        System.out.println(isEmpty());
        System.out.println(isFull());
        System.out.println(getFront());
        System.out.println(getRear());
    }

    //can skip this method if we are using ArrayList as it automatically resizes itself
    private static boolean isFull() {
        return size == capacity;
    }

    private static boolean isEmpty() {
        return size == 0;
    }

    private static int getFront() {
        if (isEmpty()) return -1;
        return front;
    }

    private static int getRear() {
        if (isEmpty()) return -1;
        return (front + size - 1) % capacity;
    }

    private static void enque(int x) {
        if (isFull()) return;
        int rear = getRear();
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }

    private static void deque() {
        if (isEmpty()) return;
        front = (front + 1) % capacity;
        size--;
        Queue<Integer> integers = new LinkedList<>();
    }
}
