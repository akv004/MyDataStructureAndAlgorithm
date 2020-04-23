package my.datastrusture.array;

/// Reverse the element
public class ReverseArrayTwoPointerTechnique {

	public static void main(String[] args) {
		int [] a = {1,2,3,4};
		reverse(a, a.length);
		System.out.println(a);
		for(int i=0; i<a.length ; ++i) {
			System.out.println(a[i]);
		}
		

	}
	
	
	
	public static void reverse(int[] v, int N) {
		int i =0;
		int j = N-1;
		while (i<j) {
			swap(v,i,j);
			i++;
			j--;
		}
	}

	private static void swap(int[] v, int i, int j) {
		 int tmp = v[i];
		 v[i] = v[j];
		 v[j]= tmp;
		 
		
	}

}
