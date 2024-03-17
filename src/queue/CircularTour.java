package queue;

import java.util.LinkedList;
import java.util.Queue;

/*You are given 2 arrays, 1 which contains petrol in n petrol pumps and other which contains distance of petrol pump from p[i] to p[i+1].
 * From which petrol pump should we start so that we do not loose out petrol in between. Print position not index as an output.
 * Approach 1: Using array. Time: O(N*N) Space:O(1) Implemented in deque folder
 * Approach 2: Using queue. O(N) time and space. Add and remove an item once. */
public class CircularTour {
    public static void main(String[] args) {
        int petrol[] = {55, 52, 33, 100};
        int dist[] = {77, 61, 40, 69};
        System.out.println("Queue implementation: ");
        System.out.println(tour(petrol, dist));
    }

    //Approach is to add indexes of petrol pumps in queue and keep on calculating current petrol value, the moment you find the negative value,
    //start removing first indexes from queue and value in petrol they contributed for, until you find a positive value. This will help you
    // identify starting point and then loop until you reach that point again
    private static int tour(int[] petrol, int[] distance) {
        Queue<Integer> queue = new LinkedList<>();
        int start = 0;
        int end = 1;
        int curr_petrol = petrol[start] - distance[start];
        queue.offer(start);
        //if start=petrol.length that means no starting pt found
        while (start != petrol.length && start != end) {
            while (start != end && curr_petrol < 0) {
                curr_petrol -= petrol[start] - distance[start];
                queue.remove();
                start = (start + 1) % petrol.length;
                if (start == 0)
                    return -1; // If we have come back to the starting point without finding a solution
            }
            curr_petrol += (petrol[end] - distance[end]);
            queue.add(end);
            end = (end + 1) % petrol.length;
        }
        return (start == petrol.length || curr_petrol < 0) ? -1 : queue.peek() + 1;
    }
}
