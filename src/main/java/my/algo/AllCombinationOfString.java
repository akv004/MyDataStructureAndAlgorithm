package my.algo;

import java.util.ArrayList;

public class AllCombinationOfString {
   
    
    
	public static void main(String[] args) {
		String s =  "abc";
		getPerma(s).forEach(a-> System.out.println(a));
		
	}
	
	public static  ArrayList<String> getPerma(String str) {
		if(str ==null ) return null;
		ArrayList<String> perm = new ArrayList<String>();
		if(str.length() ==0) {
			perm.add("");
			return perm;
		}
		char first = str.charAt(0); // get the first char
		String reminder = str.substring(1);
		ArrayList<String> words = getPerma(reminder);
		for(String word : words) {
			for(int j=0; j<= word.length(); j++) {
				String s =inertCharAt(word, first , j);
				perm.add(s);
			}
		}
		return perm;
	
	}
	
	public static String inertCharAt(String word, char c, int i) {
	   String start = word.substring(0,i);
	   String end = word.substring(i);
		return start+ c + end;
		
	}
}
