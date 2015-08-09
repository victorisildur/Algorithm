import java.util.*;

public class Solution {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		if(s.length() == 0)
			return res;
		List<String> curr = new ArrayList<String>();
		backtrace(res, curr, 0, s);
		return res;
	}

	private void backtrace(List<List<String>> res, List<String> curr, int start, String s) {
		if(start >= s.length()) {
			res.add(new ArrayList<String>(curr));
			return;
		}
		for(int i=start; i<s.length(); i++) {
			if( isPalindrome(s, start, i) ) {
				curr.add(s.substring(start, i+1));
				backtrace(res, curr, i+1, s);
				curr.remove(curr.size()-1);
			}
		}		
	}
	
	private boolean isPalindrome(String str, int start , int end) {
		for(int i=start, j=end; i<j; i++,j--) {
			if(str.charAt(i) != str.charAt(j))
				return false;
		}
		return true;
	}
}
