/**
 * 简单的 dp 问题
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0 || dp[i - coins[j]] == -1) {
                    continue;
                }
                min = Math.min(min, dp[i - coins[j]] + 1);
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min;
            }
        }
        return dp[amount];
    }
}