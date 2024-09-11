class ListNode {
    int val;
    ListNode next;

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode l3 = new ListNode(0, null);
        while (l1 != null && l2 != null) {
            l3.val = l1.val + l2.val + temp;
            temp = 0;
            if (l3.val >= 10) {
                l3.val -= 10;
                temp = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            l3.val = l1.val + temp;
            temp = 0;
            l1 = l1.next;
        }
        while (l2 != null) {
            l3.val = l2.val + temp;
            temp = 0;
            l2 = l2.next;
        }
        if (temp == 1) {
            l3.next = new ListNode(1, null);
        }
        return l1;
    }
}