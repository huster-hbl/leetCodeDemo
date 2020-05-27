package number_121;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[][][] dp = new int[n][2][2];
        dp[0][0][0] = 0;
        dp[0][1][0] = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] + prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
        }
        return dp[n - 1][0][1];


    }

    public static void main(String[] args) {
        new Solution().maxProfit(new int[] {7, 1, 5, 3, 6, 4});
        new Solution().maxProfit(new int[] {7, 6, 4, 3, 2, 1});
    }
}
