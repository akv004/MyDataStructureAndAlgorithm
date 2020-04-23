package my.algo.binarytree;

public class MergeTwoBinaryTree {

	public static void main(String[] args) {
	
		/* Let us construct the first Binary Tree
        1
      /   \
     2     3
    / \     \
   4   5     6
*/

Node root1 = new Node(1);
root1.left = new Node(2);
root1.right = new Node(3);
root1.left.left = new Node(4);
root1.left.right = new Node(5);
root1.right.right = new Node(6);

/* Let us construct the second Binary Tree
		  4
		/   \
       1     7
      /     /  \
     3     2    6   */
Node root2 = new Node(4);
root2.left = new Node(1);
root2.right = new Node(7);
root2.left.left = new Node(3);
root2.right.left = new Node(2);
root2.right.right = new Node(6);


Node root3 = meregeTree(root1, root2);

BTreePrinter.printNode(root3);

	}
	
	public static Node  meregeTree(Node t1, Node t2) {
		if(t1 ==null )return t2;
		if(t2==null) return t1;
		
		t1.data += t2.data;
		t1.left = meregeTree(t1.left, t2.left);
		t1.right = meregeTree(t1.right, t2.right);
		return t1;
	}

}
