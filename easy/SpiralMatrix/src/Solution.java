import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int ymin = 0, xmin = 0;
		int ymax = matrix.length-1;
		int xmax = matrix[0].length-1;
		int x=0,y=0;
		while(xmax>=xmin && ymax>=ymin) {
			while(x<=xmax) 
				res.add(matrix[y][x++]);
			x = xmax;
			ymin++;
			y ++;
			if(y>ymax)
				break;
			while(y<=ymax) 
				res.add(matrix[y++][x]);
			y = ymax;
			xmax--;
			x --;
			if(x<xmin)
				break;
			while(x>=xmin) 
				res.add(matrix[y][x--]);
			x = xmin;
			ymax--;
			y --;
			if(y<ymin)
				break;
			while(y>=ymin)
				res.add(matrix[y--][x]);
			y = ymin;
			xmin++;
			x ++;
			if(x>xmax)
				break;
		}
		return res;
	}
}
