
public class Solution {
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		int E[][] = new int [m+1][n+1];
		for(int i=0; i<=m; i++) {
			E[i][0] = i;
		}
		for(int j=1; j<=n; j++) {
			E[0][j] = j;
		}
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				E[i][j] = Math.min(1+E[i-1][j], Math.min(1+E[i][j-1], diff(word1.charAt(i-1),word2.charAt(j-1))+E[i-1][j-1]));
			}
		}
		return E[m][n];
	}
	private int diff(char a, char b) {
		if( a==b ) {
			return 0;
		}
		return 1;
	}
}
