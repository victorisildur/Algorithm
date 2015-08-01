import java.util.Map;
import java.util.HashMap;

public class Solution {
	private char [][] mBoard;
	private String mWord;
	private boolean [][] posMap;
	
	public boolean exist(char[][] board, String word) {
		mBoard = board;
		mWord  = word;
		int m = board.length; int n = board[0].length;
		posMap = new boolean[m][];
		for(int i=0; i<m; i++) {
			posMap[i] = new boolean[n];
			for(int j=0; j<n; j++) {
				posMap[i][j] = false;
			}
		}
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if( find(i,j,Dir.NULL,0) )
					return true;
			}
		}
		return false;
	}
	
	private boolean find(int i, int j, int dir, int pos) {
		if(i<0 || i>= mBoard.length)    return false;
		if(j<0 || j>= mBoard[0].length) return false;
		if(posMap[i][j])                return false;
		char curr = mBoard[i][j];
		if( !(curr == mWord.charAt(pos)) )
			return false;
		posMap[i][j] = true;
		if( pos == mWord.length() -1)
			return true;
		for(int next_dir=Dir.TOP; next_dir<=Dir.LEFT; next_dir++) {
			int next_i = i, next_j = j;
			if(next_dir == Dir.TOP)        {next_i--;}
			else if(next_dir == Dir.RIGHT) {next_j++;}
			else if(next_dir == Dir.LEFT)  {next_j--;}
			else                           {next_i++;}
			if( find(next_i, next_j, next_dir, pos+1) ) {
				return true;
			} else {
				continue;
			}
		}
		posMap[i][j] = false;
		return false;
	}

	private static class Dir {
		public static int NULL   = -3;
		public static int TOP    = 0;
		public static int RIGHT  = 1;
		public static int BOTTOM = 2;
		public static int LEFT   = 3;
	}
}
