import static org.junit.Assert.*;

import org.junit.Test;


public class test {
	Solution sol = new Solution();
	ListNode head = new ListNode(0);
	
	@Test
	public void test() {
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		TreeNode res = sol.sortedListToBST(head);
	}
	@Test
	public void test2() {
		if(null == null)
			System.out.println("true");
	}

}
