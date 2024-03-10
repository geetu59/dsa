package deque;

import java.util.Deque;
import java.util.LinkedList;

/*Rotate deque left and right by k element with O(N) time and O(1) space*/
public class RotateByK {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);

        rotateLeft(deque, 2);
        System.out.println(deque);
        rotateRight(deque, 2);
        System.out.println(deque);
    }

    //this means remove last k elements and add it in front
    private static void rotateRight(Deque<Integer> deque, int k) {
        for (int i = 0; i < k; i++) {
            deque.addFirst(deque.removeLast());
        }
    }

    //this means remove first k elements and add it at last
    private static void rotateLeft(Deque<Integer> deque, int k) {
        for (int i = 0; i < k; i++) {
            deque.addLast(deque.removeFirst());
        }
    }
}
