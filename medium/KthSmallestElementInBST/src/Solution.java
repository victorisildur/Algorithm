public class Solution {
    public int kthSmallest(TreeNode root, int k) {
    	if(root == null)
    		return -1;
    	return helper(root, new Integer(0), k);
    }
    private int helper(TreeNode node, Integer cnt, int k) {
    	if(node == null)
    		return -1;
    	int val = -1;
    	if(node.left != null)
    		val = helper(node.left, cnt, k);
    	if(cnt++ == k)
    		return val;
    	if(cnt == k)
    		return node.val;
    	if(node.right != null)
    		val = helper(node.right, cnt, k);
    	return val;
    }
}