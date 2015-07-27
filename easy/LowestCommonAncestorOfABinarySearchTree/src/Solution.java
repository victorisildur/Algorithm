import java.util.Queue;
import java.util.ArrayDeque;

public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null)
			return null;
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if( node.val >= Math.min(p.val, q.val) && node.val <= Math.max(p.val, q.val) ) {
				return node;
			}
			if( node.left != null)
				queue.add(node.left);
			if( node.right != null)
				queue.add(node.right);
		}
		return null;
    }
}
