Problem Link: https://leetcode.com/problems/sort-list/description/

Intution:
  Can be solved using merge sort.

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
class MergeSortLinkedList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode mid = middleNode(head);
        
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    //merge
    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode temp = dummyHead;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }

        temp.next = (list1 != null) ? list1:list2;
        return dummyHead.next;
    }

    //Middle element - Breaking the List into TWO halves
    ListNode middleNode(ListNode head) {
        ListNode midPrev = null;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            midPrev = (midPrev == null)? head: midPrev.next;
            fast = fast.next.next;
        }

        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}

