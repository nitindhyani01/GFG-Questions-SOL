/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/reverse-a-stack/1
 * Platform     : GFG
 * Difficulty   : Medium
 */

class Solution
{ 
    static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        reverseStack(stack);  
        
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        stack.push(top);

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
}
