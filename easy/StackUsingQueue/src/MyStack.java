import java.util.*;

public class MyStack {
	private Queue<Integer> qIn = new LinkedList<>();
	private Queue<Integer> qBackup = new LinkedList<>();
	
	public void push(int x) {
		qIn.offer(x);
	}
	
	public int top() {
		if(!qIn.isEmpty()) {
			while(qIn.size() > 1) {
				qBackup.offer(qIn.poll());
			}
		}
		return qIn.peek();
	}

	public void pop() {
		top();
		qIn.poll();
		while(!qBackup.isEmpty()) {
			qIn.offer(qBackup.poll());
		}
	}

	public boolean empty() {
		return qIn.isEmpty() && qBackup.isEmpty();
	}
}
