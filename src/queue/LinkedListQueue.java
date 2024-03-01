package queue;

import linkedlist.singlell.Node;

/*Implement queue using linkedlist. O(1) for all operations.
 * We will use single linked list, where we maintain both head and tail. head-> front and tail is rear.
 * Enqueue can be done by doing rear.next and deque can be done by updating the front as front.next.
 * If we choose head->rear and tail-> front then enqueue can be done in O(1) but not deque as to remove tail value,
 * we need to have previous of tail. For that we've to traverse.*/
public class LinkedListQueue {
    Node front, rear; //head-> front and tail is rear
    int size;

    public LinkedListQueue() {
        front = rear = null;
        size = 0;
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enque(10);
        queue.enque(20);
        queue.enque(30);
        queue.enque(40);
        queue.enque(50);
        queue.deque();
        queue.deque();
        System.out.println(queue.getFront());
        System.out.println(queue.getRear());
        System.out.println(queue.getSize());
    }

    private int getSize() {
        return this.size;
    }

    private int getRear() {
        return rear == null ? -1 : rear.data;
    }

    private int getFront() {
        return front == null ? -1 : front.data;
    }

    private void deque() {
        if (front == null) return; //if ll is empty
        front = front.next; //deletion happens in front(head)
        if (front == null) rear = null; //when queue had 1 element
        size--;
    }

    //rear will be updated as in queue element is added at end, tail side
    private void enque(int x) {
        Node node = new Node(x);
        if (front == null) { //handle first node
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }
}
