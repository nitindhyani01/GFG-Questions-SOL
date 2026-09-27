/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/pizza-mania0155/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        int[] dp = new int[x + 1];

        for (int i = 1; i <= x; i++) {
            int costSmall = (i <= s) ? cs : dp[i - s] + cs;
            int costMedium = (i <= m) ? cm : dp[i - m] + cm;
            int costLarge = (i <= l) ? cl : dp[i - l] + cl;

            dp[i] = Math.min(costSmall, Math.min(costMedium, costLarge));
        }

        return dp[x];
    }
}
