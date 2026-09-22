/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/find-largest-word-in-dictionary2430/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";

        for (String word : d) {
            if (word.length() < longestWord.length() || 
               (word.length() == longestWord.length() && word.compareTo(longestWord) >= 0)) {
                continue; 
            }

            if (isSubsequence(word, s)) {
                longestWord = word;
            }
        }

        return longestWord;
    }

    private boolean isSubsequence(String word, String s) {
        int i = 0, j = 0;
        int wLen = word.length(), sLen = s.length();

        while (i < wLen && j < sLen) {
            if (wLen - i > sLen - j) {
                return false;
            }

            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == wLen;
    }
}
