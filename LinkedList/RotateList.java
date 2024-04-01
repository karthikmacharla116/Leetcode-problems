Problem Link: https://leetcode.com/problems/rotate-list/description/

Intuition:-
  Simple as easy(finding a node in a List)  

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
class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if(k<=0 || head == null || head.next == null)
            return head;
        
        ListNode start = head;
        ListNode last = head;
        int length = 1;
        while(last.next != null) {
            length++;
            last = last.next;
        }

        int rotations = k%length;
        if(rotations == 0)
            return head;

        //traverse the List upto length - mod times
        int count = length-rotations;
        ListNode newLast = head;
        for(int i=0;i<count-1 && newLast != null;i++) {
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = null;
        last.next = start;
        return head;
    }
}
