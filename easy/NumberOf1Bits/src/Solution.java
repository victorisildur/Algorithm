
public class Solution {
	public int hammingWeight(int n) {
		int cnt = 0;
		if(n<0)
			cnt++;
		n = n & (int)(Math.pow(2, 31)-1); 

		while(n > 0) {
			int last = n % 2;
			if(last > 0)
				cnt++;
			n /= 2;
		}
		return cnt;
	}
}
