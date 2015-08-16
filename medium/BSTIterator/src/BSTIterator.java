import java.util.*;

public class BSTIterator {
	private TreeNode next;
	private Stack<TreeNode> stk = new Stack<TreeNode>();
	public BSTIterator(TreeNode root) {
		next = findLeftMost(root);
	}
	
	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return next != null;
    }

    /** @return the next smallest number */
    public int next() {
    	int res = next.val;
    	next = findNext(next);
    	return res;
    }
    
    private TreeNode findNext(TreeNode curr) {
    	if(curr.right != null) {
    		return findLeftMost(curr.right);
    	} else {
    		if(stk.isEmpty())
    			return null;
    		return stk.pop();
    	}
    }
    
    private TreeNode findLeftMost(TreeNode root) {
    	TreeNode p = root;
		while(p!=null) {
			stk.push(p);
			p = p.left;
		}
		if(stk.isEmpty())
			return null;
		return stk.pop();
    }
}
