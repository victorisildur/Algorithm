import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		for(int i=1; i<=n; i++) {
			List<Integer> comb1 = new ArrayList<Integer>();
			comb1.add(i);
			combs.add(comb1);
		}
		for(int i=2; i<=k; i++) {
			List<List<Integer>> newCombsI = new ArrayList<List<Integer>>();
			for(int j=i; j<=n; j++) {
				for(List<Integer> comb : combs) {
					if(j> comb.get(comb.size()-1)) {
						List<Integer> combI = new ArrayList<Integer>(comb);
						combI.add(j);
						newCombsI.add(combI);
					}
				}
			}
			combs = newCombsI;
		}
		return combs;
	}
}
