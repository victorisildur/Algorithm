
public class Solution {
	public int majorityElement(int [] nums) {
		int major = nums[0], count = 1;
		for(int i=1; i<nums.length; i++) {
			if(major == nums[i])
				count ++;
			else
				count --;
			if(count < 0) {
				major = nums[i];
				count = 1;
			}
		}
		return major;
	}
}
