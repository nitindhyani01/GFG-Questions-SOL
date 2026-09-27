/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/longest-colored-path--151454/1
 * Platform     : GFG
 * Difficulty   : Hard
 */

class Solution {
	public int longestPath(String s, int[][] edges) {
		int n = s.length();
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		
		List<Integer>[] adj = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adj[i] = new ArrayList<>();
		for (int[] edge : edges) {
			int u = edge[0] - 1;
			int v = edge[1] - 1;
			adj[u].add(v);
			adj[v].add(u);
		}
		
		int[] maxDist = new int[n];
		boolean[] visited = new boolean[n];
		int maxPure = 0;
		
		int[] distTemp = new int[n];
		int[] distY = new int[n];
		int[] distZ = new int[n];
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				List<Integer> comp = new ArrayList<>();
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				visited[i] = true;
				char color = s.charAt(i);
				
				while (!q.isEmpty()) {
					int curr = q.poll();
					comp.add(curr);
					for (int next : adj[curr]) {
						if (!visited[next] && s.charAt(next) == color) {
							visited[next] = true;
							q.add(next);
						}
					}
				}
				
				if (comp.size() == 1) {
					maxDist[i] = 1;
					maxPure = Math.max(maxPure, 1);
				} else {
					int y = bfsDistances(i, adj, s, color, comp, distTemp)[0];
					
					int[] resZ = bfsDistances(y, adj, s, color, comp, distY);
					int z = resZ[0];
					int diameterEdges = resZ[1];
					
					bfsDistances(z, adj, s, color, comp, distZ);
					
					maxPure = Math.max(maxPure, diameterEdges + 1);
					
					for (int node : comp) {
						maxDist[node] = Math.max(distY[node], distZ[node]) + 1;
					}
				}
			}
		}
		
		int ans = maxPure;
		
		for (int[] edge : edges) {
			int u = edge[0] - 1;
			int v = edge[1] - 1;
			if (s.charAt(u) != s.charAt(v)) {
				ans = Math.max(ans, maxDist[u] + maxDist[v]);
			}
		}
		return ans;
	}
	
	private int[] bfsDistances(int start, List<Integer>[] adj, String s, char color, List<Integer> comp, int[] dist) {
		Queue<Integer> q = new LinkedList<>();
		for (int node : comp) {
			dist[node] = -1;
		}
		
		q.add(start);
		dist[start] = 0;
		int farthestNode = start;
		int maxD = 0;
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (dist[curr] > maxD) {
				maxD = dist[curr];
				farthestNode = curr;
			}
			for (int next : adj[curr]) {
				if (s.charAt(next) == color && dist[next] == -1) {
					dist[next] = dist[curr] + 1;
					q.add(next);
				}
			}
		}
		return new int[] {farthestNode, maxD};
	}
}

