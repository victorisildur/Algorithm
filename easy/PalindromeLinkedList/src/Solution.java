
public class Solution {
	public boolean isPalindrome(ListNode head) {
		if(head == null)
			return true;
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy, curr = copy(head), next;
		while(curr!=null) {
			next = copy(curr.next);
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		while(head != null) {
			if(head.val != prev.val)
				return false;
			head = head.next;
			prev = prev.next;
		}
		return true;
	}
	private ListNode copy(ListNode node) {
		if(node == null)
			return null;
		ListNode newNode = new ListNode(node.val);
		newNode.next = node.next;
		return newNode;
	}
}
