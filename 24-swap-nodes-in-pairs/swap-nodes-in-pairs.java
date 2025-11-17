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
    public ListNode swapPairs(ListNode head) {
        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        // Traverse while there are at least 2 nodes to swap
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;

            // Swapping
            first.next = second.next;
            second.next = first;
            curr.next = second;

            // Move forward by two nodes
            curr = first;
        }

        return dummy.next;
    }
}
