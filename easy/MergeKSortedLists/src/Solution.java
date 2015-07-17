
public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		int len = lists.length;
		if(len<=0)
			return null;
		return mergeListsByIndex(lists,0,len-1); 
	}
	private ListNode mergeListsByIndex(ListNode[] lists, int start, int end) {
		if(end-start <= 0) {
			return lists[end];
		} else if (end-start==1) {
			return mergeTwoLists(lists[start],lists[end]);
		}
		int mid = start + (end-start)/2;
		ListNode head1 = mergeListsByIndex(lists,start,mid);
		ListNode head2 = mergeListsByIndex(lists,mid+1, end);
		return mergeTwoLists(head1,head2);
	}
	private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
		ListNode p1 = head1, p2 = head2;
		ListNode head = new ListNode(0), p = head;
		while(p1!=null && p2!=null) {
			boolean isP1Less = (p1.val<p2.val);
			int val = isP1Less ? p1.val:p2.val;
			p.next = new ListNode(val);
			p = p.next;
			p1 = isP1Less?p1.next:p1;
			p2 = isP1Less?p2:p2.next;
		}
		if(p1!=null || p2!=null) {
			p1 = p1!=null?p1:p2;
			while(p1!=null) {
				p.next = new ListNode(p1.val);
				p = p.next;
				p1 = p1.next;
			}
		}
		return head.next;
	}
}
