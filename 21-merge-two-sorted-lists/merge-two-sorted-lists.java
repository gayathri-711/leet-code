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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);  // dummy starter node
        ListNode current = dummy;

        // Traverse both lists and pick the smaller value each time
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // If list1 still has nodes, attach them
        if (list1 != null) {
            current.next = list1;
        }

        // If list2 still has nodes, attach them
        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next; // return merged list
    }
}
