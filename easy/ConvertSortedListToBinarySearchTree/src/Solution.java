
public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		return convert(head,null);
	}
	private TreeNode convert(ListNode start, ListNode end) {
		ListNode p1 = start, p2=p1;
		// goal: start --> end construct a tree
		// invariant: start < end
		if(null == start || start == end)
			return null;
		if(start.next == end)
			return new TreeNode(start.val);
		while(null!=p1 && end!=p2) {
			if(null!=p2.next && end!=p2.next)
				p2 = p2.next.next;
			else
				break;
			p1 = p1.next;
		}
		TreeNode newRoot = new TreeNode(p1.val);
		newRoot.left = convert(start, p1);
		newRoot.right = convert(p1.next, end);
		return newRoot;
	}
}
