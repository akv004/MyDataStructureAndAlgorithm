package my.algo.binarytree;

public class FindMinimumHight {

	public static void main(String[] args) {
		
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		System.out.println("Min hight:"+ findMinimum(root));
		System.out.println("Min hight:"+ findMaxHeight(root));
	}
	
	static int findMinimum(Node root){
		int mh = 0;
		if(root == null ) {
			return -1;
		}
		if(root.left == null && root.right ==null){
			return 0;
		}
		if(root.left == null){
			return findMinimum(root.right) ;
		}
	
		if(root.right == null){
			return findMinimum(root.left);
		}
		
		mh = 1+Math.min(findMinimum(root.left) , findMinimum(root.right));
		return mh;
		
	}
	
	
	static int findMaxHeight(Node root){
		int mh = 0;
		if(root == null ) {
			return -1;
		}
		if(root.left == null && root.right ==null){
			return 0;
		}
		if(root.left == null){
			return findMaxHeight(root.right) ;
		}
	
		if(root.right == null){
			return findMaxHeight(root.left);
		}
		
		mh = 1+Math.max(findMaxHeight(root.left) , findMaxHeight(root.right));
		return mh;
		
	}

}
