
public class Solution {
	public String addBinary(String a, String b) {
		int i = a.length(), j = b.length();
		if(i>j) {
			for(int k=i-j; k>0; k--) {
				b = "0".concat(b);
			}
		} else {
			for(int k=j-i; k>0; k--) {
				a = "0".concat(a);
			}
		}
		i = a.length();
		int carry = 0;
		String res = new String();
		while(--i>=0) {
			Integer int_a = Integer.valueOf(a.substring(i, i+1));
			Integer int_b = Integer.valueOf(b.substring(i, i+1));
			Integer int_sum = int_a + int_b + carry;
			carry = int_sum > 1 ? 1:0;
			int_sum = int_sum % 2;
			res = Integer.toString(int_sum).concat(res);
		}
		if(carry > 0)
			res = Integer.toString(carry).concat(res);
		return res;
	}
}
