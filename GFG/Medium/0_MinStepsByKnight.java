/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/steps-by-knight5927/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
	public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
		if (knightPos[0] == targetPos[0] && knightPos[1] == targetPos[1]) {
			return 0;
		}
		int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
		int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {knightPos[0], knightPos[1], 0});
		boolean[][] visited = new boolean[n + 1][n + 1];
		visited[knightPos[0]][knightPos[1]] = true;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int x = curr[0];
			int y = curr[1];
			int steps = curr[2];
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx == targetPos[0] && ny == targetPos[1]) {
					return steps + 1;
				}
				if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny, steps + 1});
				}
			}
		}
		return - 1;
	}
}

