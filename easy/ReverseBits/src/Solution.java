public class Solution {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int result = 0;
		for(int i = 0; i < 32; i ++){
			if(isBit1(n, i)){
				result = setBit1(result, 31 - i);
			}
		}
		return result;
	}

	public int setBit1(int num, int i){
		return num | (1 << i);
	}

	public boolean isBit1(int num, int i){
		return (num & (1 << i)) != 0;
	}
}