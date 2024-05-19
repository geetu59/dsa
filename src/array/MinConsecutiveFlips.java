package array;

/*Given a binary array. You have to flip either 0s or 1s to make all elements same. You have to flip 0s or 1s which occur consecutively.
 * So, we have consecutive 0s/1s as a group and flip that element which has min no of groups to be flipped. This is the requirement.
 * Eg: {1,1,0,0,0,1}, we have 2 groups of 1 to be flipped and 1 group of 0 to be flipped, hence we will flip 0 and return from 2 to 4.
 * Naive sol: O(N) time and O(1) space
 * efficient: O(N) time and O(1) space
 */
public class MinConsecutiveFlips {
    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 1, 0, 0, 1, 1, 0, 1};
        //int arr[] = {0, 0, 1, 1, 0, 0, 1, 1, 0};
        //Naive sol
        minFlips(arr);
        //Efficient sol
        printGroups(arr);
    }

    private static void printGroups(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                if (arr[i] != arr[0])
                    System.out.print("From " + i + " to ");
                else
                    System.out.println(i - 1);
            }
        }
        if (arr[arr.length - 1] != arr[0]) System.out.print(arr.length - 1);
    }

    private static void minFlips(int[] arr) {
        int grp1 = 0, grp0 = 0;
        if (arr[0] == 0) grp0++;
        else grp1++;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] != arr[i - 1] && arr[i] == 0) grp0++;
            if (arr[i] != arr[i - 1] && arr[i] == 1) grp1++;
        }
        int flip = grp1 < grp0 ? 1 : 0;
        System.out.println(flip);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[0] && arr[i] != arr[i - 1]) System.out.println(i);
            if (arr[i] != arr[i - 1] && arr[i] == arr[0]) System.out.println(i - 1);
        }
    }
}
