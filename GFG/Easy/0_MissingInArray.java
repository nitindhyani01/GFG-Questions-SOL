/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1
 * Platform     : GFG
 * Difficulty   : Easy
 */

class Solution {
    int missingNum(int arr[]) {
        int n = arr.length + 1; 

        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }
        return (int) (expectedSum - actualSum);
    }
}
