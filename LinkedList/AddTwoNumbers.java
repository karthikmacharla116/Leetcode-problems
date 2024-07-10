Problem Link: https://leetcode.com/problems/add-two-numbers/description/

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
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();

        ListNode temp = head;

        int carry = 0;

        int val1, val2, sum;
        while(l1 != null || l2 != null) {
            val1 = l1 != null? l1.val : 0;
            val2 = l2 != null?l2.val : 0;

            sum = (carry+val1+val2)%10;
            carry = (carry+val1+val2)/10;

            temp.next = new ListNode(sum);
            temp = temp.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry > 0)
            temp.next = new ListNode(carry);
        return head.next;
    }
}
