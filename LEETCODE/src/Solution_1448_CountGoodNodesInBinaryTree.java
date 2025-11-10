
public class Solution_1448_CountGoodNodesInBinaryTree {
	static int cnt;
	static int max = Integer.MIN_VALUE;
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
	  
	    public int goodNodes(TreeNode root) {
	    	cnt = 0;
	    	max = Integer.MIN_VALUE;
	    	dfs(root);
	    	
	    	
	    	
	    	return cnt;
	    }
	  
	    
	    public static void dfs(TreeNode root) {
	    	
	    	if (max < root.val) max = root.val;
	    	int tmpmax = max;
	    	if (max <= root.val) cnt++;
	    	
	    	if (root.left == null && root.right == null) {
	    		return;
	    	}
	    	
	    	
	    	if (root.left != null) {
	    		 dfs(root.left);
	    		 max = tmpmax;
	    	} 
	    	
	    	if (root.right != null) {
	    		dfs(root.right);
	    		max = tmpmax;
	    	}
	    	
	    	
	    	
	    }
	  
	  
}
