
public class Solution {
	public void rotate(int[] nums, int k) {
		if(nums.length <=1)
			return;
		k = k%nums.length;
		rotate(nums, 0, nums.length-1);
		rotate(nums, 0, k-1);
		rotate(nums, k, nums.length-1);
	}
	private void rotate(int[] nums, int i, int j) {
		while( i< j ) {
			int tmp = nums[i];
			nums[i++] = nums[j];
			nums[j--] = tmp;
		}
	}
}
