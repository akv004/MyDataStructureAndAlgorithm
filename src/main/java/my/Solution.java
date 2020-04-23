package my;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{        
 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
 List<String> retrieveMostFrequentlyUsedWords(String literatureText, 
                                              List<String> wordsToExclude)
 {
	 
	 List<String> wte = convertToUpperCase7(wordsToExclude);
	 
	 literatureText = literatureText.toUpperCase();
	 
	 literatureText = literatureText.replace("'", " ");
	 literatureText = literatureText.replace(".", "");
	 StringTokenizer st = new StringTokenizer(literatureText,  " ");
	
	 Map<String, Integer> map = new HashMap<String, Integer>();
	 while (st.hasMoreElements()) {
			String tmp = (String) st.nextElement();
			if(!wte.contains(tmp)) {
				if(map.get(tmp) == null) {
					map.put(tmp.toUpperCase(), 1);
				}else {
					Integer x = map.get(tmp);
					map.put(tmp.toUpperCase(), x+1);
				}
			}
		}
	 
	 
	 List <String> result = new ArrayList<String>(); 
	/* int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
     for (Entry<String, Integer> entry : map.entrySet()) {  // Itrate through hashmap
         if (entry.getValue()==maxValueInMap) {
        	 result.add(entry.getKey());     // Print the key with max value
         }
     }*/
	 
    
    
     String fk; 
     Integer max =-1;

     
     for (Map.Entry<String, Integer> entry : map.entrySet()) {
    	    String k = entry.getKey();
    	    Integer val = entry.getValue();
    	    if (val >= max){
        	    
                max = val;
                fk=k;
           }
    	}
     
    

     Iterator<String> it2 = map.keySet().iterator();
   while(it2.hasNext()) {
	   String k = it2.next();
       Integer val = map.get(k);
       if(val == max) {
    	     result.add(k);
       }
   }
   
   for (Map.Entry<String, Integer> entry : map.entrySet()) {
	    String k = entry.getKey();
	    Integer val = entry.getValue();
	    if (val >= max){
   	    
           max = val;
           fk=k;
      }
	}
   
     
	return result;
     // WRITE YOUR CODE HERE
 }
 // METHOD SIGNATURE ENDS
 
 
 
 public  List<String> convertToUpperCase7(List<String> inList) {
		List<String> list = new ArrayList<>();
		for (String str : inList) {
			list.add(str.toUpperCase());
		}
		return list;
	}
 
 public static void main(String args[]) {
	 Solution s = new Solution();
	 
	 String literatureText = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorate food.";
	 
	 List<String> exc = new ArrayList<String>();
	 exc.add("and");
	 exc.add("he");
	 exc.add("the");
	 exc.add("to");
	 exc.add("Jack");
	 exc.add("Jill");
	 
	 System.out.println(s.retrieveMostFrequentlyUsedWords(literatureText, exc));
	 
 }
}