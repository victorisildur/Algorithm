
public class Solution {
	/* @param root {TreeNode} : root of the tree
	 * this method only ganrantee sub tree is BST
	 * not test if subtree is all lt/gt root!
	 */
	public boolean isValidBST(TreeNode root) {
		if(null==root) {
			return false;
		}
		if(root.left!=null && root.right!=null) {
			boolean mid = (root.val < root.right.val) && (root.val > root.left.val); 
			if(mid)
				return isValidBST(root.left) && isValidBST(root.right);
			return false;
		} else if(root.left!=null && root.right==null) {
			if(root.val > root.left.val)
				return isValidBST(root.left);
			return false;
		} else if(root.left==null && root.right!=null) {
			if(root.val < root.right.val)
				return isValidBST(root.right);
			return false;
		} else {
			return true;
		}
	}
}
