package searching;

import java.util.HashMap;
import java.util.Map;

/*Given an element k and array. COunt number of elements whose occurrence is more than n/k
 * Sol 1: Pick one element and then count it's occurrences and check if > n/k then update ans++. This is O(N*N) sol
 * Sol 2: Moore's voting algo
 * Sol 3: Use hashmap, space and time is O(N) and store count of each element*/
public class CountMoreThanThreshold {
    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 2, 1, 2, 3, 3};
        //sol 3
        System.out.println(count(arr, 4));
    }

    private static int count(int[] arr, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }
        int barrier = arr.length / k;
        int count = 0;
        for (Map.Entry<Integer, Integer> mapElement : hashMap.entrySet()) {
            Integer value = mapElement.getValue();
            if (value > barrier) count++;
        }
        return count;
    }
}
