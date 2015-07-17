import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;


public class test {
	Solution sol = new Solution();
	int[][] matrix;
	@Test
	public void test() {
		matrix = new int[][]{ {1,2,3},{4,5,6},{7,8,9} };
		List<Integer> res = sol.spiralOrder(matrix);
		for(Integer item : res)
			System.out.println(item);
	}

}
