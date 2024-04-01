Problem Link: https://leetcode.com/problems/reverse-nodes-in-k-group/description/

Intuition:
  Same as Reverse LinkedList II but with little modification

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
class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1 || head == null)
            return head;

        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode last = prev;
            ListNode newEnd = current;

            //check if k nodes available
            int count = 0;
            ListNode temp = current;
            while( temp != null && count < k) {
                temp = temp.next;
                count++;
            }
            
            if( count != k)
                break;

            //reverse k times
            ListNode next = current.next;
            
            for(int i=0;current!= null && i<k;i++) {
                current.next = prev;
                prev = current;
                current = next;
                if(next != null)
                    next = next.next;
            }
            
            if(last != null) {
                last.next = prev;
            } else {
                head = prev;
            }
            newEnd.next = current;
            prev = newEnd;
            System.out.println(prev.val);
        }
        return head;
    }
}
