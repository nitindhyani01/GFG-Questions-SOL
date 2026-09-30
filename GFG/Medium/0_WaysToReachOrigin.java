/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/paths-to-reach-origin3850/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    public int ways(int x, int y) {
        int mod = 1000000007;
        int[][] dp = new int[x + 1][y + 1];

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
                }
            }
        }

        return dp[x][y];
    }
}
