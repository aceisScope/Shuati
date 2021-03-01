class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) 
            return head;

        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null)  // 区间[a,b)内结点数不足k个
                return head;
            b = b.next;
        }

        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, next = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}