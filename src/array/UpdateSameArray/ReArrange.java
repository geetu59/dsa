package array.UpdateSameArray;

import java.util.Arrays;

/*Given a sorted array of positive integers, rearrange the array elements alternatively i.e first element should be max value,
second should be min value, third should be second max, fourth should be second min and so on. Eg: arr[] = {1,2,3,4,5,6} Output: 6 1 5 2 4 3
Time Complexity: O(N)
Auxiliary Space: O(1)*/
public class ReArrange {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        rearrange(arr,  6);
        System.out.println(Arrays.toString(arr));
    }

    private static void rearrange(int[] arr, int n) {
        int k=0,j=n-1;
        long max=arr[n-1]+1;
        for(int i=0;i<n;i++){
            if(i%2==0){
                arr[i] += (arr[j] % max) * max;
                j--;
            } else{
                arr[i] += (arr[k] % max) * max;
                k++;
            }
        }
        for(int i=0;i<n;i++){
            arr[i]= (int) (arr[i]/max);
        }
    }
}
