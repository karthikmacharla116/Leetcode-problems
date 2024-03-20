Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

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
class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        
        ListNode first = head;
        ListNode second = null;
        if(head.next != null)
            second = head.next;
        
        while(second != null) {
            if(first.val == second.val) {
                first.next = second.next;
                second = second.next;
            } else {
                first = second;
                second = second.next;
            }
        }
        return head;
    }
}
