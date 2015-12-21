package dataStructure;

import java.util.Arrays;

public class Stack {
	protected int count;
	protected Object[] stack = new Object[1];
	
    public void push(Object object) {
    	stack[count++] = object;
    	Object[] s = Arrays.copyOf(stack, count + 1);
    	stack = s;
    }
    
    public Object pop() {
    	Object o;
        o = stack[count - 1];
    	Object[] s = Arrays.copyOf(stack, count);
    	s[--count] = null;
    	stack = s;
        return o;
	}
    
    public boolean isEmpty() {
		return count == 0;
	}
    
}