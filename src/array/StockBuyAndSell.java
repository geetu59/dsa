package array;

import java.util.ArrayList;

import static java.lang.Math.max;

/*Stock Buy And Sell
The cost of a stock on each day is given in an array. Find the maximum profit that you can make by buying and selling on those days.
Eg: {1,5,3,8,12} Buy on 0th day at 1, sell when price is 5 and buy when price is 3 and sell when price is 12. 13 is the total profit.
* Sol 1: Naive: consider each day as starting day(denoted by i) and consider all days after starting day as last day(denoted by j).
Start day = stock buy and end day = stock sell. This sol is recursive sol. O(N*N) time and O(1) space
Sol 2: Efficient sol: O(N) time and O(1) space. Idea is that, we will buy stack when the value is min and sell when it is max, so we will find all the
peak pts and min pts. So, you compare the value with prev one, if greater then add it else ignore, this will gice you the cumulative profit.

Variant of the question: Print days when to buy and sell. We cannot use above efficient sol becaz it will help you provide profit but will not tell
days becaz if you see A[] = {100,180,260,310,40,535,695} output would be {0,1 1,2 2,3 4,5 5,6} as per above sol but we want actual result like cumulative, {0,3 4,6}
*/
public class StockBuyAndSell {
    public static void main(String[] args) {
        int arr[] = {1, 5, 3, 8, 12}; //Cost of stock on ith day is arr[i]
        //Naive sol
        System.out.println(maxProfit(arr, 0, arr.length - 1));
        //Efficient sol
        System.out.println(maxGain(arr));
        //Variant
        System.out.println(stockBuySell(arr, arr.length));
    }

    private static int maxGain(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1])
                profit += arr[i] - arr[i - 1];
        }
        return profit;
    }

    private static int maxProfit(int[] arr, int start, int end) {
        if (end <= start)
            return 0; //end is selling stock, so if you sell before buying or at the day of buying then profit=0
        int profit = 0;
        for (int i = start; i < end; i++) { //i loop is start i.e. the day when you buy and hence value should be < end
            for (int j = i + 1; j <= end; j++) { //j is end i.e. the day when you have to sell the stock, hence it should be > start day
                if (arr[j] > arr[i]) //price on the day when you have to sell the stock is greater then only calculate profit
                {
                    int currProfit = arr[j] - arr[i] + maxProfit(arr, start, i - 1) + maxProfit(arr, j + 1, end);
                    profit = max(profit, currProfit);
                }
            }
        }
        return profit;
    }

    static ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int buy = -1;
        for (int i = 1; i < n; i++) {
            if (A[i - 1] < A[i]) {
                if (buy == -1) buy = i - 1;
            } else {
                if (buy != -1) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(buy);
                    pair.add(i - 1);
                    result.add(pair);
                    buy = -1;
                }
            }
        }
        if (buy != -1) {
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(buy);
            pair.add(n - 1);
            result.add(pair);
        }
        return result;
    }
}
