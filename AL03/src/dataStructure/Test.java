package dataStructure;

public class Test {

	public static void main(String[] args) {
		//testStackWith Push Push Pop Push Pop Pop
		//testStackWith Push Pop Push Pop
		//testStackWithRandom
		Dequeue d = new Dequeue();
		Queue q = new Queue();
		Stack s = new Stack();
//		/*
		d.pushFirst("1");
		d.pushFirst("0.1");
		d.pushLast("10");
		d.pushFirst("0.01");
		System.out.println(d.popFirst());
		System.out.println(d.popLast());
		System.out.println(d.popFirst());
		System.out.println(d.popLast());
		//0.01 10 0.1 1
//		*/
//		/*
		s.push("1");
		s.push("10");
		System.err.println(s.pop());
		s.push("100");
		s.push("1000");
		while (!s.isEmpty()) {
			System.err.println(s.pop());
		} //10 1000 100 1
//		*/
	}
}
