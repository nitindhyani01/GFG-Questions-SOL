/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/range-gcd-queries3654/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    int[] tree;
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public void build(int node, int start, int end, int[] arr) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node + 1, start, mid, arr);
        build(2 * node + 2, mid + 1, end, arr);
        tree[node] = gcd(tree[2 * node + 1], tree[2 * node + 2]);
    }

    public void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (start <= idx && idx <= mid) {
            update(2 * node + 1, start, mid, idx, val);
        } else {
            update(2 * node + 2, mid + 1, end, idx, val);
        }
        tree[node] = gcd(tree[2 * node + 1], tree[2 * node + 2]);
    }

    public int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0; 
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        int p1 = query(2 * node + 1, start, mid, l, r);
        int p2 = query(2 * node + 2, mid + 1, end, l, r);
        return gcd(p1, p2);
    }

    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        tree = new int[4 * n];
        build(0, 0, n - 1, arr);

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            if (type == 0) {
                int l = queries[i][1];
                int r = queries[i][2];
                result.add(query(0, 0, n - 1, l, r));
            } else if (type == 1) { 
                int idx = queries[i][1];
                int val = queries[i][2];
                update(0, 0, n - 1, idx, val);
                arr[idx] = val;
            }
        }
        return result;
    }
}
