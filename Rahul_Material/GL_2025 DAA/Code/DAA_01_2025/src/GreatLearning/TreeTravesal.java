package GreatLearning;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class TreeTravesal {
	
	 // Definition for a binary tree node.
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	         this.left = left;
	          this.right = right;
	      }
	  }
	 
	
	  ArrayList<Integer>  a1 = new ArrayList<Integer>();
	    public List<Integer> preorderTraversal(TreeNode root) {
	       Stack <TreeNode> s1 = new Stack<TreeNode> ();
	        s1.push(root);
	        while(!s1.isEmpty()) {
	        	TreeNode node = s1.pop();
	            if(node!=null){
	        	a1.add(node.val);
	        	if(node.right!=null)
	        		s1.push(node.right);
	        	if(node.left!=null)
	        		s1.push(node.left);
	            }
	        }
	        return a1;

	    }
	    ArrayList<Integer>  a2 = new ArrayList<Integer>();
	    public List<Integer> postorderTraversal(TreeNode root) {
	    	
	          if(root==null)
	        return a2;
	        
	        postorderTraversal(root.left);
	        
	        postorderTraversal(root.right);
	        a2.add(root.val);
	        return a2;

	    }
	    
	    ArrayList<Integer>  a3 = new ArrayList<Integer>();
	    public List<Integer> inorderTraversal(TreeNode root) {
	        if(root==null)
	        return a3;
	        inorderTraversal(root.left);
	        a3.add(root.val);
	        inorderTraversal(root.right);
	        return a3;
	    }

}
