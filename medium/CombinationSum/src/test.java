import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class test {

	@Test
	public void test() {
		Solution sol = new Solution();
		int [] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> res = sol.combinationSum(candidates, target);
	}
}