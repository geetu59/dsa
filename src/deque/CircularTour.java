package deque;

/*You are given 2 arrays, 1 which contains petrol in n petrol pumps and other which contains distance of petrol pump from p[i] to p[i+1].
 * From which petrol pump should we start so that we do not loose out petrol in between. Print position not index as an output.
 * Approach 1: Using array. Time: O(N*N) Space:O(1)
 * Approach 2: Using queue.*/
public class CircularTour {
    public static void main(String[] args) {
        int petrol[] = {4, 8, 7, 4};
        int dist[] = {6, 5, 3, 5};
        System.out.println("Array implementation: ");
        System.out.println(tour(petrol, dist));
    }

    private static int tour(int[] petrol, int[] dist) {
        //traverse thru' all petro pumps in circular manner
        for (int start = 0; start < petrol.length; start++) {
            int curr_petrol = 0;
            int end = start;
            while (true) {
                curr_petrol += (petrol[end] - dist[end]); //current petrol would be, whatever is present + petrol on
                // reaching ith - petrol which will be used to reach i+1
                //if it's < 0 then petrol is over before we could reach, so we can't start with ith petrol pump
                if (curr_petrol < 0) break;
                end = (end + 1) % petrol.length; //since it's in circular manner
                if (start == end)
                    return start + 1; //if circle gets complete and we didn't encounter negative value then return output
            }
        }
        return -1;
    }
}
