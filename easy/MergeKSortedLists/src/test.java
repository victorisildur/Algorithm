import static org.junit.Assert.*;

import org.junit.Test;


public class test {
	Solution sol = new Solution();
	@Test
	public void test() {
		ListNode h1 = new ListNode(0);
		h1.next = new ListNode(1);
		ListNode h2 = new ListNode(1);
		h2.next = new ListNode(2);
		ListNode[] lists = new ListNode[2];
		lists[0] = h1;
		lists[1] = h2;
		ListNode res = sol.mergeKLists(lists);
	}

}
