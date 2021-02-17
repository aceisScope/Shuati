class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, preStart, preEnd, inStart, inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                root.left = buildTree(preorder, inorder, preStart+1, preStart+(i-inStart), inStart, i-1);
                root.right = buildTree(preorder, inorder, preStart+(i-inStart)+1, preEnd, i+1, inEnd);
                break;
            }
        }

        return root;
    }
}