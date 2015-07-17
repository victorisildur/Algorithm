
public class Solution {
	public boolean isBalanced(TreeNode root) {
		return ( helper(root) > 0 );
	}
	private int helper(TreeNode node) {
		if(null==node)
			return 0;
		int ld = helper(node.left), rd = helper(node.right);
		if(ld<0 || rd<0)
			return -1;
		if( Math.abs(ld-rd)<=1 )
			return Math.max(ld,rd)+1;
		else
			return -1;
	}
}
