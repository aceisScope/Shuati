class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) 
            return null;
        if (root == p || root == q)
            return root;
 
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) { // 如果左子树中存在P或者Q，且右子树中存在P或者Q，则root为公共祖先
            return root;
        }

        return left == null ? right : left; // P或Q不在左子树中，则一定在右子树中, 否则即返回null
    }
}