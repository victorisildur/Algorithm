
public class Solution {
	public void sortColors(int [] nums) {
		int end0 = partition(nums, 0, 0);
		partition(nums, 1, end0);
	}
	private int partition(int [] nums, int target, int start) {
		if(start >= nums.length-1)
			return nums.length-1;
		// start -- s, nums[s] <= target
		int s = start;
		while(s < nums.length && nums[s] > target) {
			s++;
		}
		if(s == nums.length)
			return start;
		swap(nums,start,s);
		int t = s+1;
		s = start;
		// t -- end , nums[t] > target
		for(; t<nums.length; t++) {
			if(nums[t] <= target) {
				swap(nums,t,s+1);
				s++;
			}
		}
		return s+1;
	}
	private void swap(int [] nums, int i, int j) {
		if(i==j)
			return;
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
