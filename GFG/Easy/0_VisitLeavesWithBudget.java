/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/leaf-under-budget/1
 * Platform     : GFG
 * Difficulty   : Easy
 */

/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public int getCount(Node root, int k) {
        if (root == null) return 0;

        List<Integer> leafCosts = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 1)); 

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            Node node = curr.node;
            int level = curr.level;

            if (node.left == null && node.right == null) {
                leafCosts.add(level);
            }

            if (node.left != null) {
                queue.add(new Pair(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, level + 1));
            }
        }

        Collections.sort(leafCosts);

        int count = 0;
        int totalCost = 0;

        for (int cost : leafCosts) {
            if (totalCost + cost <= k) {
                totalCost += cost;
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
