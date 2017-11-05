package my.scanner.example;

import java.util.Scanner;

public class ReadingInputDemo1 {

	public static void main(String args[]){
       
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your FirstName:");
		String name = sc.nextLine();
		System.out.println(name + " enter your age:");

		int age = sc.nextInt();
	    sc.nextLine(); // this is required and nextInt insert /n char
	    System.out.println("Enter your address:");
		String address = sc.nextLine();
		
		System.out.println("your age is "+age);
		System.out.println("your address is "+ address);
		
	}
}
