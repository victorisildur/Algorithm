
public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int pos = 0, curr = 0, total = 0;
		
		for (int i = 0; i < gas.length; i++) {
			int diff = gas[i] - cost[i];
		
			curr += diff; 
			total += diff;
		
			if (curr < 0) {
				// use up all the gas in current run
				// reset from the next one
				curr = 0;
				pos = i+1;
			}
		}
		
		if (total >= 0) return pos;
		return -1;
	}
}
