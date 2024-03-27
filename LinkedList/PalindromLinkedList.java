Problem Link: https://leetcode.com/problems/palindrome-linked-list/description/

Intution:
  Breaking the solution into small parts like finding the middle node, reverese the second Half and compare. 

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
class PalindromLinkedList {

    ListNode middleNode(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode reverse(ListNode node) {
        if(node == null)
            return node;
        ListNode previous = null;
        ListNode present = node;
        ListNode next = present.next;
        while(present!=null) {
            present.next = previous;
            previous = present;
            present = next;
            if(next != null)
                next = next.next;
        }
        return previous;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode mid = middleNode(head);
        ListNode secondHead = reverse(mid);
        ListNode reverseHead = secondHead;

        //compare
        while(head != null && secondHead != null) {
            if(head.val != secondHead.val)
                break;
            head =head.next;
            secondHead = secondHead.next;
        }

        //Restoring the Original LinkedList.
        ListNode restoredSecond = reverse(reverseHead);
        mid.next = restoredSecond;
        return head == null || secondHead == null;
    }
}
