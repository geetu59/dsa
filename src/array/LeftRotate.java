package array;

import java.util.Arrays;

/*Left rotate means move d places towards left i.e. counter clockwise. eg:{1,2,3,4,5}, by 1: {2,3,4,5,1}
 * 1. Left rotate by 1: O(1) space and O(N) time
 * 2. Left rotate by d:
 * a. Call left rotate by 1 method d times. theta(n*d) time O(1) space
 * b. Create an array of d size and store d elements there and then move all elements to front and then add those elements.
 * Time: theta(d)+theta(n-d)+theta(d)-> theta(n+d) and since d<=n, theta(n) and theta(d) space
 * c. Time: theta(n) space:O(1)*/
public class LeftRotate {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        leftRotateBy1(arr);

        leftRotateByDNaive1(arr, 3);
        leftRotateByDNaive2(arr, 3);
        leftRotateByD(arr, 7);
        System.out.println(Arrays.toString(arr));
        arrange(new long[]{1,0}, 2);
    }
    static void arrange(long arr[], int n)
    {
        for(int i=0;i<arr.length/2;i++){
            long t=arr[i];
            long temp=arr[(int)t];
            arr[(int)t]=arr[i];
            arr[i]=arr[(int)t];
        }
    }

    private static void leftRotateByD(int[] arr, int d) {
        //if d>arr.length so number of rotations would be d-n becaz after n rotations array will come to the same place
        if (d > arr.length) d -= arr.length;
        //reverse d elements, theta(d)
        reverse(arr, 0, d - 1);
        //reverse rest elements, theta(n-d)
        reverse(arr, d, arr.length - 1);
        //reverse whole array, theta(n)
        reverse(arr, 0, arr.length - 1);
    }

    private static void leftRotateByDNaive2(int[] arr, int d) {
        int[] temp = new int[d];
        //store first d elements in array
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        //move rest elements to front
        for (int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }
        //add d elements at end
        for (int i = 0; i < d; i++) {
            arr[arr.length - d + i] = temp[i];
        }
    }

    //d>n, subtract n from d

    private static void leftRotateByDNaive1(int[] arr, int d) {
        for (int i = 0; i < d; i++) {
            leftRotateBy1(arr);
        }
    }

    private static void leftRotateBy1(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
