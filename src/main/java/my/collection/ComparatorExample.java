package my.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
	

	
	public static void main(String ...a){
		Student s1 = new Student("Stu1", 12, "C");
		Student s2 = new Student("Stu2", 10, "A");
		Student s3 = new Student("Stu3", 16, "B");
		Student s4 = new Student("Stu4", 8, "C");
		
		List<Student> sl = new ArrayList<Student>();
		sl.add(s1);	sl.add(s2);	sl.add(s3);	sl.add(s4);
		
		Collections.sort(sl, new AgeComparator());
		System.out.println(sl);
		
	
		
	}

}

class AgeComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return cp(o1.getAge(), o2.getAge());
	}
	
	static <T extends Comparable<T>> int cp(T a, T b){
		return 
				a == null ?
				(b==null ? 0 : Integer.MIN_VALUE) :
				(b==null ? Integer.MAX_VALUE : a.compareTo(b));
	}
	
}

class Student {
	String name;
	int age;
	String grade; // A B C
	
	
	public Student(String name, int age, String grade) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	public Student() {
		
	}
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", grade=" + grade
				+ "]";
	}
	
	
}