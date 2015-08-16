import static org.junit.Assert.*;

import org.junit.Test;


public class test {

	@Test
	public void test() {
		Solution sol = new Solution();
		int [] nums = {1,2,3,1};
		int res = sol.findPeakElement(nums);
		System.out.println(res);
	}

}
