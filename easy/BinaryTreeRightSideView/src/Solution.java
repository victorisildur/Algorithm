import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Deque<DepthNode> q = new ArrayDeque<DepthNode>();
		q.add(new DepthNode(root, 1));
		while(!q.isEmpty()) {
			DepthNode curr = q.poll();
			if(curr.node.right != null)
				q.add(new DepthNode(curr.node.right, curr.depth+1)); 
			if(curr.node.left != null)
				q.add(new DepthNode(curr.node.left, curr.depth+1));
			if(res.size() < curr.depth)
				res.add(curr.node.val);
		}
		return res;
	}
	
	private class DepthNode {
		public TreeNode node;
		public Integer depth;
		DepthNode(TreeNode treeNode, Integer depthNum) {
			node = treeNode;
			depth = depthNum;
		}
	}
}
