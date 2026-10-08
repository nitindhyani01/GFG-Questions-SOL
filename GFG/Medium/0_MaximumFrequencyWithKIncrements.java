/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/maximum-frequency-1662528911/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        long currentSum = 0;
        int left = 0;
        int maxFreq = 0;

        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];
            while ((long) (right - left + 1) * arr[right] - currentSum > k) {
                currentSum -= arr[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}
