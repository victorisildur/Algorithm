import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
	/*
	 * {c} -> (c)
	 * {b,c} -> insert b to every permutation of {c} 
	 *       -> (b,c), (c,b)
	 * {a,b,c} -> insert a to every permutaion of {b,c}
	 *         -> (a,b,c) (b,a,c) (b,c,a)
	 *         -> (a,c,b) (c,a,b) (c,b,a)
	 */
	public List<List<Integer>> permute(int []nums) {
		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		List<Integer> perm0 = new ArrayList<Integer>();
		perm0.add(nums[0]);
		res.add(perm0);
		for(int i=1; i<nums.length; i++) {
			Integer curr = nums[i];
			for(int j=0, prevPermsSize = res.size(); j<prevPermsSize; j++) {
				List<Integer> prevPerm = res.pollFirst();
				for(int k=0, permLength=prevPerm.size(); k<=permLength; k++) {
					List<Integer> newPerm = new ArrayList<Integer>(prevPerm);
					newPerm.add(k, curr);
					res.add(newPerm);
				}
			}
		}
		return res;
	}
}
