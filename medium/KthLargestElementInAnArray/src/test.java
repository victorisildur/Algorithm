import static org.junit.Assert.*;

import org.junit.Test;


public class test {

	@Test
	public void test() {
		Solution sol = new Solution();
		int nums[] = {-1, 0 , 2};
		int k = 2;
		int res = sol.findKthLargest(nums, k);
		System.out.println(res);
	}

}
