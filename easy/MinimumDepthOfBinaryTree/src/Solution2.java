
public class Solution2 {
	public int minDepth(TreeNode root) {
		if(null==root) return 0;
		return helper(root);
	}
	private Integer helper(TreeNode node) {
		if(null == node.left && null == node.right)
			return 1;
		else if(null!= node.left && null==node.right)
			return helper(node.left) + 1;
		else if(null==node.left && null!=node.right)
			return helper(node.right) + 1;
		else
			return Math.min(helper(node.left),helper(node.right)) + 1;
	}
}
