/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/minimum-edges/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    class Node {
        int v, cost;
        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(new Node(v, 0));
            adj.get(v).add(new Node(u, 1));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<Integer> deque = new LinkedList<>();
        dist[src] = 0;
        deque.addFirst(src);

        while (!deque.isEmpty()) {
            int u = deque.pollFirst();

            if (u == dst) {
                return dist[dst];
            }

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.v;
                int weight = neighbor.cost;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    if (weight == 0) {
                        deque.addFirst(v);
                    } else {
                        deque.addLast(v);
                    }
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
