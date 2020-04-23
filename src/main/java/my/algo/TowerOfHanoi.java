package my.algo;

public class TowerOfHanoi {

	public static void main(String[] args) {
		TOH(3, 1, 3, 2);

	}
	
	public static void   TOH(int n , int from, int to, int aux) {
		if(n==1) {
			System.out.println("MOVE "+ from + " -> "+  to);
			return ;
		}
		TOH(n-1, from, aux, to);
		System.out.println("MOVE "+ from + " -> "+  to);
		TOH(n-1, aux, to, from);
		
	}

}
