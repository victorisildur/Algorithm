import static org.junit.Assert.*;

import org.junit.Test;


public class test {
	Solution sol = new Solution();
	@Test
	public void test() {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		ListNode res = sol.swapPairs(l1);
		while(res!=null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
