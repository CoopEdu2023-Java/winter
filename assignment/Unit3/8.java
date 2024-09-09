class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode pos = dummy;
        for (int i = 0; i < getLength(head) - n; i++) {
            pos = pos.next;
        }
        pos.next = pos.next.next; // remove
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
