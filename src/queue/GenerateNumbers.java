package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*1. Given a number N. The task is to generate and print all binary numbers with decimal values from 1 and print N values
* 2. The task is to generate N numbers which has 5 and 6 only in it. Naive sol is to traverse thru' all nos and check if it has 5 or 6.
* Time Complexity : O(N log2N)
* Auxiliary Space : O(N log2N)*/
public class GenerateNumbers {
    public static void main(String[] args) {
        System.out.println("All N Binary nos");
        System.out.println(generateBinary(5));

        System.out.println("All N numbers which contains only 5 and 6");
        System.out.println(generate(10));
    }

    private static ArrayList generateBinary(int n) {
        ArrayList<String> list = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        for (int i = 0; i < n; i++) {
            String x = queue.remove();
            list.add(x);
            queue.add(x + '0');
            queue.add(x + '1');
        }
        return list;
    }

    private static ArrayList generate(int n) {
        //put elements 5,6 in queue. remove 5, concat 55,56, move on.
        ArrayList<String> list = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("5");
        queue.add("6");
        for (int i = 0; i < n; i++) {
            String x = queue.remove();
            list.add(x);
            queue.add(x + '5');
            queue.add(x + '6');
        }
        return list;
    }
}
