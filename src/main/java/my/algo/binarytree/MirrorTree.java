package my.algo.binarytree;


/*
 * 
 *                1          1
 *              2   3      3   2
 *           4   5           5   4
 */
public class MirrorTree {
	
	public static void main(String args[]){
		
		Node node = new Node(1);
		node.left= new Node(2);
		        node.left.left = new Node(4);
		        node.left.right = new Node(5);
		node.right = new Node(3);
		
		BTreePrinter.printNode(node);
		
		mirror(node);
		
		BTreePrinter.printNode(node);
	}

	private static Node mirror(Node node) {
		Node tmp = null;
	    if(node != null){
		     mirror(node.left);
		     mirror(node.right);  	
		    // swap th pointer in this node
		    tmp = node.left;
		    node.left = node.right;
		    node.right = tmp;
	    }

	    
	    return node;
	}



}
