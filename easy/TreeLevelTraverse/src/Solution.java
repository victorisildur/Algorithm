import java.util.*;

public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null)
			return res;
		Queue<TreeNodeLvl> q = new LinkedList<>();
		q.offer(new TreeNodeLvl(root, 1));
		while( !q.isEmpty() ) {
			TreeNodeLvl curr = q.poll();
			if(curr.node.left != null)
				q.offer(new TreeNodeLvl(curr.node.left, curr.level+1));
			if(curr.node.right != null)
				q.offer(new TreeNodeLvl(curr.node.right, curr.level+1));
			if(res.size() < curr.level) {
				List<Integer> currlevel = new ArrayList<>();
				currlevel.add(curr.node.val);
				res.add(currlevel);
			} else {
				res.get(curr.level-1).add(curr.node.val);
			}
		}
		return res;
	}
	private class TreeNodeLvl {
		public int level;
		public TreeNode node;
		TreeNodeLvl(TreeNode t, int n) {
			level = n;
			node = t;
		}
	}
}
