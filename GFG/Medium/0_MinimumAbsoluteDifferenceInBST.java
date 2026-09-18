/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/minimum-absolute-difference-in-bst-1665139652/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private int minDiff;
    private Integer prevValue;

    public int absDiff(Node root) {
        minDiff = Integer.MAX_VALUE;
        prevValue = null;
        inorderTraversal(root);
        return minDiff;
    }

    private void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        if (prevValue != null) {
            minDiff = Math.min(minDiff, node.data - prevValue);
        }
        prevValue = node.data;

        inorderTraversal(node.right);
    }
}
