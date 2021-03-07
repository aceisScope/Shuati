class Solution {
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }
    
    int sum = 0;
    void traverse(TreeNode root) {
        if (root == null)
            return;
        
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}