
public class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
		return convert(nums, 0 , nums.length-1);
	}
	private TreeNode convert(int[] nums, int start, int end) {
		if(start > end)
			return null;
		if(start == end)
			return new TreeNode(nums[start]);
		int mid = (start+end)/2;
		TreeNode newRoot = new TreeNode(nums[mid]);
		newRoot.left = convert(nums, start, mid-1);
		newRoot.right = convert(nums, mid+1, end);
		return newRoot;
	}
}
