import java.util.*;

public class Solution {
	public List<String> summaryRanges(int [] nums) {
		if(nums.length == 0)
			return new ArrayList<String>();
		String res = "";
		int oldNum = nums[0] , startNum = oldNum;
		for(int i=1; i<nums.length; i++) {
			if( nums[i] - 1 != oldNum ) {
				res += genRange(startNum, oldNum);
				startNum = nums[i];
			}
			oldNum = nums[i];
		}
		res += genRange(startNum, oldNum);
		return Arrays.asList(res.split(","));
	}
	private String genRange(int a, int b) {
		if(a == b)
			return Integer.toString(a) + ',';
		return Integer.toString(a) + "->" + Integer.toString(b) + ',';
	}
}
