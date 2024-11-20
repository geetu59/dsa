import java.util.Arrays;

/*You are given an array, prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one
and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:

Input: prices = [1]
Output: 0*/
public class Stock {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(stockProfit(prices));
    }
    static int getProfit(int[] prices, int index, int buy, int n, int[][] dp){
        if (index>=n) return 0;
        int profit =0;

        if (dp[index][buy]!=-1)
            return dp[index][buy];

        if (buy==0){
            profit = Math.max(0+getProfit(prices, index+1, 0, n, dp),
                    getProfit(prices, index+1, 1, n,dp) - prices[index]);
        }
        if (buy==1){
            profit = Math.max(0+getProfit(prices, index+1, 1,n,dp),
                    prices[index] + getProfit(prices, index+2, 0, n, dp));
        }
        dp[index][buy]=profit;
        return profit;
    }
    static int stockProfit(int[] prices){
        int[][] dp=new int[prices.length][2];
        for (int[] row:
             dp) {
            Arrays.fill(row, -1);
        }
        int profit = getProfit(prices,0,0, prices.length, dp);
        return profit;
    }
}
