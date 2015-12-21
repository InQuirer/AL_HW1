package dataStructure;

public class Dequeue {
	protected Queue q = new Queue();
	
    public void pushFirst(Object object) {
    	Stack s1 = new Stack();
    	s1.push(object);
    	while (!q.isEmpty())
    		s1.push(q.dequeue());
    	q.s = s1;
    }
    public void pushLast(Object object) {
    	q.enqueue(object);
    }
    public Object popFirst() {
    	return q.dequeue();
    }
    public Object popLast() {
    	return q.s.pop();
    }
    public boolean isEmpty() {
    	return q.isEmpty();
    }
}