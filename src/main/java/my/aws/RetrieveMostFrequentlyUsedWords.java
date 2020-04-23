package my.aws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class RetrieveMostFrequentlyUsedWords {

	public static void main(String[] args) {
		   List<String> list = new ArrayList<>();

		   list.add("and");
		   list.add("he");
		   list.add("the");
		   list.add("to");
		   list.add("is");
		   list.add("Jack");
		   list.add("Jill");

		   List<String> mylist = retrieveMostFrequentlyUsedWords("Jack and Jill went to the market to buy bread and cheese. cheese s Cheese is Jacks and Jills favorite food",list);
		   System.out.println(mylist);

	}

	public static List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {
	
	      // WRITE YOUR CODE HERE
        /*System.out.println(literatureText);
        System.out.println(wordsToExclude);*/
        List<String> result = new ArrayList<String>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        HashSet<String> set = new HashSet<String>();
        
        for(String word:wordsToExclude)
        {
            set.add(word.toLowerCase());
        }
        
        int max =0;
        if(literatureText==null || literatureText.length()==0)
        {
            return result;
        }
        int start=0;
        for(int i=0;i<literatureText.length();i++)
        {
            char c= literatureText.charAt(i);
            //for each character in log
            if(!Character.isLetter(c) || i==literatureText.length()-1)
            {
                String t="";
                if(i==literatureText.length()-1)
                {
                    t =literatureText.substring(start,i+1);
                }
                else
                {
                    t =literatureText.substring(start,i);
                }
                if(!set.contains(t.toLowerCase()))
                {
                    if(t!=null && t.length()!=0){
                        String k =t.toLowerCase();
                    map.put(k,map.getOrDefault(k,0)+1);
                    max = Math.max(max,map.get(k));
                    }
                }
                start=i+1;
            }
        }
        for(Map.Entry<String,Integer> e: map.entrySet())
        {
            if(e.getValue() == max)
            {
                result.add(e.getKey());
            }
        }
        return result;
    }
	}
	


