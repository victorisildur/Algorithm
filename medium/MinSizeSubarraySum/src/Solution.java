
public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		int N = nums.length;
		if(N == 0)
			return 0;
		int [] sums = new int[N];
		int [] lens = new int[N];
		sums[0] = nums[0];
		lens[0] = sums[0]>=s?1:0;
		int minLen = lens[0];
		for(int i=1;i<N;i++) {
			if(lens[i-1]==0) {
				if(sums[i-1]+nums[i]<s) {
					sums[i] = sums[i-1] + nums[i];
					lens[i] = 0;
				} else {
					for(int j=i, endSum=0; j>=0; j--){
						endSum += nums[j];
						if(endSum >= s) {
							sums[i] = endSum;
							lens[i] = i-j+1;
							break;
						}
					}
				}
			} else {
				int start = i - lens[i-1];
				if(nums[i] < nums[start]) {
					if(sums[i-1] + nums[i] - nums[start] < s) {
						lens[i] = lens[i-1] + 1;
						sums[i] = sums[i-1] + nums[i];
					} else {
						lens[i] = lens[i-1];
						sums[i] = sums[i-1] + nums[i] - nums[start];
					}
				} else {
					for(int j=0, startSum = 0; j<lens[i-1]; j++) {
						startSum += nums[start+j];
						if(startSum > nums[i]) {
							j--;
							lens[i] = lens[i-1] - j;
							sums[i] = sums[i-1] + nums[i] - (startSum - nums[start+j+1]);
							break;
						}
					}
				}
			}
			if(lens[i] != 0) {
				if(minLen != 0) {
					minLen = Math.min(lens[i], minLen);
				} else {
					minLen = lens[i];
				}
			}
		}
		return minLen;
	}
}
