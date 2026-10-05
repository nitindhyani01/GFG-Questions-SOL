/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/your-social-network0328/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        int n = arr.length + 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            ArrayList<int[]> currentPairs = new ArrayList<>();
            int curr = i;
            int links = 0;
            while (curr != 1) {
                curr = arr[curr - 2];
                links++;
                currentPairs.add(new int[] { i, curr, links });
            }
            Collections.sort(currentPairs, (a, b) -> Integer.compare(a[1], b[1]));
            for (int[] pair : currentPairs) {
                ArrayList<Integer> entry = new ArrayList<>();
                entry.add(pair[0]);
                entry.add(pair[1]);
                entry.add(pair[2]);
                result.add(entry);
            }
        }
        return result;
    }
}
