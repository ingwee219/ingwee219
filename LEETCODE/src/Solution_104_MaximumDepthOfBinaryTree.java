
public class Solution_104_MaximumDepthOfBinaryTree {
	static int max;
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
	
    public int maxDepth(TreeNode root) {
    	
    	max = 0;
    	dfs(root,1);
    	
    	return max;
    }
    
    static void dfs(TreeNode root, int dep) {
    	if (root == null) return;
    	if (root.left == null && root.right == null) {
    		if (max < dep) max = dep;
    		return;
    	}
    	dfs(root.left, dep+1);
    	dfs(root.right, dep+1);
    	
    }//dfs
    
    
}
