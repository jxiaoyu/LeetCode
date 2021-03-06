/**
 * dp, 要注意 0 的处理
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        
        int[] dp = new int[s.length()];
        dp[0] = 1;
        
        int val = Integer.parseInt(s.substring(0, 2));
        if (s.charAt(1) == '0') {
            if (val < 26) {
                dp[1] = 1;
            } else {
                dp[1] = 0;
            }
        } else if (val > 26) {
            dp[1] = 1;
        } else {
            dp[1] = 2;
        }
        
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i-1];
            }
            val = Integer.parseInt(s.substring(i - 1, i + 1));
            if (val <= 26 && val >= 10) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length() - 1];
    }
}