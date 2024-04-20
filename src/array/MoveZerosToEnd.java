package array;

import java.util.Arrays;

/*Move all 0s in an array at end.
 * Naive sol: The moment you find 0, check first non-zero element to th2 right of it and swap.
 * Efficient sol: Update the current array by maintaining count for non-zero element and swapping it with 0th O(N) time and O(1) space*/
public class MoveZerosToEnd {
    public static void main(String[] args) {
        int arr[] = {10, 8, 0, 0, 12, 0};
        int arr1[] = {0, 1, 1, 0, 2, 4};
        //this will not work for element other than 0 or add that element once you end up brining all element together
        moveOsToEndNaive1(arr1);
        moveOsToEndNaive2(arr);
        moveOsToEnd(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    private static void moveOsToEnd(int[] arr) {
        int count=0;
        for (int i = 0; i <arr.length; i++) {
            if (arr[i]!=0){
                int temp=arr[count];
                arr[count]=arr[i];
                arr[i]=temp;
                count++;
            }
        }
    }

    private static void moveOsToEndNaive2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0){
                //find next non-zero element and swap it with current one
                for (int j = i+1; j < arr.length; j++) {
                    if (arr[j]!=0){
                        int temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
        }
    }

    private static void moveOsToEndNaive1(int[] arr) {
        int temp[] = new int[arr.length];
        int count = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                count++;
                // arr[count]=arr[i]; this will give {10,8,12,0,12,0} as output, so 12 is moved but it is still at ith position
                temp[count]=arr[i];
            }
        }
        System.out.println(Arrays.toString(temp));
    }
}
