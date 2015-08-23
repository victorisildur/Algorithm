
public class Solution {
	public int[] productExceptSelf(int [] nums) {
		int preProduct = 1;
		int postProduct = 1;
		int len = nums.length;
		int [] res = new int [nums.length];
		for(int i=0; i<len; i++) {
			res[i] = 1;
		}
		for(int i=0; i<len; i++) {
			res[i] *= preProduct;
			res[len-1-i] *= postProduct;
			preProduct *= nums[i];
			postProduct *= nums[len-1-i];
		}
		return res;
	}
}
