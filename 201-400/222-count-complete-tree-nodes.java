class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        if (isPerfect(root)) {
            return (int)Math.pow(2, lh) - 1;
        } 

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    boolean isPerfect(root) {
        TreeNode l = root, r = right;
        int lh = 0, rh = 0;

        while (l != null) {
            l = l.left;
            lh++;
        }
        while (r != null) {
            r = r.left;
            rh++;
        }

        return lh == rh;
    }
}