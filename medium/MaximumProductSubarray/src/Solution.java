
public class Solution {
	public int maxProduct(int [] nums) {
		int len = nums.length;
		int max[] = new int [len];
		int min[] = new int [len];
		int res = max[0] = min[0] = nums[0];
		for(int i=1; i<len; i++) {
			int a = nums[i], b = nums[i]*max[i-1] , c = nums[i]*min[i-1];
			max[i] = Math.max(a, Math.max(b, c));
			min[i] = Math.min(a, Math.min(b, c));
			res = Math.max(res, Math.max(max[i], min[i]));
		}
		return res;
	}
}
