
public class Solution {
    public ListNode reverseList(ListNode head) {
    	if(head == null)
    		return null;
    	ListNode dummy = new ListNode(0), prev = dummy, curr = head;
    	while(curr!=null) {
    		ListNode next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	head.next = null;
    	return prev;
    }
}
