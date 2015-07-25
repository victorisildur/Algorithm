import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	private class State {
		public Character expect;
		public int id;
		public State next;
		State(Character e, int i, State n) {
			expect = e;
			id = i;
			next = n;
		};
		State(Character e, int i) {
			expect = e;
			id = i;
			next = null;
		}
	}
	public int strStr(String haystack, String needle) {
		// construct state machine
		State end  = new State(null, needle.length());
		List<State> charStateList = new ArrayList<State>();
		charStateList.add(end);
		for(int i=needle.length()-1; i>=0; i--) {
			State state = new State(needle.charAt(i), i, (State) getLast(charStateList));
			charStateList.add(state);
		}
		
		// traverse haystack
		State currState = (State) getLast(charStateList),
				start = currState;
		int i;
		boolean found = false;
		for(i=0; i<haystack.length(); i++) {
			Character ch = haystack.charAt(i);
			if( ch == currState.expect)
				currState = currState.next;
			else
				currState = start;
			if( currState.expect == null) {
				found = true;
				break;
			}
		}
		if(found) {
			return i-needle.length()+1;
		} else {
			return -1;
		}
	}
	private Object getLast(List list) {
		int len = list.size();
		return list.get(len-1);
	}
}
