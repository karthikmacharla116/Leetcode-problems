Problem Link: https://leetcode.com/problems/reorder-list/description/

Intuition: 
  Find the middle Node, reverse it and rearrange.

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
class ReorderLinkedList {

    ListNode middleNode(ListNode node) {
        ListNode midPrev = null;
        ListNode fast = node;
        while(fast != null && fast.next != null) {
            midPrev = (midPrev == null)?node : midPrev.next;
            fast = fast.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    ListNode reverse(ListNode node) {
        if(node == null)
            return node;
        ListNode previous = null;
        ListNode present = node;
        ListNode next = present.next;
        
        while(present != null) {
            present.next = previous;
            previous = present;
            present = next;
            if(next != null)
                next = next.next;
        }
        return previous;
    }

    public void reorderList(ListNode head) {
        if(head.next == null)
            return;

        ListNode mid = middleNode(head);
        ListNode secondHead = reverse(mid);

        ListNode reOrder = new ListNode();
        ListNode temp = reOrder;
        while(secondHead != null && head != null) {
            temp.next = head;
            head = head.next;
            temp = temp.next;
    
            temp.next = secondHead;
            secondHead = secondHead.next;
            temp = temp.next; 
        
        }
        head = reOrder;
    }
}
