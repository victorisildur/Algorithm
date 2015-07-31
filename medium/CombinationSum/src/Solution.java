import java.util.List;
import java.util.ArrayList;

public class Solution {
	private int sum(List<Integer> comb) {
		int sum = 0;
		for(int i=0; i<comb.size(); i++) {
			sum += comb.get(i);
		}
		return sum;
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> combs = new ArrayList<>();
		int minCandidate = Integer.MAX_VALUE;
		for(int i=0; i<candidates.length; i++) {
			List<Integer> comb1 = new ArrayList<>();
			comb1.add(candidates[i]);
			combs.add(comb1);
			if(candidates[i] < minCandidate) {
				minCandidate = candidates[i];
			}
		}
		int maxRounds = target/minCandidate;
		for(int i=2; i<=maxRounds; i++) {
			List<List<Integer>> combsI = new ArrayList<>();
			for( List<Integer> comb: combs ) {
				int maxInComb = comb.get(comb.size()-1);
				for(int j=0; j<candidates.length; j++) {
					if( sum(comb) == target ) {
						combsI.add(comb);
						break;
					}
					if( candidates[j] >= maxInComb ) {
						if( sum(comb) + candidates[j] <= target) {
							List<Integer> combI = new ArrayList<>(comb);
							combI.add(candidates[j]);
							combsI.add(combI);
						}
					}
				}
			}
			combs = combsI;
		}
		for(int i=combs.size()-1; i>=0; i--) {
			if(sum(combs.get(i)) != target) {
				combs.remove(i);
			}
		}
		return combs;
	}
}
