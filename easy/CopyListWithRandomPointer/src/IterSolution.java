import java.util.Map;
import java.util.HashMap;

public class IterSolution {
	private Map<RandomListNode, RandomListNode> nodes = new HashMap<RandomListNode,RandomListNode>();
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode dummy = new RandomListNode(0), p=head, q=dummy;
		while(p!=null) {
			q.next = new RandomListNode(p.label); 
			nodes.put(p, q.next);
			q = q.next;
			p = p.next;
		}
		q = dummy.next; p = head;
		while(p!=null) {
			if(nodes.containsKey(p))
				q.random = nodes.get(p); 
			else
				q.random = new RandomListNode(p.label);
			q = q.random;
			p = p.random;
		}
		return dummy.next;
	}
}
