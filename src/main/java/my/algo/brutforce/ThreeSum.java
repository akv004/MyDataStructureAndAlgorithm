package my.algo.brutforce;
/*
 * Take more time for large number ...
 *  Given n distinct integer, how many triples sum to exactly zero ?
 *    % more 8ints.txt
 *    8
 *    30 -40 -20 -10 40 0 10 5
 *    % Java TreeSum 8ints.txt = 4
 *        a[i]  a[j]   a[k]
 *    1)  30     -40   10  = 0
 *    2)  30     -20  -10  = 0
 *    3) -40      40   0   = 0
 *    4) -10     0    -10  = 0
 */
public class ThreeSum {

	public static int count(int[] a) {
		int count =0;
		int N = a.length;
		for(int i = 0 ; i < N; i++) 
			for(int j=i+1; j< N ; j++)
				for(int k=j+1; k<N ; k++)
					if(a[i]+a[j]+a[k] ==0) 
						count++;
		
		return count;
	}
	public static void main(String[] args) {
		int[] a = new int[]{30, -40, -20, -10, 40, 0, 10, 5};
         System.out.println(count(a));
	}

}
