class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        
        Node p = head, q = newHead;
        map.put(head, newHead);
        
        while (p != null && p.next != null) {
            p = p.next;
            Node tmp = new Node(p.val);
            map.put(p, tmp);
            
            q.next = tmp;
            q = tmp;
        }
        
        p = head;
        q = newHead;
        while (p != null) {
            if (p.random != null) {
                q.random = map.get(p.random);
            } else {
                q.random = null;
            }
            
            p = p.next;
            q = q.next;
        }
        
        return newHead;
    }
}