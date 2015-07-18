
import org.junit.Test;


public class test {
	Solution sol = new Solution();
	@Test
	public void test() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		
		ListNode newHead = sol.reverseKGroup(head, 2);
		while(newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}

}
