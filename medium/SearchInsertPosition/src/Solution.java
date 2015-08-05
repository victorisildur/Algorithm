
public class Solution {
	public int searchInsert(int[] nums, int target) {
		int i = 0, j=nums.length-1;
		boolean upper = false;
		while(i<=j) {
			int mid = (i+j)/2;
			if(nums[mid] > target) {
				j = mid-1;
				upper = false;
			} else if (nums[mid] < target) {
				i = mid+1;
				upper = true;
			} else {
				return mid;
			}
		}
		if(upper)
			return i;
		else
			return j+1;
	}
}
