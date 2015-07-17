import static org.junit.Assert.*;

import org.junit.Test;


public class SolutionTest {
	Solution sol = new Solution();
	@Test
	public void test() {
		String s = new String("1*2-3/4+5*6-7*8+9/10");
		int result = sol.calculate(s);
		System.out.println(result);
	}

}
