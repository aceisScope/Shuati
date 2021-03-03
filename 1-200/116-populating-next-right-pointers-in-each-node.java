class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;

        connectTwoNodes(root.left, root.right);
        return root;
    }

    void connectTwoNodes(Node node1, Node node2) {
        if (node1 == null || node2 == null) 
            return;

        node1.next = node2;
        
        connectTwoNodes(node1.left, node1.right);
        connectTwoNodes(node1.right, node2.left);
        connectTwoNodes(node2.left, node2.right);
    }
}