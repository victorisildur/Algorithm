import static org.junit.Assert.*;

import org.junit.Test;


public class testMinSizeSubarraySum {

	@Test
	public void test() {
		Solution sol = new Solution();
		int[] nums = {1,4,4};
		int res = sol.minSubArrayLen(4, nums);
		System.out.println(res);
	}

}
