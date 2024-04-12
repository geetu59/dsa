package array;

import java.util.Arrays;

/*
 * 1. Insert in static array
 * a. in begin: theta(n)
 * b. at end: O(1)
 * c. general: O(n)
 * 2. Insert at end operation in dynamic sized array:
 * Insert at end till capacity will be O(1) and after capacity, size will be double and all elements will be copied to
 * new array and hence this operation is theta(n). so avg is O(1)+O(1)+...n times + theta(n)/n+1=2theta(n)/n+1=O(1).
 * Refer Arrays Operations part 1 Gfg video.*/
public class Insert {

    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        System.out.println(insertInStaticArray(arr, 6, 3, 4, 0));
        System.out.println(insertInStaticArray(arr, 6, 4, 5, 4));
        System.out.println(insertInStaticArray(arr, 6, 5, 6, 2));
        System.out.println(Arrays.toString(arr));
    }

    private static int insertInStaticArray(int[] arr, int capacity, int size, int element, int position) {
        if (capacity == size) return size;
        for (int i = size - 1; i >= position; i--)
            arr[i+1]=arr[i];
        arr[position]=element;
        return size+1;
    }

}
