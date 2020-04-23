package my.algo;

import java.util.Arrays;
import java.util.Collections;

public class AnagramProgram {

	public static void main(String[] args) {
		isAnagram("Mother In Law", "Hitler Woman");
		 
        isAnagram("keEp", "peeK");
 
        isAnagram("SiLeNt CAT", "LisTen AcT");
 
        isAnagram("Debit Card", "Bad Credit");
 
        isAnagram("School MASTER", "The ClassROOM");
 
        isAnagram("DORMITORY", "Dirty Room");
 
        isAnagram("ASTRONOMERS", "NO MORE STARS");
 
        isAnagram("Toss", "Shot");
 
        isAnagram("joy", "enjoy");
        
        isAnagram("Tomy", "To my ");

	}
	
	public static void isAnagram(String a1, String a2){
		
		String a = a1.replaceAll("\\s", "").toLowerCase();
		String b = a2.replaceAll("\\s", "").toLowerCase();
		
		boolean status = true;
		if(a.length() != b.length()){
			status = false;
		}else{
			char [] ar = a.toCharArray();
			char [] br = b.toCharArray();
			
			Arrays.sort(ar);
			Arrays.sort(br);
			
			status = Arrays.equals(ar, br);
		}
		
		if(status){
			System.out.println(a1 + " is anagram of " + a2);
		}else{
			System.out.println(a1 + " is not anagram of " + a2);
		}
		
	}

}
