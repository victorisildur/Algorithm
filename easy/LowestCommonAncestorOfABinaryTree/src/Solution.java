
public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		/* invariant:
		 *   if p in root's left & q in root's right, return root
		 *   if p in root's left, return p 
		 *   if q in root's right, return q
		 *   if p not in root's either side, return null
		*/
		if( root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if( left != null && right != null)
			return root;
		return left != null ? left: right;
	}
}
