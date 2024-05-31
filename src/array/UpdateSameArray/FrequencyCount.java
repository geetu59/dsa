package array.UpdateSameArray;

import java.util.Arrays;

/*Given an array arr[] of N positive integers which can contain integers from 1 to P where elements can be repeated or
can be absent from the array. Your task is to count the frequency of all numbers from 1 to N. Make in-place changes in arr[],
such that arr[i] = frequency(i).
Note: The elements greater than N in the array can be ignored for counting and do modify the array in-place.
Example 1:
Input:
N = 5
arr[] = {2, 3, 2, 3, 5}
P = 5
Output:
0 2 2 0 1
Explanation:
Counting frequencies of each array element. We have:
1 occurring 0 times.
2 occurring 2 times.
3 occurring 2 times.
4 occurring 0 times.
5 occurring 1 time.
Time complexity: O(N)
Auxiliary space: O(1)*/
public class FrequencyCount {
    public static void main(String[] args) {
        int arr[]={2,3,2,3,5};
        //Approach 1
        frequencyCount(arr, 5, 5);
        System.out.println(Arrays.toString(arr));
        //Approach 2
        int arr1[]={3,3,3,3};
        freqCount(arr1, 4, 5);
        System.out.println(Arrays.toString(arr1));
    }

    private static void freqCount(int[] arr, int N, int P) {
        for(int i=0;i<N;i++){
            arr[i]--;
        }
        for(int i=0;i<N;i++){
            if(arr[i]%P<N)
                arr[arr[i]%P]+=P;
        }
        for(int i=0;i<N;i++){
            arr[i]=arr[i]/P;
        }
    }

    /*We have to update count at that index. If we directly do it, we loose the value present at that index and we will not even know
    * if the value present is the count or actual value at that index.
    * To resolve this, we will store negative of count at that index to differentiate that it is count only not actual value and to not
    * loose track of value present, we will swap it's value with the ith position and keep on updating count until we get 0/- value at ith
    * index. */
    public static void frequencyCount(int arr[], int N, int P)
    {
        //if arr[i] is -/0 then, go to next position as we need not to do anything becaz count is what is stored here
        //if arr[i] is between 0 and n, go to value at that position and check arr[position], if it is negative, that means
        //it is storing count, so decrease the value there and proceed by marking arr[i] as 0 so that you can move to next element
        //as it will keep on processing that element if it is + else swap the values and put -1
        //if arr[i] > N i.e. since P can be anything and we are interested to know the count for n elements only, so we
        //just mark 0 and proceed. We are marking 0 becaz we can do i++ only if value is -/0
        for(int i=0;i<N;){
            if(arr[i]>0 && arr[i]<=N){
                int j=arr[i]-1;
                if(arr[j]<=0){
                    arr[j]--;
                    arr[i]=0;
                    i++;
                } else {
                    swap(arr, i, j);
                    arr[j]=-1;
                }
            } else if (arr[i]>N) {
                arr[i]=0;
                i++;
            } else {
                i++;
            }
        }
        //since - of count is stored
        for(int i=0;i<N;i++){
            arr[i]=-arr[i];
        }
    }
    public static void swap(int arr[], int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
