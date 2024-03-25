Problem Link: https://leetcode.com/problems/linked-list-cycle-ii/description/

Intuition:
    1. Find the length of cycle.
    2. Move slow ahead by length of cycle times(from beginning).
    3. Move slow and fast one-by-one, it will meet at the start.

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
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        int length = 0;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                //length of cycle
                ListNode temp = slow;
                do {
                    temp = temp.next;
                    length++;
                } while( temp != slow);
                break;
            }
        }

        //Means NO cycle present
        if(length == 0)
            return null;
        
        //move "slow" to number of times the length of cycle
        slow = head;
        while(slow != null && length > 0) {
            slow = slow.next;
            length--;
        }

        fast = head;
        while(slow != null && fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
