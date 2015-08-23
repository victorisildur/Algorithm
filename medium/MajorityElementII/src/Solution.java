import java.util.*;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> res = new ArrayList<>();
    	if(nums.length == 0)
    		return res;
    	int ma=0, mb=0, ca=0, cb=0;
    	for(int num: nums) {
    		if(num == ma) ca++;
    		else if(num == mb) cb++;
    		else if(ca==0) {
    			ma = num;
    			ca = 1;
    		} else if(cb == 0) {
    			mb = num;
    			cb = 1;
    		} else {
    			ca--; cb--;
    		}
    	}
    	ca = cb = 0;
    	for(int num: nums) {
    		if(num==ma) ca++;
    		if(num==mb) cb++;
    	}
    	if(ca> nums.length/3) res.add(ma);
    	else if(cb> nums.length/3) res.add(mb);
    	return res;
    }
}