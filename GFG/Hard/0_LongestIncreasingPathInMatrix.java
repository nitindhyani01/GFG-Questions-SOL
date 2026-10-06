/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/longest-increasing-path-in-a-matrix/1
 * Platform     : GFG
 * Difficulty   : Hard
 */

class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longIncPath(int[][] matrix, int n, int m) {
        if (matrix == null || n == 0 || m == 0) return 0;
        int[][] dp = new int[n][m];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, n, m, dp));
            }
        }
        return maxLen;
    }
    private int dfs(int[][] matrix, int r, int c, int n, int m, int[][] dp) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }
        int maxPath = 1;
        for (int[] dir : DIRECTIONS) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[nr][nc] > matrix[r][c]) {
                maxPath = Math.max(maxPath, 1 + dfs(matrix, nr, nc, n, m, dp));
            }
        }
        dp[r][c] = maxPath;
        return maxPath;
    }
}
