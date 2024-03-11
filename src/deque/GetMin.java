package deque;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*Get min in O(N) time and space.
 * We can't store elements in increasing order, so that min is front becaz in that case, when we deque, we will not know which
 * element to remove and if we use queue to maintain that so that we can remove reqd element, then we've to traverse thru deque to remove it.
 * We can't do 2x-min, what we did in stack becaz there, the prev min used to be present. Here that element would be removed first.
 * Approach: Maintain queue and deque, queue will store all elements and deque will store min*/
public class GetMin {
    ArrayDeque<Integer> dq;
    Queue<Integer> queue;

    public GetMin() {
        this.dq = new ArrayDeque<>();
        this.queue = new LinkedList<>();
    }

    public static void main(String[] args) {
        GetMin d = new GetMin();
        d.enqueue(1);
        d.enqueue(2);
        d.enqueue(3);
        d.enqueue(4);
        d.enqueue(5);
        System.out.println(d.dequeue());
        System.out.println(d.getMin());
    }

    private void enqueue(int x) {
        //remove all elements in dq which are greater than x becax deque should ideally have min elements
        while (!dq.isEmpty() && dq.getLast() > x) {
            dq.removeLast();
        }
        dq.addLast(x);
        queue.add(x); //as q contains all elements
    }

    private int dequeue() {
        if (queue.peek() == dq.getFirst()) //if deque also has that element, remove it from there also
            dq.remove();
        return queue.remove(); //since queue contains all elements and hence remove from it
    }

    private int getMin() {
        if (this.queue.isEmpty()) return -1; //means there's no element present
        return dq.getFirst();
    }
}
