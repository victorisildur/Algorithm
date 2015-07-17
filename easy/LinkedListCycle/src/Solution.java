
public class Solution {
	public boolean hasCycle(ListNode head) {
		if(head==null)
			return false;
		ListNode p = head;
		try {
			while(p.next.next!=null && head.next!=null) {
				p = p.next.next;
				head = head.next;
				if(p == head)
					return true;
			}
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
		return false;
	}
}
