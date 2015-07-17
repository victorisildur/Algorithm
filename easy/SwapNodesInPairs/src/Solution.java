
public class Solution {
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0), pre = dummy, p1, p2;
		dummy.next = head;
		p1 = head;
		if(p1 == null) {
			return null;
		}
		p2 = head.next;
		while(p1!=null && p2!=null) {
			// swap p1,p2
			ListNode post = p2.next;
			pre.next = p2;
			p2.next = p1;
			p1.next = post;
			pre = p1;
			p1 = pre.next;
			if(p1==null)
				break;
			p2 = p1.next;
		}
		return dummy.next;
	}
}
