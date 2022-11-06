package my.algo.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversalDemo {
    static ArrayList l = new ArrayList<Integer>();
    public static void main(String[] args) {
      TreeNode r = new TreeNode(1);
      r.left = new TreeNode(2);
      r.left.left = new TreeNode(5);
      r.left.right = new TreeNode(6);
      r.right = new TreeNode(3);
        System.out.println(preorderTraversal(r));
    }


    public static List<Integer> preorderTraversal(TreeNode root){
         if(root==null) return l;
         l.add(root.val);
         preorderTraversal(root.left);
         preorderTraversal(root.right);
         return l;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){this.val=val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right =right;
    }
}