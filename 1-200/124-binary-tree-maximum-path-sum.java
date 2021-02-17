class Solution {
   int maxPathSum = Integer.MIN_VALUE;   
   
   public int maxPathSum(TreeNode root) {
       maxGain(root);
       return maxPathSum;
   }
	
   public int maxGain(TreeNode node) {
       if (node == null) {
          return 0; 
       }

       int left = Math.max(maxGain(node.left), 0);
       int right = Math.max(maxGain(node.right), 0);
    
       maxPathSum = Math.max(maxPathSum, left + right + node.val);
       return node.val + Math.max(left, right);
   }
}
