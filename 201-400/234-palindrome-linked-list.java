class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) 
            slow = slow.next;

        ListNode left = head, right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left++;
            right++;
        }
        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, next = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}