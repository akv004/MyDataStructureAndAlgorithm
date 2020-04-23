package my.datastrusture.array;

public class ReverString {

	public static void main(String[] args) {
		
		String  s= "amitk";
		char[] a = s.toCharArray();
		reverse(a);
		System.out.println(new String(a));

	}
	
	public static void  reverse(char [] a) {
		int i= 0;
		int j = a.length -1;
		while(i<j) {
			swap(a,i,j);
			i++;
			j--;
		}
		
	}

	private static void swap(char[] a, int i, int j) {
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
		
	}

}
