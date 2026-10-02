/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode temp = head;
        
        while(temp.next != null) {
            temp = temp.next;
        }

        ListNode rev = temp;

        while(head != rev) {
            ListNode temp2 = rev.next;
            temp = head.next;
            rev.next = head;
            rev.next.next = temp2;
            head = temp;

        }

        return rev;
    }
}