class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;

        ListNode head = null;
        ListNode move = null;

        for(int i = 0; i < n; i++) {
            ListNode curr = lists[i];

            while(curr != null) {
                ListNode next = curr.next; // save next node

                if(head == null || curr.val < head.val) {
                    curr.next = head;
                    head = curr;
                } else {
                    move = head;

                    while(move.next != null && move.next.val <= curr.val) {
                        move = move.next;
                    }

                    curr.next = move.next;
                    move.next = curr;
                }

                curr = next; 
            }
        }

        return head;
    }
}