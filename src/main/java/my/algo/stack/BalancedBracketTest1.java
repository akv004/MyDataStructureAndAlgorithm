package my.algo.stack;

import java.util.Stack;

public class BalancedBracketTest1 {

	public static void main(String[] args) {
		String test = "ASD{[()]}(";
		System.out.println(check(test));

	}
	
	public static boolean check(String str){
		boolean b = true;
		Stack<Character> s = new Stack<Character>();
		char[] ca = str.toCharArray();
		
		for(char c : ca){
			switch(c){
			case '{':
			case '(':
			case '[':
				s.push(c);
				break;
			case ')':
			case '}':
			case ']':
				char c1 = 0;
				if(!s.isEmpty()){
				 c1= s.peek();
				}
			    if( c1 =='(' && c==')' ||   c1=='{' && c=='}' ||  c1=='[' && c==']'){
				  s.pop();
				  b= true;
				  break;
			  }else{
				  return false;
			  }
			
			default:
				break;
			}
			
		}
	   if(!s.isEmpty())return false;
       return b;
		
	}

}
