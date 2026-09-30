/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/print-linked-list-elements/1
 * Platform     : GFG
 * Difficulty   : Basic
 */

/*
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    public ArrayList<Integer> printList(Node head) {
        ArrayList LL = new ArrayList<>();
        Node temp = head;
        while(temp != null){
            LL.add(temp.data);
            temp = temp.next;
        }
        return LL;
    }
}
