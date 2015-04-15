package maximumSumSubArray;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

import java.util.List;
public class test {
	Solution sol = new Solution();
	@Test
	public void test() {
		List<Integer> nums = new ArrayList();
		nums.add(2);nums.add(1);nums.add(-3);nums.add(4);
		nums.add(-1);nums.add(2);nums.add(1);nums.add(-5);
		nums.add(4);
		System.out.println( sol.maxSubArray(nums) );
	}

}
