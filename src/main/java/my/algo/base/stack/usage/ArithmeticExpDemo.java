package my.algo.base.stack.usage;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class ArithmeticExpDemo {
	
	
	public static void main1(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<Double> val = new Stack<Double>();
		
	    Scanner sn = new Scanner(System.in);
	    System.out.println("Enter expression:");
	   
	    System.out.println("nextDouble()):"+sn.nextDouble());
	   
	     

	     
	}

	
	public static void main(String[] args) {
        String string = JOptionPane.showInputDialog("Expression");
        Pattern pattern = Pattern.compile("(\\d*(\\.?)\\d+)");
        System.out.println(string);
        Matcher matcher = pattern.matcher(string);
        System.out.println("Group Count: " + matcher.groupCount());
        while (matcher.find()) {
            System.out.print(matcher.group() + "  ");
            
        }
        
        String delims = "[+\\-*/\\^ ]+"; // so the delimiters are:  + - * / ^ space
        String[] tokens = string.split(delims);
        System.out.println("=========");
        for (String string2 : tokens) {
			System.out.println(string2);
		}
    }
}
