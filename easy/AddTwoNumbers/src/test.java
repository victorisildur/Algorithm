import static org.junit.Assert.*;

import org.junit.Test;


public class test {
	Solution sol = new Solution();
	@Test
	public void test() {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(9);
		ListNode res = sol.addTwoNumbers(l1, l2);
		while(res!=null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}
