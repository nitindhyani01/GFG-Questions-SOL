/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/adding-ones3628/1
 * Platform     : GFG
 * Difficulty   : Easy
 */

class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        int[] freq = new int[n + 2];
        for (int j : updates) {
            freq[j]++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        int currentSum = 0;
        for (int i = 1; i <= n; i++) {
            currentSum += freq[i];
            result.add(currentSum);
        }
        return result;
    }
}
