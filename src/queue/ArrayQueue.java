package queue;

/*Implement queue using array
 * 1. Simple implementation where enqueue is O(1) but dequeue is O(N). Idea is to keep index of front as 0 always and rear as size-1
 */
public class ArrayQueue {
    static int size;
    static int capacity;
    static int[] arr;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
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

    //add at the end
    private static void enque(int x) {
        if (isFull()) return;
        arr[size] = x;
        size++;
    }

    //del from beginning
    private static void deque() {
        if (isEmpty()) return;
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    private static boolean isFull() {
        return size == capacity;
    }

    private static boolean isEmpty() {
        return size == 0;
    }

    //get front index
    private static int getFront() {
        if (isEmpty()) return -1;
        return 0;
    }

    //get rear index
    private static int getRear() {
        if (isEmpty()) return -1;
        return size - 1;
    }
}
