package deque;

/*You are given 2 arrays, 1 which contains petrol in n petrol pumps and other which contains distance of petrol pump from p[i] to p[i+1].
 * From which petrol pump should we start so that we do not loose out petrol in between. Print position not index as an output.
 * Approach 1: Using array. Time: O(N*N) Space:O(1)
 * Approach 2: Using queue/deque. Done as part of queue. Time: O(N). Implemented as part of queue
 * Approach 3: Same as approach 2, besides of creating a queue/deque, we will use the same array by maintaining start and end pointers
 * Approach 4: Same as approach 5 but traversing for prev_petrol
 * Approach 5: By doing single traversal. Time: O(N) Space: O(1) Efficient sol*/
public class CircularTour {
    public static void main(String[] args) {
        int petrol[] = {4, 8, 7, 4};
        int dist[] = {6, 5, 3, 5};
        //Approach 1
        System.out.println("Array implementation: ");
        System.out.println(tour(petrol, dist));
        //Approach 3
        System.out.println("Updating same array: ");
        System.out.println(findTour(petrol, dist));
        //Approach 4
        System.out.println("Traversing for prev_petrol: ");
        System.out.println(getTour(petrol, dist));
        //Approach 5
        System.out.println("Using single loop: ");
        System.out.println(printTour(petrol, dist));
    }

    private static int getTour(int[] petrol, int[] dist) {
        int start = 0;
        for (int i = 0; i < petrol.length; i++) {
            // Identify the first petrol pump from where we might get a full circular tour
            if (petrol[i] >= dist[i]) {
                start = i;
                break;
            }
        }
        int curr_petrol = 0;
        int i;
        for (i = start; i < petrol.length; ) {
            curr_petrol += petrol[i] - dist[i];
            // If at any point remaining petrol is less than 0, it means that we cannot start our journey from current start
            if (curr_petrol < 0) {
                // We move to the next petrol pump
                i++;
                // We try to identify the next petrol pump from where we might get a full circular tour
                while (i < petrol.length) {
                    if (petrol[i] >= dist[i]) {
                        start = i;
                        break;
                    }
                    i++;
                }
            } else {
                i++;
            }
        }
        if (curr_petrol < 0) return -1;
        for (int j = 0; j < start; j++) {
            curr_petrol += (petrol[j] - dist[j]);
            if (curr_petrol < 0) return -1;
        }
        return start + 1;
    }

    private static int findTour(int[] petrol, int[] dist) {
        int start = 0, end = 1, curr_petrol = petrol[start] - dist[start];

        // If current amount of petrol in truck becomes less than 0, then
        // remove the starting petrol pump from tour
        while (start != end && curr_petrol < 0) {

            // If current amount of petrol in truck becomes less than 0, then
            // remove the starting petrol pump from tour
            while (curr_petrol < 0 && start != end) {
                // Remove starting petrol pump. Change start
                curr_petrol -= petrol[start] - dist[start];
                // If 0 is being considered as start again, then there is no
                // possible solution
                start = (start + 1) % petrol.length;
                if (start == 0)
                    return -1;
            }
            // Add a petrol pump to current tour
            curr_petrol += petrol[end] - dist[end];
            end = (end + 1) % petrol.length;
        }
        return start + 1;
    }

    //The idea is, if we find any position at which petrol is negative, that means none of positions before it will be our result.
    //so we update start as i+1th position whenever this happens. prev_petrol will give me values till (i+1)th position. curr_petrol
    //will give us for rest of positions and sum, will give us total, if it's +, that means start is the index we want. Watch gfg video for understanding
    private static int printTour(int[] petrol, int[] dist) {
        int start = 0, curr_petrol = 0, prev_petrol = 0;
        for (int i = 0; i < petrol.length; i++) {
            curr_petrol += petrol[i] - dist[i];
            if (curr_petrol < 0) {
                start = i + 1;
                prev_petrol += curr_petrol;
                curr_petrol = 0;
            }
        }
        return curr_petrol + prev_petrol >= 0 ? start + 1 : -1;
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
