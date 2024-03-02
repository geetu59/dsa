package queue;

import linkedlist.singlell.Node;

import java.util.ArrayDeque;
import java.util.Queue;

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

        //Using built-in classes
        //Can use LinkedList class or ArrayDeque class. Difference is one is implemented using ll and other using array
        //ll has worst case time complexity as O(1) and array has amortised(avg) as O(1) becaz it might resize if array is full
        //Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue1 = new ArrayDeque<>();

        //both of them adds element but offer returns false if queue is full and add throws exception
        System.out.println(queue1.offer(1));
        System.out.println(queue1.add(2));

        //returns top element i.e. head i.e. front but element throws exception and peek returns null if queue is empty
        System.out.println(queue1.peek());
        System.out.println(queue1.element());

        //returns front and remove element. Null if queue is empty by poll and exception by remove
        System.out.println(queue1.poll());
        System.out.println(queue1.remove());
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
