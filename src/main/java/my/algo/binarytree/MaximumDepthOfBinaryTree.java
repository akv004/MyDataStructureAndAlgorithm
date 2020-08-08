package my.algo.binarytree;

/*
 * 
 
 Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its depth = 3.
 
 */
public class MaximumDepthOfBinaryTree {
	
	
	public static void main(String args[]) {
		Node root = new Node(3);
		root.right = new Node(20);
		root.right.right = new Node(7);
		root.right.left = new Node(15);
		root.left = new Node(9);
		Solution s = new Solution();
		System.out.println(s.maxDepth(root));
				
	}
	

}

class Solution {
	  public int maxDepth(Node root) {
	    if (root == null) {
	      return 0;
	    } else {
	      int left_height = maxDepth(root.left);
	      int right_height = maxDepth(root.right);
	      return java.lang.Math.max(left_height, right_height) + 1;
	    }
	  }
	}