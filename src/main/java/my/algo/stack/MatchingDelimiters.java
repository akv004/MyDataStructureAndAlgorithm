package my.algo.stack;

import java.util.Stack;

public class MatchingDelimiters {

	public static void main(String[] args) {
		
		System.out.println(isBalanced("(test)(test){}<html>{"));
	}
	
	public static Boolean isBalanced(String txt){
		String openDelim = "({[<";
		String closingDelim = ")}]>";
		
		Stack<Character> s = new Stack<Character>();
		
		for(char c : txt.toCharArray()){
			
			if(openDelim.indexOf(c)!= -1){
				s.push(c);
			}
			
			if(closingDelim.indexOf(c) !=-1){
				if(s.isEmpty()) return false;
				s.pop();
			}
		}
		
		return s.isEmpty();
		
	}

}
