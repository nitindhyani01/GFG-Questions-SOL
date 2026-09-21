/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/check-if-all-levels-of-two-trees-are-anagrams-or-not/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();

            if (size1 != size2) return false;

            ArrayList<Integer> level1 = new ArrayList<>();
            ArrayList<Integer> level2 = new ArrayList<>();

            for (int i = 0; i < size1; i++) {
                Node curr1 = q1.poll();
                level1.add(curr1.data);
                if (curr1.left != null) q1.add(curr1.left);
                if (curr1.right != null) q1.add(curr1.right);

                Node curr2 = q2.poll();
                level2.add(curr2.data);
                if (curr2.left != null) q2.add(curr2.left);
                if (curr2.right != null) q2.add(curr2.right);
            }

            Collections.sort(level1);
            Collections.sort(level2);

            if (!level1.equals(level2)) {
                return false;
            }
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}
