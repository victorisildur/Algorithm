
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = new ListNode(0);
		prev.next = head;
		for(int i=0; i<n; i++) {
			fast = fast.next;
		}
		boolean if_rm_head = (fast==null);
		while(fast!= null) {
			slow = slow.next;
			fast = fast.next;
			prev = prev.next;
		}
		if(if_rm_head) {
			return head.next;
		} else {
			ListNode next = slow.next;
			prev.next = next;
			return head;
		}
	}
}
