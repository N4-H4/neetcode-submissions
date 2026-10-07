class Solution {
    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int idx = 0;
        int len = 0;

        if(head == null) return null;

        ListNode temp = head;
        while(temp != null) {
            len++;
            temp = temp.next;
        }

        head = reverse(head);

        if(n == 1) {
            head = head.next;
            return reverse(head);
        }

        if(n == len) {                         // FIX
            ListNode curr = head;
            while(curr.next.next != null) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
            return reverse(head);
        }

        ListNode curr = head;

        while(idx < n - 2) {
            idx++;
            curr = curr.next;
        }

        curr.next = curr.next.next;

        head = reverse(head);

        return head;
    }
}