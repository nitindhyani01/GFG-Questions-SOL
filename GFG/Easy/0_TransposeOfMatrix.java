/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/transpose-of-matrix-1587115621/1
 * Platform     : GFG
 * Difficulty   : Easy
 */

class Solution {
	public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
		ArrayList<ArrayList<Integer>> tMat = new ArrayList<>();
		for (int i = 0; i < mat.length; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			for (int j = 0; j < mat[0].length; j++) {
				row.add(mat[j][i]);
			}
			tMat.add(row);
		}
		return tMat;
	}
}

