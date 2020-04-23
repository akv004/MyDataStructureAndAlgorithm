package my.algo.stack;

import java.util.Stack;

public class Html {
	
	public static void main(String args[]){
		String test = "<html><body>asdf</body></html>";
		System.out.println(test.substring(1));
	    System.out.println(isMatched(test));
	}

	public static boolean isMatched(String html){
		
		Stack<String> buffer = new Stack<String>();
		
		int j = html.indexOf('<');
		while(j!=-1){
			int k = html.indexOf('>', j+1);
			if(k==-1)
				return false;
			String tag = html.substring(j+1, k);
			if(!tag.startsWith("/")){
				buffer.push(tag);
			}else{
				if(buffer.empty())
					return false;
				if(!tag.substring(1).equals(buffer.pop())){
						return false;
				}
			}
			j = html.indexOf('<' , k+1);
		 }
		return buffer.isEmpty();
		
	}
}
