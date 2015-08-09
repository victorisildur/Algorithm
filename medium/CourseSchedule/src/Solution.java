import java.util.*;

public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses < 1)
			return false;
		Graph g = new Graph(numCourses);
		for(int i=0; i<prerequisites.length; i++) {
			g.addEdge(prerequisites[i][1], prerequisites[i][0]);
		}
		return g.canTopoSort();
	}
	private class Graph {
		private int nVers;
		private List<List<Integer>> edges;
		private boolean deleted[];
		Graph(int n) {
			nVers = n;
			edges = new ArrayList<List<Integer>>();
			deleted = new boolean[n];
			for(int i=0; i<n; i++) {
				List<Integer> edgeI = new ArrayList<Integer>();
				deleted[i] = false;
				edges.add(edgeI);
			}
		}
		public void addEdge(int u, int v) {
			edges.get(u).add(v);
		}
		public boolean canTopoSort() {
			for(int i=0; i<nVers; i++) {
				int ver = noSuccessors();
				if(ver<0)
					return false;
				deleteVer(ver);
			}
			return true;
		}
		private int noSuccessors() {
			for(int i=0; i<nVers; i++) {
				if(deleted[i])
					continue;
				if( edges.get(i).isEmpty() ) 
					return i;
				boolean hasSuccessor = false;
				for( int j : edges.get(i)) {
					if(deleted[j])
						continue;
					hasSuccessor = true;
					break;
				}
				if(!hasSuccessor)
					return i;
			}
			return -1;
		}
		private void deleteVer(int ver) {
			deleted[ver] = true;
		}
	}
}
