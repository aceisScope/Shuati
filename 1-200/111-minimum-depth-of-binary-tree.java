class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) 
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        int depth = 1;
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left == null && curr.right == null) {
                    return depth;
                }

                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            depth++;
        }

        return depth;
    }
}