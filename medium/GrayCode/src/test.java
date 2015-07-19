import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class test {
	Solution sol = new Solution();
	@Test
	public void test() {
		List<Integer> res = sol.grayCode(3);
		for(int i=0; i<res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

}
