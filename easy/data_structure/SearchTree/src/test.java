import static org.junit.Assert.*;

import org.junit.Test;


public class test {
	BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
	@Test
	public void test() {
		bst.insert(2);
		bst.insert(3);
		bst.insert(1);
	}

}
