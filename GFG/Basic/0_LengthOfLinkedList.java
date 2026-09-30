/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/count-nodes-of-linked-list/1
 * Platform     : GFG
 * Difficulty   : Basic
 */

/* Structure of linked list Node
class Node {
	int data;
	Node next;
	
	Node(int a) {
		data = a;
		next = null;
	}
}
*/
class Solution {
	public int getCount(Node head) {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
}

