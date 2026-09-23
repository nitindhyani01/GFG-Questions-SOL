/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/pyramid-form3044/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = Math.min(1, arr[0]);
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i - 1] + 1, arr[i]);
        }

        right[n - 1] = Math.min(1, arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1] + 1, arr[i]);
        }

        long max_h = 0;
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            max_h = Math.max(max_h, Math.min(left[i], right[i]));
        }

        long cost = totalSum - (max_h * max_h);

        return (int) cost;
    }
}
