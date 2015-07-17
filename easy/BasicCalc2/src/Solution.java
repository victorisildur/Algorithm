import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
public class Solution {
	private boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	private List<String> inToPost(String s) {
		Stack<Character> stk = new Stack<Character>();
		List<String> postList = new ArrayList<String>();
		for(int i=0; i<s.length(); i++) {
			Character ch = s.charAt(i);
			if(ch == ' ')
				continue;
			if(Character.isDigit(ch)) {
				String numStr = ch.toString();
				try {
					while(Character.isDigit(ch = s.charAt(++i))) {
						numStr = numStr.concat(ch.toString());
					}
				} catch (Exception e) {
				}
				postList.add(numStr);
				i--;
				continue;
			}
			while(!stk.isEmpty()) {
				if( ch == '+' || ch == '-') {
					if(!stk.isEmpty()) {
						postList.add(stk.pop().toString());
					}
				}
				if( ch == '*' || ch == '/') {
					if(!stk.isEmpty()) {
						if(stk.peek().equals('*') || stk.peek().equals('/'))
							postList.add(stk.pop().toString());
						else
							break;
					}
				}
			}
			stk.push(ch);
		}
		while(!stk.isEmpty()) {
			postList.add(stk.pop().toString());
		}
		return postList;
	}
	public int calculate(String s) {
		List<String> postList = inToPost(s);
		Stack<Double> stk = new Stack<Double>();
		Double op1, op2;
		for(int i=0; i<postList.size();i++) {
			String str = postList.get(i);
			if(isInteger(str)) {
				stk.push(new Double(Integer.parseInt(str)));
			}
			else {
				op2 = stk.pop();
				op1 = stk.pop();
				switch(str) {
				case "+":
					stk.push(new Double(op1+op2)); break;
				case "-":
					stk.push(new Double(op1-op2)); break;
				case "*":
					stk.push(new Double(Math.floor(op1*op2))); break;
				case "/":
					stk.push(new Double(Math.floor(op1/op2))); break;
				}
			}
		}
		return (int) Math.floor(stk.peek());
	}
}
