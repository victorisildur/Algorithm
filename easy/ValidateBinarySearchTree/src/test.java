import static org.junit.Assert.*;

import org.junit.Test;


public class test {
	Solution sol = new Solution();
	TreeNode root = new TreeNode(2147483647);
	Solution2 sol2 = new Solution2();
	@Test
	public void test() {
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		System.out.println(sol.isValidBST(root));
	}
	@Test
	public void testSol2() {
		System.out.println(sol2.isValidBST(root));	
	}
	
}
