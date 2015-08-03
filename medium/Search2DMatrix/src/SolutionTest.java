import static org.junit.Assert.*;

import org.junit.Test;


public class SolutionTest {

	@Test
	public void test() {
		int [][] matrix = new int[1][];
		matrix[0] = new int[2];
		matrix[0][0] = 1;
		matrix[0][1] = 3;
		Solution sol = new Solution();
		sol.searchMatrix(matrix, 3);
	}

}
