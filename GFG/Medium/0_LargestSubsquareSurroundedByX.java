/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/largest-subsquare-surrounded-by-x0558/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
	int largestSubsquare(char mat[][]) {
		int n = mat.length;
		if (n == 0)
			return 0;
		
		int[][] top = new int[n][n];
		int[][] left = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 'X') {
					top[i][j] = (i == 0) ? 1 : top[i - 1][j] + 1;
					left[i][j] = (j == 0) ? 1 : left[i][j - 1] + 1;
				} else {
					top[i][j] = 0;
					left[i][j] = 0;
				}
			}
		}
		
		int maxSize = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int size = Math.min(top[i][j], left[i][j]);
				while (size > maxSize) {
					if (top[i][j - size + 1] >= size && left[i - size + 1][j] >= size) {
						maxSize = size;
						break;
					}
					size--;
				}
			}
		}
		return maxSize;
	}
}

