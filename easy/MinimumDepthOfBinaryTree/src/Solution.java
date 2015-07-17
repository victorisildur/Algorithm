
public class Solution {
	public int minDepth(TreeNode root) {
		if(null == root) return 0;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
}
