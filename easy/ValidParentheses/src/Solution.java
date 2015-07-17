import java.util.Stack;

public class Solution {
	private Stack<Character> stack = new Stack<>();
	
	public boolean isValid(String s) {
		if(s.length() <= 0)
			return true;
		for(int i=0; i<s.length(); i++) {
			if(stack.isEmpty()) {
				stack.push(s.charAt(i));
				continue;
			}
			if( match(stack.peek() , s.charAt(i)) ) {
				stack.pop();
				continue;
			}
			stack.push(s.charAt(i));
		}
		if(stack.isEmpty())
			return true;
		return false;
	}
	
	private boolean match(Character x, Character y) {
		if(x.equals('[') && y.equals(']'))
			return true;
		if(x.equals('{') && y.equals('}'))
			return true;
		if(x.equals('(') && y.equals(')'))
			return true;
		return false;
	}
}
