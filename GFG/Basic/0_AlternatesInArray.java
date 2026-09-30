/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/print-alternate-elements-of-an-array/1
 * Platform     : GFG
 * Difficulty   : Basic
 */

class Solution {
    public ArrayList<Integer> getAlternates(int arr[]) {
        int i = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<arr.length){
            ans.add(arr[i]);
            i +=2;
        }
        return ans;
    }
}
