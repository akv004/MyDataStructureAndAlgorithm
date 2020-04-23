package my.algo.binarytree.collectleavesdoublylinklist;
/*
 * Let the following be input binary tree
        1
     /     \
    2       3
   / \       \
  4   5       6
 / \         / \
7   8       9   10


Output:
Doubly Linked List
7<->8<->5<->9<->10

Modified Tree:
        1
     /     \
    2       3
   /         \
  4           6
 
 */
class Node{
	int data;
	Node left;
	Node right;
	Node(int item){
		this.data = item;
		right =left = null;
	}
}
public class BinaryTree {
 Node root;
 Node head;  // will point to head of DLL
 Node prev; // temp pointer
 
 public Node extractLeafList(Node root) {
	if(root ==null) {
		return null;
	}
	if(root.left ==null && root.right==null) { // case of leaf node
		if(head ==null) {
			head = root;
			prev = root;
		}
		else {
			prev.right = root;
			prev.left= prev;
			prev = root;
		}
		return null;
		
	}
	root.left = extractLeafList(root.left);
	root.right = extractLeafList(root.right);
	return root;
	 
 }
 
 // print DLL in both fw and rev direction
 public void printDLL(Node head) {
	 Node last = null;
	 while(head != null) {
		 System.out.println(head.data  +" ");
		 last = head;
		 head = head.right;
	 }
 }
 
 void inorder(Node node) {
	 if(node ==null)
		 return;
	 inorder(node.left);
	 System.out.println(node.data + " ");
	 inorder(node.right);
 }
 
 
//Driver program to test above functions
 public static void main(String args[]) 
 {
	 
	 /*
	  * Let the following be input binary tree
	         1
	      /     \
	     2       3
	    / \       \
	   4   5       6
	  / \         / \
	 7   8       9   10
	 */
     BinaryTree tree = new BinaryTree();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(3);

     tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(5);
     tree.root.right.right = new Node(6);
     tree.root.left.left.left = new Node(7);
     tree.root.left.left.right = new Node(8);
     tree.root.right.right.left = new Node(9);
     tree.root.right.right.right = new Node(10);

     System.out.println("Inorder traversal of given tree is : ");
     tree.inorder(tree.root);
     tree.extractLeafList(tree.root);
     System.out.println("");
     System.out.println("Extracted double link list is : ");
     tree.printDLL(tree.head);
     System.out.println("");
     System.out.println("Inorder traversal of modified tree is : ");
     tree.inorder(tree.root);
 }
}
