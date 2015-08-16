
public class Solution {
	public int trailingZeroes(int n) {
		int fives = n, cnt = 0;
		while(fives>0) {
			fives = countFives(fives);
			cnt += fives;
		}
		return cnt;
	}
	private int countFives(int n) {
		return n/5;
	}
}
