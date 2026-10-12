/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/squares-in-reactangle3340/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    public int minSquares(int n, int m) {
        int count = 0;
        while (n > 0 && m > 0) {
            if (n < m) {
                int temp = n;
                n = m;
                m = temp;
            }
            count += n / m;
            n = n % m;
        }
        return count;
    }
}
