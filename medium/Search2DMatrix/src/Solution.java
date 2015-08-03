import java.util.List;
import java.util.ArrayList;

public class Solution {
	private int mHeight;
	private int mWidth;
	private List<Integer> getMid(int begin_i, int begin_j, int end_i, int end_j) {
		int cnt = (end_i+begin_i)*mWidth + (end_j + begin_j);
		cnt /= 2;
		return getPos(cnt);
	}
	private int getCnt(int i, int j) {
		return i*mWidth + j;
	}
	private List<Integer> getPos(int cnt) {
		List<Integer> res = new ArrayList<Integer>();
		int i = cnt/mWidth, j=cnt % mWidth;
		res.add(i);
		res.add(j);
		return res;
	}
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		if(m==0 || n==0)
			return false;
		mWidth = n;
		mHeight = m;
		int begin_i = 0, begin_j = 0, end_i = m-1, end_j = n-1;
		do {
			/*invariant: target between begin,end*/
			List<Integer> pos = getMid(begin_i,begin_j,end_i,end_j);
			int mid_i = pos.get(0), mid_j = pos.get(1);
			int val = matrix[mid_i][mid_j];
			if(val == target) {
				return true;
			} else if ( val > target ) {
				pos = getPos(getCnt(mid_i,mid_j)-1);
				end_i = pos.get(0);
				end_j = pos.get(1);
			} else {
				pos = getPos(getCnt(mid_i,mid_j)+1);
				begin_i = pos.get(0);
				begin_j = pos.get(1);
			}
		} while( getCnt(begin_i,begin_j) <= getCnt(end_i,end_j) );
		return false;
	}
}
