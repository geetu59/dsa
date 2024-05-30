package array.UpdateSameArray;

/*The task is to find the smallest positive number missing from the array. Note: Positive number starts from 1.
Eg: Input:
N = 5
arr[] = {1,2,3,4,5}
Output: 6 Explanation: Smallest positive missing number is 6.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1) //in this case, I've used auxiliary array which can be avoided
We solve this in 3 steps:
1. Segregate all 0/negative nos and positive nos i.e. move all positive nos to end
2. Now, traverse thru each + no and go to that position and make value at that position negative
3. Traverse thru each of them and check for + value, if you encounter that means i+1 is missing else size+1 would be output*/
public class MissingNumber {
    public static void main(String[] args) {
        int arr[] = {0, 1};
        System.out.println(missingNumber(arr));
    }

    private static int missingNumber(int[] arr) {
        //segregate - and + and return index of the array from where + elements begin
        int shift = segregate(arr);
        //storing all + values in diff array
        int[] positiveArray = new int[arr.length - shift];
        for (int i = 0; i < arr.length - shift; i++) {
            positiveArray[i] = arr[i + shift];
        }
        //finding missing
        return findMissing(positiveArray);
    }

    private static int findMissing(int[] positiveArray) {
        int size = positiveArray.length;
        for (int i = 0; i < size; i++) {
            //negate the value on index for which value is already present. So index starts from 0 but we need to check for 1, so value-1
            //is the place we are looking for. Go to that place and mark value of that place -. Actually we are concerned with indexes as
            //that will help us identify if value is their of our range and what is missing
            int x = positiveArray[i];
            if (x - 1 < size) {
                positiveArray[x - 1] = -positiveArray[x - 1];
            }
        }
        for (int i = 0; i < size; i++) {
            if (positiveArray[i] > 0) return i + 1;
        }
        return size + 1;
    }

    private static int segregate(int[] arr) {
        //if you encounter - value, swap, so j keeps track of index for - elements
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return j;
    }
}
