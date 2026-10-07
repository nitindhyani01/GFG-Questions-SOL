/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
 * Platform     : GFG
 * Difficulty   : Hard
 */

/* Node Structure
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    private int maxSum;

    public int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        int res = maxPathSumUtil(root);
        if (maxSum == Integer.MIN_VALUE) {
            return -1;
        }
        return maxSum;
    }
    private int maxPathSumUtil(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.data;
        }
        int leftSum = maxPathSumUtil(node.left);
        int rightSum = maxPathSumUtil(node.right);
        if (node.left != null && node.right != null) {
            maxSum = Math.max(maxSum, leftSum + rightSum + node.data);
            return node.data + Math.max(leftSum, rightSum);
        }
        if (node.left != null) {
            return node.data + leftSum;
        }
        return node.data + rightSum;
    }
}
