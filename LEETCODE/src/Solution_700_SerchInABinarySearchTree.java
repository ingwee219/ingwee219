import java.util.*;
public class Solution_700_SerchInABinarySearchTree {

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
	 
	 
	 
	    public TreeNode searchBST(TreeNode root, int val) {
	    	if (val == root.val) return root;
	        if (root.left !=null && val < root.val) {
	        	return searchBST(root.left,val);
	        } else if (root.right != null) {
	        	return searchBST(root.right,val);
	        }
	        
	    	
	    	
	    	
	    	
	    	
	    	return null;
	    }
	
	
	
}


