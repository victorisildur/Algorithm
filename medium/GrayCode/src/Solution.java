import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer> ();
		int totalCnt = (int) Math.pow(2,n);
		int num = 0, round = 2*n - 2;
		res.add(num);
		for(int i=0; i<totalCnt-1; i++) {
			int pos;
			try {
				pos = i % round;
			} catch (Exception e) {
				pos = 0;
			}
			if(pos < (n-1)) {
				num = num ^ (1<<pos);
			} else {
				num = num ^ (1<<round-pos);
			}
			res.add(num);
		}
		return res;
	}
}