import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;

public class test {

	@Test
	public void test() {
		Solution sol = new Solution();
		int [] nums = {9,0,3,5,7};
		sol.quicksort(nums, 0, nums.length-1);
	}

}
