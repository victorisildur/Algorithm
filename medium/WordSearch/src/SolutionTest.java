import static org.junit.Assert.*;

import org.junit.Test;


public class SolutionTest {

	@Test
	public void test() {
		char [][] board = {{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}};
		String word = "aaaaaaaaaaaaa";
		Solution sol = new Solution();
		System.out.println( sol.exist(board, word) );
	}

}
