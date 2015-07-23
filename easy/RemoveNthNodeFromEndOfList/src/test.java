import static org.junit.Assert.*;

import org.junit.Test;


public class test {

	@Test
	public void test() {
		Solution sol = new Solution();
		ListNode head = new ListNode(4);
		head.next = new ListNode(3);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		ListNode res = sol.removeNthFromEnd(head, 4);
		while(res!=null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
