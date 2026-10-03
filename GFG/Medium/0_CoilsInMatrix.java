/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/form-coils-in-a-matrix4726/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
	public ArrayList<ArrayList<Integer>> formCoils(int n) {
		int m = 4 * n;
		ArrayList<Integer> coil1 = new ArrayList<>();
		ArrayList<Integer> coil2 = new ArrayList<>();
		
		int current = 1;
		coil1.add(current);
		
		int[] dirs = {m, 1, -m, -1};
		int dirIdx = 0;
		int step = m - 1;
		for (int i = 0; i < step; i++) {
			current += dirs[dirIdx];
			coil1.add(current);
		}
		dirIdx = (dirIdx + 1) % 4;
		
		int decrement = 2;
		while (m - decrement > 0) {
			step = m - decrement;
			
			for (int i = 0; i < step; i++) {
				current += dirs[dirIdx];
				coil1.add(current);
			}
			dirIdx = (dirIdx + 1) % 4;
			
			for (int i = 0; i < step; i++) {
				current += dirs[dirIdx];
				coil1.add(current);
			}
			dirIdx = (dirIdx + 1) % 4;
			
			decrement += 2;
		}
		int total = m * m + 1;
		for (int x : coil1) {
			coil2.add(total - x);
		}
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result.add(coil1);
		result.add(coil2);
		
		return result;
	}
}

