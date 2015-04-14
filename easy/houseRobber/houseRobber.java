public class Solution() {
    /* for house k , either Include or Exclude it
     * if include , maxRob = num[k] + prevExclude
     * if exclude , maxRob = max{ prevInclude , prevExclude }
     * we maintain these two maxRob till the end
     */
    public int rob(int[] num) {
	int i=0 , e=0;
	for( int k=0; k<num.length; k++) {
	    int tmpI = i;
	    i = num[k] + e;
	    e = Math.max( tmpI, e );
	}
	return Math.max( i , e );
    }
}

public class houseRobber {
    public static void main(String args[]){
	Solution sol = new Solution();
	int [] num = [1,2,3,4,5];
	sol.rob(num);
	System.out.println(num);
    }
}
