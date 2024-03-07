package deque;

/*Implement deque using circular array, all operations in O(1)*/
public class CircularArray {
    int size, front, capacity;
    int arr[];

    public CircularArray(int capacity) {
        this.capacity = capacity;
        size = 0;
        front = 0;
        arr = new int[capacity];
    }

    public static void main(String[] args) {
        CircularArray deque = new CircularArray(5);
        deque.insertFront(10);
        deque.insertRear(20);
        deque.insertRear(30);
        deque.insertFront(40);
        System.out.println(deque.deleteFront());
        System.out.println(deque.deleteRear());
        System.out.println(deque.isEmpty());
        System.out.println(deque.isFull());
        System.out.println(deque.getFront());
        System.out.println(deque.getRear());
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    private int getRear() {
        if (isEmpty()) return -1;
        return arr[(front + size - 1) % capacity];
    }

    private void insertFront(int x) {
        if (isFull()) return;
        front = (front + capacity - 1) % capacity;
        arr[front] = x;
        size++;
    }

    private int deleteFront() {
        if (isEmpty()) return -1;
        int x=arr[front];
        front=(front + 1) % capacity;
        size--;
        return x;
    }

    private void insertRear(int x) {
        if (isFull()) return;
        int rear = (front + size) % capacity; //new_rear=(rear+1)%capacity, since rear=(front+size-1)%capacity, put this at place of rear
        arr[rear] = x;
        size++;
    }

    private int deleteRear() {
        if (isEmpty()) return -1;
        int x = (front + size - 1) % capacity; //get rear
        size--; //(rear-1+cap)%cap, reducing size will automatically update rear as rear value depends on front and size
        return arr[x];
    }
}
