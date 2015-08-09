import java.util.*;

public class MyQueue {
	private Stack<Integer> sIn = new Stack<>();
	private Stack<Integer> sOut = new Stack<>();
	
	public void push(int x) {
		while(!sOut.isEmpty()) {
			sIn.push(sOut.pop());
		}
		sIn.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!sIn.isEmpty()) {
        	sOut.push(sIn.pop());
        }
        sOut.pop();
    }

    // Get the front element.
    public int peek() {
        while(!sIn.isEmpty()) {
        	sOut.push(sIn.pop());
        }
        return sOut.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return sIn.isEmpty() && sOut.isEmpty();
    }
}
