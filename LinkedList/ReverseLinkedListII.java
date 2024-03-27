Problem Link: https://leetcode.com/problems/reverse-linked-list-ii/description/

Intuition:
  Visualize.

Solution:
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
class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right)
            return head;
        
        ListNode previous = null;
        ListNode current = head;
        ListNode last = current;
        //traverse until left-1 node
        for(int i=0;current != null && i<left-1;i++) {
            previous = current;
            current = current.next;
        }
        last = previous;

        ListNode newLast = current;

        //reverse
        ListNode next = current.next;
        for(int i=0;current != null && i< right-left+1;i++) {
            current.next = previous;
            previous = current;
            current = next;
            if(next != null)
                next = next.next;
        }

        if(last != null)
            last.next = previous;
        else 
            head = previous;

        newLast.next = current;     

        return head;
    }
}
