package dataStructure;

public class Queue {
	protected Stack s = new Stack();
	
    public void enqueue(Object object) {
    	s.push(object);
    	
    }
    public Object dequeue() {
    	Object o = s.stack[0];
    	Stack s1 = new Stack();
    	for (int i = 1; i < s.stack.length; i++)
    		if (s.stack[i] != null)
    			s1.push(s.stack[i]);
    	s = s1;
    	return o;
    }
    public boolean isEmpty() {
    	return s.isEmpty();
    }
}