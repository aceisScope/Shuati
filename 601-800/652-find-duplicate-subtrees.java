class Solution {
    List<TreeNode> res = new LinkedList<>();
    Map<String, Integer> record = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    String traverse(TreeNode root) {
        if (root == null) 
            return "#";

        String tree = traverse(root.lef) + "-" + traverse(root.right) + "-" +  root.val;
        
        int freq = record.getOrDefault(tree, 0);
        if (freq == 1) {
            res.add(root);
        }
        record.put(tree, freq + 1);

        return tree;
    }
}