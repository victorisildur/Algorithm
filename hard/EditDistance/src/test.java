
import org.junit.Test;


public class test {
	Solution sol = new Solution();
	@Test
	public void test() {
		String s1 = "snowy";
		String s2 = "snowy";
		int dis = sol.minDistance(s1, s2);
		System.out.println(dis);
	}

}
