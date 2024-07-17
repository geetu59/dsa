package searching;

/* There are n books with number of pages in each book are represented in array. There are k students, each student has to read all pages of book i.e.
you cannot read 5 pages of first book and then read 3 pages of next, and can read contiguous books only i.e. student A cannot read 0th and 2nd book,
it has to read 1st also. You have to minimise max pages read by each student.
Eg: {10,20,30,40} k=2, it can be like first student reads first book and rest are read by second student, 10 90, which is something we dont want,
60 40 would be right, max both of them are reading and max out of it is 60.
Efficient sol: O(nlogn)*/
public class MinimumPages {
    public static void main(String[] args) {
        int arr[] = {10, 5, 30, 1, 2, 5, 10, 10};
        //Naive sol
        System.out.println(minPages(arr, arr.length, 3));
        //Efficient sol O(nlogn)
        System.out.println(findPages(arr, 3));
    }

    private static int findPages(int[] arr, int k) {
        //we will find min and max values which result can hold, once we get range then we will proceed further
        //max value would be sum of all pages of books i.e. one student reads all books, so we got higher range
        //min value would be a book which has max pages becaz let's say if out of k students, each student reads 1
        //book only then student which read book with max pages would be answer and hence min value is max no of
        //pages in a book. [max, sum] now we apply binary search on it and
        int sum = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(arr[i], max);
        }
        int low = max, high = sum, result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isFeasible(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            } else low = mid + 1; //since we didn't find fisible sol till mid, we've to move to other half
        }
        return result;
    }

    private static boolean isFeasible(int[] arr, int k, int ans) {
        //we are saying that mid is ans, so for it to be ans, sum<ans i.e. books read by student should be less than ans
        //if it is more then move to next student which is represented by req and now sum would be initialized to arr[i]
        //i.e. first book read by that person. req will be giving us final count of students and if that no is less than k
        //then go ahead else fall into else condition
        int req = 1, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > ans) {
                req++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return req <= k;
    }

    /*There are total n books, so if those needs to be divided amongst students, there can be 1 cut after first book, other after second and so on. By cut
     * I mean divisions. So, there can be total n-1 divisions possible. Now, since no of students are k, so number of divisions we want is k-1, becaz that
     * will divide it into k parts. So out of (n-1) cuts we want (k-1), (n-1)C(k-1) ways. Now, we have to get value out of each of the ways, for each way,
     * we have pages read by k students, we've to get max of it i.e. max pages read by a student out of k, then store min of all the values received so far. */
    private static int minPages(int[] arr, int n, int k) {
        //if there is one student,
        if (k == 1) {
            return sum(arr, 0, n - 1);
        }
        //if there is one book, then return no of pages in that book
        if (n == 1) return arr[0];
        int result = Integer.MAX_VALUE;
        //we are diving first i pages between k-1 students and assigning left n-i pages to one student
        for (int i = 1; i < n; i++) {
            result = Math.min(result, Math.max(minPages(arr, i, k - 1), sum(arr, i, n - 1)));
        }
        return result;
    }

    private static int sum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
