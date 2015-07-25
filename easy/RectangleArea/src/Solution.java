public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	int width = join(A,C,E,G),
    	   height = join(B,D,F,H);
    	int joinArea = width * height;
    	int area1 = Math.abs(A-C) * Math.abs(B-D);
    	int area2 = Math.abs(E-G) * Math.abs(F-H);
    	return area1 + area2 - joinArea;
    }
    private int join(int a1, int a2, int b1, int b2) {
    	// a b seperate
    	if(b1>=a2 || b2<=a1)
    		return 0;
    	// b in a
    	if( b1>=a1 || b2<=a2) {
                // b all in a
                if( b1>=a1 && b2<=a2) {
                    return b2-b1;
                }
                // b left part in a
                if( b1>=a1 ) {
                    return a2-b1;
                }
                // b right part in a
                return b2-a1;
    	} else {
    		if( a1>=b1 && a2<=b2)
    			return a2-a1;
    		if( a1>=b1)
    			return b2-a1;
    		return a2-b1;
    	}
    }
}
