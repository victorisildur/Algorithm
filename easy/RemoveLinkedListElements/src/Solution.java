
public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0), prev = dummy;
		dummy.next = head;
		while(head != null) {
			if(head.val == val) {
				prev.next = head.next;
			} else {
			    prev = prev.next;
			}
			head = head.next;
		}
		return dummy.next;
    }
}
