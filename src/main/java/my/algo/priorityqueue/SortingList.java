package my.algo.priorityqueue;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingList {

	public static void main(String[] args) {
		
		Person p1 = new Person();
		p1.setName("VAmit");
		p1.setAge(43);
		p1.setAddress("61 manville hill");
		
		
		Person p2 = new Person();
		p2.setName("DOn");
		p2.setAge(42);
		p2.setAddress("yiuy");
		
		
		Person p3= new Person();
		p3.setName("TOM");
		p3.setAge(22);
		p3.setAddress("ddd");
		
		List<Person> p = new ArrayList<Person>();
		p.add(p2);p.add(p1);  p.add(p3);

		//Sort by name
		p.sort(Comparator.comparing(Person::getName));
		System.out.println(p);

		List<String> names = p.stream().map(Person::getName).collect(Collectors.toList());
        Set<String> set = p.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));

		

		System.out.println(names);
		System.out.println(set);
		
		
		
	}

	
}

class Person{
	String name;
	int age;
	String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
}
