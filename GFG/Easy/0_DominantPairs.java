/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/dominant-pairs/1
 * Platform     : GFG
 * Difficulty   : Easy
 */

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int mid = n / 2;

        int[] firstHalf = new int[mid];
        for (int i = 0; i < mid; i++) {
            firstHalf[i] = arr[i];
        }
        java.util.Arrays.sort(firstHalf);

        int[] secondHalf = new int[n - mid];
        for (int i = mid; i < n; i++) {
            secondHalf[i - mid] = arr[i];
        }
        java.util.Arrays.sort(secondHalf);

        int count = 0;
        int j = 0;

        for (int i = 0; i < mid; i++) {
            while (j < secondHalf.length && firstHalf[i] >= 5 * secondHalf[j]) {
                j++;
            }
            count += j;
        }

        return count;
    }
}
