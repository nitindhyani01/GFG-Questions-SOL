/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/lexicographically-smallest-string--151951/1
 * Platform     : GFG
 * Difficulty   : Hard
 */

class Solution {
    public String lexiString(String s) {
        int n = s.length();
        int i = 0, j = 1, k = 0;
        
        while (i < n && j < n && k < n) {
            char c1 = s.charAt((i + k) % n);
            char c2 = s.charAt((j + k) % n);
            
            if (c1 == c2) {
                k++;
            } else {
                if (c1 > c2) {
                    i = i + k + 1;
                } else {
                    j = j + k + 1;
                }
                if (i == j) {
                    j++;
                }
                k = 0;
            }
        }
        int minIndex = Math.min(i, j);
        return s.substring(minIndex) + s.substring(0, minIndex);
    }
}
