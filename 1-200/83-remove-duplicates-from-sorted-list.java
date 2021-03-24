class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow = slow.next;
                slow.val = fast.val;
            }
            fast = fast.next;
        }
        slow.next = null;
        
        return head;
    }
}