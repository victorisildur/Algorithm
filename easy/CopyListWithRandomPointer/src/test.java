import static org.junit.Assert.*;

import org.junit.Test;

public class test {
	
//	@Test
//	public void test() {
//		RandomListNode l1 = new RandomListNode(0);
//		l1.next = new RandomListNode(1);
//		l1.random = new RandomListNode(2);
//		Solution sol = new Solution();
//		RandomListNode res = sol.copyRandomList(l1);
//	}
	@Test
	public void testIter() {
		RandomListNode l1 = new RandomListNode(0);
		l1.next = new RandomListNode(1);
		l1.random = new RandomListNode(2);
		IterSolution sol = new IterSolution();
		RandomListNode res = sol.copyRandomList(l1);
	}
}
