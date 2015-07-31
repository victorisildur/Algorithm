import java.util.List;
import java.util.ArrayList;

public class Solution {
	private void swap(int [] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	public void quicksort(int [] nums, int begin, int end) {
		if( begin >= end )
			return;
		int x = nums[begin], i, m=begin;
		for(i=begin+1; i<=end; i++) {
			if( nums[i] < x) {
				swap(nums, i, ++m);
			}
		}
		swap(nums, begin, m);
		quicksort(nums, begin, m-1);
		quicksort(nums, m+1, end);
	}
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		if(nums.length == 0)
			return sets;
		quicksort(nums,0,nums.length-1);
		sets.add(new ArrayList<Integer>());
		for(int i=0; i<nums.length; i++) {
			List<List<Integer>> newSets = new ArrayList<List<Integer>>();
			for(List<Integer> set : sets) {
				int maxInSet = Integer.MIN_VALUE;
				if( !set.isEmpty() )
					maxInSet = set.get(set.size()-1);
				if( nums[i] > maxInSet ) {
					List<Integer> newSet = new ArrayList<>(set);
					newSet.add(nums[i]);
					newSets.add(newSet);
				}
			}
			sets.addAll(newSets);
		}
		return sets;
	}
}
