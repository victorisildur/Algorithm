
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1=l1,p2=l2,p,pre=new ListNode(0),head=pre;
		int overflow = 0;
		while(p1!=null || p2!=null) {
			// invariant : p = sum current bit, p1 = l1 current bit, p2 = l2 current bit
			int Dp=0, Dp1=0, Dp2=0;
			if(p1!=null && p2!=null) {
				Dp1 = p1.val;
				Dp2 = p2.val;
				p1 = p1.next;
				p2 = p2.next;
			} else if(p1!=null && p2==null) {
				Dp1 = p1.val;
				p1 = p1.next;
			} else {
				Dp2 = p2.val;
				p2 = p2.next;
			} 
			Dp = (Dp1+Dp2+overflow)%10;
			overflow = (Dp1+Dp2+overflow)/10 > 0? 1:0;
			p = new ListNode(Dp);
			pre.next = p;
			pre = p;
		}
		if(overflow > 0){
			p = new ListNode(overflow);
			pre.next = p;
		}
		return head.next;
	}
}
