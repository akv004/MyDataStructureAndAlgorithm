package my.aws;

import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;

/**
 * @author amitverma
 * 
 *  amazon alexa telephonic : add  Utterances. and keep top list of most frequently used Utterances
 *
 */
public class MostFrequentUtterances {

	
	public static void main(String[] args) {
	
		
		PriorityQueue<Utterances> tm = new PriorityQueue<Utterances>(new Comparator<Utterances>(){
			@Override
			public int compare(Utterances o1, Utterances o2) {
				return o2.count- o1.count;
			}});

		addUtterances("hello jim", tm);
		addUtterances("hello jim", tm);
		addUtterances("hello jim", tm);
		addUtterances("hello jim", tm);
		addUtterances("hello tom", tm);
		addUtterances("hello tom", tm);
		addUtterances("hello tom", tm);
		addUtterances("hello amit", tm);
		addUtterances("hello jim", tm);
		addUtterances("chaman lal", tm);
		
		
		System.out.println(tm);
	
		tm.stream().forEach( p ->  System.out.println(p.utterances + ", count : "+ p.count));
		

	}
	
	private static void  addUtterances(String ut, PriorityQueue<Utterances> tm) {
		
		Optional<Utterances> op = tm.stream().filter(u -> u.utterances.equals(ut)).findFirst();
		if(op.isPresent()) {
		op.get().setCount(op.get().count+1);
		
		}else {
			tm.add(new Utterances(ut,1) );
		}
	}

}




class Utterances {
	String utterances;
	int count;
	
	
	public Utterances(String utterances, int count) {
		super();
		this.utterances = utterances;
		this.count = count;
	}
	public String getUtterances() {
		return utterances;
	}
	public void setUtterances(String utterances) {
		this.utterances = utterances;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Utterances [utterances=" + utterances + ", count=" + count + "]";
	}
	
	
	
}