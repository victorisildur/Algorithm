
public class Solution {
	public String longestCommonPrefix(String[] strs) {
		String pre = new String();
		if(strs.length == 0)
			return pre;
		for(int i=0; ; i++) {
			if(allSame(strs,i)) {
				pre = pre.concat(Character.toString(strs[0].charAt(i)));
			} else {
				break;
			}
		}
		return pre;
    }
	private boolean allSame(String[] strs, int idx) {
		if(strs[0].length() < idx + 1)
			return false;
		char ch = strs[0].charAt(idx);
		for(int i=1; i<strs.length; i++) {
			if(strs[i].length() < idx + 1)
				return false;
			if(strs[i].charAt(idx) != ch)
				return false;
		}
		return true;
	}
}
