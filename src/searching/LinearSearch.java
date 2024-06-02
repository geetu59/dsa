package searching;

/*Theta(N) time complexity and works on unsorted array as well*/
public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {10, 15, 20, 25, 50};
        System.out.println(search(arr, 25));
    }

    private static int search(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }
}
