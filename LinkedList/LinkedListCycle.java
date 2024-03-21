Problem Link: https://leetcode.com/problems/linked-list-cycle/

Intuition:
    1. At every iteration, slow pointer will move ONE step forward and 
        the fast pointer will move TWO steps ahead.
    2. It is possible that at any point of time both fast and slow pointers will meet at same index/node.
    3. Time complexity: Once the slow enters the cycle, sure it will meet the fast pointer.
        So, O(n).

Solution:

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
