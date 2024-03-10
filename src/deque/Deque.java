package deque;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/*1. Use built-in deque: Since it implements queue also and hence it has all methods of queue, so dont use offer/add/poll, use deque specific methods
 * 2. Delete items in deque at specific position, in range, all elements in deque in O(N) time*/
public class Deque {
    public static void main(String[] args) {
        java.util.Deque<Integer> deque = new LinkedList<>();
        //adds in deque and returns true/false
        //30 10 20 40
        deque.offerFirst(10);
        deque.offerLast(20);

        //adds in deque and throws exception
        deque.addFirst(30);
        deque.addLast(40);

        //returns front and rear elements of deque and returns null if deque is empty
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        //returns front and rear and throws exception is deque is empty
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());

        //removes front and rear and returns null if deque is empty
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());

        //removes front and rear and throws exception is deque is empty
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());

        deque.offerFirst(50);
        deque.addFirst(60);
        deque.offerLast(70);
        deque.addLast(80);

        //Traverse-1
        System.out.println("Traversal - 1: ");
        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
        //Traverse-2
        System.out.println("Traversal - 2: ");
        for (Integer i : deque) {
            System.out.println(i + " ");
        }
        //Reverse Traversal
        System.out.println("Reverse Traversal: ");
        Iterator<Integer> iterator1 = deque.descendingIterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next() + " ");
        }
        deque.addLast(90);
        deque.addLast(100);
        System.out.println(deque);

        //Delete item at specific position
        deleteAtX(deque, 2);
        System.out.println(deque);
        //Delete item in range
        deleteInRange(deque, 1, 4);
        System.out.println(deque);
        //Delete all items
        deleteAll(deque);
        System.out.println(deque);
    }

    private static void deleteAtX(java.util.Deque<Integer> deque, int x) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < x; i++) {
            stack.push(deque.pollFirst());
        }
        deque.pollFirst();
        while (!stack.isEmpty()) {
            deque.offerFirst(stack.pop());
        }
    }

    private static void deleteInRange(java.util.Deque<Integer> deque, int start, int end) {
        Stack<Integer> stack = new Stack<>();
        int currentIndex = 0;
        while (!deque.isEmpty()) {
            if (currentIndex >= start && currentIndex < end) {
                deque.pollFirst();
            } else {
                stack.push(deque.pollFirst());
            }
            currentIndex++;
        }
        while (!stack.isEmpty()) {
            deque.offerFirst(stack.pop());
        }
    }

    private static void deleteAll(java.util.Deque<Integer> deque) {
        deque.clear();
    }
}
