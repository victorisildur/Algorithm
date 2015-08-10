
public class Solution {
	public void deleteNode(ListNode node) {
		if(node == null)
			return;
		ListNode next = node.next;
		ListNode old = node;
		while(next != null) {
			node.val = next.val;
			old = node;
			node = next;
			next = node.next;
		}
		old.next = null;
	}
}