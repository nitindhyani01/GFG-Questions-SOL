/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/minimum-cost-to-make-two-strings-identical1107/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
	public int findMinCost(String s1, String s2, int costS1, int costS2) {
		int n = s1.length();
		int m = s2.length();
		
		int[] prev = new int[m + 1];
		int[] curr = new int[m + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					curr[j] = 1 + prev[j - 1];
				} else {
					curr[j] = Math.max(prev[j], curr[j - 1]);
				}
			}
			
			int[] temp = prev;
			prev = curr;
			curr = temp;
		}
		
		int lcsLength = prev[m];
		
		return (n - lcsLength) * costS1 + (m - lcsLength) * costS2;
	}
}

