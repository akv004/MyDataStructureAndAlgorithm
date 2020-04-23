package my.algo.base.stack.linklisttype;
import my.algo.base.stack.linklisttype.Stack;
public class Test {

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push("BMW");
		s.push("Honda");
		s.push("Toyota");
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());

	}

}
