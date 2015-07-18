
public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || k <= 1)
			return head;
		ListNode p = head; int n = 0;
		while(p != null) {
			p = p.next;
			n ++;
		}
		if(n<k)
			return head;
		int rounds = n/k;
		p = head;
		ListNode prev = null, next, segHead, segTail = p, segTailNew, newHead=null;
		int i = 0;
		while(i++ < rounds) {
			int j = k;
			segTailNew = p;
			while(j-- > 0) {
				next = p.next;
				p.next = prev;
				prev = p;
				p = next;
			}
			segHead = prev;
			if(i==1) {
				newHead = segHead;
			}
			if(i>1 || rounds==1) {
				segTail.next = segHead;
			}
			if(i==rounds) {
				segTailNew.next = p;
			}
			segTail = segTailNew;
			prev = segTail;
		}
		return newHead;
	}
}
	