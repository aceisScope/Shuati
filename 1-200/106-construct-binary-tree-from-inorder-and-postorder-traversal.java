class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    TreeNode build(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        int rootVal = postorder[postend];
        int index = 0;
        for (int i = 0; i <= inend; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);

        int leftsize = index - instart;
        root.left = build(inorder, instart, index - 1, postorder, poststart, poststart + leftsize - 1);
        root.right = build(inorder, index + 1, inend, postorder, poststart + leftsize, postend - 1);

        return root;
    }
}