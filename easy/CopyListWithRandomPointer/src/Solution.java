import java.util.Map;
import java.util.HashMap;
public class Solution {
	private Map<RandomListNode,RandomListNode> nodes = new HashMap<RandomListNode,RandomListNode>();
	private RandomListNode copySubList(RandomListNode node) {
		if(node==null)
			return null;
		if(nodes.containsKey(node))
			return nodes.get(node);
		RandomListNode newNode = new RandomListNode(node.label);
		newNode.next = copySubList(node.next);
		newNode.random = copySubList(node.random);
		nodes.put(node, newNode);
		return newNode;
	}
	public RandomListNode copyRandomList(RandomListNode head) {
		return copySubList(head);
	}
}
