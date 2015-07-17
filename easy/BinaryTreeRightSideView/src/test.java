import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;

public class test {
	Solution sol = new Solution();
	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		List<Integer> res = sol.rightSideView(root);
		for(int i=0; i<res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

}
