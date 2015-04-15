package maximumSumSubArray;
import java.util.List;

public class Solution {
	// f(k) is max sum that ENDS at index k
	// f(k) = max{ f(k-1) + a[k] , a[k] }
	// use a max so far to main the biggest of f(k)
	public int maxSubArray(List<Integer> nums) {
		int maxEndingHere = nums.get(0);
		int maxSoFar = nums.get(0);
		for(int i=1;i<nums.size();i++) {
			maxEndingHere = Math.max( maxEndingHere+nums.get(i), nums.get(i) );
			maxSoFar = Math.max( maxEndingHere , maxSoFar);
		}
		return maxSoFar;
	}
}
