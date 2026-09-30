/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/search-in-linked-list-1664434326/1
 * Platform     : GFG
 * Difficulty   : Basic
 */

/* Structure of Linked List Node
class Node {
	int data;
	Node next;
	
	Node(int x) {
		data = x;
		next = null;
	}
} */

class Solution {
	public boolean searchKey(Node head, int key) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == key) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
}

