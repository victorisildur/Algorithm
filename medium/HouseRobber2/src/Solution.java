
public class Solution {
	public int rob(int[] nums) {
		int len = nums.length;
		if(len==1)
			return nums[0];
		int max0 = rob(nums, 1, len-1);
		int max1 = rob(nums, 0, len-2);
		return max0>max1? max0: max1;
	}
	private int rob(int[] nums, int begin, int end) {
		int len = end-begin+1;		
		if(len <= 0)
			return 0;
		if(len == 1)
			return nums[begin];
		int [] r = new int[len];
		r[0] = nums[begin];
		r[1] = nums[begin+1];
		for(int i=begin+2; i<=end; i++) {
			int max = r[0];
			for(int j=begin; j<= i-2; j++) {
				if(r[j-begin] > max)
					max = r[j-begin];
			}
			r[i-begin] = nums[i] + max;
		}
		int max = r[0];
		for(int i=1; i<len; i++) {
			if(r[i] > max)
				max = r[i];
		}
		return max;
	}
}
