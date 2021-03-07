class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left
            } else {
                TreeNode minRight = getMin(root.right);
                root.val = minRight.val;
                root.right = deleteNode(root.right, minRight.val);
            }
        }

        return root;
    }

    TreeNode getMin(TreeNode root) {
        while(root.left != null)
            root = root.left;

        return root;
    }
}