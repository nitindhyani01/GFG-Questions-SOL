/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/roll-the-characters-of-a-string2127/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    public String findRollOut(String s, int[] roll) {
        int n = s.length();
        int[] freq = new int[n + 2];

        for (int r : roll) {
            freq[r]++;
        }
        int[] totalRolls = new int[n];
        int currentRolls = 0;
        for (int i = n; i >= 1; i--) {
            currentRolls += freq[i];
            totalRolls[i - 1] = currentRolls;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int shifts = totalRolls[i] % 26;
            chars[i] = (char) ('a' + (chars[i] - 'a' + shifts) % 26);
        }
        return new String(chars);
    }
}
