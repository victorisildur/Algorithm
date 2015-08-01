import java.util.List;
import java.util.ArrayList;

public class Solution {
	public String getPermutation(int n, int k) {
		List<Integer> perm = new ArrayList<Integer>();
		perm.add(1);
		for(int i=2; i<=n; i++) {
			int pos = (k-1) % i;
			perm.add(pos, i);
		}
		String res = "";
		for(Integer item : perm) {
			res += item.toString(); 
		}
		return res;
	}
}
