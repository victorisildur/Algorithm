import static org.junit.Assert.*;

import org.junit.Test;


public class test {
	Solution sol = new Solution();

	@Test
	public void test() {
		ListNode head = new ListNode(1);
		head.next = head;
		sol.hasCycle(head);
	}

}
