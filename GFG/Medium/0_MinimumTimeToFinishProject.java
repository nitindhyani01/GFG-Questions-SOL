/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/project-manager--141631/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (int[] dep : dependencies) {
            int u = dep[0];
            int v = dep[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] maxTime = new int[n];
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                maxTime[i] = duration[i];
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;
            for (int v : adj.get(u)) {
                maxTime[v] = Math.max(maxTime[v], maxTime[u] + duration[v]);
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        if (count != n) {
            return -1; 
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, maxTime[i]);
        }
        return ans;
    }
}
