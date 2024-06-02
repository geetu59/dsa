package searching;

/*Find floor of sq root of a no. Eg: nos from 4-8 will have 2 as sq root
 * SOl 1: theta(sqroot(x))
 * Sol 2: O(logn)*/
public class SquareRoot {
    public static void main(String[] args) {
        //naive
        System.out.println(sqRoot(14));
        //Binary search
        System.out.println(squareRoot(14));
    }

    private static int squareRoot(int x) {
        int ans = 0;
        if (x == 0 || x == 1) return x;
        int low = 1, high = x / 2; //sq root cannot be less than 1 and cannot be more than x/2
        while (low <= high) {
            int mid = (low + high) / 2;
            int midSq = mid * mid;
            if (midSq == x) return mid;
            else if (midSq > x) //can't update ans becaz x is small and we want floor value
                high = mid - 1;
            else {
                low = mid + 1;
                ans = mid; //x is greater, assume a[mid]=3 and x=13, so store mid in answer becaz if mid is 4, it'll be greater and we need prev value
            }
        }
        return ans;
    }

    private static int sqRoot(int x) {
        //we increment i and check i*i is <=x, once it becomes greater than x, return i-1
        int i = 1;
        while (i * i <= x) {
            i++;
        }
        return i - 1;
        //we can also have for loop till x and calculate i*i and compare with x, if it is less then store i but in that case
        //time will be O(N) hence not a good approach
    }
}
