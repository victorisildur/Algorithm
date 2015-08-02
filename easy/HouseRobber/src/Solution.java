
public class Solution {
	public int rob(int nums[]) {
		int len = nums.length;
		int [] r = new int [len];
		if(len == 0)
			return 0;
		if(len == 1)
			return nums[0];
		r[0] = nums[0]; r[1] = nums[1];
		for(int i=2; i<len; i++) {
			int max = r[0];
			for(int j=0; j<=i-2; j++) {
				if(r[j] > max)
					max = r[j];
			}
			r[i] = nums[i] + max;
		}
		int max = r[0];
		for(int i=0; i<len; i++) {
			if(r[i] > max)
				max = r[i];
		}
		return max;
	}
}
