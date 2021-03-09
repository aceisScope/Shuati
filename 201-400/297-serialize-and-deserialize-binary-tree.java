public class Codec {
    String SEP = ",";
    String NULL = "#";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);
        serialize(root.left);
        serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s: data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    TreeNode deserialize(LinkedList nodes) {
        if (nodes.isEmpty()) 
            return null;

        TreeNode first = nodes.removeFirst();
        if (first == null)
            return null;
        TreeNode root = new TreeNode(Integer.parse(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
    }
}