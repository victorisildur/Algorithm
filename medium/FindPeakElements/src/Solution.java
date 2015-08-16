
public class Solution {
	private int N;
	public int findPeakElement(int [] nums) {
		N = nums.length -1;
		return finder(nums, 0, nums.length-1);
	}
	private int finder(int [] nums, int start, int end) {
		if(start>=end)
			return start;
		int mid = (start+end) / 2;
		int a , b = nums[mid], c;
		if(mid != 0 && mid != N) {
			a = nums[mid-1];
			c = nums[mid+1];
			if( a<b && b>c)
				return mid;
			else if( a<b && b<c)
				return finder(nums, mid+1, end);
			else 
				return finder(nums, start, mid-1);
		} else if (mid==0) {
			c = nums[mid+1];
			if(c>b)
				return finder(nums, mid+1, end);
			else
				return mid;
		} else {
			a = nums[mid-1];
			if(a>b)
				return finder(nums, start, mid-1);
			else
				return mid;
		}
	}
}
