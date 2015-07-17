
public class Solution2 {
	public boolean isValidBST(TreeNode root) {
		return valid(root, null, null);
	}
	private boolean valid(TreeNode node, Integer low, Integer high) {
		if(null == node) 
			return true;
		boolean mid = false;
		if(null!=low && null!=high)
			mid = (node.val > low) && (node.val < high);
		else if(null!=low && null==high)
			mid = (node.val > low);
		else if(null==low && null!=high)
			mid = (node.val < high);
		else
			mid = true;
		if(mid)
			return valid(node.left, low, node.val)&&valid(node.right, node.val, high);
		return false;
	}

}
