package my.algo.stack;

import java.util.Stack;

public class Html2 {

	public static void main(String args[]){
		String test = "<html><body>asdf</body></html/>";
		System.out.println(test.substring(1));
	    System.out.println(isMatched(test));
	}

	private static Boolean isMatched(String test) {
		
		Stack<String> buffer = new Stack();
		
		int j = test.indexOf('<'); // 0
		while(j !=-1){
			int k = test.indexOf('>' , j+1);
			if(k ==-1) return false;
			
			String tag = test.substring(j+1, k);
			if(!tag.startsWith("/")){
				buffer.push(tag);
			}else{
				// pop if match ending
				if(buffer.isEmpty()) return false;
				if(!tag.substring(1).equals(buffer.pop())){
					return false;
				}
			}
			j =  test.indexOf('<', k);
		}
		
		return buffer.isEmpty();
	}
	
}
