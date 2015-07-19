import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;

public class SolutionTest {
	Solution sol = new Solution();
	@Test
	public void test() {
		int[] nums = {1,2,3};
		List<List<Integer>> res = sol.permute(nums);
		for(int i=0; i<res.size(); i++) {
			List<Integer> l = res.get(i);
			for(int j=0; j<l.size(); j++) {
				System.out.print(l.get(j));
			}
			System.out.println("---");
		}
	}

}
