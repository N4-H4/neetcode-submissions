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
    public Stack<ListNode> st = new Stack<>();

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        while(head != null) {
            st.push(head);
            head = head.next;
        }

        ListNode ans = st.pop();
        ListNode temp = ans;

        while(!st.empty()) {
            temp.next = st.pop();
            temp = temp.next;
        }

        temp.next = null;

        return ans;
    }
}